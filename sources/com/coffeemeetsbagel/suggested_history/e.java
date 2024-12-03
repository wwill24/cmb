package com.coffeemeetsbagel.suggested_history;

import androidx.appcompat.app.c;
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
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.suggested_history.p;
import fj.g;
import l8.h;

public final class e {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private p.b f37115a;

        /* renamed from: b  reason: collision with root package name */
        private q f37116b;

        private a() {
        }

        public p.a a() {
            g.a(this.f37115a, p.b.class);
            g.a(this.f37116b, q.class);
            return new b(this.f37115a, this.f37116b);
        }

        public a b(q qVar) {
            this.f37116b = (q) g.b(qVar);
            return this;
        }

        public a c(p.b bVar) {
            this.f37115a = (p.b) g.b(bVar);
            return this;
        }
    }

    private static final class b implements p.a {

        /* renamed from: a  reason: collision with root package name */
        private final p.b f37117a;

        /* renamed from: b  reason: collision with root package name */
        private final q f37118b;

        /* renamed from: c  reason: collision with root package name */
        private final b f37119c;

        private b(p.b bVar, q qVar) {
            this.f37119c = this;
            this.f37117a = bVar;
            this.f37118b = qVar;
        }

        public SaveAnswerUseCase D() {
            return (SaveAnswerUseCase) g.d(this.f37118b.D());
        }

        public GetHistoryBagelUseCase E0() {
            return (GetHistoryBagelUseCase) g.d(this.f37118b.E0());
        }

        public d F0() {
            return (d) g.d(this.f37118b.F0());
        }

        public x J() {
            return (x) g.d(this.f37118b.J());
        }

        public com.coffeemeetsbagel.store.alc.b L0() {
            return (com.coffeemeetsbagel.store.alc.b) g.d(this.f37118b.L0());
        }

        public UpdateBagelLocalUseCase M() {
            return (UpdateBagelLocalUseCase) g.d(this.f37118b.M());
        }

        public bb.a M0() {
            return (bb.a) g.d(this.f37118b.i());
        }

        public com.coffeemeetsbagel.qna.e O() {
            return (com.coffeemeetsbagel.qna.e) g.d(this.f37118b.O());
        }

        public SubscriptionRepository P() {
            return (SubscriptionRepository) g.d(this.f37118b.P());
        }

        public b6.d<?, ?> a() {
            return t.a(this.f37117a);
        }

        public s9.a b() {
            return (s9.a) g.d(this.f37118b.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f37118b.c());
        }

        public ProfileContract$Manager d() {
            return (ProfileContract$Manager) g.d(this.f37118b.d());
        }

        public j d0() {
            return (j) g.d(this.f37118b.d0());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f37118b.e());
        }

        public c6.b e0() {
            return r.a(this.f37117a);
        }

        public cb.a f() {
            return (cb.a) g.d(this.f37118b.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f37118b.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f37118b.h());
        }

        /* renamed from: i */
        public void g0(p pVar) {
        }

        public k0 j() {
            return (k0) g.d(this.f37118b.j());
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f37118b.k());
        }

        public com.coffeemeetsbagel.match.j l() {
            return (com.coffeemeetsbagel.match.j) g.d(this.f37118b.l());
        }

        public c n() {
            return s.a(this.f37117a);
        }

        public DeletePromptAnswerUseCase o() {
            return (DeletePromptAnswerUseCase) g.d(this.f37118b.o());
        }

        public c9.d p() {
            return (c9.d) g.d(this.f37118b.p());
        }

        public com.coffeemeetsbagel.qna.g q() {
            return (com.coffeemeetsbagel.qna.g) g.d(this.f37118b.q());
        }

        public wb.c r() {
            return (wb.c) g.d(this.f37118b.r());
        }

        public y6.a s() {
            return (y6.a) g.d(this.f37118b.s());
        }

        public h t() {
            return (h) g.d(this.f37118b.t());
        }

        public z u0() {
            return (z) g.d(this.f37118b.u0());
        }

        public GetGroupOptionsRemainingUseCase v() {
            return (GetGroupOptionsRemainingUseCase) g.d(this.f37118b.v());
        }

        public LoadProfileUseCase w() {
            return (LoadProfileUseCase) g.d(this.f37118b.w());
        }

        public a6.a x() {
            return (a6.a) g.d(this.f37118b.x());
        }

        public FirebaseContract.Analytics x0() {
            return (FirebaseContract.Analytics) g.d(this.f37118b.x0());
        }

        public GetActivityReportUseCase y() {
            return (GetActivityReportUseCase) g.d(this.f37118b.y());
        }
    }

    public static a a() {
        return new a();
    }
}
