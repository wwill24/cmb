package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabw  reason: invalid package */
final class zzabw implements zzafe {
    final /* synthetic */ String zza;
    final /* synthetic */ zzadx zzb;
    final /* synthetic */ zzabz zzc;

    zzabw(zzabz zzabz, String str, zzadx zzadx) {
        this.zzc = zzabz;
        this.zza = str;
        this.zzb = zzadx;
    }

    public final void zza(String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzahb zzahb = (zzahb) obj;
        String zze = zzahb.zze();
        zzahn zzahn = new zzahn();
        zzahn.zze(zze);
        zzahn.zzg(this.zza);
        zzabz.zze(this.zzc, this.zzb, zzahb, zzahn, this);
    }
}
