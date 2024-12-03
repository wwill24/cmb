package com.google.firebase.auth;

import com.google.firebase.auth.PhoneAuthProvider;

public final /* synthetic */ class zzi implements Runnable {
    public final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks zza;
    public final /* synthetic */ FirebaseAuthMissingActivityForRecaptchaException zzb;

    public /* synthetic */ zzi(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, FirebaseAuthMissingActivityForRecaptchaException firebaseAuthMissingActivityForRecaptchaException) {
        this.zza = onVerificationStateChangedCallbacks;
        this.zzb = firebaseAuthMissingActivityForRecaptchaException;
    }

    public final void run() {
        this.zza.onVerificationFailed(this.zzb);
    }
}
