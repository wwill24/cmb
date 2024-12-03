package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaah  reason: invalid package */
final class zzaah implements zzafe {
    final /* synthetic */ zzadx zza;
    final /* synthetic */ zzabz zzb;

    zzaah(zzabz zzabz, zzadx zzadx) {
        this.zzb = zzabz;
        this.zza = zzadx;
    }

    public final void zza(String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaii zzaii = (zzaii) obj;
        if (zzaii.zzg()) {
            this.zza.zzf(new zzaaf(zzaii.zzd(), zzaii.zzf(), (zze) null));
            return;
        }
        zzahb zzahb = new zzahb(zzaii.zze(), zzaii.zzc(), Long.valueOf(zzaii.zzb()), "Bearer");
        this.zzb.zzR(zzahb, (String) null, (String) null, Boolean.FALSE, (zze) null, this.zza, this);
    }
}
