package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new x();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f39200a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39201b;

    /* renamed from: c  reason: collision with root package name */
    private final int f39202c;

    /* renamed from: d  reason: collision with root package name */
    private final int f39203d;

    zzq(boolean z10, String str, int i10, int i11) {
        this.f39200a = z10;
        this.f39201b = str;
        this.f39202c = d0.a(i10) - 1;
        this.f39203d = l.a(i11) - 1;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.g(parcel, 1, this.f39200a);
        a.C(parcel, 2, this.f39201b, false);
        a.s(parcel, 3, this.f39202c);
        a.s(parcel, 4, this.f39203d);
        a.b(parcel, a10);
    }

    public final String zza() {
        return this.f39201b;
    }

    public final boolean zzb() {
        return this.f39200a;
    }

    public final int zzc() {
        return l.a(this.f39203d);
    }

    public final int zzd() {
        return d0.a(this.f39202c);
    }
}
