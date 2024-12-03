package com.coffeemeetsbagel.store.models;

import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.j0;
import java.util.Map;
import lg.c;

public abstract class BaseCmbPurchaseRequest<T> implements j0<T> {
    @c("expected_price")
    protected final long expectedPrice = getExpectedPrice();
    @c("item_count")
    protected final int itemCount;
    @c("item_name")
    protected final String itemName = getCmbName();
    protected final transient Price price;
    protected final Map<String, String> purchaseIds = getPurchaseIds();
    protected final transient PurchaseType purchaseType;

    protected BaseCmbPurchaseRequest(PurchaseType purchaseType2, Price price2, int i10) {
        this.purchaseType = purchaseType2;
        this.price = price2;
        this.itemCount = i10;
    }

    public String getAnalyticsItemName() {
        return this.purchaseType.a();
    }

    public String getCmbName() {
        return this.purchaseType.d();
    }

    public long getExpectedPrice() {
        return (long) this.price.getBeanCost(this.itemCount);
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public abstract Class getListenerType();

    public abstract Map<String, String> getPurchaseIds();
}
