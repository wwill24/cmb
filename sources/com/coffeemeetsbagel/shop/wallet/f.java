package com.coffeemeetsbagel.shop.wallet;

import com.coffeemeetsbagel.shop.wallet.d;
import fj.d;
import fj.g;
import fk.a;
import k9.b;

public final class f implements d<b> {

    /* renamed from: a  reason: collision with root package name */
    private final d.c f36650a;

    /* renamed from: b  reason: collision with root package name */
    private final a<s9.a> f36651b;

    public f(d.c cVar, a<s9.a> aVar) {
        this.f36650a = cVar;
        this.f36651b = aVar;
    }

    public static f a(d.c cVar, a<s9.a> aVar) {
        return new f(cVar, aVar);
    }

    public static b c(d.c cVar, s9.a aVar) {
        return (b) g.e(cVar.b(aVar));
    }

    /* renamed from: b */
    public b get() {
        return c(this.f36650a, this.f36651b.get());
    }
}
