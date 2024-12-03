package com.coffeemeetsbagel.bagel_profile.main;

import androidx.appcompat.app.c;
import b6.t;
import com.coffeemeetsbagel.bagel_profile.main.d;
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
import fj.g;

public final class b {

    private static final class a implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f11037a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f11038b;

        /* renamed from: c  reason: collision with root package name */
        private final a f11039c;

        private a(d.b bVar, d.c cVar) {
            this.f11039c = this;
            this.f11037a = bVar;
            this.f11038b = cVar;
        }

        private com.coffemeetsbagel.hide_report.a j() {
            return e.a(this.f11037a, (ProfileRepository) g.d(this.f11038b.A()));
        }

        private GenericMatchContainerV2Interactor m(GenericMatchContainerV2Interactor genericMatchContainerV2Interactor) {
            t.a(genericMatchContainerV2Interactor, f.a(this.f11037a));
            h.i(genericMatchContainerV2Interactor, (ProfileContract$Manager) g.d(this.f11038b.d()));
            h.c(genericMatchContainerV2Interactor, (c6.b) g.d(this.f11038b.a0()));
            h.a(genericMatchContainerV2Interactor, (c) g.d(this.f11038b.n()));
            h.d(genericMatchContainerV2Interactor, (a7.a) g.d(this.f11038b.R()));
            h.g(genericMatchContainerV2Interactor, (v7.d) g.d(this.f11038b.G()));
            h.b(genericMatchContainerV2Interactor, (y6.a) g.d(this.f11038b.s()));
            h.e(genericMatchContainerV2Interactor, j());
            h.h(genericMatchContainerV2Interactor, (s9.a) g.d(this.f11038b.b()));
            h.f(genericMatchContainerV2Interactor, (a6.a) g.d(this.f11038b.N()));
            h.j(genericMatchContainerV2Interactor, (k0) g.d(this.f11038b.j()));
            return genericMatchContainerV2Interactor;
        }

        public SaveAnswerUseCase D() {
            return (SaveAnswerUseCase) g.d(this.f11038b.D());
        }

        public x J() {
            return (x) g.d(this.f11038b.J());
        }

        public a6.a N() {
            return (a6.a) g.d(this.f11038b.N());
        }

        public e O() {
            return (e) g.d(this.f11038b.Y());
        }

        public SubscriptionRepository P() {
            return (SubscriptionRepository) g.d(this.f11038b.m());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f11038b.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f11038b.R());
        }

        public ProfileContract$Manager d() {
            return (ProfileContract$Manager) g.d(this.f11038b.d());
        }

        public j d0() {
            return (j) g.d(this.f11038b.f0());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f11038b.e());
        }

        public c6.b e0() {
            return (c6.b) g.d(this.f11038b.a0());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f11038b.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f11038b.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f11038b.h());
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f11038b.k());
        }

        /* renamed from: l */
        public void l1(GenericMatchContainerV2Interactor genericMatchContainerV2Interactor) {
            m(genericMatchContainerV2Interactor);
        }

        public c n() {
            return (c) g.d(this.f11038b.n());
        }

        public DeletePromptAnswerUseCase o() {
            return (DeletePromptAnswerUseCase) g.d(this.f11038b.o());
        }

        public c9.d p() {
            return (c9.d) g.d(this.f11038b.p());
        }

        public com.coffeemeetsbagel.qna.g q() {
            return (com.coffeemeetsbagel.qna.g) g.d(this.f11038b.q());
        }

        public y6.a s() {
            return (y6.a) g.d(this.f11038b.s());
        }

        public bb.a u() {
            return (bb.a) g.d(this.f11038b.u());
        }

        public GetGroupOptionsRemainingUseCase v() {
            return (GetGroupOptionsRemainingUseCase) g.d(this.f11038b.v());
        }

        public LoadProfileUseCase w() {
            return (LoadProfileUseCase) g.d(this.f11038b.w());
        }

        public GetActivityReportUseCase y() {
            return (GetActivityReportUseCase) g.d(this.f11038b.y());
        }
    }

    /* renamed from: com.coffeemeetsbagel.bagel_profile.main.b$b  reason: collision with other inner class name */
    public static final class C0125b {

        /* renamed from: a  reason: collision with root package name */
        private d.b f11040a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f11041b;

        private C0125b() {
        }

        public C0125b a(d.b bVar) {
            this.f11040a = (d.b) g.b(bVar);
            return this;
        }

        public d.a b() {
            g.a(this.f11040a, d.b.class);
            g.a(this.f11041b, d.c.class);
            return new a(this.f11040a, this.f11041b);
        }

        public C0125b c(d.c cVar) {
            this.f11041b = (d.c) g.b(cVar);
            return this;
        }
    }

    public static C0125b a() {
        return new C0125b();
    }
}
