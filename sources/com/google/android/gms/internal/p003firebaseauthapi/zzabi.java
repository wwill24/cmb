package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabi  reason: invalid package */
final class zzabi implements zzafe {
    final /* synthetic */ zzadx zza;
    final /* synthetic */ zzabz zzb;

    zzabi(zzabz zzabz, zzadx zzadx) {
        this.zzb = zzabz;
        this.zza = zzadx;
    }

    public final void zza(String str) {
        this.zza.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzagj zzagj = (zzagj) obj;
        this.zzb.zzR(new zzahb(zzagj.zzc(), zzagj.zzb(), Long.valueOf(zzahd.zza(zzagj.zzb())), "Bearer"), (String) null, (String) null, Boolean.FALSE, (zze) null, this.zza, this);
    }
}
