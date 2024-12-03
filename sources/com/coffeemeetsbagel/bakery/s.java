package com.coffeemeetsbagel.bakery;

import fj.d;
import fj.g;
import tb.a;

public final class s implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<Bakery> f11371a;

    public s(fk.a<Bakery> aVar) {
        this.f11371a = aVar;
    }

    public static a a(Bakery bakery) {
        return (a) g.e(c.p(bakery));
    }

    public static s b(fk.a<Bakery> aVar) {
        return new s(aVar);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f11371a.get());
    }
}
