package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgz  reason: invalid package */
public final class zzgz extends zzcx {
    private final String zza;
    private final zzgx zzb;
    private final zzcx zzc;

    /* synthetic */ zzgz(String str, zzgx zzgx, zzcx zzcx, zzgy zzgy) {
        this.zza = str;
        this.zzb = zzgx;
        this.zzc = zzcx;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgz)) {
            return false;
        }
        zzgz zzgz = (zzgz) obj;
        if (!zzgz.zzb.equals(this.zzb) || !zzgz.zzc.equals(this.zzc) || !zzgz.zza.equals(this.zza)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgz.class, this.zza, this.zzb, this.zzc});
    }

    public final String toString() {
        zzcx zzcx = this.zzc;
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(zzcx);
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + this.zza + ", dekParsingStrategy: " + valueOf + ", dekParametersForNewKeys: " + valueOf2 + ")";
    }

    public final boolean zza() {
        return false;
    }

    public final zzcx zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza;
    }
}
