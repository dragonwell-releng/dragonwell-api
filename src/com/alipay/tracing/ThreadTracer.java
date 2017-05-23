package com.alipay.tracing;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Per thread method tracing support for ZTrace feature Used to enable ZTrace on
 * specific thread from Java code, used together with command line option of:
 * -XX:ZTrace=method,loglevel=[level],output=[path to log file]
 */
public class ThreadTracer {

	private static long rollingThreshold = Long.MAX_VALUE;
	private static int rollingCheckFrequency = Integer.MAX_VALUE;

	private static String ztraceLogDir;
	private static boolean ztraceEnabled;

	private static Map<Long/* thread id */, Integer /* tracing count */> threadId2Count;

	public static final int TRACE_CPU_TIME_FLAG = 0x1;
	public static final int TRACE_MEMORY_FLAG = 0x2;
	public static final int TRACE_SELF_CONTROL_FLAG = 0x4;


	/**
	 * Enable method tracing on specific thread.
	 *
	 * @param thread
	 *            marked for tracing
	 */
	public static void startMethodTracing(Thread thread) {
		throw new RuntimeException("AJDK dummy API found");
	}

	public static void startMethodTracing(Thread thread, int ztraceFlag) {
		throw new RuntimeException("AJDK dummy API found");
	}

	/**
	 * Enable method tracing on specific thread.
	 *
	 * @param thread
	 *            marked for tracing.
	 * @traceId trace id
	 */
	public static void startMethodTracing(Thread thread, String traceId) {
		throw new RuntimeException("AJDK dummy API found");
	}

	public static void startMethodTracing(Thread thread, String traceId, int ztraceFlag) {
		throw new RuntimeException("AJDK dummy API found");
	}

	/**
	 * Enable method tracing on current thread.
	 */
	public static void startMethodTracing() {
		throw new RuntimeException("AJDK dummy API found");
	}

	public static void startMethodTracing(int ztraceFlag) {
		throw new RuntimeException("AJDK dummy API found");
	}

	private static void rollThreadLogIfExceedingThreshold(Thread thread) {
		throw new RuntimeException("AJDK dummy API found");
	}

	/**
	 * Disable method tracing on specific thread.
	 *
	 * @param thread
	 *            which disable tracing for
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
	 * @param thread
	 *            target thread
	 * @return If method tracing enabled on @thread
	 */
	public static boolean isMethodTracingEnabled(Thread thread) {
		throw new RuntimeException("AJDK dummy API found");
	}

	private static native boolean setMethodTracing0(Thread thread, String traceId, boolean tracing, int ztraceFlag);

	private static native boolean isMethodTracingEnabled0(Thread thread);

}