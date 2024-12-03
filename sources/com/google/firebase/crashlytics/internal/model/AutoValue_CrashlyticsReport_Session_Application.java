package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Application extends CrashlyticsReport.Session.Application {
    private final String developmentPlatform;
    private final String developmentPlatformVersion;
    private final String displayVersion;
    private final String identifier;
    private final String installationUuid;
    private final CrashlyticsReport.Session.Application.Organization organization;
    private final String version;

    static final class Builder extends CrashlyticsReport.Session.Application.Builder {
        private String developmentPlatform;
        private String developmentPlatformVersion;
        private String displayVersion;
        private String identifier;
        private String installationUuid;
        private CrashlyticsReport.Session.Application.Organization organization;
        private String version;

        public CrashlyticsReport.Session.Application build() {
            String str = "";
            if (this.identifier == null) {
                str = str + " identifier";
            }
            if (this.version == null) {
                str = str + " version";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Application(this.identifier, this.version, this.displayVersion, this.organization, this.installationUuid, this.developmentPlatform, this.developmentPlatformVersion);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Application.Builder setDevelopmentPlatform(String str) {
            this.developmentPlatform = str;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder setDevelopmentPlatformVersion(String str) {
            this.developmentPlatformVersion = str;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder setDisplayVersion(String str) {
            this.displayVersion = str;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder setIdentifier(String str) {
            if (str != null) {
                this.identifier = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public CrashlyticsReport.Session.Application.Builder setInstallationUuid(String str) {
            this.installationUuid = str;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder setOrganization(CrashlyticsReport.Session.Application.Organization organization2) {
            this.organization = organization2;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder setVersion(String str) {
            if (str != null) {
                this.version = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }

        Builder() {
        }

        private Builder(CrashlyticsReport.Session.Application application) {
            this.identifier = application.getIdentifier();
            this.version = application.getVersion();
            this.displayVersion = application.getDisplayVersion();
            this.organization = application.getOrganization();
            this.installationUuid = application.getInstallationUuid();
            this.developmentPlatform = application.getDevelopmentPlatform();
            this.developmentPlatformVersion = application.getDevelopmentPlatformVersion();
        }
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session.Application.Organization organization2;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Application application = (CrashlyticsReport.Session.Application) obj;
        if (this.identifier.equals(application.getIdentifier()) && this.version.equals(application.getVersion()) && ((str = this.displayVersion) != null ? str.equals(application.getDisplayVersion()) : application.getDisplayVersion() == null) && ((organization2 = this.organization) != null ? organization2.equals(application.getOrganization()) : application.getOrganization() == null) && ((str2 = this.installationUuid) != null ? str2.equals(application.getInstallationUuid()) : application.getInstallationUuid() == null) && ((str3 = this.developmentPlatform) != null ? str3.equals(application.getDevelopmentPlatform()) : application.getDevelopmentPlatform() == null)) {
            String str4 = this.developmentPlatformVersion;
            if (str4 == null) {
                if (application.getDevelopmentPlatformVersion() == null) {
                    return true;
                }
            } else if (str4.equals(application.getDevelopmentPlatformVersion())) {
                return true;
            }
        }
        return false;
    }

    public String getDevelopmentPlatform() {
        return this.developmentPlatform;
    }

    public String getDevelopmentPlatformVersion() {
        return this.developmentPlatformVersion;
    }

    public String getDisplayVersion() {
        return this.displayVersion;
    }

    @NonNull
    public String getIdentifier() {
        return this.identifier;
    }

    public String getInstallationUuid() {
        return this.installationUuid;
    }

    public CrashlyticsReport.Session.Application.Organization getOrganization() {
        return this.organization;
    }

    @NonNull
    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int hashCode = (((this.identifier.hashCode() ^ 1000003) * 1000003) ^ this.version.hashCode()) * 1000003;
        String str = this.displayVersion;
        int i14 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int i15 = (hashCode ^ i10) * 1000003;
        CrashlyticsReport.Session.Application.Organization organization2 = this.organization;
        if (organization2 == null) {
            i11 = 0;
        } else {
            i11 = organization2.hashCode();
        }
        int i16 = (i15 ^ i11) * 1000003;
        String str2 = this.installationUuid;
        if (str2 == null) {
            i12 = 0;
        } else {
            i12 = str2.hashCode();
        }
        int i17 = (i16 ^ i12) * 1000003;
        String str3 = this.developmentPlatform;
        if (str3 == null) {
            i13 = 0;
        } else {
            i13 = str3.hashCode();
        }
        int i18 = (i17 ^ i13) * 1000003;
        String str4 = this.developmentPlatformVersion;
        if (str4 != null) {
            i14 = str4.hashCode();
        }
        return i18 ^ i14;
    }

    /* access modifiers changed from: protected */
    public CrashlyticsReport.Session.Application.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "Application{identifier=" + this.identifier + ", version=" + this.version + ", displayVersion=" + this.displayVersion + ", organization=" + this.organization + ", installationUuid=" + this.installationUuid + ", developmentPlatform=" + this.developmentPlatform + ", developmentPlatformVersion=" + this.developmentPlatformVersion + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Application(String str, String str2, String str3, CrashlyticsReport.Session.Application.Organization organization2, String str4, String str5, String str6) {
        this.identifier = str;
        this.version = str2;
        this.displayVersion = str3;
        this.organization = organization2;
        this.installationUuid = str4;
        this.developmentPlatform = str5;
        this.developmentPlatformVersion = str6;
    }
}
