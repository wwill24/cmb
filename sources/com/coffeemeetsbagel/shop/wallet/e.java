package com.coffeemeetsbagel.shop.wallet;

import com.coffeemeetsbagel.shop.wallet.d;
import fj.d;
import fj.g;
import fk.a;

public final class e implements d<j> {

    /* renamed from: a  reason: collision with root package name */
    private final d.c f36648a;

    /* renamed from: b  reason: collision with root package name */
    private final a<b6.d<?, ?>> f36649b;

    public e(d.c cVar, a<b6.d<?, ?>> aVar) {
        this.f36648a = cVar;
        this.f36649b = aVar;
    }

    public static j a(d.c cVar, b6.d<?, ?> dVar) {
        return (j) g.e(cVar.a(dVar));
    }

    public static e b(d.c cVar, a<b6.d<?, ?>> aVar) {
        return new e(cVar, aVar);
    }

    /* renamed from: c */
    public j get() {
        return a(this.f36648a, this.f36649b.get());
    }
}
