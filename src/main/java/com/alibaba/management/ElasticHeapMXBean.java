package com.alibaba.management;

import java.lang.management.PlatformManagedObject;
import java.util.List;

/**
 * The ElasticHeapMXBean interface provides APIs for manipulating memory commitment of heap
 */
public interface ElasticHeapMXBean extends PlatformManagedObject {

    /**
     * Set memory commit percent of young generation in heap
     *
     * @param percent commit percent of young generation to set
     * @throws IllegalStateException if -XX:+ZenGCElasticHeap is not enabled
     *          or commit percent cannot be set. Error can be gotten by Exception.getMessage()
     * @throws IllegalArgumentException if percent is not 0 or between
     *          ElasticHeapMinYoungCommitPercent(VM option) and 100
     */
    public void setYoungGenCommitPercent(int percent);

    /**
     * @return memory commit percent of young generation percentage in heap
     * (toInt(YoungGenCommitPercent * 100))
     * @throws IllegalStateException if -XX:+ZenGCElasticHeap is not enabled
     */
    public int getYoungGenCommitPercent();

    /**
     * @return number of uncommited bytes of young generation in heap
     * @throws IllegalStateException if -XX:+ZenGCElasticHeap is not enabled
     */
    public long getTotalYoungUncommittedBytes();
}
