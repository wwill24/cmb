package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.BenefitEntity;
import com.coffeemeetsbagel.models.entities.SubscriptionBundleEntity;
import com.coffeemeetsbagel.store.v0;
import com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundle;
import com.coffeemeetsbagel.subscription.network.models.SubscriptionResponseData;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SubscriptionRepository$updateBundles$1 extends Lambda implements Function1<List<? extends BenefitEntity>, List<? extends SubscriptionBundleEntity>> {
    final /* synthetic */ SubscriptionResponseData $data;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$updateBundles$1(SubscriptionResponseData subscriptionResponseData) {
        super(1);
        this.$data = subscriptionResponseData;
    }

    /* renamed from: a */
    public final List<SubscriptionBundleEntity> invoke(List<BenefitEntity> list) {
        j.g(list, "benefitList");
        List<NetworkSubscriptionBundle> subscriptionBundles = this.$data.getSubscriptionBundles();
        ArrayList arrayList = new ArrayList(r.t(subscriptionBundles, 10));
        for (NetworkSubscriptionBundle networkSubscriptionBundle : subscriptionBundles) {
            ArrayList<BenefitEntity> arrayList2 = new ArrayList<>();
            for (T next : list) {
                if (networkSubscriptionBundle.getBenefits().contains(((BenefitEntity) next).getKey())) {
                    arrayList2.add(next);
                }
            }
            ArrayList arrayList3 = new ArrayList(r.t(arrayList2, 10));
            for (BenefitEntity deepLinkTags : arrayList2) {
                arrayList3.add(deepLinkTags.getDeepLinkTags());
            }
            arrayList.add(v0.f37002a.b(r.u(arrayList3), networkSubscriptionBundle));
        }
        return arrayList;
    }
}
