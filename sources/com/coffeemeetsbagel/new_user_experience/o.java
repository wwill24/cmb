package com.coffeemeetsbagel.new_user_experience;

import c9.a;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.LoadAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.SaveAgePreferenceUseCase;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.r0;
import com.coffeemeetsbagel.qna.GetUserMCQUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import d7.g;
import hb.c;
import t8.l;

public interface o {
    ProfileRepository A();

    j A1();

    g E();

    a I();

    GetSingleSchoolsUseCase N0();

    l P0();

    ProfileManager V();

    m1 W();

    SaveAgePreferenceUseCase X();

    s9.a b();

    LoadAgePreferenceUseCase b0();

    a7.a c();

    ma.g c0();

    UserRepository e();

    QuestionRepository e0();

    cb.a f();

    BuySubscriptionUseCase g();

    GetMyOwnProfileLocalUseCase h();

    SubscriptionRepository h0();

    l5.a n0();

    GetMatchPreferencesUseCase p0();

    GetUserMCQUseCase s0();

    r0 v0();

    c y0();

    SaveAnswerUseCase z();
}
