package com.google.android.gms.measurement.internal;

final class i5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzlk f39933a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzq f39934b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ m5 f39935c;

    i5(m5 m5Var, zzlk zzlk, zzq zzq) {
        this.f39935c = m5Var;
        this.f39933a = zzlk;
        this.f39934b = zzq;
    }

    public final void run() {
        this.f39935c.f40032a.e();
        if (this.f39933a.S() == null) {
            this.f39935c.f40032a.u(this.f39933a.f40500b, this.f39934b);
        } else {
            this.f39935c.f40032a.B(this.f39933a, this.f39934b);
        }
    }
}
