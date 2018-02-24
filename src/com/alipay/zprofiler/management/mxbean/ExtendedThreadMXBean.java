package com.alipay.zprofiler.management.mxbean;

import java.util.Map;

public abstract interface ExtendedThreadMXBean {

    public abstract long[] getThreadCpuTime(long[] tids);

    public Map<String, String[]> getStacks(long[] pids, int stackDepth);
}
