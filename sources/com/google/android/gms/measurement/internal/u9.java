package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class u9 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzcf f40347a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f40348b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f40349c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f40350d;

    u9(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf, String str, String str2) {
        this.f40350d = appMeasurementDynamiteService;
        this.f40347a = zzcf;
        this.f40348b = str;
        this.f40349c = str2;
    }

    public final void run() {
        this.f40350d.f39623a.L().T(this.f40347a, this.f40348b, this.f40349c);
    }
}
