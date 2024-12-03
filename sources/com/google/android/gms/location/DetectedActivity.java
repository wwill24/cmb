package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.mparticle.identity.IdentityHttpResponse;
import fe.a;
import java.util.Comparator;

public class DetectedActivity extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new g0();
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public static final Comparator f39490c = new f0();

    /* renamed from: a  reason: collision with root package name */
    int f39491a;

    /* renamed from: b  reason: collision with root package name */
    int f39492b;

    public DetectedActivity(int i10, int i11) {
        this.f39491a = i10;
        this.f39492b = i11;
    }

    public int S() {
        return this.f39492b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof DetectedActivity) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            if (this.f39491a == detectedActivity.f39491a && this.f39492b == detectedActivity.f39492b) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int getType() {
        int i10 = this.f39491a;
        if (i10 > 22 || i10 < 0) {
            return 4;
        }
        return i10;
    }

    public final int hashCode() {
        return n.c(Integer.valueOf(this.f39491a), Integer.valueOf(this.f39492b));
    }

    @NonNull
    public String toString() {
        String str;
        int type = getType();
        if (type == 0) {
            str = "IN_VEHICLE";
        } else if (type == 1) {
            str = "ON_BICYCLE";
        } else if (type == 2) {
            str = "ON_FOOT";
        } else if (type == 3) {
            str = "STILL";
        } else if (type == 4) {
            str = IdentityHttpResponse.UNKNOWN;
        } else if (type == 5) {
            str = "TILTING";
        } else if (type == 7) {
            str = "WALKING";
        } else if (type == 8) {
            str = "RUNNING";
        } else if (type == 16) {
            str = "IN_ROAD_VEHICLE";
        } else if (type != 17) {
            str = Integer.toString(type);
        } else {
            str = "IN_RAIL_VEHICLE";
        }
        int i10 = this.f39492b;
        return "DetectedActivity [type=" + str + ", confidence=" + i10 + "]";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        p.k(parcel);
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39491a);
        a.s(parcel, 2, this.f39492b);
        a.b(parcel, a10);
    }
}
