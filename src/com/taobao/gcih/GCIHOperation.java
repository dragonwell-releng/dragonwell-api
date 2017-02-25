/*
 * @(#)GCIHOperation.java  1.0.0 16/11/29
 */

package com.taobao.gcih;


/**
 * This interface provides operations to manipulate GCIH
 */
interface GCIHOperation {
    boolean contains(Object obj);
    int getObjectSize(Object obj);
    long freeMemory();
    <T> T moveIn(T obj);
}
