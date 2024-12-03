package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchViewInteractor$compareChipAnswers$1$3 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ QuestionGroupType $questionType;
    final /* synthetic */ MatchViewInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewInteractor$compareChipAnswers$1$3(QuestionGroupType questionGroupType, MatchViewInteractor matchViewInteractor) {
        super(1);
        this.$questionType = questionGroupType;
        this.this$0 = matchViewInteractor;
    }

    public final void a(Throwable th2) {
        j.f(th2, "it");
        a.f40771d.c("MatchViewInteractor", "Failed to load " + this.$questionType + ".", th2);
        this.this$0.R2(q.j(), this.$questionType);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
