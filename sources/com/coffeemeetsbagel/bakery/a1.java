package com.coffeemeetsbagel.bakery;

import fj.d;
import fj.g;
import fk.a;
import hb.c;

public final class a1 implements d<c> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Bakery> f11069a;

    public a1(a<Bakery> aVar) {
        this.f11069a = aVar;
    }

    public static a1 a(a<Bakery> aVar) {
        return new a1(aVar);
    }

    public static c c(Bakery bakery) {
        return (c) g.e(c.Y(bakery));
    }

    /* renamed from: b */
    public c get() {
        return c(this.f11069a.get());
    }
}
