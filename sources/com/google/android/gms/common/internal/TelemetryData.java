package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.ArrayList;
import java.util.List;

public class TelemetryData extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<TelemetryData> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    private final int f38959a;

    /* renamed from: b  reason: collision with root package name */
    private List f38960b;

    public TelemetryData(int i10, List list) {
        this.f38959a = i10;
        this.f38960b = list;
    }

    public final int S() {
        return this.f38959a;
    }

    public final List Y() {
        return this.f38960b;
    }

    public final void c0(@NonNull MethodInvocation methodInvocation) {
        if (this.f38960b == null) {
            this.f38960b = new ArrayList();
        }
        this.f38960b.add(methodInvocation);
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38959a);
        a.G(parcel, 2, this.f38960b, false);
        a.b(parcel, a10);
    }
}
