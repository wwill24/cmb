package com.google.android.gms.measurement.internal;

import we.d;

final class c8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f39706a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f8 f39707b;

    c8(f8 f8Var, d dVar) {
        this.f39707b = f8Var;
        this.f39706a = dVar;
    }

    public final void run() {
        synchronized (this.f39707b) {
            this.f39707b.f39794a = false;
            if (!this.f39707b.f39796c.z()) {
                this.f39707b.f39796c.f40059a.d().q().a("Connected to remote service");
                this.f39707b.f39796c.x(this.f39706a);
            }
        }
    }
}
