package com.alipay.tracing;

import java.io.File;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

public class BinaryLogDictionary {
    public static final String DEFAULT_METHOD_ID_MAP_FILE_NAME = "method_id.map";

    public static final String DEFAULT_TRACING_ID_MAP_FILE_NAME = "tracing_id.map";

    public static final String UNKNOWN_NAME = "UNKNOWN_STRING";

    // data structure to hold mapping data
    private IDInfoMap<Long, String> methodIdMap;

    private IDInfoMap<Long, String> tracingIdMap;

    private interface IdExtractor {
        long getid(ByteBuffer bb);
    }

    private static class IdStringMapParser extends AbstractBinaryParser<IDInfoMap<Long, String>> {

        private IdExtractor idGetter;

        private int version = -1;

        private long startWallTimeNano = -1;

        private long startTimeNano = -1;

        private static final long headerMagicNumber = 0xBABABABA;

        IdStringMapParser(IdExtractor idGetter) {
            this.idGetter = idGetter;
        }

        IdStringMapParser(ByteBuffer data, IdExtractor idGetter) {
            super(data);
            this.idGetter = idGetter;
        }

        IDInfoMap<Long, String> parse() throws IOException{
            throw new RuntimeException("AJDK dummy API found");
        }
    }

    // extract ID in 4 bytes length
    private static final IdExtractor methodIdExtractor = new IdExtractor() {
        @Override
        public long getid(ByteBuffer bb) {
            throw new RuntimeException("AJDK dummy API found");
        }
    };

    // extract ID in 4 bytes length
    private static final IdExtractor tracingIdExtractor = new IdExtractor() {
        @Override
        public long getid(ByteBuffer bb) {
            throw new RuntimeException("AJDK dummy API found");
        }
    };

    private IdStringMapParser methodIdFileParser;

    private IdStringMapParser tracingIdFileParser;

    private FileChannel methodIdFileChannel = null;

    private FileChannel tracingIdFileChannel = null;

    private long lastMethodIdFileSize;

    private long lastTracingIdFileSize;

    public BinaryLogDictionary(String dirName) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public BinaryLogDictionary(ByteBuffer methodIdBuf, ByteBuffer tracingIdBuf) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public void incrementalParse() throws IOException {
        throw new RuntimeException("AJDK dummy API found");
    }

    public BinaryLogDictionary(byte[] methodIdBuf, byte[] tracingIdBuf) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public String getMethodName(long key) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public String getTracingIdString(long key) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public long getVersion() {
        throw new RuntimeException("AJDK dummy API found");
    }

    public long getStartWallTimeNano() {
        throw new RuntimeException("AJDK dummy API found");
    }

    public long getStartTimeNano() {
        throw new RuntimeException("AJDK dummy API found");
    }

    public IDInfoMap<Long, String> getMethodIdMap() {
        throw new RuntimeException("AJDK dummy API found");
    }

    public IDInfoMap<Long, String> getTracingIdMap() {
        throw new RuntimeException("AJDK dummy API found");
    }

}