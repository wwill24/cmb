package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaco  reason: invalid package */
final class zzaco extends zzaez {
    private final PhoneAuthCredential zza;

    public zzaco(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zza = (PhoneAuthCredential) p.l(phoneAuthCredential, "credential cannot be null");
    }

    public final String zza() {
        return "linkPhoneAuthCredential";
    }

    public final void zzb() {
        zzx zzS = zzadv.zzS(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzS);
        zzm(new zzr(zzS));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzp(new zzzv(this.zzh.zzf(), this.zza), this.zzf);
    }
}
