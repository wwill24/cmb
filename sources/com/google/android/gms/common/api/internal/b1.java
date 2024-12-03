package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

abstract class b1 {

    /* renamed from: a  reason: collision with root package name */
    private final a1 f38551a;

    protected b1(a1 a1Var) {
        this.f38551a = a1Var;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public final void b(d1 d1Var) {
        Lock n10;
        d1Var.f38572a.lock();
        try {
            if (d1Var.f38582l != this.f38551a) {
                n10 = d1Var.f38572a;
            } else {
                a();
                n10 = d1Var.f38572a;
            }
            n10.unlock();
        } catch (Throwable th2) {
            d1Var.f38572a.unlock();
            throw th2;
        }
    }
}
