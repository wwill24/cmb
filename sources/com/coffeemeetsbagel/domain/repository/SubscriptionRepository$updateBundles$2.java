package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.SubscriptionBundleEntity;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;

final class SubscriptionRepository$updateBundles$2 extends Lambda implements Function1<List<? extends SubscriptionBundleEntity>, f> {
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$updateBundles$2(SubscriptionRepository subscriptionRepository) {
        super(1);
        this.this$0 = subscriptionRepository;
    }

    /* renamed from: a */
    public final f invoke(List<SubscriptionBundleEntity> list) {
        j.g(list, "entities");
        return this.this$0.f12432f.c(list);
    }
}
