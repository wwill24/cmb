package com.coffeemeetsbagel.bakery;

import b9.a;
import fj.d;
import fj.g;

public final class s0 implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<y7.a> f11372a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<a6.a> f11373b;

    public s0(fk.a<y7.a> aVar, fk.a<a6.a> aVar2) {
        this.f11372a = aVar;
        this.f11373b = aVar2;
    }

    public static s0 a(fk.a<y7.a> aVar, fk.a<a6.a> aVar2) {
        return new s0(aVar, aVar2);
    }

    public static a c(y7.a aVar, a6.a aVar2) {
        return (a) g.e(c.Q(aVar, aVar2));
    }

    /* renamed from: b */
    public a get() {
        return c(this.f11372a.get(), this.f11373b.get());
    }
}
