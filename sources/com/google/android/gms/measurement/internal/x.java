package com.google.android.gms.measurement.internal;

final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f40398a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f40399b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ z1 f40400c;

    x(z1 z1Var, String str, long j10) {
        this.f40400c = z1Var;
        this.f40398a = str;
        this.f40399b = j10;
    }

    public final void run() {
        z1.j(this.f40400c, this.f40398a, this.f40399b);
    }
}
