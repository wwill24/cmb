package com.google.firebase.auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbl;

final class zzaa extends zzbl {
    final /* synthetic */ boolean zza;
    final /* synthetic */ FirebaseUser zzb;
    final /* synthetic */ EmailAuthCredential zzc;
    final /* synthetic */ FirebaseAuth zzd;

    zzaa(FirebaseAuth firebaseAuth, boolean z10, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential) {
        this.zzd = firebaseAuth;
        this.zza = z10;
        this.zzb = firebaseUser;
        this.zzc = emailAuthCredential;
    }

    public final Task zza(String str) {
        TextUtils.isEmpty(str);
        if (this.zza) {
            FirebaseAuth firebaseAuth = this.zzd;
            return firebaseAuth.zzf.zzr(firebaseAuth.zzb, (FirebaseUser) p.k(this.zzb), this.zzc, str, new zzad(this.zzd));
        }
        FirebaseAuth firebaseAuth2 = this.zzd;
        return firebaseAuth2.zzf.zzF(firebaseAuth2.zzb, this.zzc, str, new zzac(firebaseAuth2));
    }
}
