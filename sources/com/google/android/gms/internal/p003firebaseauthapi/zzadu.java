package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadu  reason: invalid package */
final class zzadu extends zzaez {
    private final zzzy zza;

    public zzadu(zzahl zzahl) {
        super(8);
        p.k(zzahl);
        this.zza = new zzzy(zzahl);
    }

    public final String zza() {
        return "verifyPhoneNumber";
    }

    public final void zzb() {
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzt(this.zza, this.zzf);
    }
}
