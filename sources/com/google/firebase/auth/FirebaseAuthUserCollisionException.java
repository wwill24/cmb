package com.google.firebase.auth;

import androidx.annotation.NonNull;

public final class FirebaseAuthUserCollisionException extends FirebaseAuthException {
    private AuthCredential zza;
    private String zzb;
    private String zzc;

    public FirebaseAuthUserCollisionException(@NonNull String str, @NonNull String str2) {
        super(str, str2);
    }

    public String getEmail() {
        return this.zzb;
    }

    public AuthCredential getUpdatedCredential() {
        return this.zza;
    }

    @NonNull
    public final FirebaseAuthUserCollisionException zza(@NonNull AuthCredential authCredential) {
        this.zza = authCredential;
        return this;
    }

    @NonNull
    public final FirebaseAuthUserCollisionException zzb(@NonNull String str) {
        this.zzb = str;
        return this;
    }

    @NonNull
    public final FirebaseAuthUserCollisionException zzc(@NonNull String str) {
        this.zzc = str;
        return this;
    }
}
