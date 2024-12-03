package com.coffeemeetsbagel.store;

import fj.d;
import fj.g;
import fk.a;

public final class u0 implements d<i0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c7.d> f37000a;

    public u0(a<c7.d> aVar) {
        this.f37000a = aVar;
    }

    public static u0 a(a<c7.d> aVar) {
        return new u0(aVar);
    }

    public static i0 c(c7.d dVar) {
        return (i0) g.e(s0.f36931a.b(dVar));
    }

    /* renamed from: b */
    public i0 get() {
        return c(this.f37000a.get());
    }
}
