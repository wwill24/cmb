package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabs  reason: invalid package */
final class zzabs implements zzafe {
    final /* synthetic */ zzadx zza;
    final /* synthetic */ zzabz zzb;

    zzabs(zzabz zzabz, zzadx zzadx) {
        this.zzb = zzabz;
        this.zza = zzadx;
    }

    public final void zza(String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaie zzaie = (zzaie) obj;
        if (!zzaie.zzm()) {
            zzabz.zzd(this.zzb, zzaie, this.zza, this);
        } else {
            this.zza.zzf(new zzaaf(zzaie.zzg(), zzaie.zzl(), zzaie.zzc()));
        }
    }
}
