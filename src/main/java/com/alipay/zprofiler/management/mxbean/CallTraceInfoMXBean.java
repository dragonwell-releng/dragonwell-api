package com.alipay.zprofiler.management.mxbean;

public interface CallTraceInfoMXBean {
    public void startSamplingCallTrace(int frequency);

    public CallTraceInfoDesc[] stopSamplingCallTrace();

    public String[] getSymbols(long[] mids);

    public String getSymbol(long mid);

    public byte[] collectNativeStacks();
}
