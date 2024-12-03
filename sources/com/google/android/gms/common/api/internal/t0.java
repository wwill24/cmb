package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

abstract class t0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u0 f38742a;

    /* synthetic */ t0(u0 u0Var, s0 s0Var) {
        this.f38742a = u0Var;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public final void run() {
        Lock z10;
        this.f38742a.f38748b.lock();
        try {
            if (Thread.interrupted()) {
                z10 = this.f38742a.f38748b;
            } else {
                a();
                z10 = this.f38742a.f38748b;
            }
        } catch (RuntimeException e10) {
            this.f38742a.f38747a.s(e10);
            z10 = this.f38742a.f38748b;
        } catch (Throwable th2) {
            this.f38742a.f38748b.unlock();
            throw th2;
        }
        z10.unlock();
    }
}
