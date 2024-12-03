package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;

final class AutoValue_InstallIdProvider_InstallIds extends InstallIdProvider.InstallIds {
    private final String crashlyticsInstallId;
    private final String firebaseInstallationId;

    AutoValue_InstallIdProvider_InstallIds(String str, String str2) {
        if (str != null) {
            this.crashlyticsInstallId = str;
            this.firebaseInstallationId = str2;
            return;
        }
        throw new NullPointerException("Null crashlyticsInstallId");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallIdProvider.InstallIds)) {
            return false;
        }
        InstallIdProvider.InstallIds installIds = (InstallIdProvider.InstallIds) obj;
        if (this.crashlyticsInstallId.equals(installIds.getCrashlyticsInstallId())) {
            String str = this.firebaseInstallationId;
            if (str == null) {
                if (installIds.getFirebaseInstallationId() == null) {
                    return true;
                }
            } else if (str.equals(installIds.getFirebaseInstallationId())) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public String getCrashlyticsInstallId() {
        return this.crashlyticsInstallId;
    }

    public String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
    }

    public int hashCode() {
        int i10;
        int hashCode = (this.crashlyticsInstallId.hashCode() ^ 1000003) * 1000003;
        String str = this.firebaseInstallationId;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.crashlyticsInstallId + ", firebaseInstallationId=" + this.firebaseInstallationId + "}";
    }
}
