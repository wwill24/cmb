package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;

public class FirebaseRemoteConfigClientException extends FirebaseRemoteConfigException {
    public FirebaseRemoteConfigClientException(@NonNull String str) {
        super(str);
    }

    public FirebaseRemoteConfigClientException(@NonNull String str, Throwable th2) {
        super(str, th2);
    }

    public FirebaseRemoteConfigClientException(@NonNull String str, @NonNull FirebaseRemoteConfigException.Code code) {
        super(str, code);
    }

    public FirebaseRemoteConfigClientException(@NonNull String str, Throwable th2, @NonNull FirebaseRemoteConfigException.Code code) {
        super(str, th2, code);
    }
}
