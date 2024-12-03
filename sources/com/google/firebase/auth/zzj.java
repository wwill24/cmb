package com.google.firebase.auth;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zze;

final class zzj implements OnCompleteListener {
    final /* synthetic */ PhoneAuthOptions zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ FirebaseAuth zzc;

    zzj(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.zzc = firebaseAuth;
        this.zza = phoneAuthOptions;
        this.zzb = str;
    }

    public final void onComplete(Task task) {
        String str;
        String str2;
        String str3 = null;
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            if (exception instanceof FirebaseAuthMissingActivityForRecaptchaException) {
                FirebaseAuth.zzX((FirebaseAuthMissingActivityForRecaptchaException) exception, this.zza, this.zzb);
                return;
            }
            if (task.getException() != null) {
                str2 = task.getException().getMessage();
            } else {
                str2 = "";
            }
            "Error while validating application identity: ".concat(String.valueOf(str2));
            str = null;
        } else {
            str3 = ((zze) task.getResult()).zzb();
            str = ((zze) task.getResult()).zza();
        }
        this.zzc.zzV(this.zza, str3, str);
    }
}
