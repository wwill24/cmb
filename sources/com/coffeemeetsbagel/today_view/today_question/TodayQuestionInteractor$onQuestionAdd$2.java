package com.coffeemeetsbagel.today_view.today_question;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class TodayQuestionInteractor$onQuestionAdd$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ TodayQuestionInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TodayQuestionInteractor$onQuestionAdd$2(TodayQuestionInteractor todayQuestionInteractor) {
        super(1);
        this.this$0 = todayQuestionInteractor;
    }

    public final void a(Throwable th2) {
        j.f(th2, "throwable");
        a.f40771d.c("TodayQuestionInteractor", "Problem saving answer for question " + this.this$0.g2().e().getId(), th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
