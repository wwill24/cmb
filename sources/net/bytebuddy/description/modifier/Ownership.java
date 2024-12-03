package net.bytebuddy.description.modifier;

import net.bytebuddy.description.modifier.ModifierContributor;

public enum Ownership implements ModifierContributor.ForField, ModifierContributor.ForMethod, ModifierContributor.ForType {
    MEMBER(0),
    STATIC(8);
    
    private final int mask;

    private Ownership(int i10) {
        this.mask = i10;
    }

    public int getMask() {
        return this.mask;
    }

    public int getRange() {
        return 8;
    }

    public boolean isDefault() {
        return this == MEMBER;
    }

    public boolean isStatic() {
        return this == STATIC;
    }
}
