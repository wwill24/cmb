package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    public String f40479a;

    /* renamed from: b  reason: collision with root package name */
    public String f40480b;

    /* renamed from: c  reason: collision with root package name */
    public zzlk f40481c;

    /* renamed from: d  reason: collision with root package name */
    public long f40482d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40483e;

    /* renamed from: f  reason: collision with root package name */
    public String f40484f;

    /* renamed from: g  reason: collision with root package name */
    public final zzau f40485g;

    /* renamed from: h  reason: collision with root package name */
    public long f40486h;

    /* renamed from: j  reason: collision with root package name */
    public zzau f40487j;

    /* renamed from: k  reason: collision with root package name */
    public final long f40488k;

    /* renamed from: l  reason: collision with root package name */
    public final zzau f40489l;

    zzac(zzac zzac) {
        p.k(zzac);
        this.f40479a = zzac.f40479a;
        this.f40480b = zzac.f40480b;
        this.f40481c = zzac.f40481c;
        this.f40482d = zzac.f40482d;
        this.f40483e = zzac.f40483e;
        this.f40484f = zzac.f40484f;
        this.f40485g = zzac.f40485g;
        this.f40486h = zzac.f40486h;
        this.f40487j = zzac.f40487j;
        this.f40488k = zzac.f40488k;
        this.f40489l = zzac.f40489l;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 2, this.f40479a, false);
        a.C(parcel, 3, this.f40480b, false);
        a.A(parcel, 4, this.f40481c, i10, false);
        a.v(parcel, 5, this.f40482d);
        a.g(parcel, 6, this.f40483e);
        a.C(parcel, 7, this.f40484f, false);
        a.A(parcel, 8, this.f40485g, i10, false);
        a.v(parcel, 9, this.f40486h);
        a.A(parcel, 10, this.f40487j, i10, false);
        a.v(parcel, 11, this.f40488k);
        a.A(parcel, 12, this.f40489l, i10, false);
        a.b(parcel, a10);
    }

    zzac(String str, String str2, zzlk zzlk, long j10, boolean z10, String str3, zzau zzau, long j11, zzau zzau2, long j12, zzau zzau3) {
        this.f40479a = str;
        this.f40480b = str2;
        this.f40481c = zzlk;
        this.f40482d = j10;
        this.f40483e = z10;
        this.f40484f = str3;
        this.f40485g = zzau;
        this.f40486h = j11;
        this.f40487j = zzau2;
        this.f40488k = j12;
        this.f40489l = zzau3;
    }
}
