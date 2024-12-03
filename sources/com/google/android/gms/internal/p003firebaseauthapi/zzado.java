package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzado  reason: invalid package */
final class zzado extends zzaez {
    private final String zza;

    public zzado(String str) {
        super(2);
        this.zza = p.h(str, "email cannot be null or empty");
    }

    public final String zza() {
        return "updateEmail";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzadv.zzS(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzb(this.zzh.zzf(), this.zza, this.zzf);
    }
}
