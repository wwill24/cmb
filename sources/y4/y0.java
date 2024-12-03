package y4;

import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.cmbbottomnav.state.NavStateManager;
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
import com.coffeemeetsbagel.limelight.LikesYouDialogUseCase;
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
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.GetSubscriptionBundlesUseCase;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.today_view.card.actioncards.GetFirstEligibleActionCardUseCase;
import f6.f2;
import fj.g;
import l8.h;
import l9.e;
import lc.k;
import n8.s;
import v7.d;
import y4.a1;
import z4.c;

public final class y0 {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private a1.b f18728a;

        /* renamed from: b  reason: collision with root package name */
        private k1 f18729b;

        private a() {
        }

        public a1.a a() {
            g.a(this.f18728a, a1.b.class);
            g.a(this.f18729b, k1.class);
            return new b(this.f18728a, this.f18729b);
        }

        public a b(a1.b bVar) {
            this.f18728a = (a1.b) g.b(bVar);
            return this;
        }

        public a c(k1 k1Var) {
            this.f18729b = (k1) g.b(k1Var);
            return this;
        }
    }

    private static final class b implements a1.a {

        /* renamed from: a  reason: collision with root package name */
        private final k1 f18730a;

        /* renamed from: b  reason: collision with root package name */
        private final a1.b f18731b;

        /* renamed from: c  reason: collision with root package name */
        private final b f18732c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<z4.b> f18733d;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<z4.a> f18734e;

        /* renamed from: f  reason: collision with root package name */
        private fk.a<x5.a> f18735f;

        /* renamed from: g  reason: collision with root package name */
        private fk.a<NavStateManager> f18736g;

        /* renamed from: h  reason: collision with root package name */
        private fk.a<y5.a> f18737h;

        /* renamed from: j  reason: collision with root package name */
        private fk.a<y5.b> f18738j;

        /* renamed from: k  reason: collision with root package name */
        private fk.a<ActivityMain> f18739k;

        /* renamed from: l  reason: collision with root package name */
        private fk.a<c> f18740l;

        private b(a1.b bVar, k1 k1Var) {
            this.f18732c = this;
            this.f18730a = k1Var;
            this.f18731b = bVar;
            Y(bVar, k1Var);
        }

        private GetSubscriptionBundlesUseCase X() {
            return new GetSubscriptionBundlesUseCase((SubscriptionRepository) g.d(this.f18730a.m()));
        }

        private void Y(a1.b bVar, k1 k1Var) {
            fk.a<z4.b> a10 = fj.c.a(c1.b(bVar));
            this.f18733d = a10;
            this.f18734e = fj.c.a(b1.b(bVar, a10));
            this.f18735f = fj.c.a(h1.b(bVar));
            fk.a<NavStateManager> a11 = fj.c.a(j1.a(bVar));
            this.f18736g = a11;
            this.f18737h = fj.c.a(f1.b(bVar, a11));
            this.f18738j = fj.c.a(g1.b(bVar, this.f18736g));
            this.f18739k = fj.c.a(i1.b(bVar));
            this.f18740l = fj.c.a(d1.b(bVar, this.f18733d));
        }

        private ActivityMain c0(ActivityMain activityMain) {
            com.coffeemeetsbagel.activities.main.a.a(activityMain, this.f18734e.get());
            com.coffeemeetsbagel.activities.main.a.d(activityMain, this.f18735f.get());
            com.coffeemeetsbagel.activities.main.a.b(activityMain, this.f18737h.get());
            com.coffeemeetsbagel.activities.main.a.c(activityMain, this.f18738j.get());
            com.coffeemeetsbagel.activities.main.a.l(activityMain, (s) g.d(this.f18730a.n()));
            com.coffeemeetsbagel.activities.main.a.e(activityMain, (t7.a) g.d(this.f18730a.Q()));
            com.coffeemeetsbagel.activities.main.a.n(activityMain, (hb.c) g.d(this.f18730a.H()));
            com.coffeemeetsbagel.activities.main.a.j(activityMain, (n0) g.d(this.f18730a.I1()));
            com.coffeemeetsbagel.activities.main.a.f(activityMain, (d) g.d(this.f18730a.G()));
            com.coffeemeetsbagel.activities.main.a.o(activityMain, (SubscriptionRepository) g.d(this.f18730a.m()));
            com.coffeemeetsbagel.activities.main.a.h(activityMain, X());
            com.coffeemeetsbagel.activities.main.a.g(activityMain, (s9.a) g.d(this.f18730a.b()));
            com.coffeemeetsbagel.activities.main.a.p(activityMain, (a7.a) g.d(this.f18730a.c()));
            com.coffeemeetsbagel.activities.main.a.k(activityMain, (f2) g.d(this.f18730a.Q0()));
            com.coffeemeetsbagel.activities.main.a.m(activityMain, (SaveProfilesLocalUseCase) g.d(this.f18730a.o0()));
            com.coffeemeetsbagel.activities.main.a.i(activityMain, d0());
            return activityMain;
        }

        private LikesYouDialogUseCase d0() {
            return new LikesYouDialogUseCase((LikesYouMatchRepository) g.d(this.f18730a.t0()), (a6.a) g.d(this.f18730a.x()), (hb.c) g.d(this.f18730a.H()), (ProfileContract$Manager) g.d(this.f18730a.d()));
        }

        public NavStateManager A() {
            return this.f18736g.get();
        }

        public ProfileRepositoryV2 A0() {
            return (ProfileRepositoryV2) g.d(this.f18730a.A0());
        }

        public t B() {
            return (t) g.d(this.f18730a.B());
        }

        public GetLastPassedBagelUseCase B0() {
            return (GetLastPassedBagelUseCase) g.d(this.f18730a.B0());
        }

        public LikesYouMatchRepository C() {
            return (LikesYouMatchRepository) g.d(this.f18730a.t0());
        }

        public com.coffeemeetsbagel.store.alc.d C0() {
            return (com.coffeemeetsbagel.store.alc.d) g.d(this.f18730a.C0());
        }

        public ActivityMain D() {
            return this.f18739k.get();
        }

        public BuySubscriptionUseCase D0() {
            return (BuySubscriptionUseCase) g.d(this.f18730a.g());
        }

        public x5.a E() {
            return this.f18735f.get();
        }

        public GetMyOwnProfileLocalUseCase E0() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f18730a.h());
        }

        public z F() {
            return (z) g.d(this.f18730a.F());
        }

        public d G() {
            return (d) g.d(this.f18730a.G());
        }

        public com.coffeemeetsbagel.match.d G0() {
            return (com.coffeemeetsbagel.match.d) g.d(this.f18730a.G0());
        }

        public hb.c H() {
            return (hb.c) g.d(this.f18730a.H());
        }

        public e H0() {
            return (e) g.d(this.f18730a.H0());
        }

        public ProfileRepositoryV2 J() {
            return (ProfileRepositoryV2) g.d(this.f18730a.A0());
        }

        public b7.c K() {
            return (b7.c) g.d(this.f18730a.K());
        }

        public ActivityMain K0() {
            return this.f18739k.get();
        }

        public a0 L() {
            return (a0) g.d(this.f18730a.L());
        }

        public UpdateBagelLocalUseCase M() {
            return (UpdateBagelLocalUseCase) g.d(this.f18730a.M());
        }

        public j M0() {
            return (j) g.d(this.f18730a.M0());
        }

        public y5.b N0() {
            return this.f18738j.get();
        }

        public com.coffeemeetsbagel.qna.e O() {
            return (com.coffeemeetsbagel.qna.e) g.d(this.f18730a.O());
        }

        public hb.c P() {
            return (hb.c) g.d(this.f18730a.H());
        }

        public t7.a Q() {
            return (t7.a) g.d(this.f18730a.Q());
        }

        public y5.a S() {
            return this.f18737h.get();
        }

        public c V() {
            return this.f18740l.get();
        }

        public y5.b W() {
            return this.f18738j.get();
        }

        public void Z(a1 a1Var) {
        }

        public FirebaseContract.Analytics a0() {
            return (FirebaseContract.Analytics) g.d(this.f18730a.a0());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f18730a.b());
        }

        /* renamed from: b0 */
        public void I(ActivityMain activityMain) {
            c0(activityMain);
        }

        public a7.a c() {
            return (a7.a) g.d(this.f18730a.c());
        }

        public ProfileContract$Manager d() {
            return (ProfileContract$Manager) g.d(this.f18730a.d());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f18730a.e());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f18730a.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f18730a.g());
        }

        public GetFirstEligibleActionCardUseCase g0() {
            return (GetFirstEligibleActionCardUseCase) g.d(this.f18730a.g0());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f18730a.h());
        }

        public m1 i0() {
            return (m1) g.d(this.f18730a.i0());
        }

        public k0 j() {
            return (k0) g.d(this.f18730a.j());
        }

        public l5.a j0() {
            return (l5.a) g.d(this.f18730a.j0());
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f18730a.k());
        }

        public x k0() {
            return (x) g.d(this.f18730a.k0());
        }

        public com.coffeemeetsbagel.match.j l() {
            return (com.coffeemeetsbagel.match.j) g.d(this.f18730a.l());
        }

        public com.coffeemeetsbagel.store.alc.b l0() {
            return (com.coffeemeetsbagel.store.alc.b) g.d(this.f18730a.l0());
        }

        public SubscriptionRepository m() {
            return (SubscriptionRepository) g.d(this.f18730a.m());
        }

        public ActionCardRepository m0() {
            return (ActionCardRepository) g.d(this.f18730a.m0());
        }

        public androidx.appcompat.app.c n() {
            return e1.a(this.f18731b);
        }

        public DeletePromptAnswerUseCase o() {
            return (DeletePromptAnswerUseCase) g.d(this.f18730a.o());
        }

        public SaveProfilesLocalUseCase o0() {
            return (SaveProfilesLocalUseCase) g.d(this.f18730a.o0());
        }

        public c9.d p() {
            return (c9.d) g.d(this.f18730a.p());
        }

        public com.coffeemeetsbagel.qna.g q() {
            return (com.coffeemeetsbagel.qna.g) g.d(this.f18730a.q());
        }

        public k q0() {
            return (k) g.d(this.f18730a.q0());
        }

        public wb.c r() {
            return (wb.c) g.d(this.f18730a.r());
        }

        public y6.a s() {
            return (y6.a) g.d(this.f18730a.s());
        }

        public h t() {
            return (h) g.d(this.f18730a.t());
        }

        public bb.a u() {
            return (bb.a) g.d(this.f18730a.u());
        }

        public GetGroupOptionsRemainingUseCase v() {
            return (GetGroupOptionsRemainingUseCase) g.d(this.f18730a.v());
        }

        public LoadProfileUseCase w() {
            return (LoadProfileUseCase) g.d(this.f18730a.w());
        }

        public com.coffeemeetsbagel.instant_like.d w0() {
            return (com.coffeemeetsbagel.instant_like.d) g.d(this.f18730a.w0());
        }

        public a6.a x() {
            return (a6.a) g.d(this.f18730a.x());
        }

        public GetActivityReportUseCase y() {
            return (GetActivityReportUseCase) g.d(this.f18730a.y());
        }

        public SaveAnswerUseCase z() {
            return (SaveAnswerUseCase) g.d(this.f18730a.z());
        }

        public SuggestedRepository z0() {
            return (SuggestedRepository) g.d(this.f18730a.z0());
        }

        public ActivityMain i() {
            return this.f18739k.get();
        }
    }

    public static a a() {
        return new a();
    }
}
