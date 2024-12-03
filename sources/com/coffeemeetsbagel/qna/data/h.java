package com.coffeemeetsbagel.qna.data;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class h implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36254a;

    public /* synthetic */ h(Function1 function1) {
        this.f36254a = function1;
    }

    public final Object apply(Object obj) {
        return QuestionRepository.z(this.f36254a, obj);
    }
}
