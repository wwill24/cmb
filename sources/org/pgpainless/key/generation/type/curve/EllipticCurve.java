package org.pgpainless.key.generation.type.curve;

public enum EllipticCurve {
    _P256("P-256");
    
    private final String name;

    private EllipticCurve(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
