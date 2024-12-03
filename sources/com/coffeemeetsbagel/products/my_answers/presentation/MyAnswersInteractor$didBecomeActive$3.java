package com.coffeemeetsbagel.products.my_answers.presentation;

import c6.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MyAnswersInteractor$didBecomeActive$3 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ MyAnswersInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyAnswersInteractor$didBecomeActive$3(MyAnswersInteractor myAnswersInteractor) {
        super(1);
        this.this$0 = myAnswersInteractor;
    }

    public final void a(a aVar) {
        if (aVar.b() == 9302 && aVar.c() == 41123) {
            this.this$0.r2(true);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((a) obj);
        return Unit.f32013a;
    }
}
