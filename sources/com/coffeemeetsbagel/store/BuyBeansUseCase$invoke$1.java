package com.coffeemeetsbagel.store;

import com.android.billingclient.api.Purchase;
import com.coffeemeetsbagel.store.BuyBeansUseCase;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class BuyBeansUseCase$invoke$1 extends Lambda implements Function1<Purchase, b0<? extends Pair<? extends Integer, ? extends Purchase>>> {
    final /* synthetic */ BuyBeansUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuyBeansUseCase$invoke$1(BuyBeansUseCase buyBeansUseCase) {
        super(1);
        this.this$0 = buyBeansUseCase;
    }

    /* renamed from: a */
    public final b0<? extends Pair<Integer, Purchase>> invoke(Purchase purchase) {
        j.g(purchase, "purchase");
        this.this$0.f36679g = BuyBeansUseCase.TrackingStep.SENDING_RECEIPT;
        return this.this$0.w(purchase);
    }
}
