package com.google.firebase.auth;

import com.google.android.gms.internal.p003firebaseauthapi.zzadz;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthProvider;

final class zzm extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {
    final /* synthetic */ PhoneAuthOptions zza;
    final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks zzb;
    final /* synthetic */ FirebaseAuth zzc;

    zzm(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        this.zzc = firebaseAuth;
        this.zza = phoneAuthOptions;
        this.zzb = onVerificationStateChangedCallbacks;
    }

    public final void onCodeAutoRetrievalTimeOut(String str) {
        this.zzb.onCodeAutoRetrievalTimeOut(str);
    }

    public final void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        this.zzb.onCodeSent(str, forceResendingToken);
    }

    public final void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        this.zzb.onVerificationCompleted(phoneAuthCredential);
    }

    public final void onVerificationFailed(FirebaseException firebaseException) {
        int i10 = zzadz.zzb;
        if (!(firebaseException instanceof FirebaseAuthException) || !((FirebaseAuthException) firebaseException).getErrorCode().endsWith("ALTERNATE_CLIENT_IDENTIFIER_REQUIRED")) {
            String zzh = this.zza.zzh();
            String message = firebaseException.getMessage();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invoking original failure callbacks after phone verification failure for ");
            sb2.append(zzh);
            sb2.append(", error - ");
            sb2.append(message);
            this.zzb.onVerificationFailed(firebaseException);
            return;
        }
        this.zza.zzj(true);
        "Re-triggering phone verification with Recaptcha flow forced for phone number ".concat(String.valueOf(this.zza.zzh()));
        this.zzc.zzU(this.zza);
    }
}
