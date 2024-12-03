package com.coffeemeetsbagel.limelight.profile_activity;

import android.app.Activity;
import androidx.appcompat.app.c;
import b6.d;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.limelight.profile_activity.j;
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
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import fj.g;
import l8.h;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private j.b f34429a;

        private a() {
        }

        public j.a a() {
            g.a(this.f34429a, j.b.class);
            return new C0412b(this.f34429a);
        }

        public a b(j.b bVar) {
            this.f34429a = (j.b) g.b(bVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.limelight.profile_activity.b$b  reason: collision with other inner class name */
    private static final class C0412b implements j.a {

        /* renamed from: a  reason: collision with root package name */
        private final j.b f34430a;

        /* renamed from: b  reason: collision with root package name */
        private final C0412b f34431b;

        private C0412b(j.b bVar) {
            this.f34431b = this;
            this.f34430a = bVar;
        }

        private LikesYouBrowserInteractor j(LikesYouBrowserInteractor likesYouBrowserInteractor) {
            o.a(likesYouBrowserInteractor, (LikesYouMatchRepository) g.d(this.f34430a.t0()));
            return likesYouBrowserInteractor;
        }

        public t B() {
            return (t) g.d(this.f34430a.B());
        }

        public SaveAnswerUseCase D() {
            return (SaveAnswerUseCase) g.d(this.f34430a.D());
        }

        public z F() {
            return (z) g.d(this.f34430a.F());
        }

        public x J() {
            return (x) g.d(this.f34430a.J());
        }

        public a0 L() {
            return (a0) g.d(this.f34430a.L());
        }

        public a6.a N() {
            return (a6.a) g.d(this.f34430a.N());
        }

        public a7.a R() {
            return (a7.a) g.d(this.f34430a.R());
        }

        public e Y() {
            return (e) g.d(this.f34430a.Y());
        }

        public d<?, ?> a() {
            return (d) g.d(this.f34430a.a());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f34430a.b());
        }

        /* renamed from: c */
        public void l1(LikesYouBrowserInteractor likesYouBrowserInteractor) {
            j(likesYouBrowserInteractor);
        }

        public ProfileContract$Manager d() {
            return (ProfileContract$Manager) g.d(this.f34430a.d());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f34430a.e());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f34430a.f());
        }

        public com.coffeemeetsbagel.qna.j f0() {
            return (com.coffeemeetsbagel.qna.j) g.d(this.f34430a.f0());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f34430a.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f34430a.h());
        }

        public Activity i() {
            return (Activity) g.d(this.f34430a.i());
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f34430a.k());
        }

        public com.coffeemeetsbagel.match.j l() {
            return (com.coffeemeetsbagel.match.j) g.d(this.f34430a.l());
        }

        public SubscriptionRepository m() {
            return (SubscriptionRepository) g.d(this.f34430a.m());
        }

        public c n() {
            return (c) g.d(this.f34430a.n());
        }

        public DeletePromptAnswerUseCase o() {
            return (DeletePromptAnswerUseCase) g.d(this.f34430a.o());
        }

        public c9.d p() {
            return (c9.d) g.d(this.f34430a.p());
        }

        public com.coffeemeetsbagel.qna.g q() {
            return (com.coffeemeetsbagel.qna.g) g.d(this.f34430a.q());
        }

        public wb.c r() {
            return (wb.c) g.d(this.f34430a.r());
        }

        public y6.a s() {
            return (y6.a) g.d(this.f34430a.s());
        }

        public h t() {
            return (h) g.d(this.f34430a.t());
        }

        public LikesYouMatchRepository t0() {
            return (LikesYouMatchRepository) g.d(this.f34430a.t0());
        }

        public bb.a u() {
            return (bb.a) g.d(this.f34430a.u());
        }

        public GetGroupOptionsRemainingUseCase v() {
            return (GetGroupOptionsRemainingUseCase) g.d(this.f34430a.v());
        }

        public LoadProfileUseCase w() {
            return (LoadProfileUseCase) g.d(this.f34430a.w());
        }

        public GetActivityReportUseCase y() {
            return (GetActivityReportUseCase) g.d(this.f34430a.y());
        }
    }

    public static a a() {
        return new a();
    }
}
