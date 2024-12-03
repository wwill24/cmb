package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class j6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzcf f39957a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f39958b;

    j6(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf) {
        this.f39958b = appMeasurementDynamiteService;
        this.f39957a = zzcf;
    }

    public final void run() {
        this.f39958b.f39623a.L().R(this.f39957a);
    }
}
