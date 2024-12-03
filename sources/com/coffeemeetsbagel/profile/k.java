package com.coffeemeetsbagel.profile;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class k implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36101a;

    public /* synthetic */ k(Function1 function1) {
        this.f36101a = function1;
    }

    public final Object apply(Object obj) {
        return LoadLocationUseCase.e(this.f36101a, obj);
    }
}
