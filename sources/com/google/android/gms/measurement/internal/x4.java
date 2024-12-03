package com.google.android.gms.measurement.internal;

final class x4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzac f40406a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m5 f40407b;

    x4(m5 m5Var, zzac zzac) {
        this.f40407b = m5Var;
        this.f40406a = zzac;
    }

    public final void run() {
        this.f40407b.f40032a.e();
        if (this.f40406a.f40481c.S() == null) {
            this.f40407b.f40032a.s(this.f40406a);
        } else {
            this.f40407b.f40032a.y(this.f40406a);
        }
    }
}
