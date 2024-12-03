package com.coffeemeetsbagel.store;

import com.android.billingclient.api.Purchase;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;
import qj.w;

/* synthetic */ class BuySubscriptionUseCase$invoke$1 extends FunctionReferenceImpl implements Function1<Purchase, w<Purchase>> {
    BuySubscriptionUseCase$invoke$1(Object obj) {
        super(1, obj, BuySubscriptionUseCase.class, "uploadSubscription", "uploadSubscription(Lcom/android/billingclient/api/Purchase;)Lio/reactivex/Single;", 0);
    }

    /* renamed from: c */
    public final w<Purchase> invoke(Purchase purchase) {
        j.g(purchase, "p0");
        return ((BuySubscriptionUseCase) this.receiver).u(purchase);
    }
}
