package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabd  reason: invalid package */
final class zzabd implements zzafe {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzadx zzc;
    final /* synthetic */ zzabz zzd;

    zzabd(zzabz zzabz, String str, String str2, zzadx zzadx) {
        this.zzd = zzabz;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzadx;
    }

    public final void zza(String str) {
        this.zzc.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzd.zza.zzw(new zzail(((zzahb) obj).zze(), this.zza, this.zzb), new zzabc(this));
    }
}
