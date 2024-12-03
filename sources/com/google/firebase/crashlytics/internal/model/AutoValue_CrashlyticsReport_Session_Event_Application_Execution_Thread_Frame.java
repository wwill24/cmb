package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame {
    private final String file;
    private final int importance;
    private final long offset;

    /* renamed from: pc  reason: collision with root package name */
    private final long f21024pc;
    private final String symbol;

    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder {
        private String file;
        private Integer importance;
        private Long offset;

        /* renamed from: pc  reason: collision with root package name */
        private Long f21025pc;
        private String symbol;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame build() {
            String str = "";
            if (this.f21025pc == null) {
                str = str + " pc";
            }
            if (this.symbol == null) {
                str = str + " symbol";
            }
            if (this.offset == null) {
                str = str + " offset";
            }
            if (this.importance == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(this.f21025pc.longValue(), this.symbol, this.file, this.offset.longValue(), this.importance.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setFile(String str) {
            this.file = str;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setImportance(int i10) {
            this.importance = Integer.valueOf(i10);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setOffset(long j10) {
            this.offset = Long.valueOf(j10);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setPc(long j10) {
            this.f21025pc = Long.valueOf(j10);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setSymbol(String str) {
            if (str != null) {
                this.symbol = str;
                return this;
            }
            throw new NullPointerException("Null symbol");
        }
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) obj;
        if (this.f21024pc == frame.getPc() && this.symbol.equals(frame.getSymbol()) && ((str = this.file) != null ? str.equals(frame.getFile()) : frame.getFile() == null) && this.offset == frame.getOffset() && this.importance == frame.getImportance()) {
            return true;
        }
        return false;
    }

    public String getFile() {
        return this.file;
    }

    public int getImportance() {
        return this.importance;
    }

    public long getOffset() {
        return this.offset;
    }

    public long getPc() {
        return this.f21024pc;
    }

    @NonNull
    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        int i10;
        long j10 = this.f21024pc;
        int hashCode = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.symbol.hashCode()) * 1000003;
        String str = this.file;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        long j11 = this.offset;
        return ((((hashCode ^ i10) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.importance;
    }

    public String toString() {
        return "Frame{pc=" + this.f21024pc + ", symbol=" + this.symbol + ", file=" + this.file + ", offset=" + this.offset + ", importance=" + this.importance + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long j10, String str, String str2, long j11, int i10) {
        this.f21024pc = j10;
        this.symbol = str;
        this.file = str2;
        this.offset = j11;
        this.importance = i10;
    }
}
