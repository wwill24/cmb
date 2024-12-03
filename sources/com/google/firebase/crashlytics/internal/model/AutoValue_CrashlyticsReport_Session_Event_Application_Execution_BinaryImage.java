package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage {
    private final long baseAddress;
    private final String name;
    private final long size;
    private final String uuid;

    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder {
        private Long baseAddress;
        private String name;
        private Long size;
        private String uuid;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage build() {
            String str = "";
            if (this.baseAddress == null) {
                str = str + " baseAddress";
            }
            if (this.size == null) {
                str = str + " size";
            }
            if (this.name == null) {
                str = str + " name";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(this.baseAddress.longValue(), this.size.longValue(), this.name, this.uuid);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setBaseAddress(long j10) {
            this.baseAddress = Long.valueOf(j10);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setName(String str) {
            if (str != null) {
                this.name = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setSize(long j10) {
            this.size = Long.valueOf(j10);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setUuid(String str) {
            this.uuid = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage = (CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) obj;
        if (this.baseAddress == binaryImage.getBaseAddress() && this.size == binaryImage.getSize() && this.name.equals(binaryImage.getName())) {
            String str = this.uuid;
            if (str == null) {
                if (binaryImage.getUuid() == null) {
                    return true;
                }
            } else if (str.equals(binaryImage.getUuid())) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public long getBaseAddress() {
        return this.baseAddress;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    @Encodable.Ignore
    public String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        int i10;
        long j10 = this.baseAddress;
        long j11 = this.size;
        int hashCode = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.name.hashCode()) * 1000003;
        String str = this.uuid;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.baseAddress + ", size=" + this.size + ", name=" + this.name + ", uuid=" + this.uuid + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long j10, long j11, String str, String str2) {
        this.baseAddress = j10;
        this.size = j11;
        this.name = str;
        this.uuid = str2;
    }
}
