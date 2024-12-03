package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class n6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f40060a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u6 f40061b;

    n6(u6 u6Var, AtomicReference atomicReference) {
        this.f40061b = u6Var;
        this.f40060a = atomicReference;
    }

    public final void run() {
        synchronized (this.f40060a) {
            try {
                this.f40060a.set(Double.valueOf(this.f40061b.f40059a.z().k(this.f40061b.f40059a.B().s(), g3.Q)));
                this.f40060a.notify();
            } catch (Throwable th2) {
                this.f40060a.notify();
                throw th2;
            }
        }
    }
}
