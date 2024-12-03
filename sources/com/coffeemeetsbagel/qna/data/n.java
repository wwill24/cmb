package com.coffeemeetsbagel.qna.data;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class n implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36265a;

    public /* synthetic */ n(Function1 function1) {
        this.f36265a = function1;
    }

    public final Object apply(Object obj) {
        return QuestionRepository.D(this.f36265a, obj);
    }
}
