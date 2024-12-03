package com.google.firebase.auth;

import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbl;

final class zzo extends zzbl {
    final /* synthetic */ String zza;
    final /* synthetic */ ActionCodeSettings zzb;
    final /* synthetic */ FirebaseAuth zzc;

    zzo(FirebaseAuth firebaseAuth, String str, ActionCodeSettings actionCodeSettings) {
        this.zzc = firebaseAuth;
        this.zza = str;
        this.zzb = actionCodeSettings;
    }

    public final Task zza(String str) {
        if (TextUtils.isEmpty(str)) {
            String str2 = this.zza;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Password reset request ");
            sb2.append(str2);
            sb2.append(" with empty reCAPTCHA token");
        } else {
            "Got reCAPTCHA token for password reset of email ".concat(String.valueOf(this.zza));
        }
        FirebaseAuth firebaseAuth = this.zzc;
        return firebaseAuth.zzf.zzy(firebaseAuth.zzb, this.zza, this.zzb, firebaseAuth.zzl, str);
    }
}
