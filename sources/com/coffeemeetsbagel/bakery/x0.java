package com.coffeemeetsbagel.bakery;

import fj.d;
import fj.g;
import g9.a;

public final class x0 implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<Bakery> f11390a;

    public x0(fk.a<Bakery> aVar) {
        this.f11390a = aVar;
    }

    public static x0 a(fk.a<Bakery> aVar) {
        return new x0(aVar);
    }

    public static a c(Bakery bakery) {
        return (a) g.e(c.V(bakery));
    }

    /* renamed from: b */
    public a get() {
        return c(this.f11390a.get());
    }
}
