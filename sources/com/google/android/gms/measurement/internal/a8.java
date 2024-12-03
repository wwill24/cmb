package com.google.android.gms.measurement.internal;

import we.d;

final class a8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f39649a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f8 f39650b;

    a8(f8 f8Var, d dVar) {
        this.f39650b = f8Var;
        this.f39649a = dVar;
    }

    public final void run() {
        synchronized (this.f39650b) {
            this.f39650b.f39794a = false;
            if (!this.f39650b.f39796c.z()) {
                this.f39650b.f39796c.f40059a.d().v().a("Connected to service");
                this.f39650b.f39796c.x(this.f39649a);
            }
        }
    }
}
