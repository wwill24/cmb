package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfp  reason: invalid package */
public final class zzfp extends zzcx {
    private final int zza;
    private final zzfn zzb;

    /* synthetic */ zzfp(int i10, zzfn zzfn, zzfo zzfo) {
        this.zza = i10;
        this.zzb = zzfn;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfp)) {
            return false;
        }
        zzfp zzfp = (zzfp) obj;
        return zzfp.zza == this.zza && zzfp.zzb == this.zzb;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzfp.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        return "AesGcmSiv Parameters (variant: " + valueOf + ", " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzb != zzfn.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzfn zzc() {
        return this.zzb;
    }
}
