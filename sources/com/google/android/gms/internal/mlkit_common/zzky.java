package com.google.android.gms.internal.mlkit_common;

public enum zzky implements zzbm {
    zza(0),
    TRANSLATE(1);
    
    private final int zzd;

    private zzky(int i10) {
        this.zzd = i10;
    }

    public static zzky zzb(int i10) {
        for (zzky zzky : values()) {
            if (zzky.zzd == i10) {
                return zzky;
            }
        }
        return zza;
    }

    public final int zza() {
        return this.zzd;
    }
}
