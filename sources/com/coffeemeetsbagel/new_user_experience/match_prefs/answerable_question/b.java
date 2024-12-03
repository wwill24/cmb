package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import androidx.appcompat.app.c;
import b6.t;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import fj.g;
import qj.q;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.a f35244a;

        /* renamed from: b  reason: collision with root package name */
        private d.b f35245b;

        private a() {
        }

        public a a(d.a aVar) {
            this.f35244a = (d.a) g.b(aVar);
            return this;
        }

        public d.c b() {
            g.a(this.f35244a, d.a.class);
            g.a(this.f35245b, d.b.class);
            return new C0426b(this.f35244a, this.f35245b);
        }

        public a c(d.b bVar) {
            this.f35245b = (d.b) g.b(bVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.b$b  reason: collision with other inner class name */
    private static final class C0426b implements d.c {

        /* renamed from: a  reason: collision with root package name */
        private final d.a f35246a;

        /* renamed from: b  reason: collision with root package name */
        private final d.b f35247b;

        /* renamed from: c  reason: collision with root package name */
        private final C0426b f35248c;

        private C0426b(d.a aVar, d.b bVar) {
            this.f35248c = this;
            this.f35246a = aVar;
            this.f35247b = bVar;
        }

        private PremiumPreferenceInteractor j(PremiumPreferenceInteractor premiumPreferenceInteractor) {
            t.a(premiumPreferenceInteractor, e.a(this.f35246a));
            s.h(premiumPreferenceInteractor, (QuestionRepository) g.d(this.f35247b.e0()));
            s.e(premiumPreferenceInteractor, (k) g.d(this.f35247b.k()));
            s.f(premiumPreferenceInteractor, (l) g.d(this.f35247b.j()));
            s.a(premiumPreferenceInteractor, (q) g.d(this.f35247b.a0()));
            s.g(premiumPreferenceInteractor, (ma.g) g.d(this.f35247b.c0()));
            s.c(premiumPreferenceInteractor, (l5.a) g.d(this.f35247b.j0()));
            s.d(premiumPreferenceInteractor, (s9.a) g.d(this.f35247b.b()));
            s.i(premiumPreferenceInteractor, (SaveAnswerUseCase) g.d(this.f35247b.z()));
            s.b(premiumPreferenceInteractor, (a7.a) g.d(this.f35247b.c()));
            s.j(premiumPreferenceInteractor, (UserRepository) g.d(this.f35247b.C()));
            return premiumPreferenceInteractor;
        }

        public s9.a b() {
            return (s9.a) g.d(this.f35247b.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f35247b.c());
        }

        /* renamed from: d */
        public void l1(PremiumPreferenceInteractor premiumPreferenceInteractor) {
            j(premiumPreferenceInteractor);
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f35247b.C());
        }

        public cb.a f() {
            return (cb.a) g.d(this.f35247b.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) g.d(this.f35247b.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f35247b.h());
        }

        public SubscriptionRepository m() {
            return (SubscriptionRepository) g.d(this.f35247b.h0());
        }

        public c n() {
            return (c) g.d(this.f35247b.n());
        }
    }

    public static a a() {
        return new a();
    }
}
