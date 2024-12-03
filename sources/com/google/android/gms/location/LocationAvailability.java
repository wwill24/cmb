package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.Arrays;

public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new r0();
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public static final LocationAvailability f39510f = new LocationAvailability(0, 1, 1, 0, (zzac[]) null, true);
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public static final LocationAvailability f39511g = new LocationAvailability(1000, 1, 1, 0, (zzac[]) null, false);

    /* renamed from: a  reason: collision with root package name */
    private final int f39512a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39513b;

    /* renamed from: c  reason: collision with root package name */
    private final long f39514c;

    /* renamed from: d  reason: collision with root package name */
    int f39515d;

    /* renamed from: e  reason: collision with root package name */
    private final zzac[] f39516e;

    LocationAvailability(int i10, int i11, int i12, long j10, zzac[] zzacArr, boolean z10) {
        this.f39515d = i10 < 1000 ? 0 : 1000;
        this.f39512a = i11;
        this.f39513b = i12;
        this.f39514c = j10;
        this.f39516e = zzacArr;
    }

    public boolean S() {
        return this.f39515d < 1000;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f39512a == locationAvailability.f39512a && this.f39513b == locationAvailability.f39513b && this.f39514c == locationAvailability.f39514c && this.f39515d == locationAvailability.f39515d && Arrays.equals(this.f39516e, locationAvailability.f39516e)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(this.f39515d));
    }

    @NonNull
    public String toString() {
        boolean S = S();
        return "LocationAvailability[" + S + "]";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39512a);
        a.s(parcel, 2, this.f39513b);
        a.v(parcel, 3, this.f39514c);
        a.s(parcel, 4, this.f39515d);
        a.F(parcel, 5, this.f39516e, i10, false);
        a.g(parcel, 6, S());
        a.b(parcel, a10);
    }
}
