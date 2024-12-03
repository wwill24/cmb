package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    final int f39139a;

    /* renamed from: b  reason: collision with root package name */
    final String f39140b;

    /* renamed from: c  reason: collision with root package name */
    final int f39141c;

    zac(int i10, String str, int i11) {
        this.f39139a = i10;
        this.f39140b = str;
        this.f39141c = i11;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39139a);
        a.C(parcel, 2, this.f39140b, false);
        a.s(parcel, 3, this.f39141c);
        a.b(parcel, a10);
    }

    zac(String str, int i10) {
        this.f39139a = 1;
        this.f39140b = str;
        this.f39141c = i10;
    }
}
