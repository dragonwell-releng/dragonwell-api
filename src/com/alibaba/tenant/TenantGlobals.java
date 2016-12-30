package com.alibaba.tenant;

/**
 * This class defines the constants used by multi-tenant JDK
 */
public class TenantGlobals {
    /**
     * Bit to indicate that if the multi-tenant feature is enabled.
     */
    public static final int TENANT_FLAG_MULTI_TENANT_ENABLED      = 0x1;

    /**
     * Bit to indicate that if heap throttling feature is enabled
     */
    public static final int TENANT_FLAG_HEAP_THROTTLING_ENABLED   = 0x2;

    /**
     * Bit to indicate that if cpu throttling feature is enabled
     */
    public static final int TENANT_FLAG_CPU_THROTTLING_ENABLED    = 0x4;
    /**
     * Bit to indicate that if data isolation feature is enabled
     */
    public static final int TENANT_FLAG_DATA_ISOLATION_ENABLED    = 0x8;

    /**
     * Bit to indicate that if spawned threads will be killed at TenantContainer.destroy()
     */
    public static final int TENANT_FLAG_THREAD_STOP_ENABLED       = 0x10;

    /**
     * Bit to indicate that if IO handle reclaiming feature is enabled
     */
    public static final int TENANT_FLAG_IOHANDLE_RECLAIMING_ENABLED    = 0x20;

    /**
     * Bit to indicate that if cpu accounting feature is enabled
     */
    public static final int TENANT_FLAG_CPU_ACCOUNTING_ENABLED    = 0x40;

    /**
     * Test if multi-tenant feature is enabled.
     * @return true if enabled otherwise false
     */
    public static boolean isTenantEnabled() {
       throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Test if heap throttling feature is enabled.
     * @return true if enabled otherwise false
     */
    public static boolean isHeapThrottlingEnabled() {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Test if cpu throttling feature is enabled.
     * @return true if enabled otherwise false
     */
    public static boolean isCpuThrottlingEnabled() {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Test if cpu accounting feature is enabled.
     * @return true if enabled otherwise false
     */
    public static boolean isCpuAccountingEnabled() {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Test if data isolation feature is enabled.
     * @return true if enabled otherwise false
     */
    public static boolean isDataIsolationEnabled() {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Test if thread stop feature is enabled.
     * @return true if enabled otherwise false
     */
    public static boolean isThreadStopEnabled() {
        throw new RuntimeException("AJDK dummy API found");
    }

     /**
     * Test if IO handle reclaiming feature is enabled.
     * @return true if enabled otherwise false
     */
    public static boolean isIOHandleReclaimingEnabled() {
        throw new RuntimeException("AJDK dummy API found");
    }
}
