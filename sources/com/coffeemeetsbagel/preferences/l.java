package com.coffeemeetsbagel.preferences;

import android.view.ViewGroup;
import b6.d;
import b6.j;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.LoadAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.SaveAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.e;
import com.coffeemeetsbagel.preferences.h;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.GetUserMCQUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import ma.g;

public final class l extends b6.c<MatchPrefsContainerRouter, h.a> {

    public interface a extends j<MatchPrefsContainerInteractor>, e.c {
        d<?, ?> a();
    }

    public static final class b {
        public final g a(k kVar) {
            kotlin.jvm.internal.j.g(kVar, "relayManager");
            return kVar;
        }

        public final na.b b(k kVar) {
            kotlin.jvm.internal.j.g(kVar, "relayManager");
            return kVar;
        }

        public final k c() {
            return new k();
        }
    }

    public interface c {
        c9.a I();

        m1 W();

        SaveAgePreferenceUseCase X();

        d<?, ?> a();

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

        SubscriptionRepository h0();

        androidx.appcompat.app.c n();

        l5.a n0();

        GetMatchPreferencesUseCase p0();

        GetUserMCQUseCase s0();

        SaveAnswerUseCase z();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(h.a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final MatchPrefsContainerRouter b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        MatchPrefsContainerInteractor matchPrefsContainerInteractor = new MatchPrefsContainerInteractor();
        a a10 = e.a().b((h.a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new MatchPrefsContainerRouter(viewGroup, a10, matchPrefsContainerInteractor);
    }
}
