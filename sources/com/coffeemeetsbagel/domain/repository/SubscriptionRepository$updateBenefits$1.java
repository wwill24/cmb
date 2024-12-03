package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SubscriptionRepository$updateBenefits$1 extends Lambda implements Function1<Long, Boolean> {
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$updateBenefits$1(SubscriptionRepository subscriptionRepository) {
        super(1);
        this.this$0 = subscriptionRepository;
    }

    /* renamed from: a */
    public final Boolean invoke(Long l10) {
        j.g(l10, "timestamp");
        return Boolean.valueOf(l10.longValue() < System.currentTimeMillis() - this.this$0.f12435i);
    }
}
