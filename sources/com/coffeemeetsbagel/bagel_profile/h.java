package com.coffeemeetsbagel.bagel_profile;

import a6.a;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.x;
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
import com.coffeemeetsbagel.store.k0;
import v7.d;

public interface h {
    ProfileRepository A();

    SaveAnswerUseCase D();

    d G();

    a N();

    e O();

    a7.a R();

    s9.a b();

    ProfileContract$Manager d();

    UserRepository e();

    cb.a f();

    j f0();

    BuySubscriptionUseCase g();

    GetMyOwnProfileLocalUseCase h();

    k0 j();

    QuestionRepository k();

    x k0();

    SubscriptionRepository m();

    DeletePromptAnswerUseCase o();

    c9.d p();

    g q();

    y6.a s();

    bb.a u();

    GetGroupOptionsRemainingUseCase v();

    LoadProfileUseCase w();

    GetActivityReportUseCase y();
}
