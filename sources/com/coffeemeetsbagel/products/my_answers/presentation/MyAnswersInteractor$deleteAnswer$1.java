package com.coffeemeetsbagel.products.my_answers.presentation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tj.b;

final class MyAnswersInteractor$deleteAnswer$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ MyAnswersInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyAnswersInteractor$deleteAnswer$1(MyAnswersInteractor myAnswersInteractor) {
        super(1);
        this.this$0 = myAnswersInteractor;
    }

    public final void a(b bVar) {
        this.this$0.x2(true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((b) obj);
        return Unit.f32013a;
    }
}
