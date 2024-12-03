package com.coffeemeetsbagel.bakery;

import fj.d;
import fj.g;
import h7.a;
import nc.b;
import u6.m;

public final class o implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<m> f11324a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<b> f11325b;

    public o(fk.a<m> aVar, fk.a<b> aVar2) {
        this.f11324a = aVar;
        this.f11325b = aVar2;
    }

    public static a a(m mVar, b bVar) {
        return (a) g.e(c.l(mVar, bVar));
    }

    public static o b(fk.a<m> aVar, fk.a<b> aVar2) {
        return new o(aVar, aVar2);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f11324a.get(), this.f11325b.get());
    }
}
