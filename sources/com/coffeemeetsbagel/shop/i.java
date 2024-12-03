package com.coffeemeetsbagel.shop;

import com.coffeemeetsbagel.shop.b;
import fj.d;
import fj.g;
import kb.a;

public final class i implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final b.C0446b f36423a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<kb.b> f36424b;

    public i(b.C0446b bVar, fk.a<kb.b> aVar) {
        this.f36423a = bVar;
        this.f36424b = aVar;
    }

    public static i a(b.C0446b bVar, fk.a<kb.b> aVar) {
        return new i(bVar, aVar);
    }

    public static a c(b.C0446b bVar, kb.b bVar2) {
        return (a) g.e(bVar.g(bVar2));
    }

    /* renamed from: b */
    public a get() {
        return c(this.f36423a, this.f36424b.get());
    }
}
