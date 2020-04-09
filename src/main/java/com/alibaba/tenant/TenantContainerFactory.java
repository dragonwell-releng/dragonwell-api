package com.alibaba.tenant;

import com.alibaba.rcm.Constraint;
import com.alibaba.rcm.ResourceContainer;
import com.alibaba.rcm.ResourceContainerFactory;

/**
 * Singleton factory specialized for multi-tenant {@code ResourceContainer}
 * With support of new RCM API (com.alibaba.rcm)
 *
 */
public class TenantContainerFactory implements ResourceContainerFactory {

    /**
     * Create a {@code ResourceContainer} which is capable of throttling resource
     * using MuliTenant facitlities.
     * A {@code TenantContainer} object will be created implicitly for each successful
     * call to {@code TenantContainerFactory.createContainer}
     * @param constraints the target {@code Constraint}s
     * @return
     */
    @Override
    public TenantResourceContainer createContainer(Iterable<Constraint> constraints) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Retrieve the {@code TenantContainer} object associated with given {@code ResourceContainer}
     *
     * @param resourceContainer
     * @return
     */
    public static TenantContainer tenantContainerOf(ResourceContainer resourceContainer) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     *
     * @return Singleton instance of TenantContainerFactory
     */
    public static TenantContainerFactory instance() {
        throw new RuntimeException("Dummy AJDK API found");
    }
}
