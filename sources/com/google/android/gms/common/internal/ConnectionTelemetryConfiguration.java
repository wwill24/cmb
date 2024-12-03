package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new l1();

    /* renamed from: a  reason: collision with root package name */
    private final RootTelemetryConfiguration f38921a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f38922b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f38923c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f38924d;

    /* renamed from: e  reason: collision with root package name */
    private final int f38925e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f38926f;

    public ConnectionTelemetryConfiguration(@NonNull RootTelemetryConfiguration rootTelemetryConfiguration, boolean z10, boolean z11, int[] iArr, int i10, int[] iArr2) {
        this.f38921a = rootTelemetryConfiguration;
        this.f38922b = z10;
        this.f38923c = z11;
        this.f38924d = iArr;
        this.f38925e = i10;
        this.f38926f = iArr2;
    }

    public int S() {
        return this.f38925e;
    }

    public int[] Y() {
        return this.f38924d;
    }

    public int[] c0() {
        return this.f38926f;
    }

    public boolean f0() {
        return this.f38922b;
    }

    public boolean i0() {
        return this.f38923c;
    }

    @NonNull
    public final RootTelemetryConfiguration m0() {
        return this.f38921a;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 1, this.f38921a, i10, false);
        a.g(parcel, 2, f0());
        a.g(parcel, 3, i0());
        a.t(parcel, 4, Y(), false);
        a.s(parcel, 5, S());
        a.t(parcel, 6, c0(), false);
        a.b(parcel, a10);
    }
}
