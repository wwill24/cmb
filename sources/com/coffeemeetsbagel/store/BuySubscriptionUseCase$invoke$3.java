package com.coffeemeetsbagel.store;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tj.b;

final class BuySubscriptionUseCase$invoke$3 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ String $productSku;
    final /* synthetic */ BuySubscriptionUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuySubscriptionUseCase$invoke$3(BuySubscriptionUseCase buySubscriptionUseCase, String str) {
        super(1);
        this.this$0 = buySubscriptionUseCase;
        this.$productSku = str;
    }

    public final void a(b bVar) {
        a.C0491a aVar = a.f40771d;
        String k10 = this.this$0.k();
        String str = this.$productSku;
        aVar.a(k10, "Beginning subscription process: " + str + ".");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((b) obj);
        return Unit.f32013a;
    }
}
