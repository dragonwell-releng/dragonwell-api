package com.alibaba.rcm.internal;

import com.alibaba.rcm.Constraint;
import com.alibaba.rcm.ResourceContainer;
import sun.misc.JavaLangAccess;
import sun.misc.SharedSecrets;

import java.util.Collections;

/**
 * A skeletal implementation of {@link ResourceContainer} that practices
 * the attach/detach paradigm described in {@link ResourceContainer#run(Runnable)}.
 * <p>
 * Each {@code ResourceContainer} implementation must inherit from this class.
 *
 * @see ResourceContainer#run(Runnable)
 */

public abstract class AbstractResourceContainer implements ResourceContainer {

    static ResourceContainer root() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    static AbstractResourceContainer current() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    static AbstractResourceContainer current(Thread currentThread) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    @Override
    public void run(Runnable command) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    // implement class need to Override the listed abstract methods

    @Override
    public abstract ResourceContainer.State getState();

    @Override
    public abstract void updateConstraint(Constraint constraint);

    @Override
    public abstract Iterable<Constraint> getConstraints();

    @Override
    public abstract void destroy();

    /**
     * Attach to this resource container.
     * Ensure {@link ResourceContainer#current()} as a root container
     * before calling this method.
     */
    protected abstract void attach();

    /**
     * Detach from this resource container and return to root container.
     */
    protected abstract void detach();
}
