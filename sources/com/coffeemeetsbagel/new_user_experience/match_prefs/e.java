package com.coffeemeetsbagel.new_user_experience.match_prefs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.LoadAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.SaveAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.a;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.distance.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.gender.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.religion.d;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.GetUserMCQUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.i;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.subscription_dialog.dialog.e;
import ma.g;
import qj.q;

public final class e extends b6.c<h0, c> {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f35324b;

    public interface a extends j<MatchPrefsInteractor>, a.c, d.c, d.c, d.c, d.c, d.c, d.b, d.a, e.a {
        b6.d<?, ?> a();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f35325a;

        /* renamed from: b  reason: collision with root package name */
        private final MatchPrefsInteractor f35326b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f35327c;

        public b(ViewGroup viewGroup, MatchPrefsInteractor matchPrefsInteractor, boolean z10) {
            kotlin.jvm.internal.j.g(viewGroup, "viewGroup");
            kotlin.jvm.internal.j.g(matchPrefsInteractor, "interactor");
            this.f35325a = viewGroup;
            this.f35326b = matchPrefsInteractor;
            this.f35327c = z10;
        }

        public final q<c6.a> a(b6.d<?, ?> dVar) {
            kotlin.jvm.internal.j.g(dVar, "componentActivity");
            q<c6.a> a10 = dVar.F0().a();
            kotlin.jvm.internal.j.f(a10, "componentActivity.activi…Stream().activityResult()");
            return a10;
        }

        public final k b(g0 g0Var) {
            kotlin.jvm.internal.j.g(g0Var, "matchPrefsRelayManager");
            return g0Var;
        }

        public final l c(g0 g0Var) {
            kotlin.jvm.internal.j.g(g0Var, "matchPrefsRelayManager");
            return g0Var;
        }

        public final MatchPrefsPresenter d() {
            return new MatchPrefsPresenter(this.f35325a, this.f35326b, this.f35327c);
        }

        public final g0 e() {
            return new g0();
        }
    }

    public interface c {
        c9.a I();

        m1 W();

        SaveAgePreferenceUseCase X();

        b6.d<?, ?> a();

        s9.a b();

        LoadAgePreferenceUseCase b0();

        a7.a c();

        g c0();

        ProfileManager d();

        UserRepository e();

        cb.a f();

        BuySubscriptionUseCase g();

        GetMyOwnProfileLocalUseCase h();

        SubscriptionRepository h0();

        na.b j();

        QuestionRepository k();

        androidx.appcompat.app.c n();

        l5.a n0();

        i o();

        GetMatchPreferencesUseCase p0();

        GetUserMCQUseCase s0();

        SaveAnswerUseCase z();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(c cVar, boolean z10) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
        this.f35324b = z10;
    }

    public final h0 b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        MatchPrefsInteractor matchPrefsInteractor = new MatchPrefsInteractor(this.f35324b);
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.component_onboarding_match_prefs, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        a a10 = b.a().b(new b(viewGroup2, matchPrefsInteractor, this.f35324b)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new h0(viewGroup2, a10, matchPrefsInteractor);
    }
}
