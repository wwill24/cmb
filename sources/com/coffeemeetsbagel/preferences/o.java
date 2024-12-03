package com.coffeemeetsbagel.preferences;

import com.coffeemeetsbagel.preferences.l;
import fj.d;
import fj.g;

public final class o implements d<k> {

    /* renamed from: a  reason: collision with root package name */
    private final l.b f35811a;

    public o(l.b bVar) {
        this.f35811a = bVar;
    }

    public static o a(l.b bVar) {
        return new o(bVar);
    }

    public static k c(l.b bVar) {
        return (k) g.e(bVar.c());
    }

    /* renamed from: b */
    public k get() {
        return c(this.f35811a);
    }
}
