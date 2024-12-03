package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class m6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f40035a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u6 f40036b;

    m6(u6 u6Var, AtomicReference atomicReference) {
        this.f40036b = u6Var;
        this.f40035a = atomicReference;
    }

    public final void run() {
        synchronized (this.f40035a) {
            try {
                this.f40035a.set(Integer.valueOf(this.f40036b.f40059a.z().o(this.f40036b.f40059a.B().s(), g3.P)));
                this.f40035a.notify();
            } catch (Throwable th2) {
                this.f40035a.notify();
                throw th2;
            }
        }
    }
}
