package com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchPreferencesFragment$onCreateView$5 extends Lambda implements Function1<QuestionWAnswers, Unit> {
    final /* synthetic */ MatchPreferencesFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPreferencesFragment$onCreateView$5(MatchPreferencesFragment matchPreferencesFragment) {
        super(1);
        this.this$0 = matchPreferencesFragment;
    }

    public final void a(QuestionWAnswers questionWAnswers) {
        MatchPreferencesFragment matchPreferencesFragment = this.this$0;
        j.f(questionWAnswers, "it");
        matchPreferencesFragment.p1(questionWAnswers);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((QuestionWAnswers) obj);
        return Unit.f32013a;
    }
}
