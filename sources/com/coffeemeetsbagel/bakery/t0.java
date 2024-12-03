package com.coffeemeetsbagel.bakery;

import android.content.res.Resources;
import fj.d;
import fj.g;
import fk.a;

public final class t0 implements d<Resources> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Bakery> f11376a;

    public t0(a<Bakery> aVar) {
        this.f11376a = aVar;
    }

    public static t0 a(a<Bakery> aVar) {
        return new t0(aVar);
    }

    public static Resources c(Bakery bakery) {
        return (Resources) g.e(c.R(bakery));
    }

    /* renamed from: b */
    public Resources get() {
        return c(this.f11376a.get());
    }
}
