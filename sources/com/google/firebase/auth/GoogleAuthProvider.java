package com.google.firebase.auth;

import androidx.annotation.NonNull;

public class GoogleAuthProvider {
    @NonNull
    public static final String GOOGLE_SIGN_IN_METHOD = "google.com";
    @NonNull
    public static final String PROVIDER_ID = "google.com";

    private GoogleAuthProvider() {
    }

    @NonNull
    public static AuthCredential getCredential(String str, String str2) {
        return new GoogleAuthCredential(str, str2);
    }
}
