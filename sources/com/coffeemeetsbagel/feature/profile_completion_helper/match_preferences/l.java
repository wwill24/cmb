package com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences;

import a6.a;
import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import kotlin.jvm.internal.j;

public final class l implements i0.b {

    /* renamed from: b  reason: collision with root package name */
    private final GetMatchPreferencesUseCase f13329b;

    /* renamed from: c  reason: collision with root package name */
    private final a f13330c;

    /* renamed from: d  reason: collision with root package name */
    private final SaveAnswerUseCase f13331d;

    public l(GetMatchPreferencesUseCase getMatchPreferencesUseCase, a aVar, SaveAnswerUseCase saveAnswerUseCase) {
        j.g(getMatchPreferencesUseCase, "getMatchPreferencesUseCase");
        j.g(aVar, "coachmarkManager");
        j.g(saveAnswerUseCase, "saveAnswerUseCase");
        this.f13329b = getMatchPreferencesUseCase;
        this.f13330c = aVar;
        this.f13331d = saveAnswerUseCase;
    }

    public <T extends f0> T a(Class<T> cls) {
        j.g(cls, "modelClass");
        return new MatchPreferencesViewModel(this.f13329b, this.f13330c, this.f13331d);
    }
}
