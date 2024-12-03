package com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences;

import android.view.View;
import com.coffeemeetsbagel.qna.QuestionWAnswers;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QuestionWAnswers f13302a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MatchPreferencesFragment f13303b;

    public /* synthetic */ a(QuestionWAnswers questionWAnswers, MatchPreferencesFragment matchPreferencesFragment) {
        this.f13302a = questionWAnswers;
        this.f13303b = matchPreferencesFragment;
    }

    public final void onClick(View view) {
        MatchPreferencesFragment.q1(this.f13302a, this.f13303b, view);
    }
}
