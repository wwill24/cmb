package com.coffeemeetsbagel.shop.subscription_comparison;

import com.coffeemeetsbagel.store.GetSubscriptionBundlesUseCase;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class SubscriptionComparisonInteractor$didBecomeActive$1 extends Lambda implements Function1<GetSubscriptionBundlesUseCase.a, Unit> {
    final /* synthetic */ SubscriptionComparisonInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionComparisonInteractor$didBecomeActive$1(SubscriptionComparisonInteractor subscriptionComparisonInteractor) {
        super(1);
        this.this$0 = subscriptionComparisonInteractor;
    }

    public final void a(GetSubscriptionBundlesUseCase.a aVar) {
        a.f40771d.a(this.this$0.M1(), "getActiveSubscription changed. ");
        ((i) this.this$0.f7875e).k(aVar.c(), aVar.b().g(), this.this$0.f36616h);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((GetSubscriptionBundlesUseCase.a) obj);
        return Unit.f32013a;
    }
}
