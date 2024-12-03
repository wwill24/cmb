package com.coffeemeetsbagel.domain.repository;

import fj.d;
import fk.a;

public final class n implements d<m> {

    /* renamed from: a  reason: collision with root package name */
    private final a<u6.d> f12545a;

    /* renamed from: b  reason: collision with root package name */
    private final a<cb.a> f12546b;

    public n(a<u6.d> aVar, a<cb.a> aVar2) {
        this.f12545a = aVar;
        this.f12546b = aVar2;
    }

    public static n a(a<u6.d> aVar, a<cb.a> aVar2) {
        return new n(aVar, aVar2);
    }

    public static m c(u6.d dVar, cb.a aVar) {
        return new m(dVar, aVar);
    }

    /* renamed from: b */
    public m get() {
        return c(this.f12545a.get(), this.f12546b.get());
    }
}
