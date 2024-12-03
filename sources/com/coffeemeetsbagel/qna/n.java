package com.coffeemeetsbagel.qna;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class n implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36301a;

    public /* synthetic */ n(Function1 function1) {
        this.f36301a = function1;
    }

    public final Object apply(Object obj) {
        return GetUserMCQUseCase.d(this.f36301a, obj);
    }
}
