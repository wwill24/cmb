package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhr  reason: invalid package */
public final class zzhr extends zzcx {
    private final zzhq zza;

    private zzhr(zzhq zzhq) {
        this.zza = zzhq;
    }

    public static zzhr zzc() {
        return new zzhr(zzhq.zzc);
    }

    public static zzhr zzd(zzhq zzhq) {
        return new zzhr(zzhq);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzhr) && ((zzhr) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzhr.class, this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "XChaCha20Poly1305 Parameters (variant: " + obj + ")";
    }

    public final boolean zza() {
        return this.zza != zzhq.zzc;
    }

    public final zzhq zzb() {
        return this.zza;
    }
}
