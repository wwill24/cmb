package com.coffeemeetsbagel.store;

import com.android.billingclient.api.Purchase;
import qj.a0;
import qj.y;

public final /* synthetic */ class q implements a0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Purchase f36924a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BuySubscriptionUseCase f36925b;

    public /* synthetic */ q(Purchase purchase, BuySubscriptionUseCase buySubscriptionUseCase) {
        this.f36924a = purchase;
        this.f36925b = buySubscriptionUseCase;
    }

    public final void a(y yVar) {
        BuySubscriptionUseCase.v(this.f36924a, this.f36925b, yVar);
    }
}
