package com.coffeemeetsbagel.qna.data;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class a implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36246a;

    public /* synthetic */ a(Function1 function1) {
        this.f36246a = function1;
    }

    public final Object apply(Object obj) {
        return QuestionRepository.P(this.f36246a, obj);
    }
}
