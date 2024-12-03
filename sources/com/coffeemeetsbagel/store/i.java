package com.coffeemeetsbagel.store;

import com.android.billingclient.api.Purchase;
import java.util.concurrent.Callable;

public final /* synthetic */ class i implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Purchase f36812a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BuyBeansUseCase f36813b;

    public /* synthetic */ i(Purchase purchase, BuyBeansUseCase buyBeansUseCase) {
        this.f36812a = purchase;
        this.f36813b = buyBeansUseCase;
    }

    public final Object call() {
        return BuyBeansUseCase.x(this.f36812a, this.f36813b);
    }
}
