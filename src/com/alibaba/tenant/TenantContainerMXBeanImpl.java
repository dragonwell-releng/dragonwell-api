package com.alibaba.tenant;

import com.alibaba.management.TenantContainerMXBean;
import javax.management.ObjectName;
import java.util.List;

/**
 * Implementation class for TenantContainerMXBean.
 */
public class TenantContainerMXBeanImpl implements TenantContainerMXBean {

    @Override
    public List<Long> getAllTenantIds() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    @Override
    public long getTenantProcessCpuTimeById(long id) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    public long getTenantAllocatedMemoryById(long id) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    @Override
    public ObjectName getObjectName() {
        throw new RuntimeException("Dummy AJDK API found");
    }
}
