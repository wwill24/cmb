package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class SleepSegmentEvent extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<SleepSegmentEvent> CREATOR = new t();

    /* renamed from: a  reason: collision with root package name */
    private final long f39572a;

    /* renamed from: b  reason: collision with root package name */
    private final long f39573b;

    /* renamed from: c  reason: collision with root package name */
    private final int f39574c;

    /* renamed from: d  reason: collision with root package name */
    private final int f39575d;

    /* renamed from: e  reason: collision with root package name */
    private final int f39576e;

    public SleepSegmentEvent(long j10, long j11, int i10, int i11, int i12) {
        boolean z10;
        if (j10 <= j11) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.b(z10, "endTimeMillis must be greater than or equal to startTimeMillis");
        this.f39572a = j10;
        this.f39573b = j11;
        this.f39574c = i10;
        this.f39575d = i11;
        this.f39576e = i12;
    }

    public long S() {
        return this.f39573b;
    }

    public long Y() {
        return this.f39572a;
    }

    public int c0() {
        return this.f39574c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SleepSegmentEvent) {
            SleepSegmentEvent sleepSegmentEvent = (SleepSegmentEvent) obj;
            if (this.f39572a == sleepSegmentEvent.Y() && this.f39573b == sleepSegmentEvent.S() && this.f39574c == sleepSegmentEvent.c0() && this.f39575d == sleepSegmentEvent.f39575d && this.f39576e == sleepSegmentEvent.f39576e) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return n.c(Long.valueOf(this.f39572a), Long.valueOf(this.f39573b), Integer.valueOf(this.f39574c));
    }

    @NonNull
    public String toString() {
        long j10 = this.f39572a;
        long j11 = this.f39573b;
        int i10 = this.f39574c;
        return "startMillis=" + j10 + ", endMillis=" + j11 + ", status=" + i10;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        p.k(parcel);
        int a10 = a.a(parcel);
        a.v(parcel, 1, Y());
        a.v(parcel, 2, S());
        a.s(parcel, 3, c0());
        a.s(parcel, 4, this.f39575d);
        a.s(parcel, 5, this.f39576e);
        a.b(parcel, a10);
    }
}
