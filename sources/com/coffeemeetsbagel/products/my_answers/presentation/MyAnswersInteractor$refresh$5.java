package com.coffeemeetsbagel.products.my_answers.presentation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MyAnswersInteractor$refresh$5 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ MyAnswersInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyAnswersInteractor$refresh$5(MyAnswersInteractor myAnswersInteractor) {
        super(1);
        this.this$0 = myAnswersInteractor;
    }

    public final void a(Throwable th2) {
        MyAnswersInteractor myAnswersInteractor = this.this$0;
        j.f(th2, "it");
        myAnswersInteractor.p2(th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
