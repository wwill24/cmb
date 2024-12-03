package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new q0();

    /* renamed from: a  reason: collision with root package name */
    final int f39076a;

    /* renamed from: b  reason: collision with root package name */
    final IBinder f39077b;

    /* renamed from: c  reason: collision with root package name */
    private final ConnectionResult f39078c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f39079d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f39080e;

    zav(int i10, IBinder iBinder, ConnectionResult connectionResult, boolean z10, boolean z11) {
        this.f39076a = i10;
        this.f39077b = iBinder;
        this.f39078c = connectionResult;
        this.f39079d = z10;
        this.f39080e = z11;
    }

    public final ConnectionResult S() {
        return this.f39078c;
    }

    public final i Y() {
        IBinder iBinder = this.f39077b;
        if (iBinder == null) {
            return null;
        }
        return i.a.c(iBinder);
    }

    public final boolean c0() {
        return this.f39079d;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zav = (zav) obj;
        if (!this.f39078c.equals(zav.f39078c) || !n.b(Y(), zav.Y())) {
            return false;
        }
        return true;
    }

    public final boolean f0() {
        return this.f39080e;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39076a);
        a.r(parcel, 2, this.f39077b, false);
        a.A(parcel, 3, this.f39078c, i10, false);
        a.g(parcel, 4, this.f39079d);
        a.g(parcel, 5, this.f39080e);
        a.b(parcel, a10);
    }
}
