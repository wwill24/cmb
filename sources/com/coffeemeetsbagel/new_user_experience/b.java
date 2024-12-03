package com.coffeemeetsbagel.new_user_experience;

import b6.d;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import com.coffeemeetsbagel.new_user_experience.h;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.LoadAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.SaveAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.n;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.r0;
import com.coffeemeetsbagel.qna.GetUserMCQUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.i;
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import fj.g;
import na.c;
import t8.l;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private h.b f34800a;

        /* renamed from: b  reason: collision with root package name */
        private n.a f34801b;

        private a() {
        }

        public h.a a() {
            if (this.f34800a == null) {
                this.f34800a = new h.b();
            }
            g.a(this.f34801b, n.a.class);
            return new C0414b(this.f34800a, this.f34801b);
        }

        public a b(n.a aVar) {
            this.f34801b = (n.a) g.b(aVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.b$b  reason: collision with other inner class name */
    private static final class C0414b implements h.a {

        /* renamed from: a  reason: collision with root package name */
        private final n.a f34802a;

        /* renamed from: b  reason: collision with root package name */
        private final C0414b f34803b;

        /* renamed from: c  reason: collision with root package name */
        private fk.a<c> f34804c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<na.a> f34805d;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<na.b> f34806e;

        /* renamed from: f  reason: collision with root package name */
        private fk.a<d<?, ?>> f34807f;

        /* renamed from: g  reason: collision with root package name */
        private fk.a<androidx.appcompat.app.c> f34808g;

        /* renamed from: com.coffeemeetsbagel.new_user_experience.b$b$a */
        private static final class a implements fk.a<d<?, ?>> {

            /* renamed from: a  reason: collision with root package name */
            private final n.a f34809a;

            a(n.a aVar) {
                this.f34809a = aVar;
            }

            /* renamed from: a */
            public d<?, ?> get() {
                return (d) g.d(this.f34809a.a());
            }
        }

        private C0414b(h.b bVar, n.a aVar) {
            this.f34803b = this;
            this.f34802a = aVar;
            u(bVar, aVar);
        }

        private void u(h.b bVar, n.a aVar) {
            fk.a<c> a10 = fj.c.a(l.a(bVar));
            this.f34804c = a10;
            this.f34805d = fj.c.a(j.a(bVar, a10));
            this.f34806e = fj.c.a(k.a(bVar, this.f34804c));
            a aVar2 = new a(aVar);
            this.f34807f = aVar2;
            this.f34808g = fj.c.a(i.b(bVar, aVar2));
        }

        private OnboardingInteractor w(OnboardingInteractor onboardingInteractor) {
            u.d(onboardingInteractor, this.f34805d.get());
            u.g(onboardingInteractor, (m1) g.d(this.f34802a.W()));
            u.c(onboardingInteractor, (d) g.d(this.f34802a.a()));
            u.e(onboardingInteractor, (ProfileManager) g.d(this.f34802a.V()));
            u.a(onboardingInteractor, (a7.a) g.d(this.f34802a.c()));
            u.h(onboardingInteractor, (UserRepository) g.d(this.f34802a.e()));
            u.f(onboardingInteractor, (j) g.d(this.f34802a.A1()));
            u.b(onboardingInteractor, (d7.g) g.d(this.f34802a.E()));
            return onboardingInteractor;
        }

        public ProfileRepository A() {
            return (ProfileRepository) g.d(this.f34802a.A());
        }

        public d7.g E() {
            return (d7.g) g.d(this.f34802a.E());
        }

        public c9.a I() {
            return (c9.a) g.d(this.f34802a.I());
        }

        public GetSingleSchoolsUseCase N0() {
            return (GetSingleSchoolsUseCase) g.d(this.f34802a.N0());
        }

        public l P0() {
            return (l) g.d(this.f34802a.P0());
        }

        public j R0() {
            return (j) g.d(this.f34802a.A1());
        }

        public a7.a T() {
            return (a7.a) g.d(this.f34802a.c());
        }

        public ProfileManager V() {
            return (ProfileManager) g.d(this.f34802a.V());
        }

        public m1 W() {
            return (m1) g.d(this.f34802a.W());
        }

        public SaveAgePreferenceUseCase X() {
            return (SaveAgePreferenceUseCase) g.d(this.f34802a.X());
        }

        public d<?, ?> a() {
            return (d) g.d(this.f34802a.a());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f34802a.b());
        }

        public LoadAgePreferenceUseCase b0() {
            return (LoadAgePreferenceUseCase) g.d(this.f34802a.b0());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f34802a.c());
        }

        public ma.g c0() {
            return (ma.g) g.d(this.f34802a.c0());
        }

        public ProfileManager d() {
            return (ProfileManager) g.d(this.f34802a.V());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f34802a.e());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f34802a.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f34802a.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f34802a.h());
        }

        public SubscriptionRepository h0() {
            return (SubscriptionRepository) g.d(this.f34802a.h0());
        }

        public na.b j() {
            return this.f34806e.get();
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f34802a.e0());
        }

        public SaveAnswerUseCase l() {
            return (SaveAnswerUseCase) g.d(this.f34802a.z());
        }

        public ProfileManager m() {
            return (ProfileManager) g.d(this.f34802a.V());
        }

        public androidx.appcompat.app.c n() {
            return this.f34808g.get();
        }

        public l5.a n0() {
            return (l5.a) g.d(this.f34802a.n0());
        }

        public i o() {
            return new i((QuestionRepository) g.d(this.f34802a.e0()));
        }

        public j p() {
            return (j) g.d(this.f34802a.A1());
        }

        public GetMatchPreferencesUseCase p0() {
            return (GetMatchPreferencesUseCase) g.d(this.f34802a.p0());
        }

        public UserRepository q() {
            return (UserRepository) g.d(this.f34802a.e());
        }

        public QuestionRepository r() {
            return (QuestionRepository) g.d(this.f34802a.e0());
        }

        public SaveAnswerUseCase s() {
            return (SaveAnswerUseCase) g.d(this.f34802a.z());
        }

        public GetUserMCQUseCase s0() {
            return (GetUserMCQUseCase) g.d(this.f34802a.s0());
        }

        public SaveAnswerUseCase t() {
            return (SaveAnswerUseCase) g.d(this.f34802a.z());
        }

        /* renamed from: v */
        public void l1(OnboardingInteractor onboardingInteractor) {
            w(onboardingInteractor);
        }

        public r0 v0() {
            return (r0) g.d(this.f34802a.v0());
        }

        public hb.c y0() {
            return (hb.c) g.d(this.f34802a.y0());
        }

        public SaveAnswerUseCase z() {
            return (SaveAnswerUseCase) g.d(this.f34802a.z());
        }
    }

    public static a a() {
        return new a();
    }
}
