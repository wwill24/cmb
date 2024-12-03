package com.coffeemeetsbagel.feature.purchase.requests;

import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.models.BaseCmbPurchaseRequest;
import java.util.HashMap;
import java.util.Map;

public class DiscoverSearchTakePurchaseRequest extends BaseCmbPurchaseRequest<Object> {
    private final transient String giveTakeId;

    public DiscoverSearchTakePurchaseRequest(Price price, int i10, String str) {
        super(PurchaseType.DISCOVER_SEARCH_RESULT, price, i10);
        this.giveTakeId = str;
    }

    public String getGiveTakeId() {
        return this.giveTakeId;
    }

    public Class getListenerType() {
        return Object.class;
    }

    public Map<String, String> getPurchaseIds() {
        HashMap hashMap = new HashMap();
        hashMap.put("discover_search_result_id", this.giveTakeId);
        return hashMap;
    }
}
