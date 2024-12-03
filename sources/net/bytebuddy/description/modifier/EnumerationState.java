package net.bytebuddy.description.modifier;

import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.jar.asm.Opcodes;

public enum EnumerationState implements ModifierContributor.ForType, ModifierContributor.ForField {
    PLAIN(0),
    ENUMERATION(Opcodes.ACC_ENUM);
    
    private final int mask;

    private EnumerationState(int i10) {
        this.mask = i10;
    }

    public int getMask() {
        return this.mask;
    }

    public int getRange() {
        return Opcodes.ACC_ENUM;
    }

    public boolean isDefault() {
        return this == PLAIN;
    }

    public boolean isEnumeration() {
        return this == ENUMERATION;
    }
}
