package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import ie.h;

public class ModuleInstallResponse extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ModuleInstallResponse> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private final int f39096a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f39097b;

    public ModuleInstallResponse(int i10) {
        this(i10, false);
    }

    public int S() {
        return this.f39096a;
    }

    public final boolean Y() {
        return this.f39097b;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, S());
        a.g(parcel, 2, this.f39097b);
        a.b(parcel, a10);
    }

    public ModuleInstallResponse(int i10, boolean z10) {
        this.f39096a = i10;
        this.f39097b = z10;
    }
}
