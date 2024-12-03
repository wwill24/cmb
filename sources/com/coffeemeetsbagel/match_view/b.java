package com.coffeemeetsbagel.match_view;

import androidx.appcompat.app.c;
import b6.t;
import c9.d;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.x;
import com.coffeemeetsbagel.match_view.m;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.e;
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private m.b f34654a;

        /* renamed from: b  reason: collision with root package name */
        private m.c f34655b;

        private a() {
        }

        public m.a a() {
            g.a(this.f34654a, m.b.class);
            g.a(this.f34655b, m.c.class);
            return new C0413b(this.f34654a, this.f34655b);
        }

        public a b(m.b bVar) {
            this.f34654a = (m.b) g.b(bVar);
            return this;
        }

        public a c(m.c cVar) {
            this.f34655b = (m.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.match_view.b$b  reason: collision with other inner class name */
    private static final class C0413b implements m.a {

        /* renamed from: a  reason: collision with root package name */
        private final m.b f34656a;

        /* renamed from: b  reason: collision with root package name */
        private final m.c f34657b;

        /* renamed from: c  reason: collision with root package name */
        private final C0413b f34658c;

        private C0413b(m.b bVar, m.c cVar) {
            this.f34658c = this;
            this.f34656a = bVar;
            this.f34657b = cVar;
        }

        private MatchViewInteractor j(MatchViewInteractor matchViewInteractor) {
            t.a(matchViewInteractor, n.a(this.f34656a));
            d0.b(matchViewInteractor, (GetActivityReportUseCase) g.d(this.f34657b.y()));
            d0.a(matchViewInteractor, (y6.a) g.d(this.f34657b.s()));
            d0.m(matchViewInteractor, (ProfileContract$Manager) g.d(this.f34657b.d()));
            d0.d(matchViewInteractor, (a7.a) g.d(this.f34657b.c()));
            d0.f(matchViewInteractor, (s9.a) g.d(this.f34657b.b()));
            d0.k(matchViewInteractor, (x) g.d(this.f34657b.J()));
            d0.c(matchViewInteractor, (c6.b) g.d(this.f34657b.e0()));
            d0.h(matchViewInteractor, (j) g.d(this.f34657b.d0()));
            d0.l(matchViewInteractor, (e) g.d(this.f34657b.O()));
            d0.p(matchViewInteractor, (bb.a) g.d(this.f34657b.u()));
            d0.n(matchViewInteractor, l());
            d0.i(matchViewInteractor, (com.coffeemeetsbagel.qna.g) g.d(this.f34657b.q()));
            d0.e(matchViewInteractor, (a6.a) g.d(this.f34657b.N()));
            d0.o(matchViewInteractor, (SaveAnswerUseCase) g.d(this.f34657b.D()));
            d0.g(matchViewInteractor, (GetGroupOptionsRemainingUseCase) g.d(this.f34657b.v()));
            d0.j(matchViewInteractor, (LoadProfileUseCase) g.d(this.f34657b.w()));
            return matchViewInteractor;
        }

        private ProfileStringFormatter l() {
            return o.a(this.f34656a, (bb.a) g.d(this.f34657b.u()), (d) g.d(this.f34657b.p()));
        }

        public a7.a S() {
            return (a7.a) g.d(this.f34657b.c());
        }

        public c6.b a0() {
            return (c6.b) g.d(this.f34657b.e0());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f34657b.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f34657b.c());
        }

        /* renamed from: d */
        public void l1(MatchViewInteractor matchViewInteractor) {
            j(matchViewInteractor);
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f34657b.e());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f34657b.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f34657b.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f34657b.h());
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f34657b.k());
        }

        public SubscriptionRepository m() {
            return (SubscriptionRepository) g.d(this.f34657b.P());
        }

        public c n() {
            return (c) g.d(this.f34657b.n());
        }

        public DeletePromptAnswerUseCase o() {
            return (DeletePromptAnswerUseCase) g.d(this.f34657b.o());
        }

        public com.coffeemeetsbagel.qna.g q() {
            return (com.coffeemeetsbagel.qna.g) g.d(this.f34657b.q());
        }
    }

    public static a a() {
        return new a();
    }
}
