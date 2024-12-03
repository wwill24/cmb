package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.models.BeansPurchaseRedemptionData;
import com.coffeemeetsbagel.models.Price;
import java.util.HashMap;
import java.util.Map;

public class ResponseBeansVerification extends ResponseGeneric {
    private boolean didEarnUnlimitedBeans;
    private int newBeans;
    private BeansPurchaseRedemptionData redemption_data;
    private int spent;
    private String unlimitedBeansExpirationDate;
    private Map<String, Price> updatedItems;

    public int getNewBeans() {
        return this.newBeans;
    }

    public BeansPurchaseRedemptionData getRedemptionData() {
        return this.redemption_data;
    }

    public int getSpent() {
        return this.spent;
    }

    public Map<String, Price> getUpdatedItems() {
        Map<String, Price> map = this.updatedItems;
        if (map != null) {
            return map;
        }
        return new HashMap();
    }

    public int getUpdatedItemsSize() {
        Map<String, Price> map = this.updatedItems;
        if (map == null) {
            return 0;
        }
        return map.size();
    }
}
