package com.coffeemeetsbagel.models.dto;

import com.coffeemeetsbagel.models.entities.CapabilityType;

public interface Capability {
    CapabilityType getCapability();

    boolean getEnabled();
}
