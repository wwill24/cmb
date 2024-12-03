package com.google.android.gms.measurement.internal;

final class e7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z6 f39766a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f39767b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ g7 f39768c;

    e7(g7 g7Var, z6 z6Var, long j10) {
        this.f39768c = g7Var;
        this.f39766a = z6Var;
        this.f39767b = j10;
    }

    public final void run() {
        this.f39768c.p(this.f39766a, false, this.f39767b);
        g7 g7Var = this.f39768c;
        g7Var.f39869e = null;
        g7Var.f40059a.L().u((z6) null);
    }
}
