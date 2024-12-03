package com.coffeemeetsbagel.bakery;

import android.content.Context;
import fj.d;
import fj.g;
import fk.a;

public final class i implements d<Context> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Bakery> f11211a;

    public i(a<Bakery> aVar) {
        this.f11211a = aVar;
    }

    public static Context a(Bakery bakery) {
        return (Context) g.e(c.f(bakery));
    }

    public static i b(a<Bakery> aVar) {
        return new i(aVar);
    }

    /* renamed from: c */
    public Context get() {
        return a(this.f11211a.get());
    }
}
