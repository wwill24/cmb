package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zat;
import fe.a;

public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    final int f40544a;

    /* renamed from: b  reason: collision with root package name */
    final zat f40545b;

    zai(int i10, zat zat) {
        this.f40544a = i10;
        this.f40545b = zat;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f40544a);
        a.A(parcel, 2, this.f40545b, i10, false);
        a.b(parcel, a10);
    }
}
