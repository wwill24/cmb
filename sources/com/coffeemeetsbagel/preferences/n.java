package com.coffeemeetsbagel.preferences;

import com.coffeemeetsbagel.preferences.l;
import fj.d;
import fj.g;
import fk.a;
import na.b;

public final class n implements d<b> {

    /* renamed from: a  reason: collision with root package name */
    private final l.b f35809a;

    /* renamed from: b  reason: collision with root package name */
    private final a<k> f35810b;

    public n(l.b bVar, a<k> aVar) {
        this.f35809a = bVar;
        this.f35810b = aVar;
    }

    public static n a(l.b bVar, a<k> aVar) {
        return new n(bVar, aVar);
    }

    public static b c(l.b bVar, k kVar) {
        return (b) g.e(bVar.b(kVar));
    }

    /* renamed from: b */
    public b get() {
        return c(this.f35809a, this.f35810b.get());
    }
}
