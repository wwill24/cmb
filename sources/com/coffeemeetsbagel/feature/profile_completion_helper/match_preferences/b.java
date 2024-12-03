package com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences;

import android.view.View;
import com.coffeemeetsbagel.qna.QuestionWAnswers;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QuestionWAnswers f13304a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MatchPreferencesFragment f13305b;

    public /* synthetic */ b(QuestionWAnswers questionWAnswers, MatchPreferencesFragment matchPreferencesFragment) {
        this.f13304a = questionWAnswers;
        this.f13305b = matchPreferencesFragment;
    }

    public final void onClick(View view) {
        MatchPreferencesFragment.g1(this.f13304a, this.f13305b, view);
    }
}
