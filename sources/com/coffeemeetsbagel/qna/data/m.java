package com.coffeemeetsbagel.qna.data;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class m implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36264a;

    public /* synthetic */ m(Function1 function1) {
        this.f36264a = function1;
    }

    public final Object apply(Object obj) {
        return QuestionRepository.N(this.f36264a, obj);
    }
}
