package com.alibaba.wisp.engine;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Coroutine Runtime Engine. It's a "wisp" thing, as we want our asynchronization transformation to be transparent
 * without asking a Java programmer to modify his/her code.
 * <p>
 * This is a trivial implementation of WispEngine's semantics to help users compile and debug code.
 * When the program running in AJDK, bootstrapClassloader will load the correct implementation.
 */

public final class WispEngine extends AbstractExecutorService {

    private static ExecutorService executor = Executors.newCachedThreadPool();

    private static final boolean transparentAsync = Boolean.getBoolean("com.alibaba.transparentAsync");

    public static boolean isTransparentAsync() {
        return transparentAsync;
    }

    private WispEngine() {
    }

    private static ThreadLocal<WispEngine> threadLocalEngine = new ThreadLocal<WispEngine>() {
        @Override
        protected WispEngine initialValue() {
            return new WispEngine();
        }
    };

    /**
     * Constructor is private, so one can only get thread-specific engine by calling this method.
     * This method's name indicates a task is created in current thread's engine.
     *
     * @return thread-specific engine
     */
    public static WispEngine current() {
        return threadLocalEngine.get();
    }

    public long getId() {
        return 0;
    }
    /**
     * Create coroutine to run the command and schedule in current engine.
     *
     * @param command target code
     */
    public static void dispatch(Runnable command) {
        executor.execute(command);
    }

    @Override
    public void execute(Runnable command) {
        dispatch(command);
    }

    @Override
    public void shutdown() {
    }

    @Override
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }
}
