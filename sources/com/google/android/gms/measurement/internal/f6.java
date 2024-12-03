package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class f6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f39791a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u6 f39792b;

    f6(u6 u6Var, AtomicReference atomicReference) {
        this.f39792b = u6Var;
        this.f39791a = atomicReference;
    }

    public final void run() {
        synchronized (this.f39791a) {
            try {
                this.f39791a.set(Boolean.valueOf(this.f39792b.f40059a.z().B(this.f39792b.f40059a.B().s(), g3.M)));
                this.f39791a.notify();
            } catch (Throwable th2) {
                this.f39791a.notify();
                throw th2;
            }
        }
    }
}
