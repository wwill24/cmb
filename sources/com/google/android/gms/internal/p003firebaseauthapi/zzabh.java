package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabh  reason: invalid package */
final class zzabh implements zzafe {
    final /* synthetic */ zzagg zza;
    final /* synthetic */ zzadx zzb;
    final /* synthetic */ zzabz zzc;

    zzabh(zzabz zzabz, zzagg zzagg, zzadx zzadx) {
        this.zzc = zzabz;
        this.zza = zzagg;
        this.zzb = zzadx;
    }

    public final void zza(String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zza.zzb(((zzahb) obj).zze());
        this.zzc.zza.zzd(this.zza, new zzabg(this));
    }
}
