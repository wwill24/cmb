package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new a1();

    /* renamed from: a  reason: collision with root package name */
    private final int f38954a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f38955b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f38956c;

    /* renamed from: d  reason: collision with root package name */
    private final int f38957d;

    /* renamed from: e  reason: collision with root package name */
    private final int f38958e;

    public RootTelemetryConfiguration(int i10, boolean z10, boolean z11, int i11, int i12) {
        this.f38954a = i10;
        this.f38955b = z10;
        this.f38956c = z11;
        this.f38957d = i11;
        this.f38958e = i12;
    }

    public int S() {
        return this.f38957d;
    }

    public int Y() {
        return this.f38958e;
    }

    public boolean c0() {
        return this.f38955b;
    }

    public boolean f0() {
        return this.f38956c;
    }

    public int i0() {
        return this.f38954a;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, i0());
        a.g(parcel, 2, c0());
        a.g(parcel, 3, f0());
        a.s(parcel, 4, S());
        a.s(parcel, 5, Y());
        a.b(parcel, a10);
    }
}
