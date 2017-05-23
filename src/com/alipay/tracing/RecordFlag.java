package com.alipay.tracing;

public class RecordFlag {
    private int flag;
    private static final int MASK_IS_MEMORY_TRACING = (0x1 << 1);
    private static final int MASK_IS_CPU_TIME_TRACING = (0x1 << 2);
    private static final int MASK_HAS_TRACING_ID = (0x1 << 3);
    private static final int MASK_METHOD_STATUS = 0x30;

    RecordFlag(byte flag) {
        this.flag = flag;
    }

    boolean hasTracingID() {
        return 0 != (flag & MASK_HAS_TRACING_ID);
    }

    boolean isMemoryTracingEnabled() {
        return 0 != (flag & MASK_IS_MEMORY_TRACING);
    }

    boolean isCpuTimeTracingEnabled() {
        return 0 != (flag & MASK_IS_CPU_TIME_TRACING);
    }

    MethodStatus getStatus() {
        return MethodStatus.fromValue(flag & MASK_METHOD_STATUS);
    }
}

