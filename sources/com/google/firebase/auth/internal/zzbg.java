package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzbg implements OnCompleteListener {
    public final /* synthetic */ RecaptchaActivity zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbg(RecaptchaActivity recaptchaActivity, String str) {
        this.zza = recaptchaActivity;
        this.zzb = str;
    }

    public final void onComplete(Task task) {
        this.zza.zzh(this.zzb, task);
    }
}
