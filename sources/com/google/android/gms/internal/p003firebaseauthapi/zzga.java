package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzga  reason: invalid package */
public final class zzga extends zzcx {
    private final zzfz zza;

    private zzga(zzfz zzfz) {
        this.zza = zzfz;
    }

    public static zzga zzc(zzfz zzfz) {
        return new zzga(zzfz);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzga) && ((zzga) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzga.class, this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "ChaCha20Poly1305 Parameters (variant: " + obj + ")";
    }

    public final boolean zza() {
        return this.zza != zzfz.zzc;
    }

    public final zzfz zzb() {
        return this.zza;
    }
}
