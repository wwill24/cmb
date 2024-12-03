package com.coffeemeetsbagel.qna.data;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class b implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36247a;

    public /* synthetic */ b(Function1 function1) {
        this.f36247a = function1;
    }

    public final Object apply(Object obj) {
        return QuestionRepository.E(this.f36247a, obj);
    }
}
