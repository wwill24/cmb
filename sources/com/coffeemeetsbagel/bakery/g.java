package com.coffeemeetsbagel.bakery;

import b7.b;
import b7.c;
import com.coffeemeetsbagel.experiment.r;
import fj.d;
import fk.a;

public final class g implements d<c> {

    /* renamed from: a  reason: collision with root package name */
    private final a<r> f11194a;

    /* renamed from: b  reason: collision with root package name */
    private final a<b> f11195b;

    public g(a<r> aVar, a<b> aVar2) {
        this.f11194a = aVar;
        this.f11195b = aVar2;
    }

    public static c a(r rVar, b bVar) {
        return (c) fj.g.e(c.d(rVar, bVar));
    }

    public static g b(a<r> aVar, a<b> aVar2) {
        return new g(aVar, aVar2);
    }

    /* renamed from: c */
    public c get() {
        return a(this.f11194a.get(), this.f11195b.get());
    }
}
