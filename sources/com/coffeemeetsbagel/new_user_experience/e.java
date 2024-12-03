package com.coffeemeetsbagel.new_user_experience;

import b6.d;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.LoadAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.SaveAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.n;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.r0;
import com.coffeemeetsbagel.qna.GetUserMCQUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import fj.g;
import hb.c;
import t8.l;

public final class e {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private n.b f34950a;

        /* renamed from: b  reason: collision with root package name */
        private o f34951b;

        private a() {
        }

        public n.a a() {
            g.a(this.f34950a, n.b.class);
            g.a(this.f34951b, o.class);
            return new b(this.f34950a, this.f34951b);
        }

        public a b(o oVar) {
            this.f34951b = (o) g.b(oVar);
            return this;
        }

        public a c(n.b bVar) {
            this.f34950a = (n.b) g.b(bVar);
            return this;
        }
    }

    private static final class b implements n.a {

        /* renamed from: a  reason: collision with root package name */
        private final n.b f34952a;

        /* renamed from: b  reason: collision with root package name */
        private final o f34953b;

        /* renamed from: c  reason: collision with root package name */
        private final b f34954c;

        private b(n.b bVar, o oVar) {
            this.f34954c = this;
            this.f34952a = bVar;
            this.f34953b = oVar;
        }

        public ProfileRepository A() {
            return (ProfileRepository) g.d(this.f34953b.A());
        }

        public j A1() {
            return (j) g.d(this.f34953b.A1());
        }

        public d7.g E() {
            return (d7.g) g.d(this.f34953b.E());
        }

        public c9.a I() {
            return (c9.a) g.d(this.f34953b.I());
        }

        public GetSingleSchoolsUseCase N0() {
            return (GetSingleSchoolsUseCase) g.d(this.f34953b.N0());
        }

        public l P0() {
            return (l) g.d(this.f34953b.P0());
        }

        public ProfileManager V() {
            return (ProfileManager) g.d(this.f34953b.V());
        }

        public m1 W() {
            return (m1) g.d(this.f34953b.W());
        }

        public SaveAgePreferenceUseCase X() {
            return (SaveAgePreferenceUseCase) g.d(this.f34953b.X());
        }

        public d<?, ?> a() {
            return p.a(this.f34952a);
        }

        public s9.a b() {
            return (s9.a) g.d(this.f34953b.b());
        }

        public LoadAgePreferenceUseCase b0() {
            return (LoadAgePreferenceUseCase) g.d(this.f34953b.b0());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f34953b.c());
        }

        public ma.g c0() {
            return (ma.g) g.d(this.f34953b.c0());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f34953b.e());
        }

        public QuestionRepository e0() {
            return (QuestionRepository) g.d(this.f34953b.e0());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f34953b.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f34953b.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f34953b.h());
        }

        public SubscriptionRepository h0() {
            return (SubscriptionRepository) g.d(this.f34953b.h0());
        }

        /* renamed from: i */
        public void g0(n nVar) {
        }

        public l5.a n0() {
            return (l5.a) g.d(this.f34953b.n0());
        }

        public GetMatchPreferencesUseCase p0() {
            return (GetMatchPreferencesUseCase) g.d(this.f34953b.p0());
        }

        public GetUserMCQUseCase s0() {
            return (GetUserMCQUseCase) g.d(this.f34953b.s0());
        }

        public r0 v0() {
            return (r0) g.d(this.f34953b.v0());
        }

        public c y0() {
            return (c) g.d(this.f34953b.y0());
        }

        public SaveAnswerUseCase z() {
            return (SaveAnswerUseCase) g.d(this.f34953b.z());
        }
    }

    public static a a() {
        return new a();
    }
}
