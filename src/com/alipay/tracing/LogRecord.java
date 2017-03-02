package com.alipay.tracing;

import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;

/**
 * interface represents a record from log file
 */
public class LogRecord implements Serializable {

    private static final long serialVersionUID = -1L;

    // keep records of raw data as much as possible
    transient SoftReference<ByteBuffer> rawData = null;
}
