package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrt  reason: invalid package */
public final class zzrt {
    private final zzbu zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;

    /* synthetic */ zzrt(zzbu zzbu, int i10, String str, String str2, zzrs zzrs) {
        this.zza = zzbu;
        this.zzb = i10;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzrt)) {
            return false;
        }
        zzrt zzrt = (zzrt) obj;
        if (this.zza != zzrt.zza || this.zzb != zzrt.zzb || !this.zzc.equals(zzrt.zzc) || !this.zzd.equals(zzrt.zzd)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        return String.format("(status=%s, keyId=%s, keyType='%s', keyPrefix='%s')", new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final int zza() {
        return this.zzb;
    }
}
