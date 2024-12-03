package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaav  reason: invalid package */
final class zzaav implements zzafe {
    final /* synthetic */ zzafe zza;
    final /* synthetic */ zzaaw zzb;

    zzaav(zzaaw zzaaw, zzafe zzafe) {
        this.zzb = zzaaw;
        this.zza = zzafe;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaik zzaik = (zzaik) obj;
        if (!TextUtils.isEmpty(zzaik.zzf())) {
            Status status = new Status(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE);
            zzaaw zzaaw = this.zzb;
            zzaaw.zzb.zzg(status, PhoneAuthCredential.zzd(zzaik.zzd(), zzaik.zzf()));
            return;
        }
        zzahb zzahb = new zzahb(zzaik.zze(), zzaik.zzc(), Long.valueOf(zzaik.zzb()), "Bearer");
        zzaaw zzaaw2 = this.zzb;
        Boolean valueOf = Boolean.valueOf(zzaik.zzg());
        zzaaw zzaaw3 = this.zzb;
        zzafe zzafe = this.zza;
        zzaaw2.zzc.zzR(zzahb, (String) null, "phone", valueOf, (zze) null, zzaaw3.zzb, zzafe);
    }
}
