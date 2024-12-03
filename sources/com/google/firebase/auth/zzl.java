package com.google.firebase.auth;

import com.google.android.gms.common.internal.p;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthProvider;

final class zzl extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {
    final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks zza;
    final /* synthetic */ FirebaseAuth zzb;

    zzl(FirebaseAuth firebaseAuth, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        this.zzb = firebaseAuth;
        this.zza = onVerificationStateChangedCallbacks;
    }

    public final void onCodeAutoRetrievalTimeOut(String str) {
    }

    public final void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        this.zza.onVerificationCompleted(PhoneAuthProvider.getCredential(str, (String) p.k(this.zzb.zzh.zzb())));
    }

    public final void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        this.zza.onVerificationCompleted(phoneAuthCredential);
    }

    public final void onVerificationFailed(FirebaseException firebaseException) {
        this.zza.onVerificationFailed(firebaseException);
    }
}
