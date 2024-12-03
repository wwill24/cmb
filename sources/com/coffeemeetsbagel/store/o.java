package com.coffeemeetsbagel.store;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class o implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36823a;

    public /* synthetic */ o(Function1 function1) {
        this.f36823a = function1;
    }

    public final void accept(Object obj) {
        BuySubscriptionUseCase.q(this.f36823a, obj);
    }
}
