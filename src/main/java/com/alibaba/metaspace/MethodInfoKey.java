package com.alibaba.metaspace;

import java.io.Serializable;
import java.util.Objects;

public class MethodInfoKey implements Serializable {

    private static final long serialVersionUID = -1936978045753666989L;

    private String name;

    private String signature;

    private String className;

    public MethodInfoKey(String name, String signature, String className) {
        this.name = name;
        this.signature = signature;
        this.className = className.replace('.', '/');
    }

    public String getName() {
        return name;
    }

    public String getSignature() {
        return signature;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return className + "." + name + signature;
    }

    @Override
    public int hashCode() {
        if (name == null || signature == null || className == null) {
            throw new IllegalStateException("name or signature or className is null!");
        }
        return name.hashCode() ^ signature.hashCode() ^ className.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MethodInfoKey)) {
            return false;
        }
        MethodInfoKey o = (MethodInfoKey) other;
        return Objects.equals(this.name, o.name) && Objects.equals(this.className, o.className) &&
                Objects.equals(this.signature, o.signature);
    }
}
