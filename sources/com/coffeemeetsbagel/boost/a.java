package com.coffeemeetsbagel.boost;

import fj.d;

public final class a implements d<BoostAnalytics> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<a7.a> f11456a;

    public a(fk.a<a7.a> aVar) {
        this.f11456a = aVar;
    }

    public static a a(fk.a<a7.a> aVar) {
        return new a(aVar);
    }

    public static BoostAnalytics c(a7.a aVar) {
        return new BoostAnalytics(aVar);
    }

    /* renamed from: b */
    public BoostAnalytics get() {
        return c(this.f11456a.get());
    }
}
