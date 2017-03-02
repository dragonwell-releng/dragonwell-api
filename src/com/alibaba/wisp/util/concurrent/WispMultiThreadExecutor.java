package com.alibaba.wisp.util.concurrent;


import com.alibaba.wisp.engine.WispEngine;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * In some scenarios, the program runs in a single thread. Execute task in
 * {@code WispEngine.current()} can not make full use of CPU.
 * <p>
 * {@code WispMultiThreadExecutor} is used to helping dispatch tasks into multiple
 * {@code WispEngine} to maximize CPU utilization.
 */
public class WispMultiThreadExecutor extends AbstractExecutorService {


    private final WispRunner wispRunners[];
    private final AtomicInteger roundRobin;
    private final Semaphore semaphore;
    private final AtomicBoolean isShutdown;

    /**
     * Creates a new {@code WispMultiThreadExecutor} with the given initial
     * parameters.
     *
     * @param threadCount   the underlying wispEngine count
     * @param maxCoroutine  the maximum number of maxCoroutine to allow in the Executor,
     *                      if the limit is reached, {@code execute} invokes will be blocked
     * @param threadFactory the factory to use when the executor creates a thread
     */
    public WispMultiThreadExecutor(int threadCount, int maxCoroutine, ThreadFactory threadFactory) {
        wispRunners = new WispRunner[threadCount];
        roundRobin = new AtomicInteger();
        semaphore = maxCoroutine > 0 ? new Semaphore(maxCoroutine) : null;
        isShutdown = new AtomicBoolean(false);

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
        if (semaphore != null) { // flow control
            semaphore.acquireUninterruptibly();
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
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException();
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

