package com.google.android.gms.measurement.internal;

final class q7 extends n {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g8 f40206e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q7(g8 g8Var, p5 p5Var) {
        super(p5Var);
        this.f40206e = g8Var;
    }

    public final void c() {
        g8 g8Var = this.f40206e;
        g8Var.h();
        if (g8Var.z()) {
            g8Var.f40059a.d().v().a("Inactivity, disconnecting from the service");
            g8Var.Q();
        }
    }
}
