package com.google.android.gms.fido.fido2.api.common;

public enum EC2Algorithm implements a {
    ED256(-260),
    ED512(-261),
    ES256(-7),
    ES384(-35),
    ES512(-36);
    
    private final int zzb;

    private EC2Algorithm(int i10) {
        this.zzb = i10;
    }

    public int a() {
        return this.zzb;
    }
}
