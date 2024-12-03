package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaai  reason: invalid package */
final class zzaai implements zzafe {
    final /* synthetic */ EmailAuthCredential zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzadx zzc;
    final /* synthetic */ zzabz zzd;

    zzaai(zzabz zzabz, EmailAuthCredential emailAuthCredential, String str, zzadx zzadx) {
        this.zzd = zzabz;
        this.zza = emailAuthCredential;
        this.zzb = str;
        this.zzc = zzadx;
    }

    public final void zza(String str) {
        this.zzc.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzd.zzQ(new zzage(this.zza, ((zzahb) obj).zze(), this.zzb), this.zzc);
    }
}
