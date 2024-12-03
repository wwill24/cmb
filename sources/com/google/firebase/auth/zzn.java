package com.google.firebase.auth;

import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbl;

final class zzn extends zzbl {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ FirebaseAuth zzc;

    zzn(FirebaseAuth firebaseAuth, String str, String str2) {
        this.zzc = firebaseAuth;
        this.zza = str;
        this.zzb = str2;
    }

    public final Task zza(String str) {
        if (TextUtils.isEmpty(str)) {
            String str2 = this.zza;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Creating user with ");
            sb2.append(str2);
            sb2.append(" with empty reCAPTCHA token");
        } else {
            "Got reCAPTCHA token for sign up with email ".concat(String.valueOf(this.zza));
        }
        FirebaseAuth firebaseAuth = this.zzc;
        return firebaseAuth.zzf.zzd(firebaseAuth.zzb, this.zza, this.zzb, firebaseAuth.zzl, str, new zzac(firebaseAuth));
    }
}
