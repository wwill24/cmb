package net.bytebuddy.description.modifier;

import net.bytebuddy.description.modifier.ModifierContributor;

public enum FieldPersistence implements ModifierContributor.ForField {
    PLAIN(0),
    TRANSIENT(128);
    
    private final int mask;

    private FieldPersistence(int i10) {
        this.mask = i10;
    }

    public int getMask() {
        return this.mask;
    }

    public int getRange() {
        return 128;
    }

    public boolean isDefault() {
        return this == PLAIN;
    }

    public boolean isTransient() {
        return (this.mask & 128) != 0;
    }
}
