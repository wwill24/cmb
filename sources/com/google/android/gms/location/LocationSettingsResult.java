package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class LocationSettingsResult extends AbstractSafeParcelable implements j {
    @NonNull
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    private final Status f39555a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationSettingsStates f39556b;

    public LocationSettingsResult(@NonNull Status status, LocationSettingsStates locationSettingsStates) {
        this.f39555a = status;
        this.f39556b = locationSettingsStates;
    }

    public LocationSettingsStates S() {
        return this.f39556b;
    }

    @NonNull
    public Status getStatus() {
        return this.f39555a;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 1, getStatus(), i10, false);
        a.A(parcel, 2, S(), i10, false);
        a.b(parcel, a10);
    }
}
