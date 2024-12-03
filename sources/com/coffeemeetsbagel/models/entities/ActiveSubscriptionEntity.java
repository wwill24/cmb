package com.coffeemeetsbagel.models.entities;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.jvm.internal.j;

public final class ActiveSubscriptionEntity {
    private final boolean autoRenew;
    private final List<String> benefits;
    private final String bundleId;
    private final String expiryDate;
    private final String purchaseToken;
    private final String sku;
    private final String startDate;
    private final SubscriptionState subscriptionState;
    private final int tier;

    public ActiveSubscriptionEntity(boolean z10, List<String> list, String str, String str2, String str3, String str4, SubscriptionState subscriptionState2, int i10, String str5) {
        j.g(list, "benefits");
        j.g(str2, "sku");
        j.g(str3, "startDate");
        j.g(str4, "bundleId");
        j.g(str5, SDKConstants.PARAM_PURCHASE_TOKEN);
        this.autoRenew = z10;
        this.benefits = list;
        this.expiryDate = str;
        this.sku = str2;
        this.startDate = str3;
        this.bundleId = str4;
        this.subscriptionState = subscriptionState2;
        this.tier = i10;
        this.purchaseToken = str5;
    }

    public final boolean getAutoRenew() {
        return this.autoRenew;
    }

    public final List<String> getBenefits() {
        return this.benefits;
    }

    public final String getBundleId() {
        return this.bundleId;
    }

    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final String getSku() {
        return this.sku;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final SubscriptionState getSubscriptionState() {
        return this.subscriptionState;
    }

    public final int getTier() {
        return this.tier;
    }
}
