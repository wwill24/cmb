package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.subscription.network.models.SubscriptionResponse;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;

final class SubscriptionRepository$refreshSubscriptions$1 extends Lambda implements Function1<SubscriptionResponse, f> {
    final /* synthetic */ boolean $refreshBenefits;
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$refreshSubscriptions$1(SubscriptionRepository subscriptionRepository, boolean z10) {
        super(1);
        this.this$0 = subscriptionRepository;
        this.$refreshBenefits = z10;
    }

    /* renamed from: a */
    public final f invoke(SubscriptionResponse subscriptionResponse) {
        j.g(subscriptionResponse, "response");
        return this.this$0.x0(this.$refreshBenefits, subscriptionResponse.getData());
    }
}
