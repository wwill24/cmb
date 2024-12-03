package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchViewPresenter$didLoad$2 extends Lambda implements Function1<QuestionGroupType, Unit> {
    final /* synthetic */ MatchViewPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewPresenter$didLoad$2(MatchViewPresenter matchViewPresenter) {
        super(1);
        this.this$0 = matchViewPresenter;
    }

    public final void a(QuestionGroupType questionGroupType) {
        j.g(questionGroupType, "group");
        this.this$0.f34645f.w(questionGroupType);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((QuestionGroupType) obj);
        return Unit.f32013a;
    }
}
