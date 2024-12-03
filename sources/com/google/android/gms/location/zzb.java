package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new x();

    /* renamed from: a  reason: collision with root package name */
    private final long f39606a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f39607b;

    /* renamed from: c  reason: collision with root package name */
    private final WorkSource f39608c;

    /* renamed from: d  reason: collision with root package name */
    private final String f39609d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f39610e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f39611f;

    /* renamed from: g  reason: collision with root package name */
    private final String f39612g;

    /* renamed from: h  reason: collision with root package name */
    private final long f39613h;

    /* renamed from: j  reason: collision with root package name */
    private String f39614j;

    zzb(long j10, boolean z10, WorkSource workSource, String str, int[] iArr, boolean z11, String str2, long j11, String str3) {
        this.f39606a = j10;
        this.f39607b = z10;
        this.f39608c = workSource;
        this.f39609d = str;
        this.f39610e = iArr;
        this.f39611f = z11;
        this.f39612g = str2;
        this.f39613h = j11;
        this.f39614j = str3;
    }

    public final zzb S(String str) {
        this.f39614j = str;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        p.k(parcel);
        int a10 = a.a(parcel);
        a.v(parcel, 1, this.f39606a);
        a.g(parcel, 2, this.f39607b);
        a.A(parcel, 3, this.f39608c, i10, false);
        a.C(parcel, 4, this.f39609d, false);
        a.t(parcel, 5, this.f39610e, false);
        a.g(parcel, 6, this.f39611f);
        a.C(parcel, 7, this.f39612g, false);
        a.v(parcel, 8, this.f39613h);
        a.C(parcel, 9, this.f39614j, false);
        a.b(parcel, a10);
    }
}
