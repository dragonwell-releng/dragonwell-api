package com.alipay.tracing;

import java.util.HashMap;

public class IDInfoMap<K, V> extends HashMap<K, V> {

    private static final long serialVersionUID = -3381853179906529233L;

    private int version;

    private long startWallTimeNano = 0;

    private long startTimeNano = 0;

    public IDInfoMap() {
        super();
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public long getStartWallTimeNano() {
        return startWallTimeNano;
    }

    void setStartWallTimeNano(long startWallTimeNano) {
        this.startWallTimeNano = startWallTimeNano;
    }

    public long getStartTimeNano() {
        return startTimeNano;
    }

    void setStartTimeNano(long startTimeNano) {
        this.startTimeNano = startTimeNano;
    }
}
