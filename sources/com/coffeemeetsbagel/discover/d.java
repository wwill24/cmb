package com.coffeemeetsbagel.discover;

import fk.a;
import hb.c;

public final class d implements fj.d<DiscoverMatchRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final a<f> f12174a;

    /* renamed from: b  reason: collision with root package name */
    private final a<t7.a> f12175b;

    /* renamed from: c  reason: collision with root package name */
    private final a<c> f12176c;

    public d(a<f> aVar, a<t7.a> aVar2, a<c> aVar3) {
        this.f12174a = aVar;
        this.f12175b = aVar2;
        this.f12176c = aVar3;
    }

    public static d a(a<f> aVar, a<t7.a> aVar2, a<c> aVar3) {
        return new d(aVar, aVar2, aVar3);
    }

    public static DiscoverMatchRepository c(f fVar, t7.a aVar, c cVar) {
        return new DiscoverMatchRepository(fVar, aVar, cVar);
    }

    /* renamed from: b */
    public DiscoverMatchRepository get() {
        return c(this.f12174a.get(), this.f12175b.get(), this.f12176c.get());
    }
}
