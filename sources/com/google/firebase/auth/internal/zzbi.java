package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;

public final /* synthetic */ class zzbi implements Continuation {
    public final /* synthetic */ RecaptchaAction zza;
    public final /* synthetic */ FirebaseAuth zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ Continuation zzd;

    public /* synthetic */ zzbi(RecaptchaAction recaptchaAction, FirebaseAuth firebaseAuth, String str, Continuation continuation) {
        this.zza = recaptchaAction;
        this.zzb = firebaseAuth;
        this.zzc = str;
        this.zzd = continuation;
    }

    public final Object then(Task task) {
        return zzbl.zzc(this.zza, this.zzb, this.zzc, this.zzd, task);
    }
}
