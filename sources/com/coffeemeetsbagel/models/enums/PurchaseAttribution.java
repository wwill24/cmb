package com.coffeemeetsbagel.models.enums;

import com.coffeemeetsbagel.models.R;
import java.util.HashMap;
import java.util.Map;

public enum PurchaseAttribution {
    TAKE(1, r4, r14, r15, true),
    SKIP_THE_LINE(2, r20, R.drawable.skip_the_line, R.string.skip_the_line_attribution, true),
    PRIORITIZED_LIKE(4, r20, R.drawable.prioritized_like, R.string.priority_likes_attribution, true),
    BOOST(5, r20, R.drawable.boost_attribution, R.string.boost_attribution, false),
    DISCOVER_SEARCH(6, r1, r14, r15, true),
    INSTANT_LIKE(8, r20, R.drawable.ic_star, R.string.instant_like_attribution, true),
    PAID_LIKE(9, r20, R.drawable.flower, R.string.paid_like_attribution, true);
    
    private static final Map<Integer, PurchaseAttribution> purchaseAttributionMap = null;
    private final int chatTextId;
    private final int colorId;
    private final int drawableId;
    private final boolean isPurchased;
    private final int purchaseAttributionInteger;

    static {
        int i10;
        purchaseAttributionMap = new HashMap();
        for (PurchaseAttribution purchaseAttribution : values()) {
            purchaseAttributionMap.put(Integer.valueOf(purchaseAttribution.getPurchaseAttributionInteger()), purchaseAttribution);
        }
    }

    private PurchaseAttribution(int i10, int i11, int i12, int i13, boolean z10) {
        this.purchaseAttributionInteger = i10;
        this.colorId = i11;
        this.drawableId = i12;
        this.chatTextId = i13;
        this.isPurchased = z10;
    }

    public static PurchaseAttribution purchaseAttributionFromInteger(Integer num) {
        return purchaseAttributionMap.get(num);
    }

    public int getChatTextId() {
        return this.chatTextId;
    }

    public int getColorId() {
        return this.colorId;
    }

    public int getDrawableId() {
        return this.drawableId;
    }

    public int getPurchaseAttributionInteger() {
        return this.purchaseAttributionInteger;
    }

    public boolean isPurchased() {
        return this.isPurchased;
    }
}
