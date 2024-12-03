package com.coffeemeetsbagel.bakery;

import fj.d;
import fj.g;
import hb.c;
import j7.a;

public final class p implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<c> f11332a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<h1> f11333b;

    public p(fk.a<c> aVar, fk.a<h1> aVar2) {
        this.f11332a = aVar;
        this.f11333b = aVar2;
    }

    public static a a(c cVar, h1 h1Var) {
        return (a) g.e(c.m(cVar, h1Var));
    }

    public static p b(fk.a<c> aVar, fk.a<h1> aVar2) {
        return new p(aVar, aVar2);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f11332a.get(), this.f11333b.get());
    }
}
