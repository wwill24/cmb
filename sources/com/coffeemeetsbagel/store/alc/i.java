package com.coffeemeetsbagel.store.alc;

import com.coffeemeetsbagel.store.alc.models.PurchaseRequest;
import com.google.gson.j;
import qj.w;
import vn.a;
import vn.o;

public interface i {
    @o("/purchase")
    w<j> a(@a PurchaseRequest purchaseRequest);
}
