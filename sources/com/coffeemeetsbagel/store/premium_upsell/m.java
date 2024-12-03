package com.coffeemeetsbagel.store.premium_upsell;

import com.coffeemeetsbagel.store.premium_upsell.k;
import fj.d;
import fj.g;
import fk.a;

public final class m implements d<PremiumUpsellAnalytics> {

    /* renamed from: a  reason: collision with root package name */
    private final k.c f36901a;

    /* renamed from: b  reason: collision with root package name */
    private final a<a7.a> f36902b;

    public m(k.c cVar, a<a7.a> aVar) {
        this.f36901a = cVar;
        this.f36902b = aVar;
    }

    public static m a(k.c cVar, a<a7.a> aVar) {
        return new m(cVar, aVar);
    }

    public static PremiumUpsellAnalytics c(k.c cVar, a7.a aVar) {
        return (PremiumUpsellAnalytics) g.e(cVar.b(aVar));
    }

    /* renamed from: b */
    public PremiumUpsellAnalytics get() {
        return c(this.f36901a, this.f36902b.get());
    }
}
