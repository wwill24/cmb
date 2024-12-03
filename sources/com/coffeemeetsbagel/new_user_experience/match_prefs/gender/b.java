package com.coffeemeetsbagel.new_user_experience.match_prefs.gender;

import b6.t;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.match_prefs.gender.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f35366a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f35367b;

        private a() {
        }

        public d.a a() {
            g.a(this.f35366a, d.b.class);
            g.a(this.f35367b, d.c.class);
            return new C0430b(this.f35366a, this.f35367b);
        }

        public a b(d.b bVar) {
            this.f35366a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35367b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.match_prefs.gender.b$b  reason: collision with other inner class name */
    private static final class C0430b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f35368a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f35369b;

        /* renamed from: c  reason: collision with root package name */
        private final C0430b f35370c;

        private C0430b(d.b bVar, d.c cVar) {
            this.f35370c = this;
            this.f35368a = bVar;
            this.f35369b = cVar;
        }

        private GenderMatchPreferenceInteractor c(GenderMatchPreferenceInteractor genderMatchPreferenceInteractor) {
            t.a(genderMatchPreferenceInteractor, e.a(this.f35368a));
            h.c(genderMatchPreferenceInteractor, (ProfileManager) g.d(this.f35369b.d()));
            h.a(genderMatchPreferenceInteractor, (k) g.d(this.f35369b.k()));
            h.b(genderMatchPreferenceInteractor, (l) g.d(this.f35369b.j()));
            return genderMatchPreferenceInteractor;
        }

        /* renamed from: b */
        public void l1(GenderMatchPreferenceInteractor genderMatchPreferenceInteractor) {
            c(genderMatchPreferenceInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
