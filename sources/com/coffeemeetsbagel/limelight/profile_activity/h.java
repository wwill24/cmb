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
import com.coffeemeetsbagel.limelight.profile_activity.q0;
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
import fj.g;

public final class h {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private q0.b f34442a;

        /* renamed from: b  reason: collision with root package name */
        private r0 f34443b;

        private a() {
        }

        public q0.a a() {
            g.a(this.f34442a, q0.b.class);
            g.a(this.f34443b, r0.class);
            return new b(this.f34442a, this.f34443b);
        }

        public a b(r0 r0Var) {
            this.f34443b = (r0) g.b(r0Var);
            return this;
        }

        public a c(q0.b bVar) {
            this.f34442a = (q0.b) g.b(bVar);
            return this;
        }
    }

    private static final class b implements q0.a {

        /* renamed from: a  reason: collision with root package name */
        private final q0.b f34444a;

        /* renamed from: b  reason: collision with root package name */
        private final r0 f34445b;

        /* renamed from: c  reason: collision with root package name */
        private final b f34446c;

        private b(q0.b bVar, r0 r0Var) {
            this.f34446c = this;
            this.f34444a = bVar;
            this.f34445b = r0Var;
        }

        public t B() {
            return (t) g.d(this.f34445b.B());
        }

        public SaveAnswerUseCase D() {
            return (SaveAnswerUseCase) g.d(this.f34445b.D());
        }

        public z F() {
            return (z) g.d(this.f34445b.F());
        }

        public x J() {
            return (x) g.d(this.f34445b.J());
        }

        public a0 L() {
            return (a0) g.d(this.f34445b.L());
        }

        public a6.a N() {
            return (a6.a) g.d(this.f34445b.N());
        }

        public a7.a R() {
            return (a7.a) g.d(this.f34445b.R());
        }

        public e Y() {
            return (e) g.d(this.f34445b.Y());
        }

        public d<?, ?> a() {
            return u0.a(this.f34444a);
        }

        public s9.a b() {
            return (s9.a) g.d(this.f34445b.b());
        }

        /* renamed from: c */
        public void g0(q0 q0Var) {
        }

        public ProfileContract$Manager d() {
            return (ProfileContract$Manager) g.d(this.f34445b.d());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f34445b.e());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f34445b.f());
        }

        public j f0() {
            return (j) g.d(this.f34445b.O0());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f34445b.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f34445b.h());
        }

        public Activity i() {
            return s0.a(this.f34444a);
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f34445b.k());
        }

        public com.coffeemeetsbagel.match.j l() {
            return (com.coffeemeetsbagel.match.j) g.d(this.f34445b.l());
        }

        public SubscriptionRepository m() {
            return (SubscriptionRepository) g.d(this.f34445b.m());
        }

        public c n() {
            return t0.a(this.f34444a);
        }

        public DeletePromptAnswerUseCase o() {
            return (DeletePromptAnswerUseCase) g.d(this.f34445b.o());
        }

        public c9.d p() {
            return (c9.d) g.d(this.f34445b.p());
        }

        public com.coffeemeetsbagel.qna.g q() {
            return (com.coffeemeetsbagel.qna.g) g.d(this.f34445b.q());
        }

        public wb.c r() {
            return (wb.c) g.d(this.f34445b.r());
        }

        public y6.a s() {
            return (y6.a) g.d(this.f34445b.s());
        }

        public l8.h t() {
            return (l8.h) g.d(this.f34445b.t());
        }

        public LikesYouMatchRepository t0() {
            return (LikesYouMatchRepository) g.d(this.f34445b.t0());
        }

        public bb.a u() {
            return (bb.a) g.d(this.f34445b.u());
        }

        public GetGroupOptionsRemainingUseCase v() {
            return (GetGroupOptionsRemainingUseCase) g.d(this.f34445b.v());
        }

        public LoadProfileUseCase w() {
            return (LoadProfileUseCase) g.d(this.f34445b.w());
        }

        public GetActivityReportUseCase y() {
            return (GetActivityReportUseCase) g.d(this.f34445b.y());
        }
    }

    public static a a() {
        return new a();
    }
}
