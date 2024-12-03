package com.coffeemeetsbagel.bakery;

import android.net.ConnectivityManager;
import fj.d;
import fj.g;
import fk.a;

public final class w implements d<ConnectivityManager> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Bakery> f11387a;

    public w(a<Bakery> aVar) {
        this.f11387a = aVar;
    }

    public static ConnectivityManager a(Bakery bakery) {
        return (ConnectivityManager) g.e(c.t(bakery));
    }

    public static w b(a<Bakery> aVar) {
        return new w(aVar);
    }

    /* renamed from: c */
    public ConnectivityManager get() {
        return a(this.f11387a.get());
    }
}
