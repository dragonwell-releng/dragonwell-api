package com.alipay.tracing;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.alipay.tracing.LogFile.RecordFlag;

/**
 * the binary log file parser
 */
public class BinaryLogParser extends AbstractBinaryParser<List<MethodTracingRecord>> {

    static final String METHOD_TRACING_ID_MAP = "com.alipay.tracing.needsIDMap";
    private static boolean needMapId = true;

    private BinaryLogDictionary dict;
    private long lastIndex;
    private FileChannel ch;


    BinaryLogParser(File file, BinaryLogDictionary dict) throws IOException {
        this.dict = dict;
        ch = FileChannel.open(file.toPath(), StandardOpenOption.READ);
    }

    BinaryLogParser(ByteBuffer data, BinaryLogDictionary dict) {
        super(data);
        this.dict = dict;
    }

    BinaryLogParser(byte[] data, BinaryLogDictionary dict) {
        super(data);
        this.dict = dict;
    }

    List<MethodTracingRecord> incrementalParse() throws IOException {
        throw new RuntimeException("AJDK dummy API found");
    }

    List<MethodTracingRecord> parse() {
        throw new RuntimeException("AJDK dummy API found");
    }

}
