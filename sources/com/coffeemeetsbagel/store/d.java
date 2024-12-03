package com.coffeemeetsbagel.store;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class d implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36783a;

    public /* synthetic */ d(Function1 function1) {
        this.f36783a = function1;
    }

    public final Object apply(Object obj) {
        return BuyBeansUseCase.p(this.f36783a, obj);
    }
}
