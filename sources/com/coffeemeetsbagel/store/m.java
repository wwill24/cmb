package com.coffeemeetsbagel.store;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class m implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36817a;

    public /* synthetic */ m(Function1 function1) {
        this.f36817a = function1;
    }

    public final void accept(Object obj) {
        BuySubscriptionUseCase.o(this.f36817a, obj);
    }
}
