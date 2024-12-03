package com.coffeemeetsbagel.store.alc;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class f implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36772a;

    public /* synthetic */ f(Function1 function1) {
        this.f36772a = function1;
    }

    public final Object apply(Object obj) {
        return PurchaseRepository.g(this.f36772a, obj);
    }
}
