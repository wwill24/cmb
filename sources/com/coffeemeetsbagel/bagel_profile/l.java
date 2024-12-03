package com.coffeemeetsbagel.bagel_profile;

import androidx.appcompat.app.c;
import com.coffeemeetsbagel.bagel_profile.g;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.x;
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
import v7.d;

public final class l {

    private static final class a implements g.a {

        /* renamed from: a  reason: collision with root package name */
        private final g.b f11009a;

        /* renamed from: b  reason: collision with root package name */
        private final h f11010b;

        /* renamed from: c  reason: collision with root package name */
        private final a f11011c;

        private a(g.b bVar, h hVar) {
            this.f11011c = this;
            this.f11009a = bVar;
            this.f11010b = hVar;
        }

        public ProfileRepository A() {
            return (ProfileRepository) fj.g.d(this.f11010b.A());
        }

        public SaveAnswerUseCase D() {
            return (SaveAnswerUseCase) fj.g.d(this.f11010b.D());
        }

        public d G() {
            return (d) fj.g.d(this.f11010b.G());
        }

        public x J() {
            return (x) fj.g.d(this.f11010b.k0());
        }

        public a6.a N() {
            return (a6.a) fj.g.d(this.f11010b.N());
        }

        public a7.a R() {
            return (a7.a) fj.g.d(this.f11010b.R());
        }

        public e Y() {
            return (e) fj.g.d(this.f11010b.O());
        }

        public c6.b a0() {
            return i.a(this.f11009a);
        }

        public s9.a b() {
            return (s9.a) fj.g.d(this.f11010b.b());
        }

        /* renamed from: c */
        public void g0(g gVar) {
        }

        public ProfileContract$Manager d() {
            return (ProfileContract$Manager) fj.g.d(this.f11010b.d());
        }

        public UserRepository e() {
            return (UserRepository) fj.g.d(this.f11010b.e());
        }

        public cb.a f() {
            return (cb.a) fj.g.d(this.f11010b.f());
        }

        public j f0() {
            return (j) fj.g.d(this.f11010b.f0());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) fj.g.d(this.f11010b.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) fj.g.d(this.f11010b.h());
        }

        public k0 j() {
            return (k0) fj.g.d(this.f11010b.j());
        }

        public QuestionRepository k() {
            return (QuestionRepository) fj.g.d(this.f11010b.k());
        }

        public SubscriptionRepository m() {
            return (SubscriptionRepository) fj.g.d(this.f11010b.m());
        }

        public c n() {
            return j.a(this.f11009a);
        }

        public DeletePromptAnswerUseCase o() {
            return (DeletePromptAnswerUseCase) fj.g.d(this.f11010b.o());
        }

        public c9.d p() {
            return (c9.d) fj.g.d(this.f11010b.p());
        }

        public com.coffeemeetsbagel.qna.g q() {
            return (com.coffeemeetsbagel.qna.g) fj.g.d(this.f11010b.q());
        }

        public y6.a s() {
            return (y6.a) fj.g.d(this.f11010b.s());
        }

        public bb.a u() {
            return (bb.a) fj.g.d(this.f11010b.u());
        }

        public GetGroupOptionsRemainingUseCase v() {
            return (GetGroupOptionsRemainingUseCase) fj.g.d(this.f11010b.v());
        }

        public LoadProfileUseCase w() {
            return (LoadProfileUseCase) fj.g.d(this.f11010b.w());
        }

        public GetActivityReportUseCase y() {
            return (GetActivityReportUseCase) fj.g.d(this.f11010b.y());
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private g.b f11012a;

        /* renamed from: b  reason: collision with root package name */
        private h f11013b;

        private b() {
        }

        public b a(h hVar) {
            this.f11013b = (h) fj.g.b(hVar);
            return this;
        }

        public b b(g.b bVar) {
            this.f11012a = (g.b) fj.g.b(bVar);
            return this;
        }

        public g.a c() {
            fj.g.a(this.f11012a, g.b.class);
            fj.g.a(this.f11013b, h.class);
            return new a(this.f11012a, this.f11013b);
        }
    }

    public static b a() {
        return new b();
    }
}
