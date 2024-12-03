package com.coffeemeetsbagel.match;

import fj.d;
import fk.a;

public final class y implements d<x> {

    /* renamed from: a  reason: collision with root package name */
    private final a<BagelRepository> f34525a;

    public y(a<BagelRepository> aVar) {
        this.f34525a = aVar;
    }

    public static y a(a<BagelRepository> aVar) {
        return new y(aVar);
    }

    public static x c(BagelRepository bagelRepository) {
        return new x(bagelRepository);
    }

    /* renamed from: b */
    public x get() {
        return c(this.f34525a.get());
    }
}
