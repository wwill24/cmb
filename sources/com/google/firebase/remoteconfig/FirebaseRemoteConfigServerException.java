package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;

public class FirebaseRemoteConfigServerException extends FirebaseRemoteConfigException {
    private final int httpStatusCode;

    public FirebaseRemoteConfigServerException(int i10, @NonNull String str) {
        super(str);
        this.httpStatusCode = i10;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public FirebaseRemoteConfigServerException(int i10, @NonNull String str, Throwable th2) {
        super(str, th2);
        this.httpStatusCode = i10;
    }

    public FirebaseRemoteConfigServerException(@NonNull String str, FirebaseRemoteConfigException.Code code) {
        super(str, code);
        this.httpStatusCode = -1;
    }

    public FirebaseRemoteConfigServerException(int i10, @NonNull String str, FirebaseRemoteConfigException.Code code) {
        super(str, code);
        this.httpStatusCode = i10;
    }

    public FirebaseRemoteConfigServerException(@NonNull String str, Throwable th2, @NonNull FirebaseRemoteConfigException.Code code) {
        super(str, th2, code);
        this.httpStatusCode = -1;
    }

    public FirebaseRemoteConfigServerException(int i10, @NonNull String str, Throwable th2, @NonNull FirebaseRemoteConfigException.Code code) {
        super(str, th2, code);
        this.httpStatusCode = i10;
    }
}
