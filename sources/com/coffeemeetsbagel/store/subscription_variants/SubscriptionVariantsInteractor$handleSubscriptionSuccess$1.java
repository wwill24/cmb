package com.coffeemeetsbagel.store.subscription_variants;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tj.b;

final class SubscriptionVariantsInteractor$handleSubscriptionSuccess$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ SubscriptionVariantsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionVariantsInteractor$handleSubscriptionSuccess$1(SubscriptionVariantsInteractor subscriptionVariantsInteractor) {
        super(1);
        this.this$0 = subscriptionVariantsInteractor;
    }

    public final void a(b bVar) {
        ((SubscriptionVariantsRouter) this.this$0.B1()).q(true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((b) obj);
        return Unit.f32013a;
    }
}
