package com.coffeemeetsbagel.products.my_answers.presentation;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MyAnswersInteractor$refresh$4 extends Lambda implements Function1<Pair<? extends Integer, ? extends List<? extends QuestionWAnswers>>, Unit> {
    final /* synthetic */ MyAnswersInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyAnswersInteractor$refresh$4(MyAnswersInteractor myAnswersInteractor) {
        super(1);
        this.this$0 = myAnswersInteractor;
    }

    public final void a(Pair<Integer, ? extends List<QuestionWAnswers>> pair) {
        Integer c10 = pair.c();
        j.f(c10, "pair.first");
        this.this$0.q2((List) pair.d(), c10.intValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
