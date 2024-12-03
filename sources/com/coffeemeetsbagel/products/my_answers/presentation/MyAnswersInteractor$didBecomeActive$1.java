package com.coffeemeetsbagel.products.my_answers.presentation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MyAnswersInteractor$didBecomeActive$1 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ MyAnswersInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyAnswersInteractor$didBecomeActive$1(MyAnswersInteractor myAnswersInteractor) {
        super(1);
        this.this$0 = myAnswersInteractor;
    }

    public final void a(Unit unit) {
        this.this$0.l2().a();
        ((j0) this.this$0.B1()).n();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Unit) obj);
        return Unit.f32013a;
    }
}
