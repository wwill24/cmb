package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;

final class AutoValue_CrashlyticsReport_Session extends CrashlyticsReport.Session {
    private final CrashlyticsReport.Session.Application app;
    private final String appQualitySessionId;
    private final boolean crashed;
    private final CrashlyticsReport.Session.Device device;
    private final Long endedAt;
    private final ImmutableList<CrashlyticsReport.Session.Event> events;
    private final String generator;
    private final int generatorType;
    private final String identifier;
    private final CrashlyticsReport.Session.OperatingSystem os;
    private final long startedAt;
    private final CrashlyticsReport.Session.User user;

    static final class Builder extends CrashlyticsReport.Session.Builder {
        private CrashlyticsReport.Session.Application app;
        private String appQualitySessionId;
        private Boolean crashed;
        private CrashlyticsReport.Session.Device device;
        private Long endedAt;
        private ImmutableList<CrashlyticsReport.Session.Event> events;
        private String generator;
        private Integer generatorType;
        private String identifier;
        private CrashlyticsReport.Session.OperatingSystem os;
        private Long startedAt;
        private CrashlyticsReport.Session.User user;

        public CrashlyticsReport.Session build() {
            String str = "";
            if (this.generator == null) {
                str = str + " generator";
            }
            if (this.identifier == null) {
                str = str + " identifier";
            }
            if (this.startedAt == null) {
                str = str + " startedAt";
            }
            if (this.crashed == null) {
                str = str + " crashed";
            }
            if (this.app == null) {
                str = str + " app";
            }
            if (this.generatorType == null) {
                str = str + " generatorType";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session(this.generator, this.identifier, this.appQualitySessionId, this.startedAt.longValue(), this.endedAt, this.crashed.booleanValue(), this.app, this.user, this.os, this.device, this.events, this.generatorType.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Builder setApp(CrashlyticsReport.Session.Application application) {
            if (application != null) {
                this.app = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public CrashlyticsReport.Session.Builder setAppQualitySessionId(String str) {
            this.appQualitySessionId = str;
            return this;
        }

        public CrashlyticsReport.Session.Builder setCrashed(boolean z10) {
            this.crashed = Boolean.valueOf(z10);
            return this;
        }

        public CrashlyticsReport.Session.Builder setDevice(CrashlyticsReport.Session.Device device2) {
            this.device = device2;
            return this;
        }

        public CrashlyticsReport.Session.Builder setEndedAt(Long l10) {
            this.endedAt = l10;
            return this;
        }

        public CrashlyticsReport.Session.Builder setEvents(ImmutableList<CrashlyticsReport.Session.Event> immutableList) {
            this.events = immutableList;
            return this;
        }

        public CrashlyticsReport.Session.Builder setGenerator(String str) {
            if (str != null) {
                this.generator = str;
                return this;
            }
            throw new NullPointerException("Null generator");
        }

        public CrashlyticsReport.Session.Builder setGeneratorType(int i10) {
            this.generatorType = Integer.valueOf(i10);
            return this;
        }

        public CrashlyticsReport.Session.Builder setIdentifier(String str) {
            if (str != null) {
                this.identifier = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public CrashlyticsReport.Session.Builder setOs(CrashlyticsReport.Session.OperatingSystem operatingSystem) {
            this.os = operatingSystem;
            return this;
        }

        public CrashlyticsReport.Session.Builder setStartedAt(long j10) {
            this.startedAt = Long.valueOf(j10);
            return this;
        }

        public CrashlyticsReport.Session.Builder setUser(CrashlyticsReport.Session.User user2) {
            this.user = user2;
            return this;
        }

        Builder() {
        }

        private Builder(CrashlyticsReport.Session session) {
            this.generator = session.getGenerator();
            this.identifier = session.getIdentifier();
            this.appQualitySessionId = session.getAppQualitySessionId();
            this.startedAt = Long.valueOf(session.getStartedAt());
            this.endedAt = session.getEndedAt();
            this.crashed = Boolean.valueOf(session.isCrashed());
            this.app = session.getApp();
            this.user = session.getUser();
            this.os = session.getOs();
            this.device = session.getDevice();
            this.events = session.getEvents();
            this.generatorType = Integer.valueOf(session.getGeneratorType());
        }
    }

    public boolean equals(Object obj) {
        String str;
        Long l10;
        CrashlyticsReport.Session.User user2;
        CrashlyticsReport.Session.OperatingSystem operatingSystem;
        CrashlyticsReport.Session.Device device2;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session)) {
            return false;
        }
        CrashlyticsReport.Session session = (CrashlyticsReport.Session) obj;
        if (!this.generator.equals(session.getGenerator()) || !this.identifier.equals(session.getIdentifier()) || ((str = this.appQualitySessionId) != null ? !str.equals(session.getAppQualitySessionId()) : session.getAppQualitySessionId() != null) || this.startedAt != session.getStartedAt() || ((l10 = this.endedAt) != null ? !l10.equals(session.getEndedAt()) : session.getEndedAt() != null) || this.crashed != session.isCrashed() || !this.app.equals(session.getApp()) || ((user2 = this.user) != null ? !user2.equals(session.getUser()) : session.getUser() != null) || ((operatingSystem = this.os) != null ? !operatingSystem.equals(session.getOs()) : session.getOs() != null) || ((device2 = this.device) != null ? !device2.equals(session.getDevice()) : session.getDevice() != null) || ((immutableList = this.events) != null ? !immutableList.equals(session.getEvents()) : session.getEvents() != null) || this.generatorType != session.getGeneratorType()) {
            return false;
        }
        return true;
    }

    @NonNull
    public CrashlyticsReport.Session.Application getApp() {
        return this.app;
    }

    public String getAppQualitySessionId() {
        return this.appQualitySessionId;
    }

    public CrashlyticsReport.Session.Device getDevice() {
        return this.device;
    }

    public Long getEndedAt() {
        return this.endedAt;
    }

    public ImmutableList<CrashlyticsReport.Session.Event> getEvents() {
        return this.events;
    }

    @NonNull
    public String getGenerator() {
        return this.generator;
    }

    public int getGeneratorType() {
        return this.generatorType;
    }

    @NonNull
    @Encodable.Ignore
    public String getIdentifier() {
        return this.identifier;
    }

    public CrashlyticsReport.Session.OperatingSystem getOs() {
        return this.os;
    }

    public long getStartedAt() {
        return this.startedAt;
    }

    public CrashlyticsReport.Session.User getUser() {
        return this.user;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int hashCode = (((this.generator.hashCode() ^ 1000003) * 1000003) ^ this.identifier.hashCode()) * 1000003;
        String str = this.appQualitySessionId;
        int i16 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        long j10 = this.startedAt;
        int i17 = (((hashCode ^ i10) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        Long l10 = this.endedAt;
        if (l10 == null) {
            i11 = 0;
        } else {
            i11 = l10.hashCode();
        }
        int i18 = (i17 ^ i11) * 1000003;
        if (this.crashed) {
            i12 = 1231;
        } else {
            i12 = 1237;
        }
        int hashCode2 = (((i18 ^ i12) * 1000003) ^ this.app.hashCode()) * 1000003;
        CrashlyticsReport.Session.User user2 = this.user;
        if (user2 == null) {
            i13 = 0;
        } else {
            i13 = user2.hashCode();
        }
        int i19 = (hashCode2 ^ i13) * 1000003;
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.os;
        if (operatingSystem == null) {
            i14 = 0;
        } else {
            i14 = operatingSystem.hashCode();
        }
        int i20 = (i19 ^ i14) * 1000003;
        CrashlyticsReport.Session.Device device2 = this.device;
        if (device2 == null) {
            i15 = 0;
        } else {
            i15 = device2.hashCode();
        }
        int i21 = (i20 ^ i15) * 1000003;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList = this.events;
        if (immutableList != null) {
            i16 = immutableList.hashCode();
        }
        return ((i21 ^ i16) * 1000003) ^ this.generatorType;
    }

    public boolean isCrashed() {
        return this.crashed;
    }

    public CrashlyticsReport.Session.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "Session{generator=" + this.generator + ", identifier=" + this.identifier + ", appQualitySessionId=" + this.appQualitySessionId + ", startedAt=" + this.startedAt + ", endedAt=" + this.endedAt + ", crashed=" + this.crashed + ", app=" + this.app + ", user=" + this.user + ", os=" + this.os + ", device=" + this.device + ", events=" + this.events + ", generatorType=" + this.generatorType + "}";
    }

    private AutoValue_CrashlyticsReport_Session(String str, String str2, String str3, long j10, Long l10, boolean z10, CrashlyticsReport.Session.Application application, CrashlyticsReport.Session.User user2, CrashlyticsReport.Session.OperatingSystem operatingSystem, CrashlyticsReport.Session.Device device2, ImmutableList<CrashlyticsReport.Session.Event> immutableList, int i10) {
        this.generator = str;
        this.identifier = str2;
        this.appQualitySessionId = str3;
        this.startedAt = j10;
        this.endedAt = l10;
        this.crashed = z10;
        this.app = application;
        this.user = user2;
        this.os = operatingSystem;
        this.device = device2;
        this.events = immutableList;
        this.generatorType = i10;
    }
}
