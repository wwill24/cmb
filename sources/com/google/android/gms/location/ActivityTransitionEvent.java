package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class ActivityTransitionEvent extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new a0();

    /* renamed from: a  reason: collision with root package name */
    private final int f39462a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39463b;

    /* renamed from: c  reason: collision with root package name */
    private final long f39464c;

    public ActivityTransitionEvent(int i10, int i11, long j10) {
        ActivityTransition.c0(i11);
        this.f39462a = i10;
        this.f39463b = i11;
        this.f39464c = j10;
    }

    public int S() {
        return this.f39462a;
    }

    public long Y() {
        return this.f39464c;
    }

    public int c0() {
        return this.f39463b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        if (this.f39462a == activityTransitionEvent.f39462a && this.f39463b == activityTransitionEvent.f39463b && this.f39464c == activityTransitionEvent.f39464c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(this.f39462a), Integer.valueOf(this.f39463b), Long.valueOf(this.f39464c));
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i10 = this.f39462a;
        sb2.append("ActivityType " + i10);
        sb2.append(" ");
        int i11 = this.f39463b;
        sb2.append("TransitionType " + i11);
        sb2.append(" ");
        long j10 = this.f39464c;
        sb2.append("ElapsedRealTimeNanos " + j10);
        return sb2.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        p.k(parcel);
        int a10 = a.a(parcel);
        a.s(parcel, 1, S());
        a.s(parcel, 2, c0());
        a.v(parcel, 3, Y());
        a.b(parcel, a10);
    }
}
