package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class l6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f40012a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u6 f40013b;

    l6(u6 u6Var, AtomicReference atomicReference) {
        this.f40013b = u6Var;
        this.f40012a = atomicReference;
    }

    public final void run() {
        synchronized (this.f40012a) {
            try {
                this.f40012a.set(Long.valueOf(this.f40013b.f40059a.z().r(this.f40013b.f40059a.B().s(), g3.O)));
                this.f40012a.notify();
            } catch (Throwable th2) {
                this.f40012a.notify();
                throw th2;
            }
        }
    }
}
