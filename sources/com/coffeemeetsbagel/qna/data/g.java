package com.coffeemeetsbagel.qna.data;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36253a;

    public /* synthetic */ g(Function1 function1) {
        this.f36253a = function1;
    }

    public final void accept(Object obj) {
        QuestionRepository.T(this.f36253a, obj);
    }
}
