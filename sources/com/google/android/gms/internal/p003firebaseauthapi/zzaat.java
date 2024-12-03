package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaat  reason: invalid package */
final class zzaat implements zzafe {
    final /* synthetic */ zzadx zza;
    final /* synthetic */ zzabz zzb;

    zzaat(zzabz zzabz, zzadx zzadx) {
        this.zzb = zzabz;
        this.zza = zzadx;
    }

    public final void zza(String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaik zzaik = (zzaik) obj;
        this.zzb.zzR(new zzahb(zzaik.zze(), zzaik.zzc(), Long.valueOf(zzaik.zzb()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzaik.zzg()), (zze) null, this.zza, this);
    }
}
