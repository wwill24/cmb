package com.coffeemeetsbagel.store.alc;

import com.coffeemeetsbagel.models.Bagel;
import fj.d;
import fk.a;

public final class c implements d<b> {

    /* renamed from: a  reason: collision with root package name */
    private final a<PurchaseRepository<Bagel>> f36769a;

    public c(a<PurchaseRepository<Bagel>> aVar) {
        this.f36769a = aVar;
    }

    public static c a(a<PurchaseRepository<Bagel>> aVar) {
        return new c(aVar);
    }

    public static b c(PurchaseRepository<Bagel> purchaseRepository) {
        return new b(purchaseRepository);
    }

    /* renamed from: b */
    public b get() {
        return c(this.f36769a.get());
    }
}
