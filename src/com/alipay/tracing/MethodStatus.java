package com.alipay.tracing;

public enum MethodStatus {
    INTERPRETED("Interpreted", 0x0), COMPILED("Compiled", 0x10), NATIVE("Native", 0x20), UNKNOWN("Unknown", 0xFF);
    
    private String name;
    private int value;
    
    MethodStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }
    
    public String toString() {
        return name;
    }
    
    public int getValue() {
        return value;
    }
    
    public static MethodStatus fromValue(int value) {
        switch (value) {
            case 0x0:
                return INTERPRETED;
            case 0x10:
                return COMPILED;
            case 0x20:
                return NATIVE;
            default:
                return UNKNOWN;
        }
    }
}
