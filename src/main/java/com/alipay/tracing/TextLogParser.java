package com.alipay.tracing;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class TextLogParser {
    private BufferedReader reader;
    
    TextLogParser(BufferedReader reader) {
        this.reader = reader;
    }
    
    List<MethodTracingRecord> parse() {
        throw new RuntimeException("AJDK dummy API found");
    }
}
