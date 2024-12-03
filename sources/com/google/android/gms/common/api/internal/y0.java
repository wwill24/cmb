package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class y0 extends r1 {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f38820a;

    y0(z0 z0Var) {
        this.f38820a = new WeakReference(z0Var);
    }

    public final void a() {
        z0 z0Var = (z0) this.f38820a.get();
        if (z0Var != null) {
            z0.y(z0Var);
        }
    }
}
