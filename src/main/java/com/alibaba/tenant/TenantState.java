package com.alibaba.tenant;

import com.alibaba.rcm.ResourceContainer;
import com.alibaba.rcm.ResourceContainer.State;

/**
 * Defines the state used by TenantContainer
 */
public enum TenantState {
    /**
     * Created but not attached yet.
     */
    STARTING,
    /**
     * Ready for attaching.
     */
    RUNNING,
    /**
     * {@link ResourceContainer#destroy()} has been called.
     */
    STOPPING,
    /**
     * Container is destroyed. Further usage is not allowed.
     */
    DEAD;
}

