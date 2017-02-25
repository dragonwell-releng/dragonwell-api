/*
 * @(#)GCIHImpl.java  1.0.0 16/11/29
 *
 */

package com.taobao.gcih;

/**
 * This class provides native APIs to manipulate GCIH
 */
class GCIHImpl implements GCIHOperation {

    /* Make sure registerNatives is the first thing <clinit> does. */
    private static native void registerNatives();

    static {
        registerNatives();
    }

    // methods that do real work
    private static native boolean contains0(Object obj);
    private static native long freeMemory0();
    private static native int getObjectSize0(Object obj);
    private static native <T> T moveIn0(T obj);

    // implements methods of GCIHOperation
    public boolean contains(Object obj) {
        return contains0(obj);
    }

    public long freeMemory() {
        return freeMemory0();
    }

    public int getObjectSize(Object obj) {
        return getObjectSize0(obj);
    }

    public <T> T moveIn(T obj) {
        return moveIn0(obj);
    }
}
