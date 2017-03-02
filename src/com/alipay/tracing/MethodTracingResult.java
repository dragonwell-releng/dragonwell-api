package com.alipay.tracing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class MethodTracingResult implements Serializable {

    private static final long serialVersionUID = -1L;

    private Map<String, byte[]> methodData;
    private byte[] methodIdMappingData;
    private byte[] tracingIdMappingData;
    private boolean compressed;
    private int totalSize;

    private int tracingIdMappingDataLen;
    private int methodIdMappingDataLen;
    private Map<String, Integer> methodDataLen;

    // getters & setters
    public byte[] getMethodIdMappingData() {
        return methodIdMappingData;
    }

    public byte[] getTracingIdMappingData() {
        return tracingIdMappingData;
    }

    public Map<String, byte[]> getMethodData() {
        return methodData;
    }

    public void setMethodIdMappingData(byte[] data) {
        methodIdMappingData = data;
    }

    public void setTracingIdMappingData(byte[] data) {
        tracingIdMappingData = data;
    }

    public void setMethodData(Map<String, byte[]> data) {
        methodData = data;
    }

    public boolean getCompressed() {
        return compressed;
    }

    public void setCompressed(boolean comp) {
        compressed = comp;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int sz) {
        totalSize = sz;
    }

    public void setTracingIdMappingDataLen(int i) {
        tracingIdMappingDataLen = i;
    }

    public int getTracingIdMappingDataLen() {
        return tracingIdMappingDataLen;
    }

    public void setMethodIdMappingDataLen(int i) {
        methodIdMappingDataLen = i;
    }

    public int getMethodIdMappingDataLen() {
        return methodIdMappingDataLen;
    }

    public void setMethodDataLen(Map<String, Integer> lens) {
        methodDataLen = lens;
    }

    public Map<String, Integer> getMethodDataLen() {
        return methodDataLen;
    }

    public MethodTracingResult() { /* JMX just requires this */ }

    public MethodTracingResult(Map<String, byte[]> contents, byte[] midMapping, byte[] tidMapping) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public Map<String, List<MethodTracingRecord>> toMap() {
        throw new RuntimeException("AJDK dummy API found");
    }


    public void compress() {
        throw new RuntimeException("AJDK dummy API found");
    }

    public void uncompress() {
        throw new RuntimeException("AJDK dummy API found");
    }

    private int updateTotalSize() {
        throw new RuntimeException("AJDK dummy API found");
    }

    private static byte[] compressArray(byte[] input) {
        throw new RuntimeException("AJDK dummy API found");
    }


    private static byte[] uncompressArray(byte[] input, int outLen) {
        throw new RuntimeException("AJDK dummy API found");
    }
}
