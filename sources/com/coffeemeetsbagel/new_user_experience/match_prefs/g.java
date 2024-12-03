package com.coffeemeetsbagel.new_user_experience.match_prefs;

import com.coffeemeetsbagel.new_user_experience.match_prefs.e;
import fj.d;
import fk.a;

public final class g implements d<k> {

    /* renamed from: a  reason: collision with root package name */
    private final e.b f35356a;

    /* renamed from: b  reason: collision with root package name */
    private final a<g0> f35357b;

    public g(e.b bVar, a<g0> aVar) {
        this.f35356a = bVar;
        this.f35357b = aVar;
    }

    public static g a(e.b bVar, a<g0> aVar) {
        return new g(bVar, aVar);
    }

    public static k c(e.b bVar, g0 g0Var) {
        return (k) fj.g.e(bVar.b(g0Var));
    }

    /* renamed from: b */
    public k get() {
        return c(this.f35356a, this.f35357b.get());
    }
}
