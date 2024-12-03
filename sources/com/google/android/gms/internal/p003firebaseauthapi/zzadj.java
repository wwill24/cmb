package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzag;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadj  reason: invalid package */
final class zzadj extends zzaez {
    private final zzahx zza;

    public zzadj(zzag zzag, String str) {
        super(12);
        p.k(zzag);
        this.zza = zzahx.zzb(p.g(zzag.zzd()), str);
    }

    public final String zza() {
        return "startMfaEnrollment";
    }

    public final void zzb() {
        zzm(this.zzz);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzD(this.zza, this.zzf);
    }
}
