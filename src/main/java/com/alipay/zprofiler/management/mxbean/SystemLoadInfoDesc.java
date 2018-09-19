package com.alipay.zprofiler.management.mxbean;

import java.beans.ConstructorProperties;
import java.util.Map;

public class SystemLoadInfoDesc {

    //global system info
    private long                  now;
    private String                loads[];    //size 3

    //current process
    private String                sState[];
    private String                dState[];
    private String                tState[];
    private String                rState[];
    private String                zState[];
    private String                xState[];

    private Map<String, String>   d2syscall;  //which syscall is doing by the thread in D status

    private Map<String, String>   tid2switchs;

    private Map<String, String[]> pid2stacks;

    @ConstructorProperties({ "now", "loads", "sState", "rState", "dState", "tState", "zState",
        "xState", "d2syscall", "tid2switchs", "pid2stacks" })
    public SystemLoadInfoDesc(long now, String[] loads, String sState[], String rState[],
                              String dState[], String tState[], String zState[], String xState[],
                              Map<String, String> d2syscall, Map<String, String> tid2switchs,
                              Map<String, String[]> pid2stacks) {
        this.now = now;
        this.loads = loads;
        this.sState = sState;
        this.rState = rState;
        this.dState = dState;
        this.tState = tState;
        this.zState = zState;
        this.xState = xState;
        this.d2syscall = d2syscall;
        this.tid2switchs = tid2switchs;
        this.pid2stacks = pid2stacks;
    }

    public long getNow() {
        return now;
    }

    public String[] getLoads() {
        return loads;
    }

    public String[] getsState() {
        return sState;
    }

    public String[] getdState() {
        return dState;
    }

    public String[] gettState() {
        return tState;
    }

    public String[] getrState() {
        return rState;
    }

    public String[] getzState() {
        return zState;
    }

    public String[] getxState() {
        return xState;
    }

    public Map<String, String> getD2syscall() {
        return d2syscall;
    }

    public Map<String, String> getTid2switchs() {
        return tid2switchs;
    }

    public Map<String, String[]> getPid2stacks() {
        return pid2stacks;
    }

}
