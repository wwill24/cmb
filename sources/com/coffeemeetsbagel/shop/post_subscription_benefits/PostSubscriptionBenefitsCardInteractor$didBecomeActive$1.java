package com.coffeemeetsbagel.shop.post_subscription_benefits;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PostSubscriptionBenefitsCardInteractor$didBecomeActive$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ PostSubscriptionBenefitsCardInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostSubscriptionBenefitsCardInteractor$didBecomeActive$1(PostSubscriptionBenefitsCardInteractor postSubscriptionBenefitsCardInteractor) {
        super(1);
        this.this$0 = postSubscriptionBenefitsCardInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String Q1 = this.this$0.Q1();
        j.f(th2, "throwable");
        aVar.c(Q1, "Unable to show expiration date.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
