package com.coffeemeetsbagel.bakery;

import fj.d;
import fj.g;
import fk.a;

public final class h0 implements d<h1> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Bakery> f11200a;

    public h0(a<Bakery> aVar) {
        this.f11200a = aVar;
    }

    public static h0 a(a<Bakery> aVar) {
        return new h0(aVar);
    }

    public static h1 c(Bakery bakery) {
        return (h1) g.e(c.F(bakery));
    }

    /* renamed from: b */
    public h1 get() {
        return c(this.f11200a.get());
    }
}
