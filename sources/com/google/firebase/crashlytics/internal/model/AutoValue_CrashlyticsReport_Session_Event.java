package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event extends CrashlyticsReport.Session.Event {
    private final CrashlyticsReport.Session.Event.Application app;
    private final CrashlyticsReport.Session.Event.Device device;
    private final CrashlyticsReport.Session.Event.Log log;
    private final long timestamp;
    private final String type;

    static final class Builder extends CrashlyticsReport.Session.Event.Builder {
        private CrashlyticsReport.Session.Event.Application app;
        private CrashlyticsReport.Session.Event.Device device;
        private CrashlyticsReport.Session.Event.Log log;
        private Long timestamp;
        private String type;

        public CrashlyticsReport.Session.Event build() {
            String str = "";
            if (this.timestamp == null) {
                str = str + " timestamp";
            }
            if (this.type == null) {
                str = str + " type";
            }
            if (this.app == null) {
                str = str + " app";
            }
            if (this.device == null) {
                str = str + " device";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event(this.timestamp.longValue(), this.type, this.app, this.device, this.log);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Builder setApp(CrashlyticsReport.Session.Event.Application application) {
            if (application != null) {
                this.app = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public CrashlyticsReport.Session.Event.Builder setDevice(CrashlyticsReport.Session.Event.Device device2) {
            if (device2 != null) {
                this.device = device2;
                return this;
            }
            throw new NullPointerException("Null device");
        }

        public CrashlyticsReport.Session.Event.Builder setLog(CrashlyticsReport.Session.Event.Log log2) {
            this.log = log2;
            return this;
        }

        public CrashlyticsReport.Session.Event.Builder setTimestamp(long j10) {
            this.timestamp = Long.valueOf(j10);
            return this;
        }

        public CrashlyticsReport.Session.Event.Builder setType(String str) {
            if (str != null) {
                this.type = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        Builder() {
        }

        private Builder(CrashlyticsReport.Session.Event event) {
            this.timestamp = Long.valueOf(event.getTimestamp());
            this.type = event.getType();
            this.app = event.getApp();
            this.device = event.getDevice();
            this.log = event.getLog();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event)) {
            return false;
        }
        CrashlyticsReport.Session.Event event = (CrashlyticsReport.Session.Event) obj;
        if (this.timestamp == event.getTimestamp() && this.type.equals(event.getType()) && this.app.equals(event.getApp()) && this.device.equals(event.getDevice())) {
            CrashlyticsReport.Session.Event.Log log2 = this.log;
            if (log2 == null) {
                if (event.getLog() == null) {
                    return true;
                }
            } else if (log2.equals(event.getLog())) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Application getApp() {
        return this.app;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Device getDevice() {
        return this.device;
    }

    public CrashlyticsReport.Session.Event.Log getLog() {
        return this.log;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    @NonNull
    public String getType() {
        return this.type;
    }

    public int hashCode() {
        int i10;
        long j10 = this.timestamp;
        int hashCode = (((((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.app.hashCode()) * 1000003) ^ this.device.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Log log2 = this.log;
        if (log2 == null) {
            i10 = 0;
        } else {
            i10 = log2.hashCode();
        }
        return hashCode ^ i10;
    }

    public CrashlyticsReport.Session.Event.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "Event{timestamp=" + this.timestamp + ", type=" + this.type + ", app=" + this.app + ", device=" + this.device + ", log=" + this.log + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event(long j10, String str, CrashlyticsReport.Session.Event.Application application, CrashlyticsReport.Session.Event.Device device2, CrashlyticsReport.Session.Event.Log log2) {
        this.timestamp = j10;
        this.type = str;
        this.app = application;
        this.device = device2;
        this.log = log2;
    }
}
