package com.coffeemeetsbagel.bakery;

import fj.d;
import fj.g;
import fk.a;
import ga.b;
import ga.j;
import hb.c;

public final class y0 implements d<j> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Bakery> f11392a;

    /* renamed from: b  reason: collision with root package name */
    private final a<g9.a> f11393b;

    /* renamed from: c  reason: collision with root package name */
    private final a<c> f11394c;

    /* renamed from: d  reason: collision with root package name */
    private final a<b> f11395d;

    public y0(a<Bakery> aVar, a<g9.a> aVar2, a<c> aVar3, a<b> aVar4) {
        this.f11392a = aVar;
        this.f11393b = aVar2;
        this.f11394c = aVar3;
        this.f11395d = aVar4;
    }

    public static y0 a(a<Bakery> aVar, a<g9.a> aVar2, a<c> aVar3, a<b> aVar4) {
        return new y0(aVar, aVar2, aVar3, aVar4);
    }

    public static j c(Bakery bakery, g9.a aVar, c cVar, b bVar) {
        return (j) g.e(c.W(bakery, aVar, cVar, bVar));
    }

    /* renamed from: b */
    public j get() {
        return c(this.f11392a.get(), this.f11393b.get(), this.f11394c.get(), this.f11395d.get());
    }
}
