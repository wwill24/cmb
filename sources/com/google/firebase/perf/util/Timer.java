package com.google.firebase.perf.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import java.util.concurrent.TimeUnit;

public class Timer implements Parcelable {
    public static final Parcelable.Creator<Timer> CREATOR = new Parcelable.Creator<Timer>() {
        public Timer createFromParcel(Parcel parcel) {
            return new Timer(parcel);
        }

        public Timer[] newArray(int i10) {
            return new Timer[i10];
        }
    };
    private long elapsedRealtimeMicros;
    private long wallClockMicros;

    private static long elapsedRealtimeMicros() {
        return TimeUnit.NANOSECONDS.toMicros(SystemClock.elapsedRealtimeNanos());
    }

    public static Timer ofElapsedRealtime(long j10) {
        long micros = TimeUnit.MILLISECONDS.toMicros(j10);
        return new Timer(wallClockMicros() + (micros - elapsedRealtimeMicros()), micros);
    }

    private static long wallClockMicros() {
        return TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
    }

    public int describeContents() {
        return 0;
    }

    public long getCurrentTimestampMicros() {
        return this.wallClockMicros + getDurationMicros();
    }

    public long getDurationMicros() {
        return getDurationMicros(new Timer());
    }

    public long getMicros() {
        return this.wallClockMicros;
    }

    public void reset() {
        this.wallClockMicros = wallClockMicros();
        this.elapsedRealtimeMicros = elapsedRealtimeMicros();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.wallClockMicros);
        parcel.writeLong(this.elapsedRealtimeMicros);
    }

    public Timer() {
        this(wallClockMicros(), elapsedRealtimeMicros());
    }

    public long getDurationMicros(@NonNull Timer timer) {
        return timer.elapsedRealtimeMicros - this.elapsedRealtimeMicros;
    }

    Timer(long j10, long j11) {
        this.wallClockMicros = j10;
        this.elapsedRealtimeMicros = j11;
    }

    public Timer(long j10) {
        this(j10, j10);
    }

    private Timer(Parcel parcel) {
        this(parcel.readLong(), parcel.readLong());
    }
}
