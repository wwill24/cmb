package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;

public class FirebaseRemoteConfigException extends FirebaseException {
    private final Code code;

    public enum Code {
        UNKNOWN(0),
        CONFIG_UPDATE_STREAM_ERROR(1),
        CONFIG_UPDATE_MESSAGE_INVALID(2),
        CONFIG_UPDATE_NOT_FETCHED(3),
        CONFIG_UPDATE_UNAVAILABLE(4);
        
        private final int value;

        private Code(int i10) {
            this.value = i10;
        }

        public int value() {
            return this.value;
        }
    }

    public FirebaseRemoteConfigException(@NonNull String str) {
        super(str);
        this.code = Code.UNKNOWN;
    }

    @NonNull
    public Code getCode() {
        return this.code;
    }

    public FirebaseRemoteConfigException(@NonNull String str, Throwable th2) {
        super(str, th2);
        this.code = Code.UNKNOWN;
    }

    public FirebaseRemoteConfigException(@NonNull String str, @NonNull Code code2) {
        super(str);
        this.code = code2;
    }

    public FirebaseRemoteConfigException(@NonNull String str, Throwable th2, @NonNull Code code2) {
        super(str, th2);
        this.code = code2;
    }
}
