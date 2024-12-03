package com.coffeemeetsbagel.feature.bagel;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class x implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12797a;

    public /* synthetic */ x(Function1 function1) {
        this.f12797a = function1;
    }

    public final Object apply(Object obj) {
        return UpdateBagelLocalUseCase.g(this.f12797a, obj);
    }
}
