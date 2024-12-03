package com.coffeemeetsbagel.store.premium_upsell;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PremiumUpsellInteractor$didBecomeActive$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ PremiumUpsellInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PremiumUpsellInteractor$didBecomeActive$2(PremiumUpsellInteractor premiumUpsellInteractor) {
        super(1);
        this.this$0 = premiumUpsellInteractor;
    }

    public final void a(Throwable th2) {
        PremiumUpsellInteractor premiumUpsellInteractor = this.this$0;
        j.f(th2, "it");
        premiumUpsellInteractor.e2(th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
