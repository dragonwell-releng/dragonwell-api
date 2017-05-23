package com.alipay.tracing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Util {

    // Switch to enable debugging output of ztrace logging
    private static boolean debug = "true".equals(System.getProperty("ztrace.log.debug"));

    /*
     * convenient print method to support runtime debug
     */
    static void debug(String msg) {
        throw new RuntimeException("AJDK dummy API found");
    }

    static void debug(Exception e) {
        throw new RuntimeException("AJDK dummy API found");
    }

    static void debug(String msg, byte[] arr) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public static String readRawTextFile(String fname) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public static MappedByteBuffer readRawBinaryFile(String fname) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public static MappedByteBuffer readRawBinaryFile(FileChannel ch, long start, long bufLen) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public static MappedByteBuffer readRawBinaryFile(String fname, long start, long bufLen) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public static String getMethodTracingLogFilePath(long tid) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public static String getMethodIdMappingFilePath() {
        throw new RuntimeException("AJDK dummy API found");
    }

    public static String getTracingIdMappingFilePath() {
        throw new RuntimeException("AJDK dummy API found");
    }

    private static String getFilePathImpl(String fname) {
        throw new RuntimeException("AJDK dummy API found");
    }

    public static long readVarInt(ByteBuffer data) {
        throw new RuntimeException("AJDK dummy API found");
    }
}
