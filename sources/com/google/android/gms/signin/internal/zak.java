package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zav;
import fe.a;

public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    final int f40546a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionResult f40547b;

    /* renamed from: c  reason: collision with root package name */
    private final zav f40548c;

    zak(int i10, ConnectionResult connectionResult, zav zav) {
        this.f40546a = i10;
        this.f40547b = connectionResult;
        this.f40548c = zav;
    }

    public final ConnectionResult S() {
        return this.f40547b;
    }

    public final zav Y() {
        return this.f40548c;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f40546a);
        a.A(parcel, 2, this.f40547b, i10, false);
        a.A(parcel, 3, this.f40548c, i10, false);
        a.b(parcel, a10);
    }
}
