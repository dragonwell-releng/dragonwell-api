package com.alibaba.tenant;

/**
 * 
 * The configuration used by tenant
 */
public class TenantConfiguration {

    public TenantConfiguration(int maxCPU, int weight, long maxHeap) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public TenantConfiguration(int weight, long maxHeap) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public TenantConfiguration(long maxHeap) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * @return the max amount of cpu the tenant is allowed to consume.
     */
    public int getMaxCPU() {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * @return the weight, impact the ratio of cpu among all tenants.
     */
    public int getWeight() {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * @return the max amount of heap the tenant is allowed to consume.
     */
    public long getMaxHeap() {
        throw new RuntimeException("AJDK dummy API found");
    }
}
