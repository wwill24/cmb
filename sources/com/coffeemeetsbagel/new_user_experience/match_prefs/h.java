package com.coffeemeetsbagel.new_user_experience.match_prefs;

import com.coffeemeetsbagel.new_user_experience.match_prefs.e;
import fj.d;
import fj.g;
import fk.a;

public final class h implements d<l> {

    /* renamed from: a  reason: collision with root package name */
    private final e.b f35377a;

    /* renamed from: b  reason: collision with root package name */
    private final a<g0> f35378b;

    public h(e.b bVar, a<g0> aVar) {
        this.f35377a = bVar;
        this.f35378b = aVar;
    }

    public static h a(e.b bVar, a<g0> aVar) {
        return new h(bVar, aVar);
    }

    public static l c(e.b bVar, g0 g0Var) {
        return (l) g.e(bVar.c(g0Var));
    }

    /* renamed from: b */
    public l get() {
        return c(this.f35377a, this.f35378b.get());
    }
}
