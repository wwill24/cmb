package net.bytebuddy.dynamic.scaffold;

public enum TypeValidation {
    ENABLED(true),
    DISABLED(false);
    
    private final boolean enabled;

    private TypeValidation(boolean z10) {
        this.enabled = z10;
    }

    public static TypeValidation of(boolean z10) {
        return z10 ? ENABLED : DISABLED;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
