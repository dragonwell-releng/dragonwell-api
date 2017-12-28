package com.alibaba.tenant;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * The configuration used by tenant
 */
public class TenantConfiguration {

    /**
     * Create an empty TenantConfiguration, no limitations on any resource
     */
    public TenantConfiguration() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * @param maxCPUPercent
     * @param cpuShare
     * @param maxHeap
     */
    @Deprecated
    public TenantConfiguration(int maxCPUPercent, int cpuShare, long maxHeap) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * @param cpuShare
     * @param maxHeapBytes
     */
    public TenantConfiguration(int cpuShare, long maxHeapBytes) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * @param maxHeapBytes
     */
    public TenantConfiguration(long maxHeapBytes) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * limit CGroup's cpu.cfs_* controller
     * @param period    corresponding to cpu.cfs_period
     * @param quota     corresponding to cpu.cfs_quota
     * @return current tenantConfiguration object
     */
    public TenantConfiguration limitCpuCfs(int period, int quota) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     *
     * @param share
     * @return
     */
    public TenantConfiguration limitCpuShares(int share) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     *
     * @param cpuSets
     * @return
     */
    public TenantConfiguration limitCpuSet(String cpuSets) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     *
     * @param maxJavaHeapBytes
     * @return
     */
    public TenantConfiguration limitHeap(long maxJavaHeapBytes) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * @return true if configured to allocate object in old
     */
    public boolean isAllocToOld() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * set the allocate type of configuration as OLD.
     * @return current configuration
     */
    public TenantConfiguration setDirectTenuredAlloc() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * @see TenantConfiguration#getMaxCpuPercent()
     */
    @Deprecated
    public int getMaxCPU() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Corresponding to combination of Linux cgroup's cpu.cfs_period_us and cpu.cfs_quota_us
     * @return the max percent of cpu the tenant is allowed to consume, -1 means unlimited
     */
    public int getMaxCpuPercent() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * @see TenantConfiguration#getCpuShares()
     */
    @Deprecated
    public int getWeight() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Corresponding to Linux cgroup's cpu.shares
     * @return the weight, impact the ratio of cpu among all tenants.
     */
    public int getCpuShares() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * @return the max amount of heap the tenant is allowed to consume.
     */
    public long getMaxHeap() {
        throw new RuntimeException("Dummy AJDK API found");
    }
}
