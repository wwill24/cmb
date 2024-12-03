package com.coffeemeetsbagel.qna;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class l implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36299a;

    public /* synthetic */ l(Function1 function1) {
        this.f36299a = function1;
    }

    public final Object apply(Object obj) {
        return GetTextAnswersUseCase.c(this.f36299a, obj);
    }
}
