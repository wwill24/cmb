package com.google.android.gms.internal.p003firebaseauthapi;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacz  reason: invalid package */
final class zzacz extends zzaez {
    @NonNull
    private final zzzw zza;

    public zzacz(String str, ActionCodeSettings actionCodeSettings) {
        super(6);
        p.h(str, "token cannot be null or empty");
        this.zza = new zzzw(str, actionCodeSettings);
    }

    public final String zza() {
        return "sendEmailVerification";
    }

    public final void zzb() {
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzr(this.zza, this.zzf);
    }
}
