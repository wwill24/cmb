package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzx;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacw  reason: invalid package */
final class zzacw extends zzaez {
    private final zzaab zza;

    public zzacw(PhoneAuthCredential phoneAuthCredential, String str) {
        super(2);
        p.l(phoneAuthCredential, "credential cannot be null");
        phoneAuthCredential.zze(false);
        this.zza = new zzaab(phoneAuthCredential, str);
    }

    public final String zza() {
        return "reauthenticateWithPhoneCredential";
    }

    public final void zzb() {
        zzx zzS = zzadv.zzS(this.zzg, this.zzo);
        if (this.zzh.getUid().equalsIgnoreCase(zzS.getUid())) {
            ((zzg) this.zzi).zza(this.zzn, zzS);
            zzm((Object) null);
            return;
        }
        zzl(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzA(this.zza, this.zzf);
    }
}
