package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzo;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacc  reason: invalid package */
final class zzacc extends zzaez {
    private final String zza;
    private final String zzb;

    public zzacc(String str, String str2) {
        super(4);
        p.h(str, "code cannot be null or empty");
        this.zza = str;
        this.zzb = str2;
    }

    public final String zza() {
        return "checkActionCode";
    }

    public final void zzb() {
        zzm(new zzo(this.zzq));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzd(this.zza, this.zzb, this.zzf);
    }
}
