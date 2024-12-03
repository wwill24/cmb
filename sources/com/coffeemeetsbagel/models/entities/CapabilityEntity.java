package com.coffeemeetsbagel.models.entities;

import kotlin.jvm.internal.j;

public final class CapabilityEntity {
    private final CapabilityType capability;
    private final boolean enabled;

    public CapabilityEntity(CapabilityType capabilityType, boolean z10) {
        j.g(capabilityType, "capability");
        this.capability = capabilityType;
        this.enabled = z10;
    }

    public final CapabilityType getCapability() {
        return this.capability;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }
}
