package com.coffeemeetsbagel.store;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class x implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f37005a;

    public /* synthetic */ x(Function1 function1) {
        this.f37005a = function1;
    }

    public final Object apply(Object obj) {
        return GetSubscriptionBundlesUseCase.o(this.f37005a, obj);
    }
}
