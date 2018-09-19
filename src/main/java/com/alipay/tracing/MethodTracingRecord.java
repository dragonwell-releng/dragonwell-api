package com.alipay.tracing;

/**
 * read-only log record structure for method tracing log list
 */
public class MethodTracingRecord extends LogRecord {
    
    private static final long serialVersionUID = -8274382853616999473L;
    
    private String methodSignature;
    private MethodStatus methodStatus;
    // entryTimeStamp is the start time of method entering
    private long entryTimeStamp;
    // wallTime is the relative time of executing the method
    private long wallTime;
    private long cpuTime;
    private String tracingId;
    private long allocatedBytes;
    private long cookedAllocatedBytes;
    private long stackDepth;
    
    public MethodTracingRecord(String sig, String tracingId, MethodStatus status, long entryTimeStamp, long wallTime,
                               long cpuTime, long totalExcludeTLAB, long totalIncludeTLAB, long stackDepth) {
        super();
        this.methodSignature = sig;
        this.tracingId = (tracingId == null ? BinaryLogDictionary.UNKNOWN_NAME : tracingId);
        this.methodStatus = status;
        this.entryTimeStamp = entryTimeStamp;
        this.cpuTime = cpuTime;
        this.wallTime = wallTime;
        this.allocatedBytes = totalExcludeTLAB;
        this.cookedAllocatedBytes = totalIncludeTLAB;
        this.stackDepth = stackDepth;
    }
    
    public String getMethodSignature() {
        return methodSignature;
    }
    
    public MethodStatus getMethodStatus() {
        return methodStatus;
    }
    
    public long getEntryTimeStamp() {
        return entryTimeStamp;
    }
    
    public long getWallTime() {
        return wallTime;
    }
    
    public long getCpuTime() {
        return cpuTime;
    }
    
    public String getTracingId() {
        return tracingId;
    }
    
    public long getAllocatedBytes() {
        return allocatedBytes;
    }
    
    public long getCookedAllocatedBytes() {
        return cookedAllocatedBytes;
    }
    
    public long getStackDepth() {
        return stackDepth;
    }
    
    public String getCachedString() {
        return cachedString;
    }
    
    private String cachedString = null;
    
    public String toString() {
        if (cachedString == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[entry timestamp=").append(entryTimeStamp).append("] [wall time=").append(wallTime).append("] [thread CPU time=").append(cpuTime)
                    .append("] [tracing_id=").append(tracingId).append("] [stack_depth=").append(stackDepth)
                    .append("] [status=").append(methodStatus.name()).append("] method=").append(methodSignature);
            
            if (cookedAllocatedBytes >= 0 && allocatedBytes >= 0) {
                sb.append(" totalMem=").append(cookedAllocatedBytes).append(" mem=").append(allocatedBytes);
            }
            cachedString = sb.toString();
        }
        
        return cachedString;
    }
}