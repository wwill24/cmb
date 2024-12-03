package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaci  reason: invalid package */
final class zzaci extends zzaez {
    private final MultiFactorAssertion zza;
    private final String zzb;
    private final String zzc;

    public zzaci(MultiFactorAssertion multiFactorAssertion, String str, String str2) {
        super(2);
        this.zza = (MultiFactorAssertion) p.k(multiFactorAssertion);
        this.zzb = p.g(str);
        this.zzc = str2;
    }

    public final String zza() {
        return "finalizeMfaSignIn";
    }

    public final void zzb() {
        zzx zzS = zzadv.zzS(this.zzg, this.zzo);
        FirebaseUser firebaseUser = this.zzh;
        if (firebaseUser == null || firebaseUser.getUid().equalsIgnoreCase(zzS.getUid())) {
            ((zzg) this.zzi).zza(this.zzn, zzS);
            zzm(new zzr(zzS));
            return;
        }
        zzl(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzi(this.zzb, this.zza, this.zzc, this.zzf);
    }
}
