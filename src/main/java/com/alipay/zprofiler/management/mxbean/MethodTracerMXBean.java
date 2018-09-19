package com.alipay.zprofiler.management.mxbean;

import java.util.List;
import java.util.Map;

import com.alipay.tracing.MethodTracingResult;

public interface MethodTracerMXBean {

    public void startMethodTracing(String tids);

    public MethodTracingResult stopMethodTracing();

    public Map<String, byte[]> stopMethodTracingWithRawData();

    public String checkThreadLogFilesSize();

}
