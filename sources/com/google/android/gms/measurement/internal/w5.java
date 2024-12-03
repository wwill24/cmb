package com.google.android.gms.measurement.internal;

public final /* synthetic */ class w5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u6 f40381a;

    public /* synthetic */ w5(u6 u6Var) {
        this.f40381a = u6Var;
    }

    public final void run() {
        u6 u6Var = this.f40381a;
        u6Var.h();
        if (!u6Var.f40059a.F().f39754s.b()) {
            long a10 = u6Var.f40059a.F().f39755t.a();
            u6Var.f40059a.F().f39755t.b(1 + a10);
            u6Var.f40059a.z();
            if (a10 >= 5) {
                u6Var.f40059a.d().w().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                u6Var.f40059a.F().f39754s.a(true);
                return;
            }
            u6Var.f40059a.j();
            return;
        }
        u6Var.f40059a.d().q().a("Deferred Deep Link already retrieved. Not fetching again.");
    }
}
