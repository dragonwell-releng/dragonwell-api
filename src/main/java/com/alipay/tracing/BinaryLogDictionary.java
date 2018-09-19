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
            return bb.getInt();
        }
    };
    
    // extract ID in 4 bytes length
    private static final IdExtractor tracingIdExtractor = new IdExtractor() {
        @Override
        public long getid(ByteBuffer bb) {
            return bb.getInt();
        }
    };
    
    private IdStringMapParser methodIdFileParser;
    
    private IdStringMapParser tracingIdFileParser;
    
    private FileChannel methodIdFileChannel = null;
    
    private FileChannel tracingIdFileChannel = null;
    
    private long lastMethodIdFileSize;
    
    private long lastTracingIdFileSize;
    
    public BinaryLogDictionary(String dirName) {
        File d = new File(dirName);
        if (d != null && d.exists() && d.isDirectory()) {
            methodIdFileParser = new IdStringMapParser(methodIdExtractor);
            tracingIdFileParser = new IdStringMapParser(tracingIdExtractor);
            
            File methodIdFile = new File(dirName + File.separator + DEFAULT_METHOD_ID_MAP_FILE_NAME);
            File tracingIdFile = new File(dirName + File.separator + DEFAULT_TRACING_ID_MAP_FILE_NAME);
            try {
                methodIdFileChannel = FileChannel.open(methodIdFile.toPath(), StandardOpenOption.READ);
                tracingIdFileChannel = FileChannel.open(tracingIdFile.toPath(), StandardOpenOption.READ);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException(dirName + " is not a valid ztrace log dir");
        }
    }
    
    public BinaryLogDictionary(ByteBuffer methodIdBuf, ByteBuffer tracingIdBuf) {
        try{
            IdStringMapParser methodIdParser = new IdStringMapParser(methodIdBuf, methodIdExtractor);
            methodIdMap = methodIdParser.parse();
            IdStringMapParser tracingIdParser = new IdStringMapParser(tracingIdBuf, methodIdExtractor);
            tracingIdMap = tracingIdParser.parse();
            if (methodIdMap.getVersion() != tracingIdMap.getVersion()) {
                System.out.println("WARNING: mapping files have got different version string: m-id="
                        + methodIdMap.getVersion() + ", t-id=" + tracingIdMap.getVersion());
            }
        } catch (IOException e){
            System.err.println("ERROR: method id or tracing id mapping files parsing failed");
        }
    }
    
    public void incrementalParse() throws IOException {
        throw new RuntimeException("AJDK dummy API found");
    }
    
    public BinaryLogDictionary(byte[] methodIdBuf, byte[] tracingIdBuf) {
        this(ByteBuffer.wrap(methodIdBuf), ByteBuffer.wrap(tracingIdBuf));
    }
    
    public String getMethodName(long key) {
        if (methodIdMap != null) {
            return methodIdMap.get(key);
        }
        return null;
    }
    
    public String getTracingIdString(long key) {
        if (tracingIdMap != null) {
            return tracingIdMap.get(key);
        }
        return null;
    }
    
    public long getVersion() {
        return methodIdMap.getVersion();
    }

    public long getStartWallTimeNano() {
        return methodIdMap.getStartWallTimeNano();
    }

    public long getStartTimeNano() {
        return methodIdMap.getStartTimeNano();
    }

    public IDInfoMap<Long, String> getMethodIdMap() {
        return methodIdMap;
    }
    
    public IDInfoMap<Long, String> getTracingIdMap() {
        return tracingIdMap;
    }
    
}