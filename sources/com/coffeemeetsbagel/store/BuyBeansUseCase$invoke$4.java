package com.coffeemeetsbagel.store;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tj.b;

final class BuyBeansUseCase$invoke$4 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ String $productSku;
    final /* synthetic */ BuyBeansUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuyBeansUseCase$invoke$4(BuyBeansUseCase buyBeansUseCase, String str) {
        super(1);
        this.this$0 = buyBeansUseCase;
        this.$productSku = str;
    }

    public final void a(b bVar) {
        a.C0491a aVar = a.f40771d;
        String m10 = this.this$0.m();
        String str = this.$productSku;
        aVar.a(m10, "Starting purchase " + str + ".");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((b) obj);
        return Unit.f32013a;
    }
}
