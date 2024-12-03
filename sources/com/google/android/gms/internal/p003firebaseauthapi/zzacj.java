package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.internal.zzg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacj  reason: invalid package */
final class zzacj extends zzaez {
    private final String zza;

    public zzacj(String str) {
        super(1);
        p.h(str, "refresh token cannot be null");
        this.zza = str;
    }

    public final String zza() {
        return "getAccessToken";
    }

    public final void zzb() {
        if (TextUtils.isEmpty(this.zzn.zzf())) {
            this.zzn.zzi(this.zza);
        }
        ((zzg) this.zzi).zza(this.zzn, this.zzh);
        zzm(zzba.zza(this.zzn.zze()));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzj(this.zza, this.zzf);
    }
}
