package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajw  reason: invalid package */
final class zzajw {
    private final Object zza;
    private final int zzb;

    zzajw(Object obj, int i10) {
        this.zza = obj;
        this.zzb = i10;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzajw)) {
            return false;
        }
        zzajw zzajw = (zzajw) obj;
        if (this.zza == zzajw.zza && this.zzb == zzajw.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
