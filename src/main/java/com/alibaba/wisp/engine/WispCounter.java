package com.alibaba.wisp.engine;

import java.beans.ConstructorProperties;

final public class WispCounter {

    private long switchCount = 0;

    private long waitTimeTotal = 0;

    private long runningTimeTotal = 0;

    private long completedTaskCount = 0;

    private long createTaskCount = 0;

    private long parkCount = 0;

    private long unparkCount = 0;

    private long unparkInterruptSelectorCount = 0;

    private long selectableIOCount = 0;

    private long timeOutCount = 0;

    private long eventLoopCount = 0;

    private long totalEnqueueTime = 0;

    private long maxEnqueueTime = 0;

    private long enqueueCount = 0;

    private long totalExecutionTime = 0;

    private long maxExecutionTime = 0;

    private long executionCount = 0;

    private long totalWaitSocketIOTime = 0;

    private long maxWaitSocketIOTime = 0;

    private long waitSocketIOCount = 0;

    private long totalBlockingTime = 0;

    private long maxBlockingTime = 0;

    private long unparkFromJvmCount = 0;

    private long runningTaskCount = 0;

    private long taskQueueLength = 0;

    WispEngine engine;

    public long getCompletedTaskCount() {
        return completedTaskCount;
    }

    public long getTotalEnqueueTime() {
        return totalEnqueueTime;
    }

    public long getEnqueueCount() {
        return enqueueCount;
    }

    public long getTotalExecutionTime() {
        return totalExecutionTime;
    }

    public long getExecutionCount() {
        return executionCount;
    }

    public long getTotalWaitSocketIOTime() {
        return totalWaitSocketIOTime;
    }

    public long getWaitSocketIOCount() {
        return waitSocketIOCount;
    }

    public long getTotalBlockingTime() {
        return totalBlockingTime;
    }

    public long getUnparkCount() {
        return unparkCount;
    }

    public long getMaxEnqueueTime() {
        return maxEnqueueTime;
    }

    public long getMaxExecutionTime() {
        return maxExecutionTime;
    }

    public long getMaxWaitSocketIOTime() {
        return maxWaitSocketIOTime;
    }

    public long getMaxBlockingTime() {
        return maxBlockingTime;
    }

    public long getTaskQueueLength() {
        return taskQueueLength;
    }

    public long getRunningTaskCount() {
        return runningTaskCount;
    }

    WispCounter() {}

    @ConstructorProperties({"completedTaskCount", "totalEnqueueTime", "maxEnqueueTime", "enqueueCount",
                            "totalExecutionTime", "maxExecutionTime", "executionCount",
                            "totalWaitSocketIOTime", "maxWaitSocketIOTime", "waitSocketIOCount",
                            "totalBlockingTime", "maxBlockingTime", "unparkCount",
                            "runningTaskCount", "taskQueueLength"})
    public WispCounter(long completedTaskCount, long totalEnqueueTime, long maxEnqueueTime, long enqueueCount,
                       long totalExecutionTime, long maxExecutionTime, long executionCount,
                       long totalWaitSocketIOTime, long maxWaitSocketIOTime, long waitSocketIOCount,
                       long totalBlockingTime, long maxBlockingTime, long unparkCount,
                       long runningTaskCount, long taskQueueLength) {
        this.completedTaskCount = completedTaskCount;
        this.totalEnqueueTime = totalEnqueueTime;
        this.maxEnqueueTime = maxEnqueueTime;
        this.enqueueCount = enqueueCount;
        this.totalExecutionTime = totalExecutionTime;
        this.maxExecutionTime = maxExecutionTime;
        this.executionCount = executionCount;
        this.totalWaitSocketIOTime = totalWaitSocketIOTime;
        this.maxWaitSocketIOTime = maxWaitSocketIOTime;
        this.waitSocketIOCount = waitSocketIOCount;
        this.totalBlockingTime = totalBlockingTime;
        this.maxBlockingTime = maxBlockingTime;
        this.unparkCount = unparkCount;
        this.runningTaskCount = runningTaskCount;
        this.taskQueueLength = taskQueueLength;
    }

}
