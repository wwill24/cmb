package net.bytebuddy.description.modifier;

import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.jar.asm.Opcodes;

public enum SyntheticState implements ModifierContributor.ForType, ModifierContributor.ForMethod, ModifierContributor.ForField, ModifierContributor.ForParameter {
    PLAIN(0),
    SYNTHETIC(Opcodes.ACC_SYNTHETIC);
    
    private final int mask;

    private SyntheticState(int i10) {
        this.mask = i10;
    }

    public int getMask() {
        return this.mask;
    }

    public int getRange() {
        return Opcodes.ACC_SYNTHETIC;
    }

    public boolean isDefault() {
        return this == PLAIN;
    }

    public boolean isSynthetic() {
        return this == SYNTHETIC;
    }
}
