package com.coffeemeetsbagel.products.my_answers.presentation;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class z implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f35903a;

    public /* synthetic */ z(Function1 function1) {
        this.f35903a = function1;
    }

    public final void accept(Object obj) {
        MyAnswersInteractor.v2(this.f35903a, obj);
    }
}
