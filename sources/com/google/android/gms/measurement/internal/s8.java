package com.google.android.gms.measurement.internal;

final class s8 {

    /* renamed from: a  reason: collision with root package name */
    private r8 f40265a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ w8 f40266b;

    s8(w8 w8Var) {
        this.f40266b = w8Var;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j10) {
        this.f40265a = new r8(this, this.f40266b.f40059a.a().currentTimeMillis(), j10);
        this.f40266b.f40391c.postDelayed(this.f40265a, 2000);
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.f40266b.h();
        r8 r8Var = this.f40265a;
        if (r8Var != null) {
            this.f40266b.f40391c.removeCallbacks(r8Var);
        }
        this.f40266b.f40059a.F().f39753r.a(false);
        this.f40266b.s(false);
    }
}
