package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkq  reason: invalid package */
public final class zzkq extends zzlg {
    private final zzkn zza;
    private final zzkm zzb;
    private final zzkh zzc;
    private final zzko zzd;

    /* synthetic */ zzkq(zzkn zzkn, zzkm zzkm, zzkh zzkh, zzko zzko, zzkp zzkp) {
        this.zza = zzkn;
        this.zzb = zzkm;
        this.zzc = zzkh;
        this.zzd = zzko;
    }

    public static zzkl zzc() {
        return new zzkl((zzkk) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzkq)) {
            return false;
        }
        zzkq zzkq = (zzkq) obj;
        if (this.zza == zzkq.zza && this.zzb == zzkq.zzb && this.zzc == zzkq.zzc && this.zzd == zzkq.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzkq.class, this.zza, this.zzb, this.zzc, this.zzd});
    }

    public final boolean zza() {
        throw null;
    }

    public final zzkh zzb() {
        return this.zzc;
    }

    public final zzkm zzd() {
        return this.zzb;
    }

    public final zzkn zze() {
        return this.zza;
    }

    public final zzko zzf() {
        return this.zzd;
    }
}
