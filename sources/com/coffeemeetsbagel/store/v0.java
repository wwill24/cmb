package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.models.entities.SubscriptionBundleEntity;
import com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundle;
import com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundleVariant;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import vb.b;
import vb.c;
import vb.d;

public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    public static final v0 f37002a = new v0();

    private v0() {
    }

    public final c a(SubscriptionBundleEntity subscriptionBundleEntity, List<b> list, List<d> list2) {
        j.g(subscriptionBundleEntity, "entity");
        j.g(list, "benefits");
        j.g(list2, "variant");
        return new c(subscriptionBundleEntity.getIntents(), list, list2, subscriptionBundleEntity.getId(), subscriptionBundleEntity.getName(), subscriptionBundleEntity.getTier());
    }

    public final SubscriptionBundleEntity b(List<String> list, NetworkSubscriptionBundle networkSubscriptionBundle) {
        j.g(list, "intents");
        j.g(networkSubscriptionBundle, "bundle");
        List<String> benefits = networkSubscriptionBundle.getBenefits();
        String id2 = networkSubscriptionBundle.getId();
        String displayName = networkSubscriptionBundle.getDisplayName();
        int tier = networkSubscriptionBundle.getTier();
        List<NetworkSubscriptionBundleVariant> variants = networkSubscriptionBundle.getVariants();
        ArrayList arrayList = new ArrayList(r.t(variants, 10));
        for (NetworkSubscriptionBundleVariant sku : variants) {
            arrayList.add(sku.getSku());
        }
        return new SubscriptionBundleEntity(id2, displayName, tier, list, benefits, arrayList);
    }
}
