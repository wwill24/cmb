package com.coffeemeetsbagel.deactivate;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class m implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12025a;

    public /* synthetic */ m(Function1 function1) {
        this.f12025a = function1;
    }

    public final void accept(Object obj) {
        DeactivateCompPresenter.r(this.f12025a, obj);
    }
}
