package com.coffeemeetsbagel.store;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class k implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36815a;

    public /* synthetic */ k(Function1 function1) {
        this.f36815a = function1;
    }

    public final Object apply(Object obj) {
        return BuySubscriptionUseCase.m(this.f36815a, obj);
    }
}
