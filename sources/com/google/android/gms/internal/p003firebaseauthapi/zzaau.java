package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaau  reason: invalid package */
final class zzaau implements zzafe {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzadx zzc;
    final /* synthetic */ zzabz zzd;

    zzaau(zzabz zzabz, String str, String str2, zzadx zzadx) {
        this.zzd = zzabz;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzadx;
    }

    public final void zza(String str) {
        this.zzc.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzahb zzahb = (zzahb) obj;
        zzahn zzahn = new zzahn();
        zzahn.zze(zzahb.zze());
        zzahn.zzd(this.zza);
        zzahn.zzg(this.zzb);
        zzabz.zze(this.zzd, this.zzc, zzahb, zzahn, this);
    }
}
