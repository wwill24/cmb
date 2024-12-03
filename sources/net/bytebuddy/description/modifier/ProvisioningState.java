package net.bytebuddy.description.modifier;

import net.bytebuddy.description.modifier.ModifierContributor;

public enum ProvisioningState implements ModifierContributor.ForParameter {
    PLAIN(0),
    MANDATED(32768);
    
    private final int mask;

    private ProvisioningState(int i10) {
        this.mask = i10;
    }

    public int getMask() {
        return this.mask;
    }

    public int getRange() {
        return 32768;
    }

    public boolean isDefault() {
        return this == PLAIN;
    }

    public boolean isMandated() {
        return this == MANDATED;
    }
}
