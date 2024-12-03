package com.coffeemeetsbagel.preferences;

import com.coffeemeetsbagel.preferences.l;
import fj.d;
import fj.g;
import fk.a;

public final class m implements d<g> {

    /* renamed from: a  reason: collision with root package name */
    private final l.b f35807a;

    /* renamed from: b  reason: collision with root package name */
    private final a<k> f35808b;

    public m(l.b bVar, a<k> aVar) {
        this.f35807a = bVar;
        this.f35808b = aVar;
    }

    public static m a(l.b bVar, a<k> aVar) {
        return new m(bVar, aVar);
    }

    public static g b(l.b bVar, k kVar) {
        return (g) g.e(bVar.a(kVar));
    }

    /* renamed from: c */
    public g get() {
        return b(this.f35807a, this.f35808b.get());
    }
}
