package com.alibaba.wisp.util.concurrent;


import com.alibaba.wisp.engine.Wisp2Group;
import com.alibaba.wisp.engine.WispEngine;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.Properties;


/**
 * In some scenarios, the program runs in a single thread. Execute task in
 * {@code WispEngine.current()} can not make full use of CPU.
 * <p>
 * {@code WispMultiThreadExecutor} is used to helping dispatch tasks into multiple
 * {@code WispEngine} to maximize CPU utilization.
 */
public class WispMultiThreadExecutor extends AbstractExecutorService {

    private static boolean SKIP_CHECK_OPTIONS = Boolean.getBoolean("com.alibaba.wisp.skipCheckOptions");

    private final WispRunner wispRunners[];
    private final AtomicInteger roundRobin;
    private final Semaphore semaphore;
    private final AtomicBoolean isShutdown;
    private final Consumer<Runnable> rejectedExecutionHandler;
    private final Wisp2Group delegated;
    private static final int WISP_VERSION;

    static {
        Properties p = java.security.AccessController.doPrivileged(
            new java.security.PrivilegedAction<Properties>() {
                public Properties run() {
                    return System.getProperties();
                }
            }
        );
        WISP_VERSION = parsePositiveIntegerParameter(p, "com.alibaba.wisp.version", 1);
    }

    /**
     * Creates a new {@code WispMultiThreadExecutor} with the given initial
     * parameters.
     *
     * @param threadCount     the underlying wispEngine count
     * @param maxCoroutine    the maximum number of maxCoroutine to allow in the Executor,
     *                        if the limit is reached, {@code execute} invokes will be blocked
     * @param threadFactory   the factory to use when the executor creates a thread
     * @param rejectedHandler the handler to use when execution is blocked
     *                        because the maxCoroutine bounds are reached
     */
    public WispMultiThreadExecutor(int threadCount, int maxCoroutine,
                                   ThreadFactory threadFactory,
                                   Consumer<Runnable> rejectedHandler) {
        wispRunners = new WispRunner[threadCount];
        roundRobin = new AtomicInteger();
        semaphore = maxCoroutine > 0 ? new Semaphore(maxCoroutine) : null;
        isShutdown = new AtomicBoolean(false);
        rejectedExecutionHandler = rejectedHandler;
        if (WISP_VERSION == 2) {
            delegated = Wisp2Group.createGroup(threadCount, threadFactory);
        } else {
            delegated = null;
            final CountDownLatch allEngineCreated = new CountDownLatch(threadCount);

            for (int i = 0; i < threadCount; i++) {
                wispRunners[i] = new WispRunner() {
                    @Override
                    public void run() {
                        this.engine = WispEngine.current();
                        this.thread = Thread.currentThread();
                        allEngineCreated.countDown();
                        awaitUninterruptibly(this.poison);
                    }

                    @Override
                    public WispEngine getWispEngine() {
                        return engine;
                    }
                };
                threadFactory.newThread(wispRunners[i]).start();
            }
            awaitUninterruptibly(allEngineCreated);
        }
    }

    public WispMultiThreadExecutor(int threadCount, int maxCoroutine,
                                   ThreadFactory threadFactory) {
        this(threadCount, maxCoroutine, threadFactory, null);
    }

    public List<Long> getWispEngines() {
        if (delegated != null) {
            return delegated.getWispEngineIDs();
        }
        return null;
    }

    private abstract class WispRunner implements Runnable {
        WispEngine engine;
        Thread thread;
        CountDownLatch poison = new CountDownLatch(1);
        public abstract WispEngine getWispEngine();
    }

    @Override
    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException("command");
        }
        if (isShutdown.get()) {
            throw new IllegalStateException("has been shutdown");
        }
        if (semaphore != null) { // flow control
            if (rejectedExecutionHandler == null) {
                semaphore.acquireUninterruptibly();
            } else if (!semaphore.tryAcquire()) {
                rejectedExecutionHandler.accept(command);
                return;
            }

            final Runnable originCommand = command;
            command = new Runnable() {
                @Override
                public void run() {
                    try {
                        originCommand.run();
                    } finally {
                        semaphore.release();
                    }
                }
            };
        }

        if (delegated != null) {
            delegated.execute(command);
        } else {
            wispRunners[(roundRobin.getAndIncrement() & 0xfffffff) // avoid overflow to negative
                    % wispRunners.length].engine.execute(command);
        }
    }

    @Override
    public void shutdown() {
        if (!isShutdown.get() && isShutdown.compareAndSet(false, true)) {
            if (delegated != null) {
                delegated.shutdown();
                return;
            }
            for (WispRunner wispRunner : wispRunners) {
                wispRunner.engine.shutdown();
                wispRunner.poison.countDown();
            }
        }
    }

    @Override
    public boolean isShutdown() {
        return isShutdown.get();
    }

    @Override
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isTerminated() {
        if (delegated != null) {
            return delegated.isTerminated();
        }
        for (WispRunner wispRunner : wispRunners) {
            if (!wispRunner.engine.isTerminated()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        if (delegated != null) {
            return delegated.awaitTermination(timeout, unit);
        }
        long deadline = System.nanoTime() + unit.toNanos(timeout);
        for (WispRunner wispRunner : wispRunners) {
            if (!wispRunner.engine.awaitTermination(deadline - System.nanoTime(), TimeUnit.NANOSECONDS)) {
                return false;
            }
        }
        return true;
    }

    private static void awaitUninterruptibly(CountDownLatch latch) {
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    latch.await();
                    return;
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
        } finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static int parsePositiveIntegerParameter(Properties p, String key, int defaultVal) {
        String value;
        if (p == null || (value = p.getProperty(key)) == null) {
            return defaultVal;
        }
        int res = defaultVal;
        try {
            res = Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
        return res <= 0 ? defaultVal : res;
    }
}
