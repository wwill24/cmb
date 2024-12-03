package com.coffeemeetsbagel.bakery;

import fj.d;
import fj.g;
import q8.a;

public final class g0 implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<Bakery> f11196a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<h8.a> f11197b;

    public g0(fk.a<Bakery> aVar, fk.a<h8.a> aVar2) {
        this.f11196a = aVar;
        this.f11197b = aVar2;
    }

    public static g0 a(fk.a<Bakery> aVar, fk.a<h8.a> aVar2) {
        return new g0(aVar, aVar2);
    }

    public static a c(Bakery bakery, h8.a aVar) {
        return (a) g.e(c.E(bakery, aVar));
    }

    /* renamed from: b */
    public a get() {
        return c(this.f11196a.get(), this.f11197b.get());
    }
}
