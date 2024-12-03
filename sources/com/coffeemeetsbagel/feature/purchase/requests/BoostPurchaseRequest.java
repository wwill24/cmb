package com.coffeemeetsbagel.feature.purchase.requests;

import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.models.BaseCmbPurchaseRequest;
import java.util.HashMap;
import java.util.Map;

public class BoostPurchaseRequest extends BaseCmbPurchaseRequest<Object> {
    public BoostPurchaseRequest(Price price, int i10) {
        super(PurchaseType.BOOST, price, i10);
    }

    public Class getListenerType() {
        return Object.class;
    }

    public Map<String, String> getPurchaseIds() {
        return new HashMap();
    }
}
