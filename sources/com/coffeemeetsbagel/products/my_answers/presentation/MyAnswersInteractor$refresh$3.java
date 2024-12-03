package com.coffeemeetsbagel.products.my_answers.presentation;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import qj.p;

final class MyAnswersInteractor$refresh$3 extends Lambda implements Function1<p<Pair<? extends Integer, ? extends List<? extends QuestionWAnswers>>>, Unit> {
    final /* synthetic */ MyAnswersInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MyAnswersInteractor$refresh$3(MyAnswersInteractor myAnswersInteractor) {
        super(1);
        this.this$0 = myAnswersInteractor;
    }

    public final void a(p<Pair<Integer, List<QuestionWAnswers>>> pVar) {
        if (this.this$0.f35822f) {
            this.this$0.x2(false);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((p) obj);
        return Unit.f32013a;
    }
}
