package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabb  reason: invalid package */
final class zzabb implements zzafe {
    final /* synthetic */ String zza;
    final /* synthetic */ zzadx zzb;
    final /* synthetic */ zzabz zzc;

    zzabb(zzabz zzabz, String str, zzadx zzadx) {
        this.zzc = zzabz;
        this.zza = str;
        this.zzb = zzadx;
    }

    public final void zza(String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzahb zzahb = (zzahb) obj;
        this.zzc.zza.zzg(new zzagq(zzahb.zze()), new zzaba(this, this, zzahb));
    }
}
