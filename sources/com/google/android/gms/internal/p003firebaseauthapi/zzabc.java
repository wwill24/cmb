package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabc  reason: invalid package */
final class zzabc implements zzafe {
    final /* synthetic */ zzabd zza;

    zzabc(zzabd zzabd) {
        this.zza = zzabd;
    }

    public final void zza(String str) {
        this.zza.zzc.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaim zzaim = (zzaim) obj;
        if (TextUtils.isEmpty(zzaim.zzb()) || TextUtils.isEmpty(zzaim.zzc())) {
            this.zza.zzc.zzh(zzai.zza("INTERNAL_SUCCESS_SIGN_OUT"));
            return;
        }
        zzahb zzahb = new zzahb(zzaim.zzc(), zzaim.zzb(), Long.valueOf(zzahd.zza(zzaim.zzb())), "Bearer");
        zzabd zzabd = this.zza;
        zzabd.zzd.zzR(zzahb, (String) null, (String) null, Boolean.FALSE, (zze) null, zzabd.zzc, this);
    }
}
