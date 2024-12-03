package com.coffeemeetsbagel.products.my_answers.presentation;

import com.coffeemeetsbagel.products.my_answers.presentation.m;
import fj.d;
import fj.g;
import ta.a;

public final class t implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final m.b f35895a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<a7.a> f35896b;

    public t(m.b bVar, fk.a<a7.a> aVar) {
        this.f35895a = bVar;
        this.f35896b = aVar;
    }

    public static t a(m.b bVar, fk.a<a7.a> aVar) {
        return new t(bVar, aVar);
    }

    public static a c(m.b bVar, a7.a aVar) {
        return (a) g.e(bVar.g(aVar));
    }

    /* renamed from: b */
    public a get() {
        return c(this.f35895a, this.f35896b.get());
    }
}
