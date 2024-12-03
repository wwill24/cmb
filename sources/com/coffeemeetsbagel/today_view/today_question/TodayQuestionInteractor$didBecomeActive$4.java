package com.coffeemeetsbagel.today_view.today_question;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class TodayQuestionInteractor$didBecomeActive$4 extends Lambda implements Function1<QuestionWAnswers, Unit> {
    final /* synthetic */ TodayQuestionInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TodayQuestionInteractor$didBecomeActive$4(TodayQuestionInteractor todayQuestionInteractor) {
        super(1);
        this.this$0 = todayQuestionInteractor;
    }

    public final void a(QuestionWAnswers questionWAnswers) {
        TodayQuestionInteractor todayQuestionInteractor = this.this$0;
        j.f(questionWAnswers, "firstQuestion");
        todayQuestionInteractor.r2(questionWAnswers);
        ((TodayQuestionPresenter) this.this$0.f7875e).w(questionWAnswers.e().getText(), questionWAnswers.e().getOptions(), questionWAnswers.d(), this.this$0.X1(questionWAnswers.e()));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((QuestionWAnswers) obj);
        return Unit.f32013a;
    }
}
