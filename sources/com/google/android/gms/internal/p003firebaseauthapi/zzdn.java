package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdn  reason: invalid package */
public final class zzdn extends zzcx {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzdl zze;
    private final zzdk zzf;

    /* synthetic */ zzdn(int i10, int i11, int i12, int i13, zzdl zzdl, zzdk zzdk, zzdm zzdm) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = zzdl;
        this.zzf = zzdk;
    }

    public static zzdj zzf() {
        return new zzdj((zzdi) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdn)) {
            return false;
        }
        zzdn zzdn = (zzdn) obj;
        return zzdn.zza == this.zza && zzdn.zzb == this.zzb && zzdn.zzc == this.zzc && zzdn.zzd == this.zzd && zzdn.zze == this.zze && zzdn.zzf == this.zzf;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzdn.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf});
    }

    public final String toString() {
        zzdk zzdk = this.zzf;
        String valueOf = String.valueOf(this.zze);
        String valueOf2 = String.valueOf(zzdk);
        return "AesCtrHmacAead Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + this.zzc + "-byte IV, and " + this.zzd + "-byte tags, and " + this.zza + "-byte AES key, and " + this.zzb + "-byte HMAC key)";
    }

    public final boolean zza() {
        return this.zze != zzdl.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final zzdk zzg() {
        return this.zzf;
    }

    public final zzdl zzh() {
        return this.zze;
    }
}
