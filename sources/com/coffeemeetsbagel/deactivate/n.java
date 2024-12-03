package com.coffeemeetsbagel.deactivate;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class n implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12026a;

    public /* synthetic */ n(Function1 function1) {
        this.f12026a = function1;
    }

    public final void accept(Object obj) {
        DeactivateCompRouter.w(this.f12026a, obj);
    }
}
