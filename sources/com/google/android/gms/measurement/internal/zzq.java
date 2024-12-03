package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.List;

public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new y9();
    public final String B;
    public final String C;
    public final String D;
    public final String E;
    public final boolean F;
    public final long G;

    /* renamed from: a  reason: collision with root package name */
    public final String f40506a;

    /* renamed from: b  reason: collision with root package name */
    public final String f40507b;

    /* renamed from: c  reason: collision with root package name */
    public final String f40508c;

    /* renamed from: d  reason: collision with root package name */
    public final String f40509d;

    /* renamed from: e  reason: collision with root package name */
    public final long f40510e;

    /* renamed from: f  reason: collision with root package name */
    public final long f40511f;

    /* renamed from: g  reason: collision with root package name */
    public final String f40512g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f40513h;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f40514j;

    /* renamed from: k  reason: collision with root package name */
    public final long f40515k;

    /* renamed from: l  reason: collision with root package name */
    public final String f40516l;
    @Deprecated

    /* renamed from: m  reason: collision with root package name */
    public final long f40517m;

    /* renamed from: n  reason: collision with root package name */
    public final long f40518n;

    /* renamed from: p  reason: collision with root package name */
    public final int f40519p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f40520q;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f40521t;

    /* renamed from: w  reason: collision with root package name */
    public final String f40522w;

    /* renamed from: x  reason: collision with root package name */
    public final Boolean f40523x;

    /* renamed from: y  reason: collision with root package name */
    public final long f40524y;

    /* renamed from: z  reason: collision with root package name */
    public final List f40525z;

    zzq(String str, String str2, String str3, long j10, String str4, long j11, long j12, String str5, boolean z10, boolean z11, String str6, long j13, long j14, int i10, boolean z12, boolean z13, String str7, Boolean bool, long j15, List list, String str8, String str9, String str10, String str11, boolean z14, long j16) {
        p.g(str);
        this.f40506a = str;
        this.f40507b = true == TextUtils.isEmpty(str2) ? null : str2;
        this.f40508c = str3;
        this.f40515k = j10;
        this.f40509d = str4;
        this.f40510e = j11;
        this.f40511f = j12;
        this.f40512g = str5;
        this.f40513h = z10;
        this.f40514j = z11;
        this.f40516l = str6;
        this.f40517m = 0;
        this.f40518n = j14;
        this.f40519p = i10;
        this.f40520q = z12;
        this.f40521t = z13;
        this.f40522w = str7;
        this.f40523x = bool;
        this.f40524y = j15;
        this.f40525z = list;
        this.B = null;
        this.C = str9;
        this.D = str10;
        this.E = str11;
        this.F = z14;
        this.G = j16;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 2, this.f40506a, false);
        a.C(parcel, 3, this.f40507b, false);
        a.C(parcel, 4, this.f40508c, false);
        a.C(parcel, 5, this.f40509d, false);
        a.v(parcel, 6, this.f40510e);
        a.v(parcel, 7, this.f40511f);
        a.C(parcel, 8, this.f40512g, false);
        a.g(parcel, 9, this.f40513h);
        a.g(parcel, 10, this.f40514j);
        a.v(parcel, 11, this.f40515k);
        a.C(parcel, 12, this.f40516l, false);
        a.v(parcel, 13, this.f40517m);
        a.v(parcel, 14, this.f40518n);
        a.s(parcel, 15, this.f40519p);
        a.g(parcel, 16, this.f40520q);
        a.g(parcel, 18, this.f40521t);
        a.C(parcel, 19, this.f40522w, false);
        a.i(parcel, 21, this.f40523x, false);
        a.v(parcel, 22, this.f40524y);
        a.E(parcel, 23, this.f40525z, false);
        a.C(parcel, 24, this.B, false);
        a.C(parcel, 25, this.C, false);
        a.C(parcel, 26, this.D, false);
        a.C(parcel, 27, this.E, false);
        a.g(parcel, 28, this.F);
        a.v(parcel, 29, this.G);
        a.b(parcel, a10);
    }

    zzq(String str, String str2, String str3, String str4, long j10, long j11, String str5, boolean z10, boolean z11, long j12, String str6, long j13, long j14, int i10, boolean z12, boolean z13, String str7, Boolean bool, long j15, List list, String str8, String str9, String str10, String str11, boolean z14, long j16) {
        this.f40506a = str;
        this.f40507b = str2;
        this.f40508c = str3;
        this.f40515k = j12;
        this.f40509d = str4;
        this.f40510e = j10;
        this.f40511f = j11;
        this.f40512g = str5;
        this.f40513h = z10;
        this.f40514j = z11;
        this.f40516l = str6;
        this.f40517m = j13;
        this.f40518n = j14;
        this.f40519p = i10;
        this.f40520q = z12;
        this.f40521t = z13;
        this.f40522w = str7;
        this.f40523x = bool;
        this.f40524y = j15;
        this.f40525z = list;
        this.B = str8;
        this.C = str9;
        this.D = str10;
        this.E = str11;
        this.F = z14;
        this.G = j16;
    }
}
