package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class LocationSettingsStates extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f39557a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f39558b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f39559c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f39560d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f39561e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f39562f;

    public LocationSettingsStates(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.f39557a = z10;
        this.f39558b = z11;
        this.f39559c = z12;
        this.f39560d = z13;
        this.f39561e = z14;
        this.f39562f = z15;
    }

    public boolean S() {
        return this.f39562f;
    }

    public boolean Y() {
        return this.f39559c;
    }

    public boolean c0() {
        return this.f39560d;
    }

    public boolean f0() {
        return this.f39557a;
    }

    public boolean i0() {
        return this.f39561e;
    }

    public boolean m0() {
        return this.f39558b;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.g(parcel, 1, f0());
        a.g(parcel, 2, m0());
        a.g(parcel, 3, Y());
        a.g(parcel, 4, c0());
        a.g(parcel, 5, i0());
        a.g(parcel, 6, S());
        a.b(parcel, a10);
    }
}
