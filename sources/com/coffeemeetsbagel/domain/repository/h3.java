package com.coffeemeetsbagel.domain.repository;

import fj.d;
import fk.a;
import ma.g;
import u6.q;

public final class h3 implements d<UserRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final a<g> f12516a;

    /* renamed from: b  reason: collision with root package name */
    private final a<q> f12517b;

    /* renamed from: c  reason: collision with root package name */
    private final a<za.d> f12518c;

    /* renamed from: d  reason: collision with root package name */
    private final a<s9.a> f12519d;

    public h3(a<g> aVar, a<q> aVar2, a<za.d> aVar3, a<s9.a> aVar4) {
        this.f12516a = aVar;
        this.f12517b = aVar2;
        this.f12518c = aVar3;
        this.f12519d = aVar4;
    }

    public static h3 a(a<g> aVar, a<q> aVar2, a<za.d> aVar3, a<s9.a> aVar4) {
        return new h3(aVar, aVar2, aVar3, aVar4);
    }

    public static UserRepository c(g gVar, q qVar, za.d dVar, s9.a aVar) {
        return new UserRepository(gVar, qVar, dVar, aVar);
    }

    /* renamed from: b */
    public UserRepository get() {
        return c(this.f12516a.get(), this.f12517b.get(), this.f12518c.get(), this.f12519d.get());
    }
}
