package com.coffeemeetsbagel.store;

import vj.a;

public final /* synthetic */ class n implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BuySubscriptionUseCase f36818a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f36819b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PurchaseSource f36820c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f36821d;

    public /* synthetic */ n(BuySubscriptionUseCase buySubscriptionUseCase, String str, PurchaseSource purchaseSource, boolean z10) {
        this.f36818a = buySubscriptionUseCase;
        this.f36819b = str;
        this.f36820c = purchaseSource;
        this.f36821d = z10;
    }

    public final void run() {
        BuySubscriptionUseCase.p(this.f36818a, this.f36819b, this.f36820c, this.f36821d);
    }
}
