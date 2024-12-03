package com.google.firebase.auth;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;

public class EmailAuthProvider {
    @NonNull
    public static final String EMAIL_LINK_SIGN_IN_METHOD = "emailLink";
    @NonNull
    public static final String EMAIL_PASSWORD_SIGN_IN_METHOD = "password";
    @NonNull
    public static final String PROVIDER_ID = "password";

    private EmailAuthProvider() {
    }

    @NonNull
    public static AuthCredential getCredential(@NonNull String str, @NonNull String str2) {
        p.g(str);
        p.g(str2);
        return new EmailAuthCredential(str, str2, (String) null, (String) null, false);
    }

    @NonNull
    public static AuthCredential getCredentialWithLink(@NonNull String str, @NonNull String str2) {
        if (EmailAuthCredential.zzi(str2)) {
            return new EmailAuthCredential(str, (String) null, str2, (String) null, false);
        }
        throw new IllegalArgumentException("Given link is not a valid email link. Please use FirebaseAuth#isSignInWithEmailLink(String) to determine this before calling this function");
    }
}
