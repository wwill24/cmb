package com.coffeemeetsbagel.store;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class l implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36816a;

    public /* synthetic */ l(Function1 function1) {
        this.f36816a = function1;
    }

    public final Object apply(Object obj) {
        return BuySubscriptionUseCase.n(this.f36816a, obj);
    }
}
