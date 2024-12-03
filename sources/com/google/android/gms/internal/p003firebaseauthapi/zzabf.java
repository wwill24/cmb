package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabf  reason: invalid package */
final class zzabf implements zzafe {
    final /* synthetic */ zzadx zza;
    final /* synthetic */ zzabz zzb;

    zzabf(zzabz zzabz, zzadx zzadx) {
        this.zzb = zzabz;
        this.zza = zzadx;
    }

    public final void zza(String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaig zzaig = (zzaig) obj;
        this.zzb.zzR(new zzahb(zzaig.zzd(), zzaig.zzc(), Long.valueOf(zzaig.zzb()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzaig.zze()), (zze) null, this.zza, this);
    }
}
