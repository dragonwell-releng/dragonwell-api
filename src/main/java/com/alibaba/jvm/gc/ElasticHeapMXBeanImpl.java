package com.alibaba.jvm.gc;
import com.alibaba.management.ElasticHeapMXBean;
import sun.management.Util;
import javax.management.ObjectName;
import sun.security.action.GetBooleanAction;
import java.security.AccessController;

/**
 * Implementation class for ElasticHeapMXBean.
 **/
public class ElasticHeapMXBeanImpl implements ElasticHeapMXBean {

    @Override
    public void setYoungGenCommitPercent(int percent) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    @Override
    public int  getYoungGenCommitPercent() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    @Override
    public long getTotalYoungUncommittedBytes() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    @Override
    public ObjectName getObjectName() {
        throw new RuntimeException("Dummy AJDK API found");
    }
}
