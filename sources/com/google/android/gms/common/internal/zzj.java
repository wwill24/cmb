package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new k1();

    /* renamed from: a  reason: collision with root package name */
    Bundle f39086a;

    /* renamed from: b  reason: collision with root package name */
    Feature[] f39087b;

    /* renamed from: c  reason: collision with root package name */
    int f39088c;

    /* renamed from: d  reason: collision with root package name */
    ConnectionTelemetryConfiguration f39089d;

    public zzj() {
    }

    zzj(Bundle bundle, Feature[] featureArr, int i10, ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.f39086a = bundle;
        this.f39087b = featureArr;
        this.f39088c = i10;
        this.f39089d = connectionTelemetryConfiguration;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.j(parcel, 1, this.f39086a, false);
        a.F(parcel, 2, this.f39087b, i10, false);
        a.s(parcel, 3, this.f39088c);
        a.A(parcel, 4, this.f39089d, i10, false);
        a.b(parcel, a10);
    }
}
