package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

@Deprecated
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    public final int f39598a;

    /* renamed from: b  reason: collision with root package name */
    public final int f39599b;

    /* renamed from: c  reason: collision with root package name */
    public final long f39600c;

    /* renamed from: d  reason: collision with root package name */
    public final long f39601d;

    zzac(int i10, int i11, long j10, long j11) {
        this.f39598a = i10;
        this.f39599b = i11;
        this.f39600c = j10;
        this.f39601d = j11;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzac) {
            zzac zzac = (zzac) obj;
            if (this.f39598a == zzac.f39598a && this.f39599b == zzac.f39599b && this.f39600c == zzac.f39600c && this.f39601d == zzac.f39601d) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return n.c(Integer.valueOf(this.f39599b), Integer.valueOf(this.f39598a), Long.valueOf(this.f39601d), Long.valueOf(this.f39600c));
    }

    public final String toString() {
        int i10 = this.f39598a;
        int i11 = this.f39599b;
        long j10 = this.f39601d;
        long j11 = this.f39600c;
        return "NetworkLocationStatus: Wifi status: " + i10 + " Cell status: " + i11 + " elapsed time NS: " + j10 + " system time ms: " + j11;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39598a);
        a.s(parcel, 2, this.f39599b);
        a.v(parcel, 3, this.f39600c);
        a.v(parcel, 4, this.f39601d);
        a.b(parcel, a10);
    }
}
