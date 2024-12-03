package com.google.android.gms.internal.mlkit_common;

public enum zzln implements zzbm {
    SOURCE_UNKNOWN(0),
    APP_ASSET(1),
    LOCAL(2),
    CLOUD(3),
    SDK_BUILT_IN(4),
    URI(5);
    
    private final int zzh;

    private zzln(int i10) {
        this.zzh = i10;
    }

    public final int zza() {
        return this.zzh;
    }
}
