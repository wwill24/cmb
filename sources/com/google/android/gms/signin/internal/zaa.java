package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zaa extends AbstractSafeParcelable implements j {
    public static final Parcelable.Creator<zaa> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    final int f40539a;

    /* renamed from: b  reason: collision with root package name */
    private int f40540b;

    /* renamed from: c  reason: collision with root package name */
    private Intent f40541c;

    public zaa() {
        this(2, 0, (Intent) null);
    }

    public final Status getStatus() {
        if (this.f40540b == 0) {
            return Status.f38500g;
        }
        return Status.f38504l;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f40539a);
        a.s(parcel, 2, this.f40540b);
        a.A(parcel, 3, this.f40541c, i10, false);
        a.b(parcel, a10);
    }

    zaa(int i10, int i11, Intent intent) {
        this.f40539a = i10;
        this.f40540b = i11;
        this.f40541c = intent;
    }
}
