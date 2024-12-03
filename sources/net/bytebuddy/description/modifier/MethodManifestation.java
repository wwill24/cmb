package net.bytebuddy.description.modifier;

import com.coffeemeetsbagel.models.Height;
import net.bytebuddy.description.modifier.ModifierContributor;

public enum MethodManifestation implements ModifierContributor.ForMethod {
    PLAIN(0),
    NATIVE(256),
    ABSTRACT(1024),
    FINAL(16),
    FINAL_NATIVE(Height.CENTIMETRES_MAX),
    BRIDGE(64),
    FINAL_BRIDGE(80);
    
    private final int mask;

    private MethodManifestation(int i10) {
        this.mask = i10;
    }

    public int getMask() {
        return this.mask;
    }

    public int getRange() {
        return 1360;
    }

    public boolean isAbstract() {
        return (this.mask & 1024) != 0;
    }

    public boolean isBridge() {
        return (this.mask & 64) != 0;
    }

    public boolean isDefault() {
        return this == PLAIN;
    }

    public boolean isFinal() {
        return (this.mask & 16) != 0;
    }

    public boolean isNative() {
        return (this.mask & 256) != 0;
    }
}
