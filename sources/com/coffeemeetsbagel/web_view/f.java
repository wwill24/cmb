package com.coffeemeetsbagel.web_view;

import com.coffeemeetsbagel.web_view.c;
import fj.d;
import fj.g;
import qc.a;

public final class f implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final c.b f37607a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<a> f37608b;

    public f(c.b bVar, fk.a<a> aVar) {
        this.f37607a = bVar;
        this.f37608b = aVar;
    }

    public static f a(c.b bVar, fk.a<a> aVar) {
        return new f(bVar, aVar);
    }

    public static a c(c.b bVar, a aVar) {
        return (a) g.e(bVar.c(aVar));
    }

    /* renamed from: b */
    public a get() {
        return c(this.f37607a, this.f37608b.get());
    }
}
