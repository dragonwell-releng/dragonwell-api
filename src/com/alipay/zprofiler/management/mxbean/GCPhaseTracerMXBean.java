package com.alipay.zprofiler.management.mxbean;

import com.alibaba.ras.gc.GCPhaseInfo;

/**
 * The management interface for GC phase.
 */
public interface GCPhaseTracerMXBean {

    /**
     * Returns the GC phase information about the most recent GC.
     * This method returns an array of {@link GCPhaseInfo}.
     * If no GC phase information is available, <tt>null</tt> is returned.
     * Currently only support ParNew+CMS or G1.
     * @return an array of {@link GCPhaseInfo}
     */
    GCPhaseInfo[] getLastGCPhaseInfo();
}