package com.coffeemeetsbagel.products.my_answers.presentation;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MyAnswersInteractor$didBecomeActive$2 extends Lambda implements Function1<Pair<? extends QuestionWAnswers, ? extends Integer>, Unit> {
    final /* synthetic */ MyAnswersInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyAnswersInteractor$didBecomeActive$2(MyAnswersInteractor myAnswersInteractor) {
        super(1);
        this.this$0 = myAnswersInteractor;
    }

    public final void a(Pair<QuestionWAnswers, Integer> pair) {
        j.f(pair, "questionWAnswerNPostion");
        ((j0) this.this$0.B1()).r(pair);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
