package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacm  reason: invalid package */
final class zzacm extends zzaez {
    private final EmailAuthCredential zza;

    public zzacm(EmailAuthCredential emailAuthCredential) {
        super(2);
        this.zza = (EmailAuthCredential) p.l(emailAuthCredential, "credential cannot be null");
        p.h(emailAuthCredential.zzd(), "email cannot be null");
        p.h(emailAuthCredential.zze(), "password cannot be null");
    }

    public final String zza() {
        return "linkEmailAuthCredential";
    }

    public final void zzb() {
        zzx zzS = zzadv.zzS(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzS);
        zzm(new zzr(zzS));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        EmailAuthCredential emailAuthCredential = this.zza;
        zzady.zzn(emailAuthCredential.zzd(), p.g(emailAuthCredential.zze()), this.zzh.zzf(), this.zzf);
    }
}
