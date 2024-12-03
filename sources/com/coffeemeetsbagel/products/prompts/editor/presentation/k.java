package com.coffeemeetsbagel.products.prompts.editor.presentation;

import com.coffeemeetsbagel.products.prompts.editor.presentation.g;
import fj.d;
import xa.a;

public final class k implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final g.b f35943a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<a7.a> f35944b;

    public k(g.b bVar, fk.a<a7.a> aVar) {
        this.f35943a = bVar;
        this.f35944b = aVar;
    }

    public static k a(g.b bVar, fk.a<a7.a> aVar) {
        return new k(bVar, aVar);
    }

    public static a c(g.b bVar, a7.a aVar) {
        return (a) fj.g.e(bVar.d(aVar));
    }

    /* renamed from: b */
    public a get() {
        return c(this.f35943a, this.f35944b.get());
    }
}
