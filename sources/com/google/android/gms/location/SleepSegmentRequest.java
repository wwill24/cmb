package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.List;

public class SleepSegmentRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<SleepSegmentRequest> CREATOR = new u();

    /* renamed from: a  reason: collision with root package name */
    private final List f39577a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39578b;

    public SleepSegmentRequest(List list, int i10) {
        this.f39577a = list;
        this.f39578b = i10;
    }

    public int S() {
        return this.f39578b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepSegmentRequest)) {
            return false;
        }
        SleepSegmentRequest sleepSegmentRequest = (SleepSegmentRequest) obj;
        if (!n.b(this.f39577a, sleepSegmentRequest.f39577a) || this.f39578b != sleepSegmentRequest.f39578b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f39577a, Integer.valueOf(this.f39578b));
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        p.k(parcel);
        int a10 = a.a(parcel);
        a.G(parcel, 1, this.f39577a, false);
        a.s(parcel, 2, S());
        a.b(parcel, a10);
    }
}
