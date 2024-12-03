package com.coffeemeetsbagel.bakery;

import fj.d;
import fj.g;
import fk.a;
import tb.b;

public final class t implements d<b> {

    /* renamed from: a  reason: collision with root package name */
    private final a<tb.a> f11374a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Bakery> f11375b;

    public t(a<tb.a> aVar, a<Bakery> aVar2) {
        this.f11374a = aVar;
        this.f11375b = aVar2;
    }

    public static b a(tb.a aVar, Bakery bakery) {
        return (b) g.e(c.q(aVar, bakery));
    }

    public static t b(a<tb.a> aVar, a<Bakery> aVar2) {
        return new t(aVar, aVar2);
    }

    /* renamed from: c */
    public b get() {
        return a(this.f11374a.get(), this.f11375b.get());
    }
}
