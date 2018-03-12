package com.alibaba.management;

import java.lang.management.PlatformManagedObject;
import java.util.List;

public interface WispCounterMXBean extends PlatformManagedObject {

    /**
     * @return list of managed wisp worker running state
     */
    List<Boolean> getRunningStates();

    /**
     * @return list of managed wisp worker switch count
     */
    List<Long> getSwitchCount();

    /**
     * @return list of managed wisp worker wait time total, unit ns
     */
    List<Long> getWaitTimeTotal();

    /**
     * @return list of managed wisp worker running time total, unit ns
     */
    List<Long> getRunningTimeTotal();

    /**
     * @return list of managed wisp worker complete task count
     */
    List<Long> getCompleteTaskCount();

    /**
     * @return list of managed wisp worker create task count
     */
    List<Long> getCreateTaskCount();

    /**
     * @return list of managed wisp worker park count
     */
    List<Long> getParkCount();

    /**
     * @return list of managed wisp worker unpark count
     */
    List<Long> getUnparkCount();

    /**
     * @return list of managed wisp worker lazy unpark count
     */
    List<Long> getLazyUnparkCount();

    /**
     * @return list of managed wisp worker unpark interrupt selector count
     */
    List<Long> getUnparkInterruptSelectorCount();

    /**
     * @return list of managed wisp worker do IO count
     */
    List<Long> getSelectableIOCount();

    /**
     * @return list of managed wisp worker timeout count
     */
    List<Long> getTimeOutCount();

    /**
     * @return list of managed wisp worker do event loop count
     */
    List<Long> getEventLoopCount();

    /**
     * @return list of managed wisp worker task queue length
     */
    List<Long> getQueueLength();
}
