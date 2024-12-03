package com.google.firebase.perf.session;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.SessionVerbosity;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.cli.HelpFormatter;

public class PerfSession implements Parcelable {
    public static final Parcelable.Creator<PerfSession> CREATOR = new Parcelable.Creator<PerfSession>() {
        public PerfSession createFromParcel(@NonNull Parcel parcel) {
            return new PerfSession(parcel);
        }

        public PerfSession[] newArray(int i10) {
            return new PerfSession[i10];
        }
    };
    private final Timer creationTime;
    private boolean isGaugeAndEventCollectionEnabled;
    private final String sessionId;

    public static com.google.firebase.perf.v1.PerfSession[] buildAndSort(@NonNull List<PerfSession> list) {
        if (list.isEmpty()) {
            return null;
        }
        com.google.firebase.perf.v1.PerfSession[] perfSessionArr = new com.google.firebase.perf.v1.PerfSession[list.size()];
        com.google.firebase.perf.v1.PerfSession build = list.get(0).build();
        boolean z10 = false;
        for (int i10 = 1; i10 < list.size(); i10++) {
            com.google.firebase.perf.v1.PerfSession build2 = list.get(i10).build();
            if (z10 || !list.get(i10).isVerbose()) {
                perfSessionArr[i10] = build2;
            } else {
                perfSessionArr[0] = build2;
                perfSessionArr[i10] = build;
                z10 = true;
            }
        }
        if (!z10) {
            perfSessionArr[0] = build;
        }
        return perfSessionArr;
    }

    public static PerfSession createWithId(@NonNull String str) {
        PerfSession perfSession = new PerfSession(str.replace(HelpFormatter.DEFAULT_OPT_PREFIX, ""), new Clock());
        perfSession.setGaugeAndEventCollectionEnabled(shouldCollectGaugesAndEvents());
        return perfSession;
    }

    public static boolean shouldCollectGaugesAndEvents() {
        ConfigResolver instance = ConfigResolver.getInstance();
        if (!instance.isPerformanceMonitoringEnabled() || Math.random() >= instance.getSessionsSamplingRate()) {
            return false;
        }
        return true;
    }

    public com.google.firebase.perf.v1.PerfSession build() {
        PerfSession.Builder sessionId2 = com.google.firebase.perf.v1.PerfSession.newBuilder().setSessionId(this.sessionId);
        if (this.isGaugeAndEventCollectionEnabled) {
            sessionId2.addSessionVerbosity(SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS);
        }
        return (com.google.firebase.perf.v1.PerfSession) sessionId2.build();
    }

    public int describeContents() {
        return 0;
    }

    public Timer getTimer() {
        return this.creationTime;
    }

    public boolean isGaugeAndEventCollectionEnabled() {
        return this.isGaugeAndEventCollectionEnabled;
    }

    public boolean isSessionRunningTooLong() {
        if (TimeUnit.MICROSECONDS.toMinutes(this.creationTime.getDurationMicros()) > ConfigResolver.getInstance().getSessionsMaxDurationMinutes()) {
            return true;
        }
        return false;
    }

    public boolean isVerbose() {
        return this.isGaugeAndEventCollectionEnabled;
    }

    public String sessionId() {
        return this.sessionId;
    }

    public void setGaugeAndEventCollectionEnabled(boolean z10) {
        this.isGaugeAndEventCollectionEnabled = z10;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeString(this.sessionId);
        parcel.writeByte(this.isGaugeAndEventCollectionEnabled ? (byte) 1 : 0);
        parcel.writeParcelable(this.creationTime, 0);
    }

    public PerfSession(String str, Clock clock) {
        this.isGaugeAndEventCollectionEnabled = false;
        this.sessionId = str;
        this.creationTime = clock.getTime();
    }

    static boolean isVerbose(@NonNull com.google.firebase.perf.v1.PerfSession perfSession) {
        for (SessionVerbosity sessionVerbosity : perfSession.getSessionVerbosityList()) {
            if (sessionVerbosity == SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS) {
                return true;
            }
        }
        return false;
    }

    private PerfSession(@NonNull Parcel parcel) {
        boolean z10 = false;
        this.isGaugeAndEventCollectionEnabled = false;
        this.sessionId = parcel.readString();
        this.isGaugeAndEventCollectionEnabled = parcel.readByte() != 0 ? true : z10;
        this.creationTime = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
    }
}
