package com.coffeemeetsbagel.today_view.today_question;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class TodayQuestionInteractor$didBecomeActive$5 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ TodayQuestionInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TodayQuestionInteractor$didBecomeActive$5(TodayQuestionInteractor todayQuestionInteractor) {
        super(1);
        this.this$0 = todayQuestionInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        j.f(th2, "it");
        aVar.c("TodayQuestionInteractor", "problem getting periodic question", th2);
        this.this$0.h2().h();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
