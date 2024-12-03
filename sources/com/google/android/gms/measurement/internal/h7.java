package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class h7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzcf f39897a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzau f39898b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f39899c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f39900d;

    h7(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf, zzau zzau, String str) {
        this.f39900d = appMeasurementDynamiteService;
        this.f39897a = zzcf;
        this.f39898b = zzau;
        this.f39899c = str;
    }

    public final void run() {
        this.f39900d.f39623a.L().p(this.f39897a, this.f39898b, this.f39899c);
    }
}
