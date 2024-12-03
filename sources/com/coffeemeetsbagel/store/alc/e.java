package com.coffeemeetsbagel.store.alc;

import fj.d;
import fk.a;

public final class e implements d<d> {

    /* renamed from: a  reason: collision with root package name */
    private final a<PurchaseRepository<Boolean>> f36771a;

    public e(a<PurchaseRepository<Boolean>> aVar) {
        this.f36771a = aVar;
    }

    public static e a(a<PurchaseRepository<Boolean>> aVar) {
        return new e(aVar);
    }

    public static d c(PurchaseRepository<Boolean> purchaseRepository) {
        return new d(purchaseRepository);
    }

    /* renamed from: b */
    public d get() {
        return c(this.f36771a.get());
    }
}
