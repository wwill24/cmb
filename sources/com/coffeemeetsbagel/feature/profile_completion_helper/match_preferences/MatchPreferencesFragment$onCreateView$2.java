package com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences;

import com.coffeemeetsbagel.match_prefs.MatchPreference$Gender;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchPreferencesFragment$onCreateView$2 extends Lambda implements Function1<QuestionWAnswers, Unit> {
    final /* synthetic */ MatchPreferencesFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPreferencesFragment$onCreateView$2(MatchPreferencesFragment matchPreferencesFragment) {
        super(1);
        this.this$0 = matchPreferencesFragment;
    }

    public final void a(QuestionWAnswers questionWAnswers) {
        List<Option> options = questionWAnswers.e().getOptions();
        MatchPreferencesFragment matchPreferencesFragment = this.this$0;
        for (Option option : options) {
            String title = option.getTitle();
            if (j.b(title, MatchPreference$Gender.MEN.b())) {
                matchPreferencesFragment.T0().f15829h.setTag(option.getId());
            } else if (j.b(title, MatchPreference$Gender.WOMEN.b())) {
                matchPreferencesFragment.T0().f15830j.setTag(option.getId());
            } else if (j.b(title, MatchPreference$Gender.EVERYONE.b())) {
                matchPreferencesFragment.T0().f15828g.setTag(option.getId());
            }
        }
        MatchPreferencesFragment matchPreferencesFragment2 = this.this$0;
        j.f(questionWAnswers, "it");
        matchPreferencesFragment2.i1(questionWAnswers);
        this.this$0.l1();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((QuestionWAnswers) obj);
        return Unit.f32013a;
    }
}
