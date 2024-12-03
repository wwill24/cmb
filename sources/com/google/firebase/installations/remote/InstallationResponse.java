package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import com.google.firebase.installations.remote.AutoValue_InstallationResponse;

public abstract class InstallationResponse {

    public static abstract class Builder {
        @NonNull
        public abstract InstallationResponse build();

        @NonNull
        public abstract Builder setAuthToken(@NonNull TokenResult tokenResult);

        @NonNull
        public abstract Builder setFid(@NonNull String str);

        @NonNull
        public abstract Builder setRefreshToken(@NonNull String str);

        @NonNull
        public abstract Builder setResponseCode(@NonNull ResponseCode responseCode);

        @NonNull
        public abstract Builder setUri(@NonNull String str);
    }

    public enum ResponseCode {
        OK,
        BAD_CONFIG
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_InstallationResponse.Builder();
    }

    public abstract TokenResult getAuthToken();

    public abstract String getFid();

    public abstract String getRefreshToken();

    public abstract ResponseCode getResponseCode();

    public abstract String getUri();

    @NonNull
    public abstract Builder toBuilder();
}
