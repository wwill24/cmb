package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;
import ze.a;

final class p0 extends a {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f38724a;

    p0(u0 u0Var) {
        this.f38724a = new WeakReference(u0Var);
    }

    public final void n(zak zak) {
        u0 u0Var = (u0) this.f38724a.get();
        if (u0Var != null) {
            u0Var.f38747a.r(new o0(this, u0Var, u0Var, zak));
        }
    }
}
