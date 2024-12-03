package com.coffeemeetsbagel.shop.main;

import com.coffeemeetsbagel.shop.main.d;
import fj.d;
import fj.g;
import fk.a;

public final class f implements d<n> {

    /* renamed from: a  reason: collision with root package name */
    private final d.b f36446a;

    /* renamed from: b  reason: collision with root package name */
    private final a<b6.d> f36447b;

    public f(d.b bVar, a<b6.d> aVar) {
        this.f36446a = bVar;
        this.f36447b = aVar;
    }

    public static n a(d.b bVar, b6.d dVar) {
        return (n) g.e(bVar.a(dVar));
    }

    public static f b(d.b bVar, a<b6.d> aVar) {
        return new f(bVar, aVar);
    }

    /* renamed from: c */
    public n get() {
        return a(this.f36446a, this.f36447b.get());
    }
}
