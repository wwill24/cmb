package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;

public interface InstallIdProvider {

    public static abstract class InstallIds {
        static InstallIds create(String str, String str2) {
            return new AutoValue_InstallIdProvider_InstallIds(str, str2);
        }

        public static InstallIds createWithoutFid(String str) {
            return create(str, (String) null);
        }

        @NonNull
        public abstract String getCrashlyticsInstallId();

        public abstract String getFirebaseInstallationId();
    }

    InstallIds getInstallIds();
}
