package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacd  reason: invalid package */
final class zzacd extends zzaez {
    private final zzzs zza;

    public zzacd(String str, String str2, String str3) {
        super(4);
        p.h(str, "code cannot be null or empty");
        p.h(str2, "new password cannot be null or empty");
        this.zza = new zzzs(str, str2, str3);
    }

    public final String zza() {
        return "confirmPasswordReset";
    }

    public final void zzb() {
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zze(this.zza, this.zzf);
    }
}
