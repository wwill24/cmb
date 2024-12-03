package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.store.BuyBeansUseCase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class BuyBeansUseCase$invoke$3 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ BuyBeansUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuyBeansUseCase$invoke$3(BuyBeansUseCase buyBeansUseCase) {
        super(1);
        this.this$0 = buyBeansUseCase;
    }

    public final void a(Integer num) {
        this.this$0.f36679g = BuyBeansUseCase.TrackingStep.CONSUME_SUCCESS;
        BuyBeansUseCase buyBeansUseCase = this.this$0;
        j.f(num, "it");
        buyBeansUseCase.u(num.intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Integer) obj);
        return Unit.f32013a;
    }
}
