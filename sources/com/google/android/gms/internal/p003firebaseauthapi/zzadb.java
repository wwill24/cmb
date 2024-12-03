package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadb  reason: invalid package */
final class zzadb extends zzaez {
    private final zzzz zza;

    public zzadb(String str) {
        super(9);
        this.zza = new zzzz(str);
    }

    public final String zza() {
        return "setFirebaseUIVersion";
    }

    public final void zzb() {
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzu(this.zza, this.zzf);
    }
}
