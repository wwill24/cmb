package com.coffeemeetsbagel.shop;

import com.coffeemeetsbagel.shop.b;
import fj.d;
import fj.g;
import fk.a;
import kb.c;

public final class k implements d<c> {

    /* renamed from: a  reason: collision with root package name */
    private final b.C0446b f36426a;

    /* renamed from: b  reason: collision with root package name */
    private final a<kb.b> f36427b;

    public k(b.C0446b bVar, a<kb.b> aVar) {
        this.f36426a = bVar;
        this.f36427b = aVar;
    }

    public static k a(b.C0446b bVar, a<kb.b> aVar) {
        return new k(bVar, aVar);
    }

    public static c c(b.C0446b bVar, kb.b bVar2) {
        return (c) g.e(bVar.i(bVar2));
    }

    /* renamed from: b */
    public c get() {
        return c(this.f36426a, this.f36427b.get());
    }
}
