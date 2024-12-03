package com.coffeemeetsbagel.today_view.today_question;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tj.b;

final class TodayQuestionInteractor$onQuestionSkip$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ TodayQuestionInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TodayQuestionInteractor$onQuestionSkip$1(TodayQuestionInteractor todayQuestionInteractor) {
        super(1);
        this.this$0 = todayQuestionInteractor;
    }

    public final void a(b bVar) {
        this.this$0.t2(true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((b) obj);
        return Unit.f32013a;
    }
}
