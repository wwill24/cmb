package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadq  reason: invalid package */
final class zzadq extends zzaez {
    private final PhoneAuthCredential zza;

    public zzadq(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zza = (PhoneAuthCredential) p.k(phoneAuthCredential);
    }

    public final String zza() {
        return "updatePhoneNumber";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzadv.zzS(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzp(new zzzv(this.zzh.zzf(), this.zza), this.zzf);
    }
}
