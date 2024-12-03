package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacp  reason: invalid package */
final class zzacp extends zzaez {
    private final EmailAuthCredential zza;

    public zzacp(EmailAuthCredential emailAuthCredential) {
        super(2);
        this.zza = (EmailAuthCredential) p.l(emailAuthCredential, "credential cannot be null");
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
        emailAuthCredential.zzb(this.zzh);
        zzady.zzz(new zzaaa(emailAuthCredential, (String) null), this.zzf);
    }
}
