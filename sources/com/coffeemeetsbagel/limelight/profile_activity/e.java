package com.coffeemeetsbagel.limelight.profile_activity;

import b6.d;
import b6.t;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.limelight.profile_activity.r;
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
import fj.g;
import l8.h;
import wb.c;

public final class e {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private r.b f34435a;

        /* renamed from: b  reason: collision with root package name */
        private r.c f34436b;

        private a() {
        }

        public r.a a() {
            g.a(this.f34435a, r.b.class);
            g.a(this.f34436b, r.c.class);
            return new b(this.f34435a, this.f34436b);
        }

        public a b(r.b bVar) {
            this.f34435a = (r.b) g.b(bVar);
            return this;
        }

        public a c(r.c cVar) {
            this.f34436b = (r.c) g.b(cVar);
            return this;
        }
    }

    private static final class b implements r.a {

        /* renamed from: a  reason: collision with root package name */
        private final r.b f34437a;

        /* renamed from: b  reason: collision with root package name */
        private final r.c f34438b;

        /* renamed from: c  reason: collision with root package name */
        private final b f34439c;

        private b(r.b bVar, r.c cVar) {
            this.f34439c = this;
            this.f34437a = bVar;
            this.f34438b = cVar;
        }

        private LikesYouMatchContainerInteractor l(LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
            t.a(likesYouMatchContainerInteractor, t.a(this.f34437a));
            o0.g(likesYouMatchContainerInteractor, (a0) g.d(this.f34438b.L()));
            o0.h(likesYouMatchContainerInteractor, (h) g.d(this.f34438b.t()));
            o0.b(likesYouMatchContainerInteractor, (a7.a) g.d(this.f34438b.R()));
            o0.f(likesYouMatchContainerInteractor, (z) g.d(this.f34438b.F()));
            o0.c(likesYouMatchContainerInteractor, (j) g.d(this.f34438b.l()));
            o0.j(likesYouMatchContainerInteractor, (cb.a) g.d(this.f34438b.f()));
            o0.i(likesYouMatchContainerInteractor, (com.coffeemeetsbagel.experiment.t) g.d(this.f34438b.B()));
            o0.a(likesYouMatchContainerInteractor, e0());
            o0.e(likesYouMatchContainerInteractor, (LikesYouMatchRepository) g.d(this.f34438b.t0()));
            o0.d(likesYouMatchContainerInteractor, (c) g.d(this.f34438b.r()));
            return likesYouMatchContainerInteractor;
        }

        public SaveAnswerUseCase D() {
            return (SaveAnswerUseCase) g.d(this.f34438b.D());
        }

        public x J() {
            return (x) g.d(this.f34438b.J());
        }

        public a6.a N() {
            return (a6.a) g.d(this.f34438b.N());
        }

        public com.coffeemeetsbagel.qna.e O() {
            return (com.coffeemeetsbagel.qna.e) g.d(this.f34438b.Y());
        }

        public SubscriptionRepository P() {
            return (SubscriptionRepository) g.d(this.f34438b.m());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f34438b.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f34438b.R());
        }

        public ProfileContract$Manager d() {
            return (ProfileContract$Manager) g.d(this.f34438b.d());
        }

        public com.coffeemeetsbagel.qna.j d0() {
            return (com.coffeemeetsbagel.qna.j) g.d(this.f34438b.f0());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f34438b.e());
        }

        public c6.b e0() {
            return s.a(this.f34437a, (d) g.d(this.f34438b.a()));
        }

        public cb.a f() {
            return (cb.a) g.d(this.f34438b.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f34438b.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f34438b.h());
        }

        /* renamed from: j */
        public void l1(LikesYouMatchContainerInteractor likesYouMatchContainerInteractor) {
            l(likesYouMatchContainerInteractor);
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f34438b.k());
        }

        public androidx.appcompat.app.c n() {
            return (androidx.appcompat.app.c) g.d(this.f34438b.n());
        }

        public DeletePromptAnswerUseCase o() {
            return (DeletePromptAnswerUseCase) g.d(this.f34438b.o());
        }

        public c9.d p() {
            return (c9.d) g.d(this.f34438b.p());
        }

        public com.coffeemeetsbagel.qna.g q() {
            return (com.coffeemeetsbagel.qna.g) g.d(this.f34438b.q());
        }

        public y6.a s() {
            return (y6.a) g.d(this.f34438b.s());
        }

        public bb.a u() {
            return (bb.a) g.d(this.f34438b.u());
        }

        public GetGroupOptionsRemainingUseCase v() {
            return (GetGroupOptionsRemainingUseCase) g.d(this.f34438b.v());
        }

        public LoadProfileUseCase w() {
            return (LoadProfileUseCase) g.d(this.f34438b.w());
        }

        public GetActivityReportUseCase y() {
            return (GetActivityReportUseCase) g.d(this.f34438b.y());
        }
    }

    public static a a() {
        return new a();
    }
}
