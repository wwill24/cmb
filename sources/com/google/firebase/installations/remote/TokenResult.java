package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import com.google.firebase.installations.remote.AutoValue_TokenResult;

public abstract class TokenResult {

    public static abstract class Builder {
        @NonNull
        public abstract TokenResult build();

        @NonNull
        public abstract Builder setResponseCode(@NonNull ResponseCode responseCode);

        @NonNull
        public abstract Builder setToken(@NonNull String str);

        @NonNull
        public abstract Builder setTokenExpirationTimestamp(long j10);
    }

    public enum ResponseCode {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_TokenResult.Builder().setTokenExpirationTimestamp(0);
    }

    public abstract ResponseCode getResponseCode();

    public abstract String getToken();

    @NonNull
    public abstract long getTokenExpirationTimestamp();

    @NonNull
    public abstract Builder toBuilder();
}
