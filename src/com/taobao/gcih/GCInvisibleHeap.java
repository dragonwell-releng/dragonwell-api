/*
 * @(#)GCInvisibleHeap.java  1.0.0 16/11/29
 */

package com.taobao.gcih;

import java.lang.IllegalStateException;

/**
 * This class provides APIs to manipulate GCIH
 */
public class GCInvisibleHeap {
    private static GCIHOperation impl;

    static {
        try {
           impl = new GCIHImpl();
        } catch (Throwable e) {
           System.out.println("GCIH: " + e.getMessage() +
               ", swith to dummy function!");
           impl = new GCIHDummy();
        }
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

    public static <T> T moveIn(T obj) {
        return impl.moveIn(obj);
    }
}
