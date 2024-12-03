package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_OperatingSystem extends CrashlyticsReport.Session.OperatingSystem {
    private final String buildVersion;
    private final boolean jailbroken;
    private final int platform;
    private final String version;

    static final class Builder extends CrashlyticsReport.Session.OperatingSystem.Builder {
        private String buildVersion;
        private Boolean jailbroken;
        private Integer platform;
        private String version;

        Builder() {
        }

        public CrashlyticsReport.Session.OperatingSystem build() {
            String str = "";
            if (this.platform == null) {
                str = str + " platform";
            }
            if (this.version == null) {
                str = str + " version";
            }
            if (this.buildVersion == null) {
                str = str + " buildVersion";
            }
            if (this.jailbroken == null) {
                str = str + " jailbroken";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem(this.platform.intValue(), this.version, this.buildVersion, this.jailbroken.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.OperatingSystem.Builder setBuildVersion(String str) {
            if (str != null) {
                this.buildVersion = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public CrashlyticsReport.Session.OperatingSystem.Builder setJailbroken(boolean z10) {
            this.jailbroken = Boolean.valueOf(z10);
            return this;
        }

        public CrashlyticsReport.Session.OperatingSystem.Builder setPlatform(int i10) {
            this.platform = Integer.valueOf(i10);
            return this;
        }

        public CrashlyticsReport.Session.OperatingSystem.Builder setVersion(String str) {
            if (str != null) {
                this.version = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.OperatingSystem)) {
            return false;
        }
        CrashlyticsReport.Session.OperatingSystem operatingSystem = (CrashlyticsReport.Session.OperatingSystem) obj;
        if (this.platform != operatingSystem.getPlatform() || !this.version.equals(operatingSystem.getVersion()) || !this.buildVersion.equals(operatingSystem.getBuildVersion()) || this.jailbroken != operatingSystem.isJailbroken()) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getBuildVersion() {
        return this.buildVersion;
    }

    public int getPlatform() {
        return this.platform;
    }

    @NonNull
    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int i10;
        int hashCode = (((((this.platform ^ 1000003) * 1000003) ^ this.version.hashCode()) * 1000003) ^ this.buildVersion.hashCode()) * 1000003;
        if (this.jailbroken) {
            i10 = 1231;
        } else {
            i10 = 1237;
        }
        return hashCode ^ i10;
    }

    public boolean isJailbroken() {
        return this.jailbroken;
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.platform + ", version=" + this.version + ", buildVersion=" + this.buildVersion + ", jailbroken=" + this.jailbroken + "}";
    }

    private AutoValue_CrashlyticsReport_Session_OperatingSystem(int i10, String str, String str2, boolean z10) {
        this.platform = i10;
        this.version = str;
        this.buildVersion = str2;
        this.jailbroken = z10;
    }
}
