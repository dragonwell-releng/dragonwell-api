package com.alibaba.tenant;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Supplier;

/**
 * Used to store all the data isolated per tenant.
 */
public class TenantData {
    /**
     * Retrieves the value of {@code obj}'s field isolated per tenant
     * @param obj           Object the field associates with
     * @param fieldName     Field name
     * @param supplier      Responsible for creating the initial field value
     * @return              Value of field.
     */
    @SuppressWarnings("unchecked")
    public synchronized <K, T> T getFieldValue(K obj, String fieldName, Supplier<T> supplier) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Retrieves the value of {@code obj}'s field isolated per tenant
     * @param obj           Object the field associates with
     * @param fieldName     Field name
     * @return              Value of field, null if not found
     */
    public synchronized <K, T> T getFieldValue(K obj, String fieldName) {
        throw new RuntimeException("AJDK dummy API found");
    }

    /**
     * Sets the value for tenant isolated field
     * @param key           Object associated with field.
     * @param fieldName     name of field.
     * @param value         new field value
     */
    public synchronized <K, T> void setFieldValue(K key, String fieldName, T value) {
        throw new RuntimeException("AJDK dummy API found");
    }
}
