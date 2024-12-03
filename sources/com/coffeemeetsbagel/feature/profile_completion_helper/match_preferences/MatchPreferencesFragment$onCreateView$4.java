package com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MatchPreferencesFragment$onCreateView$4 extends Lambda implements Function1<Pair<? extends QuestionWAnswers, ? extends Boolean>, Unit> {
    final /* synthetic */ MatchPreferencesFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPreferencesFragment$onCreateView$4(MatchPreferencesFragment matchPreferencesFragment) {
        super(1);
        this.this$0 = matchPreferencesFragment;
    }

    public final void a(Pair<QuestionWAnswers, Boolean> pair) {
        this.this$0.d1(pair.c(), pair.d().booleanValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
