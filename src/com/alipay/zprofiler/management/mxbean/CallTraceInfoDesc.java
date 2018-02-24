package com.alipay.zprofiler.management.mxbean;

import java.beans.ConstructorProperties;

public class CallTraceInfoDesc {
    int    count;
    int    numFrames;
    long[] methodIds = new long[128];

    @ConstructorProperties({ "count", "numFrames", "methodIds" })
    public CallTraceInfoDesc(int count, int numFrames, long[] methodIds) {
        this.count = count;
        this.numFrames = numFrames;
        this.methodIds = methodIds;
    }

    public CallTraceInfoDesc() {
    }

    public int getCount() {
        return count;
    }

    public int getNumFrames() {
        return numFrames;
    }

    public long[] getMethodIds() {
        return methodIds;
    }
}
