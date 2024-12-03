package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import fe.a;

public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    final int f39163a;

    /* renamed from: b  reason: collision with root package name */
    final String f39164b;

    /* renamed from: c  reason: collision with root package name */
    final FastJsonResponse.Field f39165c;

    zam(int i10, String str, FastJsonResponse.Field field) {
        this.f39163a = i10;
        this.f39164b = str;
        this.f39165c = field;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39163a);
        a.C(parcel, 2, this.f39164b, false);
        a.A(parcel, 3, this.f39165c, i10, false);
        a.b(parcel, a10);
    }

    zam(String str, FastJsonResponse.Field field) {
        this.f39163a = 1;
        this.f39164b = str;
        this.f39165c = field;
    }
}
