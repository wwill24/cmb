package com.coffeemeetsbagel.store;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class z implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f37007a;

    public /* synthetic */ z(Function1 function1) {
        this.f37007a = function1;
    }

    public final Object apply(Object obj) {
        return GetSubscriptionBundlesUseCase.i(this.f37007a, obj);
    }
}
