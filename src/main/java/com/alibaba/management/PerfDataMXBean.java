package com.alibaba.management;

import java.lang.management.PlatformManagedObject;
import java.util.List;
import java.util.Map;
import sun.management.counter.Counter;

/**
 * The PerfDataMXBean interface provides APIs for PerfData
 */
public interface PerfDataMXBean extends PlatformManagedObject {

    /**
     * Query performance counters of long type by pattern
     *
     * @param pattern the pattern for which to query, not null or empty
     * @return map of matched counters
     * @throws IllegalArgumentException if the name is null or empty
     * @see sun.management.counter.perf.PerfLongCounter
     */
    Map<String, Long> queryLongValuesByPattern(String pattern);

    /**
     * Query performance long value by name
     *
     * @param name the name for which to query, not null or empty
     * @return the long value of target counter
     * @throws IllegalArgumentException if the name is null or empty
     * @throws NoSuchElementException if the target counter is null or type mismatch
     * @see sun.management.counter.perf.PerfLongCounter
     */
    long queryLongValueByName(String name);

    /**
     * Query performance counters of string type by pattern
     *
     * @param pattern the pattern for which to query, not null or empty
     * @return map of matched counters
     * @throws IllegalArgumentException if the name is null or empty
     * @see sun.management.counter.perf.PerfStringCounter
     */
    Map<String, String> queryStringValuesByPattern(String pattern);

    /**
     * Query performance string value by name
     *
     * @param name the name for which to query, not null or empty
     * @return the string value of target counter
     * @throws IllegalArgumentException if the name is null or empty
     * @throws NoSuchElementException if the target counter is null or type mismatch
     * @see sun.management.counter.perf.PerfStringCounter
     */
    String queryStringValueByName(String name);

    /**
     * Query performance counters of byte array type by pattern
     *
     * @param pattern the pattern for which to query, not null or empty
     * @return map of matched counters
     * @throws IllegalArgumentException if the name is null or empty
     * @see sun.management.counter.perf.PerfByteArrayCounter
     */
    Map<String, byte[]> queryByteArrayValuesByPattern(String pattern);

    /**
     * Query performance byte array value by name
     *
     * @param name the name for which to query, not null or empty
     * @return the byte array value of target counter
     * @throws IllegalArgumentException if the name is null or empty
     * @throws NoSuchElementException if the target counter is null or type mismatch
     * @see sun.management.counter.perf.PerfByteArrayCounter
     */
    byte[] queryByteArrayValueByName(String name);

    /**
     * Query performance counters of long array type by pattern
     *
     * @param pattern the pattern for which to query, not null or empty
     * @return map of matched counters
     * @throws IllegalArgumentException if the name is null or empty
     * @see sun.management.counter.perf.PerfByteArrayCounter
     */
    Map<String, long[]> queryLongArrayValuesByPattern(String pattern);

    /**
     * Query performance long array value by name
     *
     * @param name the name for which to query, not null or empty
     * @return the long array value of target counter
     * @throws IllegalArgumentException if the name is null or empty
     * @throws NoSuchElementException if the target counter is null or type mismatch
     * @see sun.management.counter.perf.PerfLongArrayCounter
     */
    long[] queryLongArrayValueByName(String name);
}
