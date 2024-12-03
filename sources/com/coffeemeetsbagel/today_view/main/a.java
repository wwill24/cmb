package com.coffeemeetsbagel.today_view.main;

import b6.t;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.domain.repository.ActionCardRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.SuggestedRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.feature.bagel.GetLastPassedBagelUseCase;
import com.coffeemeetsbagel.feature.bagel.UpdateBagelLocalUseCase;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.d;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.match.x;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.match_view.GetActivityReportUseCase;
import com.coffeemeetsbagel.match_view.LoadProfileUseCase;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.today_view.card.actioncards.GetFirstEligibleActionCardUseCase;
import com.coffeemeetsbagel.today_view.main.b;
import com.coffeemeetsbagel.today_view.main.e;
import fj.g;
import l8.h;
import l9.e;
import wb.c;

public final class a {

    /* renamed from: com.coffeemeetsbagel.today_view.main.a$a  reason: collision with other inner class name */
    public static final class C0467a {

        /* renamed from: a  reason: collision with root package name */
        private b.c f37361a;

        /* renamed from: b  reason: collision with root package name */
        private b.a f37362b;

        private C0467a() {
        }

        public b.C0468b a() {
            g.a(this.f37361a, b.c.class);
            g.a(this.f37362b, b.a.class);
            return new b(this.f37361a, this.f37362b);
        }

        public C0467a b(b.a aVar) {
            this.f37362b = (b.a) g.b(aVar);
            return this;
        }

        public C0467a c(b.c cVar) {
            this.f37361a = (b.c) g.b(cVar);
            return this;
        }
    }

    private static final class b implements b.C0468b {

        /* renamed from: a  reason: collision with root package name */
        private final b.c f37363a;

        /* renamed from: b  reason: collision with root package name */
        private final b.a f37364b;

        /* renamed from: c  reason: collision with root package name */
        private final b f37365c;

        private b(b.c cVar, b.a aVar) {
            this.f37365c = this;
            this.f37363a = cVar;
            this.f37364b = aVar;
        }

        private e G(e eVar) {
            t.a(eVar, d.a(this.f37363a));
            f.c(eVar, (j) g.d(this.f37364b.l()));
            f.j(eVar, (ProfileContract$Manager) g.d(this.f37364b.d()));
            f.e(eVar, (ActivityMain) g.d(this.f37364b.K0()));
            f.g(eVar, (c) g.d(this.f37364b.r()));
            f.b(eVar, (a7.a) g.d(this.f37364b.c()));
            f.i(eVar, (a0) g.d(this.f37364b.L()));
            f.k(eVar, (QuestionRepository) g.d(this.f37364b.k()));
            f.l(eVar, (com.coffeemeetsbagel.experiment.t) g.d(this.f37364b.B()));
            f.f(eVar, (s9.a) g.d(this.f37364b.b()));
            f.n(eVar, (SuggestedRepository) g.d(this.f37364b.z0()));
            f.m(eVar, (hb.c) g.d(this.f37364b.H()));
            f.d(eVar, (a6.a) g.d(this.f37364b.x()));
            f.h(eVar, (GetLastPassedBagelUseCase) g.d(this.f37364b.B0()));
            f.a(eVar, (d) g.d(this.f37364b.G0()));
            return eVar;
        }

        public y5.b A() {
            return (y5.b) g.d(this.f37364b.N0());
        }

        public com.coffeemeetsbagel.experiment.t B() {
            return (com.coffeemeetsbagel.experiment.t) g.d(this.f37364b.B());
        }

        public GetLastPassedBagelUseCase B0() {
            return (GetLastPassedBagelUseCase) g.d(this.f37364b.B0());
        }

        public UserRepository C() {
            return (UserRepository) g.d(this.f37364b.e());
        }

        public SaveAnswerUseCase D() {
            return (SaveAnswerUseCase) g.d(this.f37364b.z());
        }

        /* renamed from: E */
        public void l1(e eVar) {
            G(eVar);
        }

        public z F() {
            return (z) g.d(this.f37364b.F());
        }

        public d G0() {
            return (d) g.d(this.f37364b.G0());
        }

        public hb.c H() {
            return (hb.c) g.d(this.f37364b.H());
        }

