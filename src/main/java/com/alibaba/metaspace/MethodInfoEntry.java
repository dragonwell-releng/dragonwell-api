package com.alibaba.metaspace;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.util.*;

/**
 * This class stores literal information that corresponding one or more
 * {@link Method} and {@link Constructor} in JVM
 */
public class MethodInfoEntry implements Serializable {

    public static class JVMMethod {
        WeakReference<Executable> o;
        boolean isMethod;

        public JVMMethod(Method m) {
            o = new WeakReference<Executable>(m);
            isMethod = true;
        }

        public JVMMethod(Constructor ctor) {
            o = new WeakReference<Executable>(ctor);
            isMethod = false;
        }

        public boolean isMethod() {
            return isMethod;
        }

        public boolean isConstructor() {
            return !isMethod;
        }

        public Object get() {
            Executable e = o.get();
            if (e != null && e.getClass() != Method.class && e.getClass() != Constructor.class) {
                throw new IllegalStateException("Wrong MethodInfoEntry substance type!");
            }
            return e;
        }

        // No default ctor allowed
        private JVMMethod() {

        }
    }

    private static final long serialVersionUID = -2806184269504474078L;

    protected MethodInfoEntry() {
    }

    public MethodInfoEntry(String name, String signature, String className) {
        this.key = new MethodInfoKey(name, signature, className);
    }

    public MethodInfoEntry(String name, String signature, String className, String filePath) {
        this(name, signature, className);
        this.filePath = filePath;
    }

    private MethodInfoKey key;

    private String classLoaderName;

    private String filePath;

    private transient Set<JVMMethod> resolvedMethods = new HashSet<JVMMethod>();

    private int compLevel;

    public MethodInfoKey getKey() {
        return key;
    }

    public boolean resolved() {
        return resolvedMethods.size() != 0;
    }

    public String getName() {
        return key.getName();
    }

    public String getSignature() {
        return key.getSignature();
    }

    public String getClassName() {
        return key.getClassName();
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    public void setClassLoaderName(String classLoaderName) {
        this.classLoaderName = classLoaderName.replace('.', '/');
    }

    public String getFilePath() {
        return filePath;
    }

    public int getCompLevel() {
        return compLevel;
    }

    public void setCompLevel(int compLevel) {
        this.compLevel = compLevel;
    }

    public Set<JVMMethod> getResolvedMethods() {
        if (resolvedMethods == null) {
            resolvedMethods = new HashSet<JVMMethod>();
        }
        return resolvedMethods;
    }

    public boolean matchTo(MethodInfoEntry other) {
        if (this == other) {
            return true;
        }
        if (!this.getKey().equals(other.getKey())) {
            return false;
        }

        if (this.getClassLoaderName() != null && !this.getClassLoaderName().equals(other.getClassLoaderName())) {
            return false;
        }
        if (this.getFilePath() != null && !this.getFilePath().equals(other.getFilePath())) {
            return false;
        }
        return true;
    }

    public boolean isResolved() {
        return !(getResolvedMethods().size() == 0);
    }

    public void addResolvedMethod(Method resolvedMethod) {
        getResolvedMethods().add(new JVMMethod(resolvedMethod));
    }

    public void addResolvedConstructor(Constructor resolvedConstructor) {
        getResolvedMethods().add(new JVMMethod(resolvedConstructor));
    }

    public void addResolvedMethod(JVMMethod jvmMethod) {
        getResolvedMethods().add(jvmMethod);
    }

    public void addResolvedMethod(Collection<JVMMethod> methods) {
        if (methods == null) {
            return;
        }
        getResolvedMethods().addAll(methods);
    }

    public String toString() {
        return key.toString() + "@" + classLoaderName + ":" + filePath;
    }


}
