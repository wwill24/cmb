package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.feature.instagram.c;
import fj.d;
import fj.g;
import fk.a;

public final class e0 implements d<c> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c7.d> f11089a;

    /* renamed from: b  reason: collision with root package name */
    private final a<hb.c> f11090b;

    public e0(a<c7.d> aVar, a<hb.c> aVar2) {
        this.f11089a = aVar;
        this.f11090b = aVar2;
    }

    public static e0 a(a<c7.d> aVar, a<hb.c> aVar2) {
        return new e0(aVar, aVar2);
    }

    public static c c(c7.d dVar, hb.c cVar) {
        return (c) g.e(c.C(dVar, cVar));
    }

    /* renamed from: b */
    public c get() {
        return c(this.f11089a.get(), this.f11090b.get());
    }
}
