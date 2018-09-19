package com.alibaba.wisp.util.concurrent;


import com.alibaba.wisp.engine.WispEngine;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;


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
        if (!SKIP_CHECK_OPTIONS) {
            boolean enableCoroutine;
            try {
                Field f = sun.misc.VM.class.getDeclaredField("enableCoroutine");
                f.setAccessible(true);
                enableCoroutine = f.getBoolean(null);
            } catch (ReflectiveOperationException e) {
                enableCoroutine = false;
            }
            if (!enableCoroutine || !WispEngine.isTransparentAsync()) {
                throw new IllegalArgumentException("enableCoroutine=" + enableCoroutine +
                        ", transparentAsync=" + WispEngine.isTransparentAsync());
            }
        }

        wispRunners = new WispRunner[threadCount];
        roundRobin = new AtomicInteger();
        semaphore = maxCoroutine > 0 ? new Semaphore(maxCoroutine) : null;
        isShutdown = new AtomicBoolean(false);
        rejectedExecutionHandler = rejectedHandler;

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
            };
            threadFactory.newThread(wispRunners[i]).start();
        }
        awaitUninterruptibly(allEngineCreated);
    }

    public WispMultiThreadExecutor(int threadCount, int maxCoroutine,
                                   ThreadFactory threadFactory) {
        this(threadCount, maxCoroutine, threadFactory, null);
    }

    private abstract class WispRunner implements Runnable {
        WispEngine engine;
        Thread thread;
        CountDownLatch poison = new CountDownLatch(1);
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

        wispRunners[(roundRobin.getAndIncrement() & 0xfffffff) // avoid overflow to negative
                % wispRunners.length].engine.execute(command);
    }

    @Override
    public void shutdown() {
        if (!isShutdown.get() && isShutdown.compareAndSet(false, true)) {
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
        for (WispRunner wispRunner : wispRunners) {
            if (!wispRunner.engine.isTerminated()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
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
}

