package com.alipay.tracing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.List;

import com.alipay.tracing.MethodTracingRecord.MethodStatus;

public class LogFile {

    static final String TEXT_CONTENT_SEPARATOR = "\n";

    /**
     * Read a list of method record text log from specific file
     *
     * @param fname file name
     * @return a list of parsed MethodTracingRecord
     */
    public static List<MethodTracingRecord> readMethodTracingTextLog(String fname) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public static void readMethodTracingBinaryLogWithCallBack(String fname,
                                                              MethodTracingParserCallBack methodTracingParserCallBack, int interval) throws IOException {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Read a list of method tracing logs from a file, which was writen in
     * binary format;
     *
     * @param fname file name
     * @return a list of parsed MethodTracingRecord
     */
    public static List<MethodTracingRecord> readMethodTracingBinaryLog(String fname) throws IOException {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Parse a list of method tracing log records from a byte array
     *
     * @param buf source byte array
     * @return a list of parsed MethodTracingRecord
     */
    public static List<MethodTracingRecord> parse(byte[] buf, BinaryLogDictionary dict) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public static List<MethodTracingRecord> parse(ByteBuffer buf, BinaryLogDictionary dict) {
        throw new RuntimeException("AJDK dummy API found");
    }

    // Flag byte of record
    static class RecordFlag {
        private int flag;
        private static final int MASK_IS_MEMORY_TRACING = (0x1 << 1);
        private static final int MASK_IS_CPU_TIME_TRACING = (0x1 << 2);
        private static final int MASK_HAS_TRACING_ID = (0x1 << 3);
        private static final int MASK_METHOD_STATUS = 0x30;

        RecordFlag(byte flag) {
            this.flag = flag;
        }

        boolean hasTracingID() {
            return 0 != (flag & MASK_HAS_TRACING_ID);
        }

        boolean isMemoryTracingEnabled() {
            return 0 != (flag & MASK_IS_MEMORY_TRACING);
        }

        boolean isCpuTimeTracingEnabled() {
            return 0 != (flag & MASK_IS_CPU_TIME_TRACING);
        }

        MethodStatus getStatus() {
            return MethodStatus.fromValue(flag & MASK_METHOD_STATUS);
        }
    }
}
