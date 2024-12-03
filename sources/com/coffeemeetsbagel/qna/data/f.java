package com.coffeemeetsbagel.qna.data;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class f implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36252a;

    public /* synthetic */ f(Function1 function1) {
        this.f36252a = function1;
    }

    public final Object apply(Object obj) {
        return QuestionRepository.Q(this.f36252a, obj);
    }
}
