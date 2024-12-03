package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzow  reason: invalid package */
final class zzow {
    private final Class zza;
    private final zzzo zzb;

    /* synthetic */ zzow(Class cls, zzzo zzzo, zzov zzov) {
        this.zza = cls;
        this.zzb = zzzo;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzow)) {
            return false;
        }
        zzow zzow = (zzow) obj;
        if (!zzow.zza.equals(this.zza) || !zzow.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        zzzo zzzo = this.zzb;
        String simpleName = this.zza.getSimpleName();
        String valueOf = String.valueOf(zzzo);
        return simpleName + ", object identifier: " + valueOf;
    }
}
