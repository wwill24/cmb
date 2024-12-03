package net.bytebuddy.description.modifier;

import net.bytebuddy.description.modifier.ModifierContributor;

public enum MethodStrictness implements ModifierContributor.ForMethod {
    PLAIN(0),
    STRICT(2048);
    
    private final int mask;

    private MethodStrictness(int i10) {
        this.mask = i10;
    }

    public int getMask() {
        return this.mask;
    }

    public int getRange() {
        return 2048;
    }

    public boolean isDefault() {
        return this == PLAIN;
    }

    public boolean isStrict() {
        return this == STRICT;
    }
}
