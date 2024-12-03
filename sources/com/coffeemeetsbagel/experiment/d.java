package com.coffeemeetsbagel.experiment;

import fj.g;
import s9.a;

public final class d implements fj.d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final a f12646a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<r> f12647b;

    public d(a aVar, fk.a<r> aVar2) {
        this.f12646a = aVar;
        this.f12647b = aVar2;
    }

    public static d a(a aVar, fk.a<r> aVar2) {
        return new d(aVar, aVar2);
    }

    public static a b(a aVar, r rVar) {
        return (a) g.e(aVar.c(rVar));
    }

    /* renamed from: c */
    public a get() {
        return b(this.f12646a, this.f12647b.get());
    }
}
