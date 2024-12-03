package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class k6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f39991a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u6 f39992b;

    k6(u6 u6Var, AtomicReference atomicReference) {
        this.f39992b = u6Var;
        this.f39991a = atomicReference;
    }

    public final void run() {
        synchronized (this.f39991a) {
            try {
                this.f39991a.set(this.f39992b.f40059a.z().x(this.f39992b.f40059a.B().s(), g3.N));
                this.f39991a.notify();
            } catch (Throwable th2) {
                this.f39991a.notify();
                throw th2;
            }
        }
    }
}
