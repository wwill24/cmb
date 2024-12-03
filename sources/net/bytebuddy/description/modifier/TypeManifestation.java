package net.bytebuddy.description.modifier;

import net.bytebuddy.description.modifier.ModifierContributor;

public enum TypeManifestation implements ModifierContributor.ForType {
    PLAIN(0),
    FINAL(16),
    ABSTRACT(1024),
    INTERFACE(1536),
    ANNOTATION(9728);
    
    private final int mask;

    private TypeManifestation(int i10) {
        this.mask = i10;
    }

    public int getMask() {
        return this.mask;
    }

    public int getRange() {
        return 9744;
    }

    public boolean isAbstract() {
        return (this.mask & 1024) != 0 && !isInterface();
    }

    public boolean isAnnotation() {
        return (this.mask & 8192) != 0;
    }

    public boolean isDefault() {
        return this == PLAIN;
    }

    public boolean isFinal() {
        return (this.mask & 16) != 0;
    }

    public boolean isInterface() {
        return (this.mask & 512) != 0;
    }
}
