package com.coffeemeetsbagel.store;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class w implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f37003a;

    public /* synthetic */ w(Function1 function1) {
        this.f37003a = function1;
    }

    public final Object apply(Object obj) {
        return GetSubscriptionBundlesUseCase.n(this.f37003a, obj);
    }
}
