package com.coffeemeetsbagel.store;

import com.android.billingclient.api.Purchase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;

final class BuySubscriptionUseCase$invoke$2 extends Lambda implements Function1<Purchase, f> {
    final /* synthetic */ BuySubscriptionUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuySubscriptionUseCase$invoke$2(BuySubscriptionUseCase buySubscriptionUseCase) {
        super(1);
        this.this$0 = buySubscriptionUseCase;
    }

    /* renamed from: a */
    public final f invoke(Purchase purchase) {
        j.g(purchase, "purchase");
        this.this$0.f36692e = BuySubscriptionUseCase.TrackingStep.SENDING_ACKNOWLEDGEMENT;
        return this.this$0.f36688a.N(purchase);
    }
}
