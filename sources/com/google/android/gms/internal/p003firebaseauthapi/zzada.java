package com.google.android.gms.internal.p003firebaseauthapi;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzada  reason: invalid package */
final class zzada extends zzaez {
    @NonNull
    private final zzzx zza;
    private final String zzb;

    public zzada(String str, ActionCodeSettings actionCodeSettings, String str2, String str3, String str4) {
        super(4);
        p.h(str, "email cannot be null or empty");
        this.zza = new zzzx(str, actionCodeSettings, str2, str3);
        this.zzb = str4;
    }

    public final String zza() {
        return this.zzb;
    }

    public final void zzb() {
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzs(this.zza, this.zzf);
    }
}
