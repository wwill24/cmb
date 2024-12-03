package com.coffeemeetsbagel.match;

import fj.d;
import fk.a;

public final class t implements d<BagelRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final a<l> f34518a;

    /* renamed from: b  reason: collision with root package name */
    private final a<u> f34519b;

    public t(a<l> aVar, a<u> aVar2) {
        this.f34518a = aVar;
        this.f34519b = aVar2;
    }

    public static t a(a<l> aVar, a<u> aVar2) {
        return new t(aVar, aVar2);
    }

    public static BagelRepository c(l lVar, u uVar) {
        return new BagelRepository(lVar, uVar);
    }

    /* renamed from: b */
    public BagelRepository get() {
        return c(this.f34518a.get(), this.f34519b.get());
    }
}
