package com.coffeemeetsbagel.store;

import com.android.billingclient.api.Purchase;
import com.coffeemeetsbagel.store.BuyBeansUseCase;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class BuyBeansUseCase$invoke$2 extends Lambda implements Function1<Pair<? extends Integer, ? extends Purchase>, b0<? extends Integer>> {
    final /* synthetic */ BuyBeansUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuyBeansUseCase$invoke$2(BuyBeansUseCase buyBeansUseCase) {
        super(1);
        this.this$0 = buyBeansUseCase;
    }

    /* renamed from: a */
    public final b0<? extends Integer> invoke(Pair<Integer, ? extends Purchase> pair) {
        j.g(pair, "pair");
        this.this$0.f36679g = BuyBeansUseCase.TrackingStep.SENDING_CONSUME;
        return this.this$0.f36673a.g((Purchase) pair.d()).J(pair.c());
    }
}
