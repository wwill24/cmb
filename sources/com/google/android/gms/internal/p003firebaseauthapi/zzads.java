package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzads  reason: invalid package */
final class zzads extends zzaez {
    private final zzaad zza;

    public zzads(String str, String str2, ActionCodeSettings actionCodeSettings) {
        super(6);
        p.g(str);
        p.g(str2);
        p.k(actionCodeSettings);
        this.zza = new zzaad(str, str2, actionCodeSettings);
    }

    public final String zza() {
        return "verifyBeforeUpdateEmail";
    }

    public final void zzb() {
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzI(this.zza, this.zzf);
    }
}
