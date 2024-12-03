package com.coffeemeetsbagel.domain.repository;

import fj.d;
import fk.a;
import hb.c;

public final class e implements d<ActionCardRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final a<ma.a> f12490a;

    /* renamed from: b  reason: collision with root package name */
    private final a<u6.a> f12491b;

    /* renamed from: c  reason: collision with root package name */
    private final a<c> f12492c;

    public e(a<ma.a> aVar, a<u6.a> aVar2, a<c> aVar3) {
        this.f12490a = aVar;
        this.f12491b = aVar2;
        this.f12492c = aVar3;
    }

    public static e a(a<ma.a> aVar, a<u6.a> aVar2, a<c> aVar3) {
        return new e(aVar, aVar2, aVar3);
    }

    public static ActionCardRepository c(ma.a aVar, u6.a aVar2, c cVar) {
        return new ActionCardRepository(aVar, aVar2, cVar);
    }

    /* renamed from: b */
    public ActionCardRepository get() {
        return c(this.f12490a.get(), this.f12491b.get(), this.f12492c.get());
    }
}
