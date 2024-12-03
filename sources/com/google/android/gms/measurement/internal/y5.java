package com.google.android.gms.measurement.internal;

final class y5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f40431a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u6 f40432b;

    y5(u6 u6Var, long j10) {
        this.f40432b = u6Var;
        this.f40431a = j10;
    }

    public final void run() {
        this.f40432b.f40059a.F().f39746k.b(this.f40431a);
        this.f40432b.f40059a.d().q().b("Session timeout duration set", Long.valueOf(this.f40431a));
    }
}
