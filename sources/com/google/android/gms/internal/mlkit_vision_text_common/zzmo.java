package com.google.android.gms.internal.mlkit_vision_text_common;

public enum zzmo implements zzcx {
    TYPE_UNKNOWN(0),
    LATIN(1),
    LATIN_AND_CHINESE(2),
    LATIN_AND_DEVANAGARI(3),
    LATIN_AND_JAPANESE(4),
    LATIN_AND_KOREAN(5);
    
    private final int zzh;

    private zzmo(int i10) {
        this.zzh = i10;
    }

    public final int zza() {
        return this.zzh;
    }
}
