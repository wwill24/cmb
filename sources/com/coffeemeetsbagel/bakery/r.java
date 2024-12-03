package com.coffeemeetsbagel.bakery;

import fj.d;
import fj.g;
import hb.c;
import o7.a;

public final class r implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<h1> f11367a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<c> f11368b;

    public r(fk.a<h1> aVar, fk.a<c> aVar2) {
        this.f11367a = aVar;
        this.f11368b = aVar2;
    }

    public static a a(h1 h1Var, c cVar) {
        return (a) g.e(c.o(h1Var, cVar));
    }

    public static r b(fk.a<h1> aVar, fk.a<c> aVar2) {
        return new r(aVar, aVar2);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f11367a.get(), this.f11368b.get());
    }
}
