package com.google.android.gms.appset;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import td.e;

public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final String f38171a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38172b;

    public zzc(String str, int i10) {
        this.f38171a = str;
        this.f38172b = i10;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.f38171a, false);
        a.s(parcel, 2, this.f38172b);
        a.b(parcel, a10);
    }

    public final int zza() {
        return this.f38172b;
    }

    public final String zzb() {
        return this.f38171a;
    }
}
