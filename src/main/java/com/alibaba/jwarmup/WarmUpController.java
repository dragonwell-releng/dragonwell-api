package com.alibaba.jwarmup;

import com.alibaba.metaspace.MetaspaceInfo;
import com.alibaba.metaspace.MethodInfoEntry;
import com.alibaba.metaspace.MethodInfoKey;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * This class supplies APIs for customized compilation policy.
 */
public class WarmUpController {

    private WarmUpController() { }

    public static WarmUpController getInstance() {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * refresh cached {@link MethodInfoEntry} collections
     */
    public void refresh() {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * get compiled method list in given compile level.
     * for latest method list, should call {@link WarmUpController}.refresh() before this.
     * @param level compile level
     * @return list of {@link MethodInfoEntry}
     */
    public List<MethodInfoEntry> getCompiledMethodList(int level) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * resolve {@link Method}s or {@link Constructor}s from literal struct {@link MethodInfoEntry}s
     * and try compile those
     * @param entries literal entries {@link MethodInfoEntry}
     * @return count of successfully committed force compilation tasks
     */
    public int forceCompile(Collection<MethodInfoEntry> entries) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * resolve {@link Method} or {@link Constructor} from literal struct {@link MethodInfoEntry} and try compile it
     * @param entry literal entry {@link MethodInfoEntry}
     * @return count of successfully committed force compilation tasks
     */
    public int forceCompile(MethodInfoEntry entry) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * force compile a {@link Method}
     * @param m target {@link Method}
     * @param level compile level
     * @return true on successful compilation of submitted tasks
     */
    public boolean forceCompile(Method m, int level) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * force compile a {@link Constructor}
     * @param ctor target {@link Constructor}
     * @param level compile level
     * @return true on successful compilation of submitted tasks
     */
    public boolean forceCompile(Constructor ctor, int level) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * force compile methods recorded in target file
     * @param file target {@link File}
     * @return count of successfully completed compilation tasks
     * @throws IOException
     */
    public int forceCompileFromFile(File file) throws IOException {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * force compile methods recorded in target file list
     * @param files target {@link File}s
     * @return count of successfully completed compilation tasks
     * @throws IOException
     */
    public int forceCompileFromFiles(List<File> files) throws IOException {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Save all methods to target file which compile level greater than or equal to given level
     * @param target target {@link File}
     * @param level minimal level to save
     * @throws IOException
     */
    public void saveMethodsToFile(File target, int level) throws IOException {
        throw new RuntimeException("AJDK dummy API found");
    }
}
