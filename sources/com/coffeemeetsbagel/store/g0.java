package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class g0 {
    public static final Price a(PurchaseType purchaseType) {
        j.g(purchaseType, "<this>");
        String d10 = purchaseType.d();
        j.f(d10, "this@toPrice.itemName");
        return new Price((int) purchaseType.e(), 0, false, d10, "", "", (String) null, 64, (DefaultConstructorMarker) null);
    }
}
