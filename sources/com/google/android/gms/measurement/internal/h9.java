package com.google.android.gms.measurement.internal;

final class h9 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w9 f39906a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f39907b;

    h9(AppMeasurementDynamiteService appMeasurementDynamiteService, w9 w9Var) {
        this.f39907b = appMeasurementDynamiteService;
        this.f39906a = w9Var;
    }

    public final void run() {
        this.f39907b.f39623a.I().H(this.f39906a);
    }
}
