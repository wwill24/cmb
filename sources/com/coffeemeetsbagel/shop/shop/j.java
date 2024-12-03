package com.coffeemeetsbagel.shop.shop;

import com.coffeemeetsbagel.shop.shop.h;
import fj.d;
import fj.g;
import fk.a;

public final class j implements d<o0> {

    /* renamed from: a  reason: collision with root package name */
    private final h.c f36541a;

    /* renamed from: b  reason: collision with root package name */
    private final a<b6.d> f36542b;

    public j(h.c cVar, a<b6.d> aVar) {
        this.f36541a = cVar;
        this.f36542b = aVar;
    }

    public static o0 a(h.c cVar, b6.d dVar) {
        return (o0) g.e(cVar.a(dVar));
    }

    public static j b(h.c cVar, a<b6.d> aVar) {
        return new j(cVar, aVar);
    }

    /* renamed from: c */
    public o0 get() {
        return a(this.f36541a, this.f36542b.get());
    }
}
