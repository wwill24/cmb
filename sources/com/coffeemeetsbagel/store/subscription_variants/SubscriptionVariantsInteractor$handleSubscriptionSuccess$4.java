package com.coffeemeetsbagel.store.subscription_variants;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SubscriptionVariantsInteractor$handleSubscriptionSuccess$4 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ SubscriptionVariantsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionVariantsInteractor$handleSubscriptionSuccess$4(SubscriptionVariantsInteractor subscriptionVariantsInteractor) {
        super(1);
        this.this$0 = subscriptionVariantsInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String N1 = this.this$0.f36962k;
        j.f(th2, "throwable");
        aVar.c(N1, "failed to refresh subscription", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
