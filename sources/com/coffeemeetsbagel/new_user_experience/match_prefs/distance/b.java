package com.coffeemeetsbagel.new_user_experience.match_prefs.distance;

import b6.t;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.match_prefs.distance.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.i;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f35300a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f35301b;

        private a() {
        }

        public d.a a() {
            g.a(this.f35300a, d.b.class);
            g.a(this.f35301b, d.c.class);
            return new C0428b(this.f35300a, this.f35301b);
        }

        public a b(d.b bVar) {
            this.f35300a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35301b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.match_prefs.distance.b$b  reason: collision with other inner class name */
    private static final class C0428b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f35302a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f35303b;

        /* renamed from: c  reason: collision with root package name */
        private final C0428b f35304c;

        private C0428b(d.b bVar, d.c cVar) {
            this.f35304c = this;
            this.f35302a = bVar;
            this.f35303b = cVar;
        }

        private DistanceMatchPreferenceInteractor c(DistanceMatchPreferenceInteractor distanceMatchPreferenceInteractor) {
            t.a(distanceMatchPreferenceInteractor, e.a(this.f35302a));
            q.e(distanceMatchPreferenceInteractor, (ProfileManager) g.d(this.f35303b.d()));
            q.a(distanceMatchPreferenceInteractor, (k) g.d(this.f35303b.k()));
            q.b(distanceMatchPreferenceInteractor, (l) g.d(this.f35303b.j()));
            q.d(distanceMatchPreferenceInteractor, (i) g.d(this.f35303b.o()));
            q.c(distanceMatchPreferenceInteractor, (s9.a) g.d(this.f35303b.b()));
            q.g(distanceMatchPreferenceInteractor, (UserRepository) g.d(this.f35303b.e()));
            q.f(distanceMatchPreferenceInteractor, (SaveAnswerUseCase) g.d(this.f35303b.l()));
            return distanceMatchPreferenceInteractor;
        }

        /* renamed from: b */
        public void l1(DistanceMatchPreferenceInteractor distanceMatchPreferenceInteractor) {
            c(distanceMatchPreferenceInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
