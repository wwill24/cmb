package com.coffeemeetsbagel.feature.bagel;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class t implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12792a;

    public /* synthetic */ t(Function1 function1) {
        this.f12792a = function1;
    }

    public final Object apply(Object obj) {
        return GetLastPassedBagelUseCase.d(this.f12792a, obj);
    }
}
