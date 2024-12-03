package com.coffeemeetsbagel.bakery;

import fj.d;
import fj.g;
import fk.a;
import hb.c;

public final class v0 implements d<c7.d> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c> f11385a;

    /* renamed from: b  reason: collision with root package name */
    private final a<j7.a> f11386b;

    public v0(a<c> aVar, a<j7.a> aVar2) {
        this.f11385a = aVar;
        this.f11386b = aVar2;
    }

    public static v0 a(a<c> aVar, a<j7.a> aVar2) {
        return new v0(aVar, aVar2);
    }

    public static c7.d c(c cVar, j7.a aVar) {
        return (c7.d) g.e(c.T(cVar, aVar));
    }

    /* renamed from: b */
    public c7.d get() {
        return c(this.f11385a.get(), this.f11386b.get());
    }
}
