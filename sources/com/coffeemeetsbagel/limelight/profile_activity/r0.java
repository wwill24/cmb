package com.coffeemeetsbagel.limelight.profile_activity;

import a6.a;
import c9.d;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.x;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.match_view.GetActivityReportUseCase;
import com.coffeemeetsbagel.match_view.LoadProfileUseCase;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.e;
import com.coffeemeetsbagel.qna.g;
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import l8.h;
import wb.c;

public interface r0 {
    t B();

    SaveAnswerUseCase D();

    z F();

    x J();

    a0 L();

    a N();

    j O0();

    a7.a R();

    e Y();

    s9.a b();

    ProfileContract$Manager d();

    UserRepository e();

    cb.a f();

    BuySubscriptionUseCase g();

    GetMyOwnProfileLocalUseCase h();

    QuestionRepository k();

    com.coffeemeetsbagel.match.j l();

    SubscriptionRepository m();

    DeletePromptAnswerUseCase o();

    d p();

    g q();

    c r();

    y6.a s();

    h t();

    LikesYouMatchRepository t0();

    bb.a u();

    GetGroupOptionsRemainingUseCase v();

    LoadProfileUseCase w();

    GetActivityReportUseCase y();
}
