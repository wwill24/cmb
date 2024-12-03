package com.google.android.gms.measurement.internal;

final class r6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f40222a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u6 f40223b;

    r6(u6 u6Var, boolean z10) {
        this.f40223b = u6Var;
        this.f40222a = z10;
    }

    public final void run() {
        boolean o10 = this.f40223b.f40059a.o();
        boolean n10 = this.f40223b.f40059a.n();
        this.f40223b.f40059a.k(this.f40222a);
        if (n10 == this.f40222a) {
            this.f40223b.f40059a.d().v().b("Default data collection state already set to", Boolean.valueOf(this.f40222a));
        }
        if (this.f40223b.f40059a.o() == o10 || this.f40223b.f40059a.o() != this.f40223b.f40059a.n()) {
            this.f40223b.f40059a.d().x().c("Default data collection is different than actual status", Boolean.valueOf(this.f40222a), Boolean.valueOf(o10));
        }
        this.f40223b.P();
    }
}
