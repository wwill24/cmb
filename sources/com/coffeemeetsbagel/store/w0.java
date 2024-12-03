package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.models.RewardPrice;
import com.coffeemeetsbagel.models.entities.SubscriptionEntity;
import com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundleVariant;
import fa.a;
import kotlin.jvm.internal.j;
import vb.d;

public final class w0 {

    /* renamed from: a  reason: collision with root package name */
    public static final w0 f37004a = new w0();

    private w0() {
    }

    private final long a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return Long.parseLong(str) * ((long) 1000);
        } catch (NumberFormatException e10) {
            a.f40771d.c("NetworkSubscriptionBundleVariant", "Invalid sale time in json,", e10);
            return 0;
        }
    }

    public final d b(String str, SubscriptionEntity subscriptionEntity, RewardPrice rewardPrice) {
        j.g(str, "buildId");
        j.g(subscriptionEntity, "entity");
        j.g(rewardPrice, "rewardPrice");
        return new d(subscriptionEntity.getMarketingType(), subscriptionEntity.getNumberOfUnits(), subscriptionEntity.getUnit(), subscriptionEntity.getSavingsComparisonSku(), subscriptionEntity.getSku(), str, subscriptionEntity.getSaleSkuType(), subscriptionEntity.getSaleEndTimeLocal(), rewardPrice);
    }

    public final SubscriptionEntity c(String str, NetworkSubscriptionBundleVariant networkSubscriptionBundleVariant, String str2) {
        String str3 = str;
        j.g(str3, "bundleId");
        j.g(networkSubscriptionBundleVariant, "data");
        String marketingType = networkSubscriptionBundleVariant.getMarketingType();
        int numberOfUnits = networkSubscriptionBundleVariant.getNumberOfUnits();
        String unit = networkSubscriptionBundleVariant.getUnit();
        String sku = networkSubscriptionBundleVariant.getSku();
        return new SubscriptionEntity(str3, marketingType, numberOfUnits, unit, str2, networkSubscriptionBundleVariant.getSaleComparisonSku(), networkSubscriptionBundleVariant.getSaleSkuType(), a(networkSubscriptionBundleVariant.getSaleStartTimeLocal()), a(networkSubscriptionBundleVariant.getSaleEndTimeLocal()), sku);
    }
}
