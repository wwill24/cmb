package com.coffeemeetsbagel.qna.data;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class o implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36270a;

    public /* synthetic */ o(Function1 function1) {
        this.f36270a = function1;
    }

    public final Object apply(Object obj) {
        return QuestionRepository$fetch$1.e(this.f36270a, obj);
    }
}
