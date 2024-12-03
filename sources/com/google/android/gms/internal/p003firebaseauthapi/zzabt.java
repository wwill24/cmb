package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabt  reason: invalid package */
final class zzabt implements zzafe {
    final /* synthetic */ zzadx zza;
    final /* synthetic */ zzabz zzb;

    zzabt(zzabz zzabz, zzadx zzadx) {
        this.zzb = zzabz;
        this.zza = zzadx;
    }

    public final void zza(String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzahq zzahq = (zzahq) obj;
        this.zzb.zzR(new zzahb(zzahq.zzd(), zzahq.zzc(), Long.valueOf(zzahq.zzb()), "Bearer"), (String) null, (String) null, Boolean.TRUE, (zze) null, this.zza, this);
    }
}
