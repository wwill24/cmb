package com.google.android.gms.measurement.internal;

abstract class b9 extends a9 {

    /* renamed from: c  reason: collision with root package name */
    private boolean f39687c;

    b9(n9 n9Var) {
        super(n9Var);
        this.f39651b.r();
    }

    /* access modifiers changed from: protected */
    public final void i() {
        if (!k()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void j() {
        if (!this.f39687c) {
            l();
            this.f39651b.m();
            this.f39687c = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: package-private */
    public final boolean k() {
        return this.f39687c;
    }

    /* access modifiers changed from: protected */
    public abstract boolean l();
}
