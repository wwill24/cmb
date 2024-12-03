package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadl  reason: invalid package */
final class zzadl extends zzaez {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzadl(String str, String str2, String str3) {
        super(2);
        this.zza = p.g(str);
        this.zzb = p.g(str2);
        this.zzc = str3;
    }

    public final String zza() {
        return "unenrollMfa";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzadv.zzS(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzE(this.zza, this.zzb, this.zzc, this.zzf);
    }
}
