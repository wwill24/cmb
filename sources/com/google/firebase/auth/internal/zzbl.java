package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzadz;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public abstract class zzbl {
    static /* synthetic */ Task zzc(RecaptchaAction recaptchaAction, FirebaseAuth firebaseAuth, String str, Continuation continuation, Task task) throws Exception {
        if (task.isSuccessful()) {
            return Tasks.forResult(task.getResult());
        }
        Exception exc = (Exception) p.k(task.getException());
        int i10 = zzadz.zzb;
        if (!(exc instanceof FirebaseAuthException) || !((FirebaseAuthException) exc).getErrorCode().endsWith("MISSING_RECAPTCHA_TOKEN")) {
            String valueOf = String.valueOf(recaptchaAction);
            String message = exc.getMessage();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Initial task failed for action ");
            sb2.append(valueOf);
            sb2.append("with exception - ");
            sb2.append(message);
            return Tasks.forException(exc);
        }
        if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
            "Falling back to recaptcha enterprise flow for action ".concat(String.valueOf(recaptchaAction));
        }
        if (firebaseAuth.zzB() == null) {
            firebaseAuth.zzP(new zzbr(firebaseAuth.getApp(), firebaseAuth));
        }
        return zzd(firebaseAuth.zzB(), recaptchaAction, str, continuation);
    }

    private static Task zzd(zzbr zzbr, RecaptchaAction recaptchaAction, String str, Continuation continuation) {
        Task zza = zzbr.zza(str, Boolean.FALSE, recaptchaAction);
        return zza.continueWithTask(continuation).continueWithTask(new zzbk(str, zzbr, recaptchaAction, continuation));
    }

    public abstract Task zza(String str);

    public final Task zzb(FirebaseAuth firebaseAuth, String str, RecaptchaAction recaptchaAction) {
        zzbj zzbj = new zzbj(this);
        zzbr zzB = firebaseAuth.zzB();
        if (zzB == null || !zzB.zze()) {
            return zza((String) null).continueWithTask(new zzbi(recaptchaAction, firebaseAuth, str, zzbj));
        }
        return zzd(zzB, recaptchaAction, str, zzbj);
    }
}
