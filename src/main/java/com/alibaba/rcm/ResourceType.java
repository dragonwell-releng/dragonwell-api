package com.alibaba.rcm;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Enumeration of {@link Constraint}'s type.
 * <p>
 * {@code class} is used instead of {@code enum} to provide extensibility.
 * An implementation of resource management can define its own
 * resource type. Below is an example of extension ResourceType:
 *
 * <pre>
 *     public class MyResourceType extends ResourceType {
 *         public final static ResourceType CPU_CFS = new MyResourceType();
 *
 *         public MyResourceType() {}
 *     }
 * </pre>
 * <p>
 * CPU_CFS is an instance of {@code ResourceType}, so it can be used wherever
 * ResourceType is handled.
 * <p>
 * The descriptions and parameters of each public final static value need to
 * be documented in details.
 */
public class ResourceType {
    /**
     * Throttling the CPU usage by cpu percentage.
     * <p>
     * param #1: CPU usage measured in a percentage granularity.
     * The value ranges from 0 to CPU_COUNT * 100. For example, {@code 150}
     * means that ResourceContainer can use up to 1.5 CPU cores.
     */
    public final static ResourceType CPU_PERCENT = new ResourceType("CPU_PERCENT");
    /**
     * Throttling the max heap usage.
     * <p>
     * param #1: maximum heap size in bytes
     */
    public final static ResourceType HEAP_RETAINED = new ResourceType("HEAP_RETAINED");

    protected ResourceType(String name) {
        throw new RuntimeException("Dummy AJDK API found");
    }
    /**
     * Creates a {@link Constraint} with this {@code ResourceType} and
     * the given {@code values}.
     *
     * @param values constraint values
     * @return newly-created Constraint
     * @throws IllegalArgumentException when parameter check fails
     */
    public final Constraint newConstraint(long... values) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Checks the validity of parameters. Since a long [] is used to
     * express the configuration, a length and range check is required.
     * <p>
     * Each ResourceType instance can implement its own {@code validate()}
     * method through Override, for example:
     * <pre>
     * public final static ResourceType MY_RESOURCE =
     *     new ResourceType() {
     *         protected boolean validate(long[] values) {
     *              // the check logic
     *         }
     *     };
     * </pre>
     *
     * @param values parameter value
     * @return if parameter is validated
     */
    protected boolean validate(long[] values) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Dummy AJDK API found");
    }
}
