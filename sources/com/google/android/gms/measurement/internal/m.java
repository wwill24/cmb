package com.google.android.gms.measurement.internal;

final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p5 f40026a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ n f40027b;

    m(n nVar, p5 p5Var) {
        this.f40027b = nVar;
        this.f40026a = p5Var;
    }

    public final void run() {
        this.f40026a.b();
        if (c.a()) {
            this.f40026a.f().z(this);
            return;
        }
        boolean e10 = this.f40027b.e();
        this.f40027b.f40047c = 0;
        if (e10) {
            this.f40027b.c();
        }
    }
}
