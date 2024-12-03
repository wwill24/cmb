package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class FirebaseRemoteConfigInfoImpl implements FirebaseRemoteConfigInfo {
    private final FirebaseRemoteConfigSettings configSettings;
    private final int lastFetchStatus;
    private final long lastSuccessfulFetchTimeInMillis;

    public static class Builder {
        private FirebaseRemoteConfigSettings builderConfigSettings;
        private int builderLastFetchStatus;
        private long builderLastSuccessfulFetchTimeInMillis;

        private Builder() {
        }

        public FirebaseRemoteConfigInfoImpl build() {
            return new FirebaseRemoteConfigInfoImpl(this.builderLastSuccessfulFetchTimeInMillis, this.builderLastFetchStatus, this.builderConfigSettings);
        }

        /* access modifiers changed from: package-private */
        public Builder withConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
            this.builderConfigSettings = firebaseRemoteConfigSettings;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder withLastFetchStatus(int i10) {
            this.builderLastFetchStatus = i10;
            return this;
        }

        public Builder withLastSuccessfulFetchTimeInMillis(long j10) {
            this.builderLastSuccessfulFetchTimeInMillis = j10;
            return this;
        }
    }

    static Builder newBuilder() {
        return new Builder();
    }

    public FirebaseRemoteConfigSettings getConfigSettings() {
        return this.configSettings;
    }

    public long getFetchTimeMillis() {
        return this.lastSuccessfulFetchTimeInMillis;
    }

    public int getLastFetchStatus() {
        return this.lastFetchStatus;
    }

    private FirebaseRemoteConfigInfoImpl(long j10, int i10, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.lastSuccessfulFetchTimeInMillis = j10;
        this.lastFetchStatus = i10;
        this.configSettings = firebaseRemoteConfigSettings;
    }
}
