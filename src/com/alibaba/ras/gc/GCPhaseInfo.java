package com.alibaba.ras.gc;

import java.beans.ConstructorProperties;

/**
 * gc phase information, contains the name and time of a phase.
 */
public class GCPhaseInfo {

    private String name;

    private double time;

    /**
     * @param name the name of this GC phase
     * @param time the time used in this GC phase
     */
    @ConstructorProperties({ "name", "time" })
    public GCPhaseInfo(String name, double time) {
        this.name = name;
        this.time = time;
    }

    /**
     * get the name of this GC phase
     * @return phase name
     */
    public String getName() {
        return name;
    }

    /**
     * get the time used in this GC phase
     * @return time
     */
    public double getTime() {
        return time;
    }

}
