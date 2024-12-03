package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    private final int f39602a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39603b;

    /* renamed from: c  reason: collision with root package name */
    private final int f39604c;

    /* renamed from: d  reason: collision with root package name */
    private final int f39605d;

    public zzaj(int i10, int i11, int i12, int i13) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14 = true;
        if (i10 < 0 || i10 > 23) {
            z10 = false;
        } else {
            z10 = true;
        }
        p.p(z10, "Start hour must be in range [0, 23].");
        if (i11 < 0 || i11 > 59) {
            z11 = false;
        } else {
            z11 = true;
        }
        p.p(z11, "Start minute must be in range [0, 59].");
        if (i12 < 0 || i12 > 23) {
            z12 = false;
        } else {
            z12 = true;
        }
        p.p(z12, "End hour must be in range [0, 23].");
        if (i13 < 0 || i13 > 59) {
            z13 = false;
        } else {
            z13 = true;
        }
        p.p(z13, "End minute must be in range [0, 59].");
        p.p(((i10 + i11) + i12) + i13 <= 0 ? false : z14, "Parameters can't be all 0.");
        this.f39602a = i10;
        this.f39603b = i11;
        this.f39604c = i12;
        this.f39605d = i13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaj)) {
            return false;
        }
        zzaj zzaj = (zzaj) obj;
        if (this.f39602a == zzaj.f39602a && this.f39603b == zzaj.f39603b && this.f39604c == zzaj.f39604c && this.f39605d == zzaj.f39605d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return n.c(Integer.valueOf(this.f39602a), Integer.valueOf(this.f39603b), Integer.valueOf(this.f39604c), Integer.valueOf(this.f39605d));
    }

    public final String toString() {
        int i10 = this.f39602a;
        int i11 = this.f39603b;
        int i12 = this.f39604c;
        int i13 = this.f39605d;
        return "UserPreferredSleepWindow [startHour=" + i10 + ", startMinute=" + i11 + ", endHour=" + i12 + ", endMinute=" + i13 + "]";
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        p.k(parcel);
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39602a);
        a.s(parcel, 2, this.f39603b);
        a.s(parcel, 3, this.f39604c);
        a.s(parcel, 4, this.f39605d);
        a.b(parcel, a10);
    }
}
