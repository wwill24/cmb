package com.coffeemeetsbagel.bakery;

import fj.d;
import fj.g;
import fk.a;
import p9.c;

public final class l0 implements d<p9.d> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c> f11266a;

    public l0(a<c> aVar) {
        this.f11266a = aVar;
    }

    public static l0 a(a<c> aVar) {
        return new l0(aVar);
    }

    public static p9.d c(c cVar) {
        return (p9.d) g.e(c.J(cVar));
    }

    /* renamed from: b */
    public p9.d get() {
        return c(this.f11266a.get());
    }
}
