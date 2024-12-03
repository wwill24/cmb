package com.coffeemeetsbagel.feature.purchase;

import c7.d;
import com.coffeemeetsbagel.store.alc.i;
import com.coffeemeetsbagel.store.alc.models.PurchaseRequest;
import com.google.gson.j;
import qj.w;

public class PurchaseApi {
    private final i purchaseService;

    public PurchaseApi(d dVar) {
        this.purchaseService = (i) dVar.c(i.class);
    }

    public w<j> purchase(PurchaseRequest purchaseRequest) {
        return this.purchaseService.a(purchaseRequest);
    }
}
