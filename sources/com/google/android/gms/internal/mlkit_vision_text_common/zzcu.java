package com.google.android.gms.internal.mlkit_vision_text_common;

import org.apache.commons.beanutils.PropertyUtils;

final class zzcu implements zzcz {
    private final int zza;
    private final zzcy zzb;

    zzcu(int i10, zzcy zzcy) {
        this.zza = i10;
        this.zzb = zzcy;
    }

    public final Class annotationType() {
        return zzcz.class;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcz)) {
            return false;
        }
        zzcz zzcz = (zzcz) obj;
        if (this.zza != zzcz.zza() || !this.zzb.equals(zzcz.zzb())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf" + "(tag=" + this.zza + "intEncoding=" + this.zzb + PropertyUtils.MAPPED_DELIM2;
    }

    public final int zza() {
        return this.zza;
    }

    public final zzcy zzb() {
        return this.zzb;
    }
}
