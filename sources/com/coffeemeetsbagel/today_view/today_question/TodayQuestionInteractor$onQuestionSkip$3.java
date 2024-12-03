package com.coffeemeetsbagel.today_view.today_question;

import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class TodayQuestionInteractor$onQuestionSkip$3 extends Lambda implements Function1<ResponseGeneric, Unit> {
    final /* synthetic */ TodayQuestionInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TodayQuestionInteractor$onQuestionSkip$3(TodayQuestionInteractor todayQuestionInteractor) {
        super(1);
        this.this$0 = todayQuestionInteractor;
    }

    public final void a(ResponseGeneric responseGeneric) {
        this.this$0.h2().h();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((ResponseGeneric) obj);
        return Unit.f32013a;
    }
}
