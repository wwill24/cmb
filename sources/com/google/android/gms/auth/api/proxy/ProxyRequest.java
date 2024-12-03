package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class ProxyRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    public static final int f38348g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final int f38349h = 1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f38350j = 2;

    /* renamed from: k  reason: collision with root package name */
    public static final int f38351k = 3;

    /* renamed from: l  reason: collision with root package name */
    public static final int f38352l = 4;

    /* renamed from: m  reason: collision with root package name */
    public static final int f38353m = 5;

    /* renamed from: n  reason: collision with root package name */
    public static final int f38354n = 6;

    /* renamed from: p  reason: collision with root package name */
    public static final int f38355p = 7;

    /* renamed from: q  reason: collision with root package name */
    public static final int f38356q = 7;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f38357a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38358b;

    /* renamed from: c  reason: collision with root package name */
    public final long f38359c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f38360d;

    /* renamed from: e  reason: collision with root package name */
    final int f38361e;

    /* renamed from: f  reason: collision with root package name */
    Bundle f38362f;

    ProxyRequest(int i10, String str, int i11, long j10, byte[] bArr, Bundle bundle) {
        this.f38361e = i10;
        this.f38357a = str;
        this.f38358b = i11;
        this.f38359c = j10;
        this.f38360d = bArr;
        this.f38362f = bundle;
    }

    @NonNull
    public String toString() {
        String str = this.f38357a;
        int i10 = this.f38358b;
        return "ProxyRequest[ url: " + str + ", method: " + i10 + " ]";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.f38357a, false);
        a.s(parcel, 2, this.f38358b);
        a.v(parcel, 3, this.f38359c);
        a.k(parcel, 4, this.f38360d, false);
        a.j(parcel, 5, this.f38362f, false);
        a.s(parcel, 1000, this.f38361e);
        a.b(parcel, a10);
    }
}
