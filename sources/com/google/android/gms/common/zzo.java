package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import pe.a;
import pe.b;

public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    private final String f39195a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f39196b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f39197c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f39198d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f39199e;

    zzo(String str, boolean z10, boolean z11, IBinder iBinder, boolean z12) {
        this.f39195a = str;
        this.f39196b = z10;
        this.f39197c = z11;
        this.f39198d = (Context) b.f(a.C0503a.c(iBinder));
        this.f39199e = z12;
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [pe.a, android.os.IBinder] */
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.C(parcel, 1, this.f39195a, false);
        fe.a.g(parcel, 2, this.f39196b);
        fe.a.g(parcel, 3, this.f39197c);
        fe.a.r(parcel, 4, b.g(this.f39198d), false);
        fe.a.g(parcel, 5, this.f39199e);
        fe.a.b(parcel, a10);
    }
}
