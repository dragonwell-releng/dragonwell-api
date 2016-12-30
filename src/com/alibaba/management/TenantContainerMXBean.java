package com.alibaba.management;

import java.lang.management.PlatformManagedObject;
import java.util.List;

public interface TenantContainerMXBean extends PlatformManagedObject {

    public List<Long> getAllTenantIds();

    public long getTenantProcessCpuTimeById(long id);

    public long getTenantAllocatedMemoryById(long id);
}
