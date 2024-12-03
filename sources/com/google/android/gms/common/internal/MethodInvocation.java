package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class MethodInvocation extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new k0();

    /* renamed from: a  reason: collision with root package name */
    private final int f38945a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38946b;

    /* renamed from: c  reason: collision with root package name */
    private final int f38947c;

    /* renamed from: d  reason: collision with root package name */
    private final long f38948d;

    /* renamed from: e  reason: collision with root package name */
    private final long f38949e;

    /* renamed from: f  reason: collision with root package name */
    private final String f38950f;

    /* renamed from: g  reason: collision with root package name */
    private final String f38951g;

    /* renamed from: h  reason: collision with root package name */
    private final int f38952h;

    /* renamed from: j  reason: collision with root package name */
    private final int f38953j;

    @Deprecated
    public MethodInvocation(int i10, int i11, int i12, long j10, long j11, String str, String str2, int i13) {
        this(i10, i11, i12, j10, j11, str, str2, i13, -1);
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38945a);
        a.s(parcel, 2, this.f38946b);
        a.s(parcel, 3, this.f38947c);
        a.v(parcel, 4, this.f38948d);
        a.v(parcel, 5, this.f38949e);
        a.C(parcel, 6, this.f38950f, false);
        a.C(parcel, 7, this.f38951g, false);
        a.s(parcel, 8, this.f38952h);
        a.s(parcel, 9, this.f38953j);
        a.b(parcel, a10);
    }

    public MethodInvocation(int i10, int i11, int i12, long j10, long j11, String str, String str2, int i13, int i14) {
        this.f38945a = i10;
        this.f38946b = i11;
        this.f38947c = i12;
        this.f38948d = j10;
        this.f38949e = j11;
        this.f38950f = str;
        this.f38951g = str2;
        this.f38952h = i13;
        this.f38953j = i14;
    }
}
