package com.coffeemeetsbagel.feature.purchase;

import fj.d;
import fk.a;

public final class PurchaseApi_Factory implements d<PurchaseApi> {
    private final a<c7.d> retrofitManagerProvider;

    public PurchaseApi_Factory(a<c7.d> aVar) {
        this.retrofitManagerProvider = aVar;
    }

    public static PurchaseApi_Factory create(a<c7.d> aVar) {
        return new PurchaseApi_Factory(aVar);
    }

    public static PurchaseApi newInstance(c7.d dVar) {
        return new PurchaseApi(dVar);
    }

    public PurchaseApi get() {
        return newInstance(this.retrofitManagerProvider.get());
    }
}
