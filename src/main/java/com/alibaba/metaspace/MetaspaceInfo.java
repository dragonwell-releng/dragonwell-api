package com.alibaba.metaspace;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * This class can traverse compiled {@link Method} and {@link Constructor} in CodeCache.
 * Present as {@link MethodInfoEntry} collection.
 */
public class MetaspaceInfo {

    public static final int NONE = 0;
    public static final int SIMPLE = 1;
    public static final int LIMITED_PROFILE = 2;
    public static final int FULL_PROFILE = 3;
    public static final int FULL_OPTIMIZATION = 4;

    /**
     * try resolve actual {@link Method} or {@link Constructor} from literal structure {@link MethodInfoEntry}
     *
     * @param entry method info entry
     * @return true means has resolved at least one {@link Method} or {@link Constructor} successful
     */
    public static boolean tryResolveMethod(MethodInfoEntry entry) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * get method (represent as {@link MethodInfoEntry} collection with given compile level.
     *
     * @param level compile level
     * @return {@link MethodInfoEntry}) collection
     */
    public static ConcurrentHashMap<MethodInfoKey, Deque<MethodInfoEntry>> getMethodsByLevel(int level) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * refresh local java cache from JVM CodeCache
     */
    public static synchronized void refresh() {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * clear local java cache
     */
    public static synchronized void clear() {
        throw new RuntimeException("AJDK dummy API found");
    }


    /**
     * get target {@link Method} compile level
     *
     * @param m method
     * @return compile level, range 0 ~ 4
     */
    public static int getCompileLevel(Method m) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * get target {@link Constructor} compile level
     *
     * @param ctor constructor
     * @return compile level, range 0 ~ 4
     */
    public static int getCompileLevel(Constructor ctor) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * helper function that calculate {@link Method} signature
     *
     * @param method target method
     * @return signature
     */
    public static String calculateMethodSignature(Method method) {
        StringBuilder signature = new StringBuilder();
        if (method != null) {
            signature.append("(");
            for (Class<?> c : method.getParameterTypes()) {
                String lsig = Array.newInstance(c, 1).getClass().getName();
                signature.append(lsig.substring(1));
            }
            signature.append(")");

            Class<?> returnType = method.getReturnType();
            if (returnType == void.class) {
                signature.append("V");
            } else {
                String lsig = Array.newInstance(returnType, 1).getClass().getName();
                signature.append(lsig.substring(1));
            }

            signature = new StringBuilder(signature.toString().replace('.', '/'));
        }
        return signature.toString();
    }

    /**
     * helper function that calculate {@link Constructor} signature
     *
     * @param ctor target {@link Constructor}
     * @return signature
     */
    public static String calculateConstructorSignature(Constructor ctor) {
        StringBuilder signature = new StringBuilder();
        if (ctor != null) {
            signature.append("(");
            for (Class<?> c : ctor.getParameterTypes()) {
                String lsig = Array.newInstance(c, 1).getClass().getName();
                signature.append(lsig.substring(1));
            }
            signature.append(")");
            signature.append("V");
            signature = new StringBuilder(signature.toString().replace('.', '/'));
        }
        return signature.toString();
    }
}
