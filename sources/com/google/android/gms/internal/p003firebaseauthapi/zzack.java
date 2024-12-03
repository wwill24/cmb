package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzack  reason: invalid package */
final class zzack extends zzaez {
    private final zzzt zza = new zzzt();

    public zzack() {
        super(11);
    }

    public final String zza() {
        return "getRecaptchaParam";
    }

    public final void zzb() {
        zzm(this.zzy);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzk(this.zza, this.zzf);
    }
}
