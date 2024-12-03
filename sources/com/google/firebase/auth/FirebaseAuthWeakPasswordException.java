package com.google.firebase.auth;

import androidx.annotation.NonNull;

public final class FirebaseAuthWeakPasswordException extends FirebaseAuthInvalidCredentialsException {
    private final String zza;

    public FirebaseAuthWeakPasswordException(@NonNull String str, @NonNull String str2, String str3) {
        super(str, str2);
        this.zza = str3;
    }

    public String getReason() {
        return this.zza;
    }
}
