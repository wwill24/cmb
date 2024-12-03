package com.coffeemeetsbagel.store;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class e0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36803a;

    public /* synthetic */ e0(Function1 function1) {
        this.f36803a = function1;
    }

    public final Object apply(Object obj) {
        return PriceRepository.i(this.f36803a, obj);
    }
}
