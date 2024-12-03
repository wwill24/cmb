package com.google.android.gms.internal.p003firebaseauthapi;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadf  reason: invalid package */
final class zzadf extends zzaez {
    @NonNull
    final String zza;
    @NonNull
    final String zzb;
    final String zzc;
    final String zzd;

    public zzadf(String str, String str2, String str3, String str4) {
        super(2);
        p.h(str, "email cannot be null or empty");
        p.h(str2, "password cannot be null or empty");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
    }

    public final String zza() {
        return "signInWithEmailAndPassword";
    }

    public final void zzb() {
        zzx zzS = zzadv.zzS(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzS);
        zzm(new zzr(zzS));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzy(this.zza, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
