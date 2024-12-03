package com.google.android.gms.internal.play_billing;

public enum zzew {
    DOUBLE(zzex.DOUBLE, 1),
    FLOAT(zzex.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzex.BOOLEAN, 0),
    STRING(zzex.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzex.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzex.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzex zzt;

    private zzew(zzex zzex, int i10) {
        this.zzt = zzex;
    }

    public final zzex zza() {
        return this.zzt;
    }
}
