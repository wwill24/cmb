package com.coffeemeetsbagel.suggested_history;

import androidx.appcompat.app.c;
import b6.d;
import b6.t;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.bagel.UpdateBagelLocalUseCase;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
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
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.suggested_history.k;
import com.coffeemeetsbagel.suggested_history.p;
import fj.g;
import l8.h;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private k.c f37110a;

        /* renamed from: b  reason: collision with root package name */
        private p.a f37111b;

        private a() {
        }

        public k.b a() {
            g.a(this.f37110a, k.c.class);
            g.a(this.f37111b, p.a.class);
            return new C0459b(this.f37110a, this.f37111b);
        }

        public a b(k.c cVar) {
            this.f37110a = (k.c) g.b(cVar);
            return this;
        }

        public a c(p.a aVar) {
            this.f37111b = (p.a) g.b(aVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.suggested_history.b$b  reason: collision with other inner class name */
    private static final class C0459b implements k.b {

        /* renamed from: a  reason: collision with root package name */
        private final k.c f37112a;

        /* renamed from: b  reason: collision with root package name */
        private final p.a f37113b;

        /* renamed from: c  reason: collision with root package name */
        private final C0459b f37114c;

        private C0459b(k.c cVar, p.a aVar) {
            this.f37114c = this;
            this.f37112a = cVar;
            this.f37113b = aVar;
        }

        private SuggestedHistoryCompPresenter A() {
            return l.a(this.f37112a, (d) g.d(this.f37113b.a()));
        }

        private m z(m mVar) {
            t.a(mVar, A());
            n.a(mVar, (bb.a) g.d(this.f37113b.M0()));
            return mVar;
        }

        public SaveAnswerUseCase D() {
            return (SaveAnswerUseCase) g.d(this.f37113b.D());
        }

        public GetHistoryBagelUseCase E0() {
            return (GetHistoryBagelUseCase) g.d(this.f37113b.E0());
        }

        public com.coffeemeetsbagel.match.d F0() {
            return (com.coffeemeetsbagel.match.d) g.d(this.f37113b.F0());
        }

        public x J() {
            return (x) g.d(this.f37113b.J());
        }

        public com.coffeemeetsbagel.store.alc.b L0() {
            return (com.coffeemeetsbagel.store.alc.b) g.d(this.f37113b.L0());
        }

        public UpdateBagelLocalUseCase M() {
            return (UpdateBagelLocalUseCase) g.d(this.f37113b.M());
        }

        public e O() {
            return (e) g.d(this.f37113b.O());
        }

        public SubscriptionRepository P() {
            return (SubscriptionRepository) g.d(this.f37113b.P());
        }

        public d<?, ?> a() {
            return (d) g.d(this.f37113b.a());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f37113b.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f37113b.c());
        }

        public ProfileContract$Manager d() {
            return (ProfileContract$Manager) g.d(this.f37113b.d());
        }

        public j d0() {
            return (j) g.d(this.f37113b.d0());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f37113b.e());
        }

        public c6.b e0() {
            return (c6.b) g.d(this.f37113b.e0());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f37113b.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f37113b.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f37113b.h());
        }

        public k0 j() {
            return (k0) g.d(this.f37113b.j());
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f37113b.k());
        }

        public com.coffeemeetsbagel.match.j l() {
            return (com.coffeemeetsbagel.match.j) g.d(this.f37113b.l());
        }

        /* renamed from: m */
        public void l1(m mVar) {
            z(mVar);
        }

        public c n() {
            return (c) g.d(this.f37113b.n());
        }

        public DeletePromptAnswerUseCase o() {
            return (DeletePromptAnswerUseCase) g.d(this.f37113b.o());
        }

        public c9.d p() {
            return (c9.d) g.d(this.f37113b.p());
        }

        public com.coffeemeetsbagel.qna.g q() {
            return (com.coffeemeetsbagel.qna.g) g.d(this.f37113b.q());
        }

        public wb.c r() {
            return (wb.c) g.d(this.f37113b.r());
        }

        public y6.a s() {
            return (y6.a) g.d(this.f37113b.s());
        }

        public h t() {
            return (h) g.d(this.f37113b.t());
        }

        public bb.a u() {
            return (bb.a) g.d(this.f37113b.M0());
        }

        public z u0() {
            return (z) g.d(this.f37113b.u0());
        }

        public GetGroupOptionsRemainingUseCase v() {
            return (GetGroupOptionsRemainingUseCase) g.d(this.f37113b.v());
        }

        public LoadProfileUseCase w() {
            return (LoadProfileUseCase) g.d(this.f37113b.w());
        }

        public a6.a x() {
            return (a6.a) g.d(this.f37113b.x());
        }

        public FirebaseContract.Analytics x0() {
            return (FirebaseContract.Analytics) g.d(this.f37113b.x0());
        }

        public GetActivityReportUseCase y() {
            return (GetActivityReportUseCase) g.d(this.f37113b.y());
        }
    }

    public static a a() {
        return new a();
    }
}
