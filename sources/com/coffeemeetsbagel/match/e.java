package com.coffeemeetsbagel.match;

import fj.d;
import fk.a;

public final class e implements d<d> {

    /* renamed from: a  reason: collision with root package name */
    private final a<BagelRepository> f34504a;

    /* renamed from: b  reason: collision with root package name */
    private final a<w> f34505b;

    public e(a<BagelRepository> aVar, a<w> aVar2) {
        this.f34504a = aVar;
        this.f34505b = aVar2;
    }

    public static e a(a<BagelRepository> aVar, a<w> aVar2) {
        return new e(aVar, aVar2);
    }

    public static d c(BagelRepository bagelRepository, w wVar) {
        return new d(bagelRepository, wVar);
    }

    /* renamed from: b */
    public d get() {
        return c(this.f34504a.get(), this.f34505b.get());
    }
}
