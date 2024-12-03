package com.google.firebase.auth;

public abstract class FirebaseAuthSettings {
    public abstract void forceRecaptchaFlowForTesting(boolean z10);

    public abstract void setAppVerificationDisabledForTesting(boolean z10);

    public abstract void setAutoRetrievedSmsCodeForPhoneNumber(String str, String str2);
}
