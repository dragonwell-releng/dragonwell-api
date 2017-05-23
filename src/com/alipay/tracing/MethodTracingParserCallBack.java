package com.alipay.tracing;

import java.util.List;

/**
 * callback of method tracing parsing
 */
public interface MethodTracingParserCallBack {

    /**
     * this method will be called after parsing
     * @param records the parsed result
     */
    void postParse(List<MethodTracingRecord> records);
    
}
