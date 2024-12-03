package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class ActivityTransition extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new z();

    /* renamed from: a  reason: collision with root package name */
    private final int f39460a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39461b;

    ActivityTransition(int i10, int i11) {
        this.f39460a = i10;
        this.f39461b = i11;
    }

    public static void c0(int i10) {
        boolean z10 = true;
        if (i10 < 0 || i10 > 1) {
            z10 = false;
        }
        p.b(z10, "Transition type " + i10 + " is not valid.");
    }

    public int S() {
        return this.f39460a;
    }

    public int Y() {
        return this.f39461b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        if (this.f39460a == activityTransition.f39460a && this.f39461b == activityTransition.f39461b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(this.f39460a), Integer.valueOf(this.f39461b));
    }

    @NonNull
    public String toString() {
        int i10 = this.f39460a;
        int i11 = this.f39461b;
        return "ActivityTransition [mActivityType=" + i10 + ", mTransitionType=" + i11 + "]";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        p.k(parcel);
        int a10 = a.a(parcel);
        a.s(parcel, 1, S());
        a.s(parcel, 2, Y());
        a.b(parcel, a10);
    }
}
