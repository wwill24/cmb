package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziw  reason: invalid package */
public final class zziw extends zzje {
    private final int zza;
    private final zziu zzb;

    /* synthetic */ zziw(int i10, zziu zziu, zziv zziv) {
        this.zza = i10;
        this.zzb = zziu;
    }

    public static zzit zzc() {
        return new zzit((zzis) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zziw)) {
            return false;
        }
        zziw zziw = (zziw) obj;
        return zziw.zza == this.zza && zziw.zzb == this.zzb;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zziw.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        return "AesSiv Parameters (variant: " + valueOf + ", " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzb != zziu.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zziu zzd() {
        return this.zzb;
    }
}
