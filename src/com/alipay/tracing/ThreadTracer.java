package com.alipay.tracing;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Per thread method tracing support for ZTrace feature
 * Used to enable ZTrace on specific thread from Java code, used together
 * with command line option of:
 * -XX:ZTrace=method,loglevel=[level],output=[path to log file]
 */
public class ThreadTracer {

    private static boolean ztraceEnabled = System.getProperty("ztrace.log.dir") != null;

    /**
     * Enable method tracing on specific thread.
     *
     * @param thread marked for tracing
     */
    public static void startMethodTracing(Thread thread) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Enable method tracing on specific thread.
     *
     * @param thread marked for tracing.
     * @traceId trace id
     */
    public static void startMethodTracing(Thread thread, String traceId) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Enable method tracing on current thread.
     */
    public static void startMethodTracing() {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Disable method tracing on specific thread.
     *
     * @param thread which disable tracing for
     */
    public static void stopMethodTracing(Thread thread) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Disable method tracing on current thread
     */
    public static void stopMethodTracing() {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Check if method tracing is enabled on a thread.
     *
     * @param thread target thread
     * @return If method tracing enabled on @thread
     */
    public static boolean isMethodTracingEnabled(Thread thread) {
        throw new RuntimeException("AJDK dummy API found");
    }

    private static native void setMethodTracing0(Thread thread, String traceId, boolean tracing);

    private static native boolean isMethodTracingEnabled0(Thread thread);

    static {
        AccessController.doPrivileged(
                new PrivilegedAction<Object>() {
                    public Object run() {
                        System.loadLibrary("zprofileragent");
                        return null;
                    }
                }
        );
    }
}
