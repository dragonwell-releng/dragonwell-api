package com.alibaba.tenant;

import com.alibaba.rcm.Constraint;
import com.alibaba.rcm.ResourceType;
import com.alibaba.rcm.internal.AbstractResourceContainer;
import java.util.HashMap;
import java.util.Map;
import static com.alibaba.tenant.TenantState.*;

class TenantResourceContainer extends AbstractResourceContainer {
    @Override
    protected void attach() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    @Override
    protected void detach() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Should not call TenantResourceContainer::destroy() directly");
    }

    @Override
    public Iterable<Constraint> getConstraints() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    @Override
    public void updateConstraint(Constraint constraint) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    @Override
    public State getState() {
        throw new RuntimeException("Dummy AJDK API found");
    }
}
