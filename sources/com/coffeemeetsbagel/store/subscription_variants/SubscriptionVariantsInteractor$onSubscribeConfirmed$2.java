package com.coffeemeetsbagel.store.subscription_variants;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SubscriptionVariantsInteractor$onSubscribeConfirmed$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ SubscriptionVariantsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionVariantsInteractor$onSubscribeConfirmed$2(SubscriptionVariantsInteractor subscriptionVariantsInteractor) {
        super(1);
        this.this$0 = subscriptionVariantsInteractor;
    }

    public final void a(Throwable th2) {
        SubscriptionVariantsInteractor subscriptionVariantsInteractor = this.this$0;
        j.f(th2, "throwable");
        subscriptionVariantsInteractor.T1(th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
