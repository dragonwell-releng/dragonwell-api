/*
 * @(#)GCIHDummy.java  1.0.0 16/11/29
 *
 */

package com.taobao.gcih;


/**
 * This class provides dummy APIs to manipulate GCIH
 */
class GCIHDummy implements GCIHOperation {

    public boolean contains(Object obj) {
        return false;
    }

    public long freeMemory() {
        return 0l;
    }

    public int getObjectSize(Object obj) {
        return -1;
    }

    public <T> T moveIn(T obj) {
        return obj;
    }

    @Override
    public void compact() {
        throw new RuntimeException("Unimplemented");
    }
}
