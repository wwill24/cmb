package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzadz;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuthException;

final class zzbk implements Continuation {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbr zzb;
    final /* synthetic */ RecaptchaAction zzc;
    final /* synthetic */ Continuation zzd;

    zzbk(String str, zzbr zzbr, RecaptchaAction recaptchaAction, Continuation continuation) {
        this.zza = str;
        this.zzb = zzbr;
        this.zzc = recaptchaAction;
        this.zzd = continuation;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        if (task.isSuccessful()) {
            return task;
        }
        Exception exc = (Exception) p.k(task.getException());
        int i10 = zzadz.zzb;
        if (!(exc instanceof FirebaseAuthException) || !((FirebaseAuthException) exc).getErrorCode().endsWith("INVALID_RECAPTCHA_TOKEN")) {
            return task;
        }
        if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
            "Invalid token - Refreshing Recaptcha Enterprise config and fetching new token for tenant ".concat(String.valueOf(this.zza));
        }
        return this.zzb.zza(this.zza, Boolean.TRUE, this.zzc).continueWithTask(this.zzd);
    }
}
