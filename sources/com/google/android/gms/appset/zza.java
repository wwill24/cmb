package com.google.android.gms.appset;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import td.d;

public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private final String f38169a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38170b;

    public zza(String str, String str2) {
        this.f38169a = str;
        this.f38170b = str2;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.f38169a, false);
        a.C(parcel, 2, this.f38170b, false);
        a.b(parcel, a10);
    }
}
