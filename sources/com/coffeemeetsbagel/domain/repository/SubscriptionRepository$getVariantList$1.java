package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.RewardPrice;
import com.coffeemeetsbagel.models.entities.SubscriptionEntity;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class SubscriptionRepository$getVariantList$1 extends Lambda implements Function1<List<? extends SubscriptionEntity>, b0<? extends List<? extends Pair<? extends SubscriptionEntity, ? extends RewardPrice>>>> {
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$getVariantList$1(SubscriptionRepository subscriptionRepository) {
        super(1);
        this.this$0 = subscriptionRepository;
    }

    /* renamed from: a */
    public final b0<? extends List<Pair<SubscriptionEntity, RewardPrice>>> invoke(List<SubscriptionEntity> list) {
        j.g(list, "entityList");
        return this.this$0.c0(list);
    }
}
