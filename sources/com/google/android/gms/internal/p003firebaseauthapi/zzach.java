package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzach  reason: invalid package */
final class zzach extends zzaez {
    private final MultiFactorAssertion zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    public zzach(MultiFactorAssertion multiFactorAssertion, String str, String str2, String str3) {
        super(2);
        this.zza = (MultiFactorAssertion) p.k(multiFactorAssertion);
        this.zzb = p.g(str);
        this.zzc = str2;
        this.zzd = str3;
    }

    public final String zza() {
        return "finalizeMfaEnrollment";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzadv.zzS(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzh(this.zza, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
