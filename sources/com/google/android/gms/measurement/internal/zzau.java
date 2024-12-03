package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzau extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzau> CREATOR = new t();

    /* renamed from: a  reason: collision with root package name */
    public final String f40491a;

    /* renamed from: b  reason: collision with root package name */
    public final zzas f40492b;

    /* renamed from: c  reason: collision with root package name */
    public final String f40493c;

    /* renamed from: d  reason: collision with root package name */
    public final long f40494d;

    zzau(zzau zzau, long j10) {
        p.k(zzau);
        this.f40491a = zzau.f40491a;
        this.f40492b = zzau.f40492b;
        this.f40493c = zzau.f40493c;
        this.f40494d = j10;
    }

    public final String toString() {
        String str = this.f40493c;
        String str2 = this.f40491a;
        String valueOf = String.valueOf(this.f40492b);
        return "origin=" + str + ",name=" + str2 + ",params=" + valueOf;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        t.a(this, parcel, i10);
    }

    public zzau(String str, zzas zzas, String str2, long j10) {
        this.f40491a = str;
        this.f40492b = zzas;
        this.f40493c = str2;
        this.f40494d = j10;
    }
}
