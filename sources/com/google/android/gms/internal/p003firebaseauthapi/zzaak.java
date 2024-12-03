package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaak  reason: invalid package */
final class zzaak implements zzafe {
    final /* synthetic */ zzafd zza;
    final /* synthetic */ zzadx zzb;
    final /* synthetic */ zzahb zzc;
    final /* synthetic */ zzahn zzd;
    final /* synthetic */ zzabz zze;

    zzaak(zzabz zzabz, zzafd zzafd, zzadx zzadx, zzahb zzahb, zzahn zzahn) {
        this.zze = zzabz;
        this.zza = zzafd;
        this.zzb = zzadx;
        this.zzc = zzahb;
        this.zzd = zzahn;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List zzb2 = ((zzagr) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            zzabz.zzf(this.zze, this.zzb, this.zzc, (zzags) zzb2.get(0), this.zzd, this.zza);
        }
    }
}
