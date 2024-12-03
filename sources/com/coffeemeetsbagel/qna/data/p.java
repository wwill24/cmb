package com.coffeemeetsbagel.qna.data;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class p implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36271a;

    public /* synthetic */ p(Function1 function1) {
        this.f36271a = function1;
    }

    public final Object apply(Object obj) {
        return QuestionRepository$fetch$1.f(this.f36271a, obj);
    }
}
