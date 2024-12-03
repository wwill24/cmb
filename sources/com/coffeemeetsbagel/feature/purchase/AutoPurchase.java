package com.coffeemeetsbagel.feature.purchase;

import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.j;

public final class AutoPurchase {
    private final int expectedPrice;
    private final int itemCount;
    private final String matchId;
    private final Price price;
    private final PurchaseType purchaseType;

    public AutoPurchase(PurchaseType purchaseType2, int i10, Price price2, int i11, String str) {
        j.g(purchaseType2, "purchaseType");
        j.g(price2, FirebaseAnalytics.Param.PRICE);
        j.g(str, "matchId");
        this.purchaseType = purchaseType2;
        this.itemCount = i10;
        this.price = price2;
        this.expectedPrice = i11;
        this.matchId = str;
    }

    public static /* synthetic */ AutoPurchase copy$default(AutoPurchase autoPurchase, PurchaseType purchaseType2, int i10, Price price2, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            purchaseType2 = autoPurchase.purchaseType;
        }
        if ((i12 & 2) != 0) {
            i10 = autoPurchase.itemCount;
        }
        int i13 = i10;
        if ((i12 & 4) != 0) {
            price2 = autoPurchase.price;
        }
        Price price3 = price2;
        if ((i12 & 8) != 0) {
            i11 = autoPurchase.expectedPrice;
        }
        int i14 = i11;
        if ((i12 & 16) != 0) {
            str = autoPurchase.matchId;
        }
        return autoPurchase.copy(purchaseType2, i13, price3, i14, str);
    }

    public final PurchaseType component1() {
        return this.purchaseType;
    }

    public final int component2() {
        return this.itemCount;
    }

    public final Price component3() {
        return this.price;
    }

    public final int component4() {
        return this.expectedPrice;
    }

    public final String component5() {
        return this.matchId;
    }

    public final AutoPurchase copy(PurchaseType purchaseType2, int i10, Price price2, int i11, String str) {
        j.g(purchaseType2, "purchaseType");
        j.g(price2, FirebaseAnalytics.Param.PRICE);
        j.g(str, "matchId");
        return new AutoPurchase(purchaseType2, i10, price2, i11, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutoPurchase)) {
            return false;
        }
        AutoPurchase autoPurchase = (AutoPurchase) obj;
        return this.purchaseType == autoPurchase.purchaseType && this.itemCount == autoPurchase.itemCount && j.b(this.price, autoPurchase.price) && this.expectedPrice == autoPurchase.expectedPrice && j.b(this.matchId, autoPurchase.matchId);
    }

    public final int getExpectedPrice() {
        return this.expectedPrice;
    }

    public final int getItemCount() {
        return this.itemCount;
    }

    public final String getMatchId() {
        return this.matchId;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final PurchaseType getPurchaseType() {
        return this.purchaseType;
    }

    public int hashCode() {
        return (((((((this.purchaseType.hashCode() * 31) + Integer.hashCode(this.itemCount)) * 31) + this.price.hashCode()) * 31) + Integer.hashCode(this.expectedPrice)) * 31) + this.matchId.hashCode();
    }

    public String toString() {
        PurchaseType purchaseType2 = this.purchaseType;
        int i10 = this.itemCount;
        Price price2 = this.price;
        int i11 = this.expectedPrice;
        String str = this.matchId;
        return "AutoPurchase(purchaseType=" + purchaseType2 + ", itemCount=" + i10 + ", price=" + price2 + ", expectedPrice=" + i11 + ", matchId=" + str + ")";
    }
}
