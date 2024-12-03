package com.google.android.gms.measurement.internal;

abstract class o5 extends n5 {

    /* renamed from: b  reason: collision with root package name */
    private boolean f40114b;

    o5(u4 u4Var) {
        super(u4Var);
        this.f40059a.i();
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean j();

    /* access modifiers changed from: protected */
    public final void k() {
        if (!n()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void l() {
        if (this.f40114b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!j()) {
            this.f40059a.g();
            this.f40114b = true;
        }
    }

    public final void m() {
        if (!this.f40114b) {
            i();
            this.f40059a.g();
            this.f40114b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: package-private */
    public final boolean n() {
        return this.f40114b;
    }
}
