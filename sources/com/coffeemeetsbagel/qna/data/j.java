package com.coffeemeetsbagel.qna.data;

import kotlin.jvm.functions.Function1;

public final /* synthetic */ class j implements vj.j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36256a;

    public /* synthetic */ j(Function1 function1) {
        this.f36256a = function1;
    }

    public final Object apply(Object obj) {
        return QuestionRepository.W(this.f36256a, obj);
    }
}
