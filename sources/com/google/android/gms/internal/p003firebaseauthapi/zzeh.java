package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeh  reason: invalid package */
public final class zzeh extends zzcx {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzef zzd;

    /* synthetic */ zzeh(int i10, int i11, int i12, zzef zzef, zzeg zzeg) {
        this.zza = i10;
        this.zzb = i11;
        this.zzd = zzef;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzeh)) {
            return false;
        }
        zzeh zzeh = (zzeh) obj;
        return zzeh.zza == this.zza && zzeh.zzb == this.zzb && zzeh.zzd == this.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzeh.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        return "AesEax Parameters (variant: " + valueOf + ", " + this.zzb + "-byte IV, " + 16 + "-byte tag, and " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzd != zzef.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzef zzd() {
        return this.zzd;
    }
}
