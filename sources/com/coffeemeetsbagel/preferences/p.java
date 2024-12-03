package com.coffeemeetsbagel.preferences;

import c9.a;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.LoadAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.SaveAgePreferenceUseCase;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.GetUserMCQUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import ma.g;

public interface p {
    a I();

    m1 W();

    SaveAgePreferenceUseCase X();

    s9.a b();

    LoadAgePreferenceUseCase b0();

    a7.a c();

    g c0();

    ProfileManager d();

    UserRepository e();

    QuestionRepository e0();

    cb.a f();

    BuySubscriptionUseCase g();

    GetMyOwnProfileLocalUseCase h();

    SubscriptionRepository m();

    l5.a n0();

    GetMatchPreferencesUseCase p0();

    GetUserMCQUseCase s0();

    SaveAnswerUseCase z();
}
