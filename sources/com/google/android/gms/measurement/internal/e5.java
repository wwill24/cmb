package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.p;
import we.o;

final class e5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f39760a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m5 f39761b;

    e5(m5 m5Var, zzq zzq) {
        this.f39761b = m5Var;
        this.f39760a = zzq;
    }

    public final void run() {
        this.f39761b.f40032a.e();
        n9 g10 = this.f39761b.f40032a;
        zzq zzq = this.f39760a;
        g10.f().h();
        g10.g();
        p.g(zzq.f40506a);
        o c10 = o.c(zzq.C, 100);
        o c02 = g10.c0(zzq.f40506a);
        g10.d().v().c("Setting consent, package, consent", zzq.f40506a, c10);
        g10.A(zzq.f40506a, c10);
        if (c10.m(c02)) {
            g10.v(zzq);
        }
    }
}
