package com.coffeemeetsbagel.store;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class y implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f37006a;

    public /* synthetic */ y(Function1 function1) {
        this.f37006a = function1;
    }

    public final Object apply(Object obj) {
        return GetSubscriptionBundlesUseCase.k(this.f37006a, obj);
    }
}
