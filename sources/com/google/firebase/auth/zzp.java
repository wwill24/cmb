package com.google.firebase.auth;

import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbl;

final class zzp extends zzbl {
    final /* synthetic */ String zza;
    final /* synthetic */ ActionCodeSettings zzb;
    final /* synthetic */ FirebaseAuth zzc;

    zzp(FirebaseAuth firebaseAuth, String str, ActionCodeSettings actionCodeSettings) {
        this.zzc = firebaseAuth;
        this.zza = str;
        this.zzb = actionCodeSettings;
    }

    public final Task zza(String str) {
        if (TextUtils.isEmpty(str)) {
            String str2 = this.zza;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Email link sign in for ");
            sb2.append(str2);
            sb2.append(" with empty reCAPTCHA token");
        } else {
            "Got reCAPTCHA token for email link sign in for ".concat(String.valueOf(this.zza));
        }
        FirebaseAuth firebaseAuth = this.zzc;
        return firebaseAuth.zzf.zzz(firebaseAuth.zzb, this.zza, this.zzb, firebaseAuth.zzl, str);
    }
}
