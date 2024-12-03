package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class v9 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzcf f40371a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f40372b;

    v9(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf) {
        this.f40372b = appMeasurementDynamiteService;
        this.f40371a = zzcf;
    }

    public final void run() {
        this.f40372b.f39623a.N().E(this.f40371a, this.f40372b.f39623a.n());
    }
}
