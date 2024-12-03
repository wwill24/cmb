package com.coffeemeetsbagel.qna;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class a0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36228a;

    public /* synthetic */ a0(Function1 function1) {
        this.f36228a = function1;
    }

    public final Object apply(Object obj) {
        return SaveAnswerUseCase.e(this.f36228a, obj);
    }
}
