package com.google.android.gms.fido.sourcedevice;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import te.a;

public class SourceDirectTransferResult extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<SourceDirectTransferResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Status f39390a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39391b;

    public SourceDirectTransferResult(@NonNull Status status, int i10) {
        this.f39390a = status;
        this.f39391b = i10;
    }

    @NonNull
    public Status getStatus() {
        return this.f39390a;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.A(parcel, 1, getStatus(), i10, false);
        fe.a.s(parcel, 2, this.f39391b);
        fe.a.b(parcel, a10);
    }
}
