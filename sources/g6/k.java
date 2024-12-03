package g6;

import com.coffeemeetsbagel.models.enums.PurchaseAttribution;

public final class k {
    public final PurchaseAttribution a(Integer num) {
        if (num != null) {
            return PurchaseAttribution.purchaseAttributionFromInteger(num);
        }
        return null;
    }

    public final Integer b(PurchaseAttribution purchaseAttribution) {
        if (purchaseAttribution != null) {
            return Integer.valueOf(purchaseAttribution.getPurchaseAttributionInteger());
        }
        return null;
    }
}
