package com.alipay.tracing;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/**
 * parent class for all binary parsers
 */
abstract class AbstractBinaryParser<R> {
    
    protected ByteBuffer data;
    
    AbstractBinaryParser() {
    }
    
    AbstractBinaryParser(ByteBuffer data) {
        this.data = data;
    }
    
    AbstractBinaryParser(byte[] arr) {
        this.data = ByteBuffer.wrap(arr);
    }
    
    void ensureRemaining(int remainSize) throws BufferUnderflowException {
        if (data == null || data.remaining() < remainSize)
            throw new BufferUnderflowException();
    }
    
    abstract R parse() throws IOException;
    
    ByteBuffer data() {
        return data;
    }
    
    void setData(ByteBuffer data) {
        this.data = data;
    }
    
    void setData(byte[] data) {
        this.data = ByteBuffer.wrap(data);
    }
    
}
