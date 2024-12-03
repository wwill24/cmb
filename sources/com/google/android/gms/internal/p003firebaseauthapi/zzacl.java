package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacl  reason: invalid package */
final class zzacl extends zzaez {
    private final zzzu zza;

    public zzacl(String str, String str2) {
        super(10);
        p.g("RECAPTCHA_ENTERPRISE");
        this.zza = new zzzu(str, "RECAPTCHA_ENTERPRISE");
    }

    public final String zza() {
        return "getRecaptchaConfig";
    }

    public final void zzb() {
        zzm(this.zzx);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzm(this.zza, this.zzf);
    }
}
