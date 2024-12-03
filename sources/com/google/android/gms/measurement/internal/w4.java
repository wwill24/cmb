package com.google.android.gms.measurement.internal;

final class w4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzac f40378a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzq f40379b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ m5 f40380c;

    w4(m5 m5Var, zzac zzac, zzq zzq) {
        this.f40380c = m5Var;
        this.f40378a = zzac;
        this.f40379b = zzq;
    }

    public final void run() {
        this.f40380c.f40032a.e();
        if (this.f40378a.f40481c.S() == null) {
            this.f40380c.f40032a.t(this.f40378a, this.f40379b);
        } else {
            this.f40380c.f40032a.z(this.f40378a, this.f40379b);
        }
    }
}
