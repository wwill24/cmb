package y4;

import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.ActionCardRepository;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.SuggestedRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.bagel.GetLastPassedBagelUseCase;
import com.coffeemeetsbagel.feature.bagel.UpdateBagelLocalUseCase;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.likes_you.n0;
import com.coffeemeetsbagel.match.x;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.match_view.GetActivityReportUseCase;
import com.coffeemeetsbagel.match_view.LoadProfileUseCase;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.g;
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.alc.b;
import com.coffeemeetsbagel.store.alc.d;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.today_view.card.actioncards.GetFirstEligibleActionCardUseCase;
import f6.f2;
import hb.c;
import l8.h;
import l9.e;
import lc.k;
import n8.s;
import t7.a;

public interface k1 {
    ProfileRepositoryV2 A0();

    t B();

    GetLastPassedBagelUseCase B0();

    d C0();

    z F();

    v7.d G();

    com.coffeemeetsbagel.match.d G0();

    c H();

    e H0();

    n0 I1();

    b7.c K();

    a0 L();

    UpdateBagelLocalUseCase M();

    j M0();

    com.coffeemeetsbagel.qna.e O();

    a Q();

    f2 Q0();

    FirebaseContract.Analytics a0();

    s9.a b();

    a7.a c();

    ProfileContract$Manager d();

    UserRepository e();

    cb.a f();

    BuySubscriptionUseCase g();

    GetFirstEligibleActionCardUseCase g0();

    GetMyOwnProfileLocalUseCase h();

    m1 i0();

    k0 j();

    l5.a j0();

    QuestionRepository k();

    x k0();

    com.coffeemeetsbagel.match.j l();

    b l0();

    SubscriptionRepository m();

    ActionCardRepository m0();

    s n();

    DeletePromptAnswerUseCase o();

    SaveProfilesLocalUseCase o0();

    c9.d p();

    g q();

    k q0();

    wb.c r();

    y6.a s();

    h t();

    LikesYouMatchRepository t0();

    bb.a u();

    GetGroupOptionsRemainingUseCase v();

    LoadProfileUseCase w();

    com.coffeemeetsbagel.instant_like.d w0();

    a6.a x();

    GetActivityReportUseCase y();

    SaveAnswerUseCase z();

    SuggestedRepository z0();
}
