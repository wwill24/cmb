package net.bytebuddy.implementation.attribute;

public enum AnnotationRetention {
    ENABLED(true),
    DISABLED(false);
    
    private final boolean enabled;

    private AnnotationRetention(boolean z10) {
        this.enabled = z10;
    }

    public static AnnotationRetention of(boolean z10) {
        return z10 ? ENABLED : DISABLED;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
