package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.SubscriptionEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;

final class SubscriptionRepository$getPricesForVariants$1 extends Lambda implements Function1<List<? extends SubscriptionEntity>, f> {
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$getPricesForVariants$1(SubscriptionRepository subscriptionRepository) {
        super(1);
        this.this$0 = subscriptionRepository;
    }

    /* renamed from: a */
    public final f invoke(List<SubscriptionEntity> list) {
        j.g(list, "variantList");
        SubscriptionRepository subscriptionRepository = this.this$0;
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (SubscriptionEntity sku : list) {
            arrayList.add(sku.getSku());
        }
        return subscriptionRepository.O(arrayList);
    }
}
