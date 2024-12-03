package com.coffeemeetsbagel.store;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class c implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36780a;

    public /* synthetic */ c(Function1 function1) {
        this.f36780a = function1;
    }

    public final Object apply(Object obj) {
        return BuyBeansUseCase.o(this.f36780a, obj);
    }
}
