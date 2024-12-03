package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class h8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzcf f39901a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f39902b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f39903c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f39904d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f39905e;

    h8(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf, String str, String str2, boolean z10) {
        this.f39905e = appMeasurementDynamiteService;
        this.f39901a = zzcf;
        this.f39902b = str;
        this.f39903c = str2;
        this.f39904d = z10;
    }

    public final void run() {
        this.f39905e.f39623a.L().V(this.f39901a, this.f39902b, this.f39903c, this.f39904d);
    }
}
