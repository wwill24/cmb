package com.coffeemeetsbagel.preferences;

import androidx.appcompat.app.c;
import b6.d;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.LoadAgePreferenceUseCase;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.SaveAgePreferenceUseCase;
import com.coffeemeetsbagel.preferences.h;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.GetUserMCQUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private h.b f35790a;

        /* renamed from: b  reason: collision with root package name */
        private p f35791b;

        private a() {
        }

        public h.a a() {
            g.a(this.f35790a, h.b.class);
            g.a(this.f35791b, p.class);
            return new C0440b(this.f35790a, this.f35791b);
        }

        public a b(h.b bVar) {
            this.f35790a = (h.b) g.b(bVar);
            return this;
        }

        public a c(p pVar) {
            this.f35791b = (p) g.b(pVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.preferences.b$b  reason: collision with other inner class name */
    private static final class C0440b implements h.a {

        /* renamed from: a  reason: collision with root package name */
        private final h.b f35792a;

        /* renamed from: b  reason: collision with root package name */
        private final p f35793b;

        /* renamed from: c  reason: collision with root package name */
        private final C0440b f35794c;

        private C0440b(h.b bVar, p pVar) {
            this.f35794c = this;
            this.f35792a = bVar;
            this.f35793b = pVar;
        }

        public c9.a I() {
            return (c9.a) g.d(this.f35793b.I());
        }

        public m1 W() {
            return (m1) g.d(this.f35793b.W());
        }

        public SaveAgePreferenceUseCase X() {
            return (SaveAgePreferenceUseCase) g.d(this.f35793b.X());
        }

        public d<?, ?> a() {
            return j.a(this.f35792a);
        }

        public s9.a b() {
            return (s9.a) g.d(this.f35793b.b());
        }

        public LoadAgePreferenceUseCase b0() {
            return (LoadAgePreferenceUseCase) g.d(this.f35793b.b0());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f35793b.c());
        }

        public ma.g c0() {
            return (ma.g) g.d(this.f35793b.c0());
        }

        public ProfileManager d() {
            return (ProfileManager) g.d(this.f35793b.d());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f35793b.e());
        }

        public QuestionRepository e0() {
            return (QuestionRepository) g.d(this.f35793b.e0());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f35793b.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f35793b.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f35793b.h());
        }

        public SubscriptionRepository h0() {
            return (SubscriptionRepository) g.d(this.f35793b.m());
        }

        /* renamed from: i */
        public void g0(h hVar) {
        }

        public c n() {
            return i.a(this.f35792a);
        }

        public l5.a n0() {
            return (l5.a) g.d(this.f35793b.n0());
        }

        public GetMatchPreferencesUseCase p0() {
            return (GetMatchPreferencesUseCase) g.d(this.f35793b.p0());
        }

        public GetUserMCQUseCase s0() {
            return (GetUserMCQUseCase) g.d(this.f35793b.s0());
        }

        public SaveAnswerUseCase z() {
            return (SaveAnswerUseCase) g.d(this.f35793b.z());
        }
    }

    public static a a() {
        return new a();
    }
}
