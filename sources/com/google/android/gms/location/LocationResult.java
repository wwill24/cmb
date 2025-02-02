package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.Collections;
import java.util.List;

public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<LocationResult> CREATOR = new t0();

    /* renamed from: b  reason: collision with root package name */
    static final List f39547b = Collections.emptyList();

    /* renamed from: a  reason: collision with root package name */
    private final List f39548a;

    LocationResult(List list) {
        this.f39548a = list;
    }

    public Location S() {
        int size = this.f39548a.size();
        if (size == 0) {
            return null;
        }
        return (Location) this.f39548a.get(size - 1);
    }

    @NonNull
    public List<Location> Y() {
        return this.f39548a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.google.android.gms.location.LocationResult
            r1 = 0
            if (r0 == 0) goto L_0x008c
            com.google.android.gms.location.LocationResult r9 = (com.google.android.gms.location.LocationResult) r9
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r0 < r2) goto L_0x0016
            java.util.List r0 = r8.f39548a
            java.util.List r9 = r9.f39548a
            boolean r9 = r0.equals(r9)
            return r9
        L_0x0016:
            java.util.List r0 = r8.f39548a
            int r0 = r0.size()
            java.util.List r2 = r9.f39548a
            int r2 = r2.size()
            if (r0 == r2) goto L_0x0025
            return r1
        L_0x0025:
            java.util.List r0 = r8.f39548a
            java.util.Iterator r0 = r0.iterator()
            java.util.List r9 = r9.f39548a
            java.util.Iterator r9 = r9.iterator()
        L_0x0031:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x008a
            java.lang.Object r2 = r0.next()
            android.location.Location r2 = (android.location.Location) r2
            java.lang.Object r3 = r9.next()
            android.location.Location r3 = (android.location.Location) r3
            double r4 = r2.getLatitude()
            double r6 = r3.getLatitude()
            int r4 = java.lang.Double.compare(r4, r6)
            if (r4 == 0) goto L_0x0052
            return r1
        L_0x0052:
            double r4 = r2.getLongitude()
            double r6 = r3.getLongitude()
            int r4 = java.lang.Double.compare(r4, r6)
            if (r4 == 0) goto L_0x0061
            return r1
        L_0x0061:
            long r4 = r2.getTime()
            long r6 = r3.getTime()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x006e
            return r1
        L_0x006e:
            long r4 = r2.getElapsedRealtimeNanos()
            long r6 = r3.getElapsedRealtimeNanos()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x007b
            return r1
        L_0x007b:
            java.lang.String r2 = r2.getProvider()
            java.lang.String r3 = r3.getProvider()
            boolean r2 = com.google.android.gms.common.internal.n.b(r2, r3)
            if (r2 != 0) goto L_0x0031
            return r1
        L_0x008a:
            r9 = 1
            return r9
        L_0x008c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.LocationResult.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return n.c(this.f39548a);
    }

    @NonNull
    public String toString() {
        return "LocationResult".concat(String.valueOf(this.f39548a));
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.G(parcel, 1, Y(), false);
        a.b(parcel, a10);
    }
}
