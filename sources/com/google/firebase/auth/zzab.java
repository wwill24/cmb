package com.google.firebase.auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzadv;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.zzbl;

final class zzab extends zzbl {
    final /* synthetic */ boolean zza;
    final /* synthetic */ FirebaseUser zzb;
    final /* synthetic */ EmailAuthCredential zzc;
    final /* synthetic */ FirebaseAuth zzd;

    zzab(FirebaseAuth firebaseAuth, boolean z10, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential) {
        this.zzd = firebaseAuth;
        this.zza = z10;
        this.zzb = firebaseUser;
        this.zzc = emailAuthCredential;
    }

    public final Task zza(String str) {
        if (this.zza) {
            TextUtils.isEmpty(str);
            FirebaseAuth firebaseAuth = this.zzd;
            return firebaseAuth.zzf.zzq(firebaseAuth.zzb, this.zzb, this.zzc, str, new zzad(firebaseAuth));
        }
        EmailAuthCredential emailAuthCredential = this.zzc;
        String zzd2 = emailAuthCredential.zzd();
        String zze = emailAuthCredential.zze();
        if (TextUtils.isEmpty(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Reauthenticating ");
            sb2.append(zzd2);
            sb2.append(" with empty reCAPTCHA token");
        } else {
            "Got reCAPTCHA token for reauth with ".concat(String.valueOf(zzd2));
        }
        FirebaseAuth firebaseAuth2 = this.zzd;
        FirebaseUser firebaseUser = this.zzb;
        zzadv zzz = firebaseAuth2.zzf;
        FirebaseApp zzv = firebaseAuth2.zzb;
        String g10 = p.g(zze);
        FirebaseUser firebaseUser2 = this.zzb;
        FirebaseAuth firebaseAuth3 = this.zzd;
        return zzz.zzs(zzv, firebaseUser, zzd2, g10, firebaseUser2.getTenantId(), str, new zzad(firebaseAuth3));
    }
}
