package com.coffeemeetsbagel.suggested_history;

import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.bagel.UpdateBagelLocalUseCase;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.d;
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
import com.coffeemeetsbagel.store.alc.b;
import com.coffeemeetsbagel.store.k0;
import l8.h;
import s9.a;
import wb.c;

public interface q {
    SaveAnswerUseCase D();

    GetHistoryBagelUseCase E0();

    d F0();

    x J();

    b L0();

    UpdateBagelLocalUseCase M();

    e O();

    SubscriptionRepository P();

    a b();

    a7.a c();

    ProfileContract$Manager d();

    j d0();

    UserRepository e();

    cb.a f();

    BuySubscriptionUseCase g();

    GetMyOwnProfileLocalUseCase h();

    bb.a i();

    k0 j();

    QuestionRepository k();

    com.coffeemeetsbagel.match.j l();

    DeletePromptAnswerUseCase o();

    c9.d p();

    g q();

    c r();

    y6.a s();

    h t();

    z u0();

    GetGroupOptionsRemainingUseCase v();

    LoadProfileUseCase w();

    a6.a x();

    FirebaseContract.Analytics x0();

    GetActivityReportUseCase y();
}
