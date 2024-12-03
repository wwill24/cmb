package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.models.entities.ActiveSubscriptionEntity;
import com.coffeemeetsbagel.models.entities.SubscriptionState;
import com.coffeemeetsbagel.subscription.network.models.NetworkActiveSubscription;
import com.coffeemeetsbagel.subscription.network.models.NetworkActiveSubscriptionAndroid;
import java.util.List;
import kotlin.jvm.internal.j;
import vb.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f36745a = new a();

    private a() {
    }

    public final vb.a a(ActiveSubscriptionEntity activeSubscriptionEntity, List<b> list) {
        j.g(activeSubscriptionEntity, "entity");
        j.g(list, "benefits");
        return new vb.a(activeSubscriptionEntity.getAutoRenew(), list, activeSubscriptionEntity.getExpiryDate(), activeSubscriptionEntity.getSku(), activeSubscriptionEntity.getStartDate(), activeSubscriptionEntity.getSubscriptionState(), activeSubscriptionEntity.getBundleId(), activeSubscriptionEntity.getTier(), activeSubscriptionEntity.getPurchaseToken());
    }

    public final ActiveSubscriptionEntity b(NetworkActiveSubscription networkActiveSubscription) {
        String str;
        j.g(networkActiveSubscription, "activeSubscriptionData");
        boolean autoRenew = networkActiveSubscription.getAutoRenew();
        List<String> benefits = networkActiveSubscription.getBenefits();
        String expiryDate = networkActiveSubscription.getExpiryDate();
        String sku = networkActiveSubscription.getSku();
        String startDate = networkActiveSubscription.getStartDate();
        SubscriptionState fromApiKey = SubscriptionState.Companion.fromApiKey(networkActiveSubscription.getSubscription_state_android());
        String bundleId = networkActiveSubscription.getBundleId();
        int tier = networkActiveSubscription.getTier();
        NetworkActiveSubscriptionAndroid androidData = networkActiveSubscription.getAndroidData();
        if (androidData == null || (str = androidData.getPurchaseToken()) == null) {
            str = "";
        }
        return new ActiveSubscriptionEntity(autoRenew, benefits, expiryDate, sku, startDate, bundleId, fromApiKey, tier, str);
    }
}