        public e H0() {
            return (e) g.d(this.f37364b.H0());
        }

        public b7.c K() {
            return (b7.c) g.d(this.f37364b.K());
        }

        public ActivityMain K0() {
            return (ActivityMain) g.d(this.f37364b.K0());
        }

        public a0 L() {
            return (a0) g.d(this.f37364b.L());
        }

        public UpdateBagelLocalUseCase M() {
            return (UpdateBagelLocalUseCase) g.d(this.f37364b.M());
        }

        public a6.a N() {
            return (a6.a) g.d(this.f37364b.x());
        }

        public t7.a Q() {
            return (t7.a) g.d(this.f37364b.Q());
        }

        public com.coffeemeetsbagel.qna.e Y() {
            return (com.coffeemeetsbagel.qna.e) g.d(this.f37364b.O());
        }

        public ActivityMain a() {
            return (ActivityMain) g.d(this.f37364b.K0());
        }

        public FirebaseContract.Analytics a0() {
            return (FirebaseContract.Analytics) g.d(this.f37364b.a0());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f37364b.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f37364b.c());
        }

        public ProfileContract$Manager d() {
            return (ProfileContract$Manager) g.d(this.f37364b.d());
        }

        public com.coffeemeetsbagel.qna.j d0() {
            return (com.coffeemeetsbagel.qna.j) g.d(this.f37364b.M0());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f37364b.e());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f37364b.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f37364b.g());
        }

        public GetFirstEligibleActionCardUseCase g0() {
            return (GetFirstEligibleActionCardUseCase) g.d(this.f37364b.g0());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f37364b.h());
        }

        public k0 j() {
            return (k0) g.d(this.f37364b.j());
        }

        public l5.a j0() {
            return (l5.a) g.d(this.f37364b.j0());
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f37364b.k());
        }

        public x k0() {
            return (x) g.d(this.f37364b.k0());
        }

        public j l() {
            return (j) g.d(this.f37364b.l());
        }

        public com.coffeemeetsbagel.store.alc.b l0() {
            return (com.coffeemeetsbagel.store.alc.b) g.d(this.f37364b.l0());
        }

        public SubscriptionRepository m() {
            return (SubscriptionRepository) g.d(this.f37364b.m());
        }

        public ActionCardRepository m0() {
            return (ActionCardRepository) g.d(this.f37364b.m0());
        }

        public androidx.appcompat.app.c n() {
            return (androidx.appcompat.app.c) g.d(this.f37364b.n());
        }

        public DeletePromptAnswerUseCase o() {
            return (DeletePromptAnswerUseCase) g.d(this.f37364b.o());
        }

        public SaveProfilesLocalUseCase o0() {
            return (SaveProfilesLocalUseCase) g.d(this.f37364b.o0());
        }

        public c9.d p() {
            return (c9.d) g.d(this.f37364b.p());
        }

        public com.coffeemeetsbagel.qna.g q() {
            return (com.coffeemeetsbagel.qna.g) g.d(this.f37364b.q());
        }

        public e.a r() {
            return c.a(this.f37363a);
        }

        public y6.a s() {
            return (y6.a) g.d(this.f37364b.s());
        }

        public h t() {
            return (h) g.d(this.f37364b.t());
        }

        public bb.a u() {
            return (bb.a) g.d(this.f37364b.u());
        }

        public GetGroupOptionsRemainingUseCase v() {
            return (GetGroupOptionsRemainingUseCase) g.d(this.f37364b.v());
        }

        public LoadProfileUseCase w() {
            return (LoadProfileUseCase) g.d(this.f37364b.w());
        }

        public com.coffeemeetsbagel.instant_like.d w0() {
            return (com.coffeemeetsbagel.instant_like.d) g.d(this.f37364b.w0());
        }

        public a6.a x() {
            return (a6.a) g.d(this.f37364b.x());
        }

        public GetActivityReportUseCase y() {
            return (GetActivityReportUseCase) g.d(this.f37364b.y());
        }

        public SaveAnswerUseCase z() {
            return (SaveAnswerUseCase) g.d(this.f37364b.z());
        }

        public SuggestedRepository z0() {
            return (SuggestedRepository) g.d(this.f37364b.z0());
        }
    }

    public static C0467a a() {
        return new C0467a();
    }
}
