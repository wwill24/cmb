package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport extends CrashlyticsReport {
    private final CrashlyticsReport.ApplicationExitInfo appExitInfo;
    private final String appQualitySessionId;
    private final String buildVersion;
    private final String displayVersion;
    private final String firebaseInstallationId;
    private final String gmpAppId;
    private final String installationUuid;
    private final CrashlyticsReport.FilesPayload ndkPayload;
    private final int platform;
    private final String sdkVersion;
    private final CrashlyticsReport.Session session;

    static final class Builder extends CrashlyticsReport.Builder {
        private CrashlyticsReport.ApplicationExitInfo appExitInfo;
        private String appQualitySessionId;
        private String buildVersion;
        private String displayVersion;
        private String firebaseInstallationId;
        private String gmpAppId;
        private String installationUuid;
        private CrashlyticsReport.FilesPayload ndkPayload;
        private Integer platform;
        private String sdkVersion;
        private CrashlyticsReport.Session session;

        public CrashlyticsReport build() {
            String str = "";
            if (this.sdkVersion == null) {
                str = str + " sdkVersion";
            }
            if (this.gmpAppId == null) {
                str = str + " gmpAppId";
            }
            if (this.platform == null) {
                str = str + " platform";
            }
            if (this.installationUuid == null) {
                str = str + " installationUuid";
            }
            if (this.buildVersion == null) {
                str = str + " buildVersion";
            }
            if (this.displayVersion == null) {
                str = str + " displayVersion";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport(this.sdkVersion, this.gmpAppId, this.platform.intValue(), this.installationUuid, this.firebaseInstallationId, this.appQualitySessionId, this.buildVersion, this.displayVersion, this.session, this.ndkPayload, this.appExitInfo);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Builder setAppExitInfo(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
            this.appExitInfo = applicationExitInfo;
            return this;
        }

        public CrashlyticsReport.Builder setAppQualitySessionId(String str) {
            this.appQualitySessionId = str;
            return this;
        }

        public CrashlyticsReport.Builder setBuildVersion(String str) {
            if (str != null) {
                this.buildVersion = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public CrashlyticsReport.Builder setDisplayVersion(String str) {
            if (str != null) {
                this.displayVersion = str;
                return this;
            }
            throw new NullPointerException("Null displayVersion");
        }

        public CrashlyticsReport.Builder setFirebaseInstallationId(String str) {
            this.firebaseInstallationId = str;
            return this;
        }

        public CrashlyticsReport.Builder setGmpAppId(String str) {
            if (str != null) {
                this.gmpAppId = str;
                return this;
            }
            throw new NullPointerException("Null gmpAppId");
        }

        public CrashlyticsReport.Builder setInstallationUuid(String str) {
            if (str != null) {
                this.installationUuid = str;
                return this;
            }
            throw new NullPointerException("Null installationUuid");
        }

        public CrashlyticsReport.Builder setNdkPayload(CrashlyticsReport.FilesPayload filesPayload) {
            this.ndkPayload = filesPayload;
            return this;
        }

        public CrashlyticsReport.Builder setPlatform(int i10) {
            this.platform = Integer.valueOf(i10);
            return this;
        }

        public CrashlyticsReport.Builder setSdkVersion(String str) {
            if (str != null) {
                this.sdkVersion = str;
                return this;
            }
            throw new NullPointerException("Null sdkVersion");
        }

        public CrashlyticsReport.Builder setSession(CrashlyticsReport.Session session2) {
            this.session = session2;
            return this;
        }

        Builder() {
        }

        private Builder(CrashlyticsReport crashlyticsReport) {
            this.sdkVersion = crashlyticsReport.getSdkVersion();
            this.gmpAppId = crashlyticsReport.getGmpAppId();
            this.platform = Integer.valueOf(crashlyticsReport.getPlatform());
            this.installationUuid = crashlyticsReport.getInstallationUuid();
            this.firebaseInstallationId = crashlyticsReport.getFirebaseInstallationId();
            this.appQualitySessionId = crashlyticsReport.getAppQualitySessionId();
            this.buildVersion = crashlyticsReport.getBuildVersion();
            this.displayVersion = crashlyticsReport.getDisplayVersion();
            this.session = crashlyticsReport.getSession();
            this.ndkPayload = crashlyticsReport.getNdkPayload();
            this.appExitInfo = crashlyticsReport.getAppExitInfo();
        }
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        CrashlyticsReport.Session session2;
        CrashlyticsReport.FilesPayload filesPayload;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport)) {
            return false;
        }
        CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
        if (this.sdkVersion.equals(crashlyticsReport.getSdkVersion()) && this.gmpAppId.equals(crashlyticsReport.getGmpAppId()) && this.platform == crashlyticsReport.getPlatform() && this.installationUuid.equals(crashlyticsReport.getInstallationUuid()) && ((str = this.firebaseInstallationId) != null ? str.equals(crashlyticsReport.getFirebaseInstallationId()) : crashlyticsReport.getFirebaseInstallationId() == null) && ((str2 = this.appQualitySessionId) != null ? str2.equals(crashlyticsReport.getAppQualitySessionId()) : crashlyticsReport.getAppQualitySessionId() == null) && this.buildVersion.equals(crashlyticsReport.getBuildVersion()) && this.displayVersion.equals(crashlyticsReport.getDisplayVersion()) && ((session2 = this.session) != null ? session2.equals(crashlyticsReport.getSession()) : crashlyticsReport.getSession() == null) && ((filesPayload = this.ndkPayload) != null ? filesPayload.equals(crashlyticsReport.getNdkPayload()) : crashlyticsReport.getNdkPayload() == null)) {
            CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.appExitInfo;
            if (applicationExitInfo == null) {
                if (crashlyticsReport.getAppExitInfo() == null) {
                    return true;
                }
            } else if (applicationExitInfo.equals(crashlyticsReport.getAppExitInfo())) {
                return true;
            }
        }
        return false;
    }

    public CrashlyticsReport.ApplicationExitInfo getAppExitInfo() {
        return this.appExitInfo;
    }

    public String getAppQualitySessionId() {
        return this.appQualitySessionId;
    }

    @NonNull
    public String getBuildVersion() {
        return this.buildVersion;
    }

    @NonNull
    public String getDisplayVersion() {
        return this.displayVersion;
    }

    public String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
    }

    @NonNull
    public String getGmpAppId() {
        return this.gmpAppId;
    }

    @NonNull
    public String getInstallationUuid() {
        return this.installationUuid;
    }

    public CrashlyticsReport.FilesPayload getNdkPayload() {
        return this.ndkPayload;
    }

    public int getPlatform() {
        return this.platform;
    }

    @NonNull
    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public CrashlyticsReport.Session getSession() {
        return this.session;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int hashCode = (((((((this.sdkVersion.hashCode() ^ 1000003) * 1000003) ^ this.gmpAppId.hashCode()) * 1000003) ^ this.platform) * 1000003) ^ this.installationUuid.hashCode()) * 1000003;
        String str = this.firebaseInstallationId;
        int i14 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int i15 = (hashCode ^ i10) * 1000003;
        String str2 = this.appQualitySessionId;
        if (str2 == null) {
            i11 = 0;
        } else {
            i11 = str2.hashCode();
        }
        int hashCode2 = (((((i15 ^ i11) * 1000003) ^ this.buildVersion.hashCode()) * 1000003) ^ this.displayVersion.hashCode()) * 1000003;
        CrashlyticsReport.Session session2 = this.session;
        if (session2 == null) {
            i12 = 0;
        } else {
            i12 = session2.hashCode();
        }
        int i16 = (hashCode2 ^ i12) * 1000003;
        CrashlyticsReport.FilesPayload filesPayload = this.ndkPayload;
        if (filesPayload == null) {
            i13 = 0;
        } else {
            i13 = filesPayload.hashCode();
        }
        int i17 = (i16 ^ i13) * 1000003;
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.appExitInfo;
        if (applicationExitInfo != null) {
            i14 = applicationExitInfo.hashCode();
        }
        return i17 ^ i14;
    }

    /* access modifiers changed from: protected */
    public CrashlyticsReport.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.sdkVersion + ", gmpAppId=" + this.gmpAppId + ", platform=" + this.platform + ", installationUuid=" + this.installationUuid + ", firebaseInstallationId=" + this.firebaseInstallationId + ", appQualitySessionId=" + this.appQualitySessionId + ", buildVersion=" + this.buildVersion + ", displayVersion=" + this.displayVersion + ", session=" + this.session + ", ndkPayload=" + this.ndkPayload + ", appExitInfo=" + this.appExitInfo + "}";
    }

    private AutoValue_CrashlyticsReport(String str, String str2, int i10, String str3, String str4, String str5, String str6, String str7, CrashlyticsReport.Session session2, CrashlyticsReport.FilesPayload filesPayload, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        this.sdkVersion = str;
        this.gmpAppId = str2;
        this.platform = i10;
        this.installationUuid = str3;
        this.firebaseInstallationId = str4;
        this.appQualitySessionId = str5;
        this.buildVersion = str6;
        this.displayVersion = str7;
        this.session = session2;
        this.ndkPayload = filesPayload;
        this.appExitInfo = applicationExitInfo;
    }
}
