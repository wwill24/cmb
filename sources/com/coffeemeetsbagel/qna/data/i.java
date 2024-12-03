package com.coffeemeetsbagel.qna.data;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class i implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36255a;

    public /* synthetic */ i(Function1 function1) {
        this.f36255a = function1;
    }

    public final Object apply(Object obj) {
        return QuestionRepository.A(this.f36255a, obj);
    }
}
