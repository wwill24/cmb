package com.coffeemeetsbagel.products.prompts.selection.presentation;

import com.coffeemeetsbagel.products.prompts.selection.presentation.h;
import fj.d;
import fj.g;
import ya.a;

public final class m implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final h.b f35996a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<a7.a> f35997b;

    public m(h.b bVar, fk.a<a7.a> aVar) {
        this.f35996a = bVar;
        this.f35997b = aVar;
    }

    public static m a(h.b bVar, fk.a<a7.a> aVar) {
        return new m(bVar, aVar);
    }

    public static a c(h.b bVar, a7.a aVar) {
        return (a) g.e(bVar.e(aVar));
    }

    /* renamed from: b */
    public a get() {
        return c(this.f35996a, this.f35997b.get());
    }
}
