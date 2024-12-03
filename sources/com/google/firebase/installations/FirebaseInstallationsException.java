package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;

public class FirebaseInstallationsException extends FirebaseException {
    @NonNull
    private final Status status;

    public enum Status {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public FirebaseInstallationsException(@NonNull Status status2) {
        this.status = status2;
    }

    @NonNull
    public Status getStatus() {
        return this.status;
    }

    public FirebaseInstallationsException(@NonNull String str, @NonNull Status status2) {
        super(str);
        this.status = status2;
    }

    public FirebaseInstallationsException(@NonNull String str, @NonNull Status status2, @NonNull Throwable th2) {
        super(str, th2);
        this.status = status2;
    }
}
