package com.coffeemeetsbagel.feature.bagel;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class w implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12796a;

    public /* synthetic */ w(Function1 function1) {
        this.f12796a = function1;
    }

    public final Object apply(Object obj) {
        return UpdateBagelLocalUseCase.f(this.f12796a, obj);
    }
}
