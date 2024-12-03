package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.p;

final class d5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f39719a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m5 f39720b;

    d5(m5 m5Var, zzq zzq) {
        this.f39720b = m5Var;
        this.f39719a = zzq;
    }

    public final void run() {
        this.f39720b.f40032a.e();
        n9 g10 = this.f39720b.f40032a;
        zzq zzq = this.f39719a;
        g10.f().h();
        g10.g();
        p.g(zzq.f40506a);
        g10.S(zzq);
    }
}
