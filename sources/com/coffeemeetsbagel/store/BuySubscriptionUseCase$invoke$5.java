package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.google_play.BillingUserCancelled;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class BuySubscriptionUseCase$invoke$5 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ BuySubscriptionUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuySubscriptionUseCase$invoke$5(BuySubscriptionUseCase buySubscriptionUseCase) {
        super(1);
        this.this$0 = buySubscriptionUseCase;
    }

    public final void a(Throwable th2) {
        if ((th2 instanceof BillingUserCancelled) || (th2.getCause() instanceof BillingUserCancelled)) {
            this.this$0.f36692e = BuySubscriptionUseCase.TrackingStep.GOOGLE_PLAY_CANCELLED;
            return;
        }
        a.C0491a aVar = a.f40771d;
        String k10 = this.this$0.k();
        j.f(th2, "throwable");
        aVar.c(k10, "Failed to purchase subscription.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
