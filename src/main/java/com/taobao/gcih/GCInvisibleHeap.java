/*
 * @(#)GCInvisibleHeap.java  1.0.0 16/11/29
 */

package com.taobao.gcih;

/**
 * This class provides APIs to manipulate GCIH
 */
public class GCInvisibleHeap {

    // The GCIH instance
    private static GCIHOperation impl;

    static {
        impl = new GCIHDummy();
    }

    public static boolean contains(Object obj) {
        return impl.contains(obj);
    }

    public static long freeMemory() {
        return impl.freeMemory();
    }

    public static int getObjectSize(Object obj) {
        return impl.getObjectSize(obj);
    }

    /**
     * Move all objects that reachable from <code>rootObj</code> to GC invisible heap
     *
     * @param rootObj root of the object graph
     * @param <T>
     * @return newly allocated root object from GC invisible heap
     */
    public static <T> T moveIn(T rootObj) {
        return impl.moveIn(rootObj);
    }

    /**
     * Compact live/reachable Java objects within GCIH,
     * unreachable objects will be reclaimed.
     */
    public static void compact() {
        impl.compact();
    }
}

