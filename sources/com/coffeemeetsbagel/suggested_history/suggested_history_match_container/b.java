package com.coffeemeetsbagel.suggested_history.suggested_history_match_container;

import b6.t;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
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
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.suggested_history.suggested_history_match_container.e;
import fj.g;
import l8.h;
import wb.c;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private e.c f37195a;

        /* renamed from: b  reason: collision with root package name */
        private e.a f37196b;

        private a() {
        }

        public e.b a() {
            g.a(this.f37195a, e.c.class);
            g.a(this.f37196b, e.a.class);
            return new C0461b(this.f37195a, this.f37196b);
        }

        public a b(e.a aVar) {
            this.f37196b = (e.a) g.b(aVar);
            return this;
        }

        public a c(e.c cVar) {
            this.f37195a = (e.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.suggested_history.suggested_history_match_container.b$b  reason: collision with other inner class name */
    private static final class C0461b implements e.b {

        /* renamed from: a  reason: collision with root package name */
        private final e.c f37197a;

        /* renamed from: b  reason: collision with root package name */
        private final e.a f37198b;

        /* renamed from: c  reason: collision with root package name */
        private final C0461b f37199c;

        private C0461b(e.c cVar, e.a aVar) {
            this.f37199c = this;
            this.f37197a = cVar;
            this.f37198b = aVar;
        }

        private com.coffeemeetsbagel.store.alc.a j() {
            return f.a(this.f37197a, (a7.a) g.d(this.f37198b.c()), (FirebaseContract.Analytics) g.d(this.f37198b.x0()));
        }

        private SuggestedHistoryMatchContainerInteractor m(SuggestedHistoryMatchContainerInteractor suggestedHistoryMatchContainerInteractor) {
            t.a(suggestedHistoryMatchContainerInteractor, g.a(this.f37197a));
            w.n(suggestedHistoryMatchContainerInteractor, (z) g.d(this.f37198b.u0()));
            w.a(suggestedHistoryMatchContainerInteractor, (d) g.d(this.f37198b.F0()));
            w.i(suggestedHistoryMatchContainerInteractor, (h) g.d(this.f37198b.t()));
            w.e(suggestedHistoryMatchContainerInteractor, (j) g.d(this.f37198b.l()));
            w.g(suggestedHistoryMatchContainerInteractor, (s9.a) g.d(this.f37198b.b()));
            w.h(suggestedHistoryMatchContainerInteractor, (c) g.d(this.f37198b.r()));
            w.d(suggestedHistoryMatchContainerInteractor, (a7.a) g.d(this.f37198b.c()));
            w.b(suggestedHistoryMatchContainerInteractor, (c6.b) g.d(this.f37198b.e0()));
            w.f(suggestedHistoryMatchContainerInteractor, (a6.a) g.d(this.f37198b.x()));
            w.k(suggestedHistoryMatchContainerInteractor, (com.coffeemeetsbagel.store.alc.b) g.d(this.f37198b.L0()));
            w.m(suggestedHistoryMatchContainerInteractor, (UpdateBagelLocalUseCase) g.d(this.f37198b.M()));
            w.l(suggestedHistoryMatchContainerInteractor, (k0) g.d(this.f37198b.j()));
            w.j(suggestedHistoryMatchContainerInteractor, (ProfileContract$Manager) g.d(this.f37198b.d()));
            w.c(suggestedHistoryMatchContainerInteractor, j());
            return suggestedHistoryMatchContainerInteractor;
        }

        public SaveAnswerUseCase D() {
            return (SaveAnswerUseCase) g.d(this.f37198b.D());
        }

        public x J() {
            return (x) g.d(this.f37198b.J());
        }

        public a6.a N() {
            return (a6.a) g.d(this.f37198b.x());
        }

        public com.coffeemeetsbagel.qna.e O() {
            return (com.coffeemeetsbagel.qna.e) g.d(this.f37198b.O());
        }

        public SubscriptionRepository P() {
            return (SubscriptionRepository) g.d(this.f37198b.P());
        }

        public b6.d<?, ?> a() {
            return (b6.d) g.d(this.f37198b.a());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f37198b.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f37198b.c());
        }

        public ProfileContract$Manager d() {
            return (ProfileContract$Manager) g.d(this.f37198b.d());
        }

        public com.coffeemeetsbagel.qna.j d0() {
            return (com.coffeemeetsbagel.qna.j) g.d(this.f37198b.d0());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f37198b.e());
        }

        public c6.b e0() {
            return (c6.b) g.d(this.f37198b.e0());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f37198b.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f37198b.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f37198b.h());
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f37198b.k());
        }

        /* renamed from: l */
        public void l1(SuggestedHistoryMatchContainerInteractor suggestedHistoryMatchContainerInteractor) {
            m(suggestedHistoryMatchContainerInteractor);
        }

        public androidx.appcompat.app.c n() {
            return (androidx.appcompat.app.c) g.d(this.f37198b.n());
        }

        public DeletePromptAnswerUseCase o() {
            return (DeletePromptAnswerUseCase) g.d(this.f37198b.o());
        }

        public c9.d p() {
            return (c9.d) g.d(this.f37198b.p());
        }

        public com.coffeemeetsbagel.qna.g q() {
            return (com.coffeemeetsbagel.qna.g) g.d(this.f37198b.q());
        }

        public y6.a s() {
            return (y6.a) g.d(this.f37198b.s());
        }

        public bb.a u() {
            return (bb.a) g.d(this.f37198b.u());
        }

        public GetGroupOptionsRemainingUseCase v() {
            return (GetGroupOptionsRemainingUseCase) g.d(this.f37198b.v());
        }

        public LoadProfileUseCase w() {
            return (LoadProfileUseCase) g.d(this.f37198b.w());
        }

        public GetActivityReportUseCase y() {
            return (GetActivityReportUseCase) g.d(this.f37198b.y());
        }
    }

    public static a a() {
        return new a();
    }
}
