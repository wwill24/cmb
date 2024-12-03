package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzey  reason: invalid package */
public final class zzey extends zzcx {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzew zzd;

    /* synthetic */ zzey(int i10, int i11, int i12, zzew zzew, zzex zzex) {
        this.zza = i10;
        this.zzd = zzew;
    }

    public static zzev zzc() {
        return new zzev((zzeu) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzey)) {
            return false;
        }
        zzey zzey = (zzey) obj;
        return zzey.zza == this.zza && zzey.zzd == this.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzey.class, Integer.valueOf(this.zza), 12, 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        return "AesGcm Parameters (variant: " + valueOf + ", " + 12 + "-byte IV, " + 16 + "-byte tag, and " + this.zza + "-byte key)";
    }

    public final boolean zza() {
        return this.zzd != zzew.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzew zzd() {
        return this.zzd;
    }
}
