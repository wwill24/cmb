package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import ie.e;

public class ModuleAvailabilityResponse extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ModuleAvailabilityResponse> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f39093a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39094b;

    public ModuleAvailabilityResponse(boolean z10, int i10) {
        this.f39093a = z10;
        this.f39094b = i10;
    }

    public boolean S() {
        return this.f39093a;
    }

    public int Y() {
        return this.f39094b;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.g(parcel, 1, S());
        a.s(parcel, 2, Y());
        a.b(parcel, a10);
    }
}
