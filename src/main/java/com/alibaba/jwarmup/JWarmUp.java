package com.alibaba.jwarmup;

/**
 * If the CompilationWarmUpOptimistic is off, application should
 * implicitly notify jvm that startup of appliacation is done
 */
public class JWarmUp {
    /**
     * Notify jvm that application startup is done.
     * <p>
     * Should be explicitly call after startup of application if
     * CompilationWarmUpOptimistic is off. Otherwise, it does
     * nothing and just prints a warning message.
     *
     * @version 1.8
     */
    public static synchronized void notifyApplicationStartUpIsDone() {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Notify jvm to deoptimize warmup methods
     * <p>
     * Should be explicitly call after startup of application
     * and warmup compilation is completed
     * vm option CompilationWarmUpExplicitDeopt must be on
     * Otherwise, it does nothing and just prints a warning message.
     *
     * @version 1.8
     */
    public static synchronized void notifyJVMDeoptWarmUpMethods() {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Check if the last compilation submitted by JWarmUp is complete.
     * <p>
     * call this method after <code>notifyApplicationStartUpIsDone</code>
     *
     * @return true if the last compilation task is complete.
     *
     * @version 1.8
     */
    public static synchronized boolean checkIfCompilationIsComplete() {
        throw new RuntimeException("AJDK dummy API found");
    }
}
