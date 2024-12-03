package com.google.firebase.auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbl;

final class zzz extends zzbl {
    final /* synthetic */ String zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ FirebaseUser zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ String zze;
    final /* synthetic */ FirebaseAuth zzf;

    zzz(FirebaseAuth firebaseAuth, String str, boolean z10, FirebaseUser firebaseUser, String str2, String str3) {
        this.zzf = firebaseAuth;
        this.zza = str;
        this.zzb = z10;
        this.zzc = firebaseUser;
        this.zzd = str2;
        this.zze = str3;
    }

    public final Task zza(String str) {
        if (TextUtils.isEmpty(str)) {
            String str2 = this.zza;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Logging in as ");
            sb2.append(str2);
            sb2.append(" with empty reCAPTCHA token");
        } else {
            "Got reCAPTCHA token for login with email ".concat(String.valueOf(this.zza));
        }
        if (this.zzb) {
            FirebaseAuth firebaseAuth = this.zzf;
            return firebaseAuth.zzf.zzt(firebaseAuth.zzb, (FirebaseUser) p.k(this.zzc), this.zza, this.zzd, this.zze, str, new zzad(this.zzf));
        }
        FirebaseAuth firebaseAuth2 = this.zzf;
        return firebaseAuth2.zzf.zzE(firebaseAuth2.zzb, this.zza, this.zzd, this.zze, str, new zzac(firebaseAuth2));
    }
}
