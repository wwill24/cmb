package com.coffeemeetsbagel.store;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class e implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36802a;

    public /* synthetic */ e(Function1 function1) {
        this.f36802a = function1;
    }

    public final void accept(Object obj) {
        BuyBeansUseCase.q(this.f36802a, obj);
    }
}
