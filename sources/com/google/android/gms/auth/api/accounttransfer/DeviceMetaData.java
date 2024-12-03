package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class DeviceMetaData extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    final int f38196a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f38197b;

    /* renamed from: c  reason: collision with root package name */
    private long f38198c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f38199d;

    DeviceMetaData(int i10, boolean z10, long j10, boolean z11) {
        this.f38196a = i10;
        this.f38197b = z10;
        this.f38198c = j10;
        this.f38199d = z11;
    }

    public long S() {
        return this.f38198c;
    }

    public boolean Y() {
        return this.f38199d;
    }

    public boolean c0() {
        return this.f38197b;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38196a);
        a.g(parcel, 2, c0());
        a.v(parcel, 3, S());
        a.g(parcel, 4, Y());
        a.b(parcel, a10);
    }
}
