package com.google.android.gms.measurement.internal;

abstract class w3 extends a3 {

    /* renamed from: b  reason: collision with root package name */
    private boolean f40377b;

    w3(u4 u4Var) {
        super(u4Var);
        this.f40059a.i();
    }

    /* access modifiers changed from: protected */
    public final void i() {
        if (!m()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void j() {
        if (this.f40377b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!n()) {
            this.f40059a.g();
            this.f40377b = true;
        }
    }

    public final void k() {
        if (!this.f40377b) {
            l();
            this.f40059a.g();
            this.f40377b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public void l() {
    }

    /* access modifiers changed from: package-private */
    public final boolean m() {
        return this.f40377b;
    }

    /* access modifiers changed from: protected */
    public abstract boolean n();
}
