package com.coffeemeetsbagel.today_view.today_bagel;

import b6.t;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.SuggestedRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.feature.bagel.GetLastPassedBagelUseCase;
import com.coffeemeetsbagel.feature.bagel.UpdateBagelLocalUseCase;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.instant_like.d;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.match.x;
import com.coffeemeetsbagel.match.z;
import com.coffeemeetsbagel.match_view.GetActivityReportUseCase;
import com.coffeemeetsbagel.match_view.LoadProfileUseCase;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.today_view.main.e;
import com.coffeemeetsbagel.today_view.today_bagel.e;
import fj.g;
import hb.c;
import l8.h;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private e.c f37438a;

        /* renamed from: b  reason: collision with root package name */
        private e.a f37439b;

        private a() {
        }

        public e.b a() {
            g.a(this.f37438a, e.c.class);
            g.a(this.f37439b, e.a.class);
            return new C0469b(this.f37438a, this.f37439b);
        }

        public a b(e.a aVar) {
            this.f37439b = (e.a) g.b(aVar);
            return this;
        }

        public a c(e.c cVar) {
            this.f37438a = (e.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.today_view.today_bagel.b$b  reason: collision with other inner class name */
    private static final class C0469b implements e.b {

        /* renamed from: a  reason: collision with root package name */
        private final e.c f37440a;

        /* renamed from: b  reason: collision with root package name */
        private final e.a f37441b;

        /* renamed from: c  reason: collision with root package name */
        private final C0469b f37442c;

        private C0469b(e.c cVar, e.a aVar) {
            this.f37442c = this;
            this.f37440a = cVar;
            this.f37441b = aVar;
        }

        private com.coffeemeetsbagel.store.alc.a r() {
            return g.a(this.f37440a, (a7.a) g.d(this.f37441b.c()), (FirebaseContract.Analytics) g.d(this.f37441b.a0()));
        }

        private SuggestedMatchContainerInteractor x(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
            t.a(suggestedMatchContainerInteractor, z());
            m0.d(suggestedMatchContainerInteractor, (j) g.d(this.f37441b.l()));
            m0.c(suggestedMatchContainerInteractor, (a7.a) g.d(this.f37441b.c()));
            m0.t(suggestedMatchContainerInteractor, (k0) g.d(this.f37441b.j()));
            m0.q(suggestedMatchContainerInteractor, (ProfileContract$Manager) g.d(this.f37441b.d()));
            m0.w(suggestedMatchContainerInteractor, (c) g.d(this.f37441b.H()));
            m0.i(suggestedMatchContainerInteractor, (s9.a) g.d(this.f37441b.b()));
            m0.p(suggestedMatchContainerInteractor, (e.a) g.d(this.f37441b.r()));
            m0.u(suggestedMatchContainerInteractor, (com.coffeemeetsbagel.experiment.t) g.d(this.f37441b.B()));
            m0.j(suggestedMatchContainerInteractor, (FirebaseContract.Analytics) g.d(this.f37441b.a0()));
            m0.h(suggestedMatchContainerInteractor, (ActivityMain) g.d(this.f37441b.a()));
            m0.o(suggestedMatchContainerInteractor, (h) g.d(this.f37441b.t()));
            m0.n(suggestedMatchContainerInteractor, (a0) g.d(this.f37441b.L()));
            m0.x(suggestedMatchContainerInteractor, (l9.e) g.d(this.f37441b.H0()));
            m0.f(suggestedMatchContainerInteractor, (l5.a) g.d(this.f37441b.j0()));
            m0.l(suggestedMatchContainerInteractor, (d) g.d(this.f37441b.w0()));
            m0.e(suggestedMatchContainerInteractor, (y5.b) g.d(this.f37441b.A()));
            m0.a(suggestedMatchContainerInteractor, (com.coffeemeetsbagel.match.d) g.d(this.f37441b.G0()));
            m0.m(suggestedMatchContainerInteractor, (z) g.d(this.f37441b.F()));
            m0.y(suggestedMatchContainerInteractor, (SubscriptionRepository) g.d(this.f37441b.m()));
            m0.s(suggestedMatchContainerInteractor, (com.coffeemeetsbagel.store.alc.b) g.d(this.f37441b.l0()));
            m0.v(suggestedMatchContainerInteractor, (UpdateBagelLocalUseCase) g.d(this.f37441b.M()));
            m0.r(suggestedMatchContainerInteractor, r());
            m0.g(suggestedMatchContainerInteractor, (a6.a) g.d(this.f37441b.N()));
            m0.b(suggestedMatchContainerInteractor, r());
            m0.z(suggestedMatchContainerInteractor, (SuggestedRepository) g.d(this.f37441b.z0()));
            m0.k(suggestedMatchContainerInteractor, (GetLastPassedBagelUseCase) g.d(this.f37441b.B0()));
            return suggestedMatchContainerInteractor;
        }

        private a1 z() {
            return h.a(this.f37440a, (s9.a) g.d(this.f37441b.b()), (a7.a) g.d(this.f37441b.c()));
        }

        public SaveAnswerUseCase D() {
            return (SaveAnswerUseCase) g.d(this.f37441b.D());
        }

        public x J() {
            return (x) g.d(this.f37441b.k0());
        }

        public ActivityMain K0() {
            return (ActivityMain) g.d(this.f37441b.a());
        }

        public UpdateBagelLocalUseCase M() {
            return (UpdateBagelLocalUseCase) g.d(this.f37441b.M());
        }

        public a6.a N() {
            return (a6.a) g.d(this.f37441b.N());
        }

        public com.coffeemeetsbagel.qna.e O() {
            return (com.coffeemeetsbagel.qna.e) g.d(this.f37441b.Y());
        }

        public androidx.appcompat.app.c O0() {
            return (androidx.appcompat.app.c) g.d(this.f37441b.n());
        }

        public SubscriptionRepository P() {
            return (SubscriptionRepository) g.d(this.f37441b.m());
        }

        public d T() {
            return (d) g.d(this.f37441b.w0());
        }

        public FirebaseContract.Analytics a0() {
            return (FirebaseContract.Analytics) g.d(this.f37441b.a0());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f37441b.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f37441b.c());
        }

        public ProfileContract$Manager d() {
            return (ProfileContract$Manager) g.d(this.f37441b.d());
        }

        public com.coffeemeetsbagel.qna.j d0() {
            return (com.coffeemeetsbagel.qna.j) g.d(this.f37441b.d0());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f37441b.e());
        }

        public c6.b e0() {
            return f.a(this.f37440a, (ActivityMain) g.d(this.f37441b.a()));
        }

        public cb.a f() {
            return (cb.a) g.d(this.f37441b.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f37441b.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f37441b.h());
        }

        public k0 j() {
            return (k0) g.d(this.f37441b.j());
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f37441b.k());
        }

        public j l() {
            return (j) g.d(this.f37441b.l());
        }

        public com.coffeemeetsbagel.store.alc.b l0() {
            return (com.coffeemeetsbagel.store.alc.b) g.d(this.f37441b.l0());
        }

        public SubscriptionRepository m() {
            return (SubscriptionRepository) g.d(this.f37441b.m());
        }

        public c6.b m0() {
            return e0();
        }

        public androidx.appcompat.app.c n() {
            return (androidx.appcompat.app.c) g.d(this.f37441b.n());
        }

        public DeletePromptAnswerUseCase o() {
            return (DeletePromptAnswerUseCase) g.d(this.f37441b.o());
        }

        public c9.d p() {
            return (c9.d) g.d(this.f37441b.p());
        }

        public com.coffeemeetsbagel.qna.g q() {
            return (com.coffeemeetsbagel.qna.g) g.d(this.f37441b.q());
        }

        public y6.a s() {
            return (y6.a) g.d(this.f37441b.s());
        }

        /* renamed from: t */
        public void l1(SuggestedMatchContainerInteractor suggestedMatchContainerInteractor) {
            x(suggestedMatchContainerInteractor);
        }

        public bb.a u() {
            return (bb.a) g.d(this.f37441b.u());
        }

        public GetGroupOptionsRemainingUseCase v() {
            return (GetGroupOptionsRemainingUseCase) g.d(this.f37441b.v());
        }

        public LoadProfileUseCase w() {
            return (LoadProfileUseCase) g.d(this.f37441b.w());
        }

        public GetActivityReportUseCase y() {
            return (GetActivityReportUseCase) g.d(this.f37441b.y());
        }
    }

    public static a a() {
        return new a();
    }
}
