package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.google_play.BillingUserCancelled;
import com.coffeemeetsbagel.store.BuyBeansUseCase;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class BuyBeansUseCase$invoke$5 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ String $productSku;
    final /* synthetic */ PurchaseSource $source;
    final /* synthetic */ BuyBeansUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuyBeansUseCase$invoke$5(BuyBeansUseCase buyBeansUseCase, String str, PurchaseSource purchaseSource) {
        super(1);
        this.this$0 = buyBeansUseCase;
        this.$productSku = str;
        this.$source = purchaseSource;
    }

    public final void a(Throwable th2) {
        if (th2.getCause() instanceof BillingUserCancelled) {
            this.this$0.f36679g = BuyBeansUseCase.TrackingStep.GOOGLE_PLAY_CANCELLED;
            return;
        }
        j.f(th2, "throwable");
        a.f40771d.c(this.this$0.m(), "Failed purchase: " + this.$productSku + ", source: " + this.$source + " ", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
