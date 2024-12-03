package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new r0();

    /* renamed from: a  reason: collision with root package name */
    final int f39081a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39082b;

    /* renamed from: c  reason: collision with root package name */
    private final int f39083c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    private final Scope[] f39084d;

    zax(int i10, int i11, int i12, Scope[] scopeArr) {
        this.f39081a = i10;
        this.f39082b = i11;
        this.f39083c = i12;
        this.f39084d = scopeArr;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39081a);
        a.s(parcel, 2, this.f39082b);
        a.s(parcel, 3, this.f39083c);
        a.F(parcel, 4, this.f39084d, i10, false);
        a.b(parcel, a10);
    }
}
