package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.List;
import ze.d;

public final class zag extends AbstractSafeParcelable implements j {
    public static final Parcelable.Creator<zag> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private final List f40542a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40543b;

    public zag(List list, String str) {
        this.f40542a = list;
        this.f40543b = str;
    }

    public final Status getStatus() {
        if (this.f40543b != null) {
            return Status.f38500g;
        }
        return Status.f38504l;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.E(parcel, 1, this.f40542a, false);
        a.C(parcel, 2, this.f40543b, false);
        a.b(parcel, a10);
    }
}
