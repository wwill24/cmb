package com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial;

import b6.t;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f35396a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f35397b;

        private a() {
        }

        public d.a a() {
            g.a(this.f35396a, d.b.class);
            g.a(this.f35397b, d.c.class);
            return new C0431b(this.f35396a, this.f35397b);
        }

        public a b(d.b bVar) {
            this.f35396a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35397b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.b$b  reason: collision with other inner class name */
    private static final class C0431b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f35398a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f35399b;

        /* renamed from: c  reason: collision with root package name */
        private final C0431b f35400c;

        private C0431b(d.b bVar, d.c cVar) {
            this.f35400c = this;
            this.f35398a = bVar;
            this.f35399b = cVar;
        }

        private HeightMatchPreferencesImperialInteractor c(HeightMatchPreferencesImperialInteractor heightMatchPreferencesImperialInteractor) {
            t.a(heightMatchPreferencesImperialInteractor, e.a(this.f35398a));
            j.d(heightMatchPreferencesImperialInteractor, (ProfileManager) g.d(this.f35399b.d()));
            j.a(heightMatchPreferencesImperialInteractor, (k) g.d(this.f35399b.k()));
            j.b(heightMatchPreferencesImperialInteractor, (l) g.d(this.f35399b.j()));
            j.e(heightMatchPreferencesImperialInteractor, (SaveAnswerUseCase) g.d(this.f35399b.l()));
            j.c(heightMatchPreferencesImperialInteractor, (s9.a) g.d(this.f35399b.b()));
            return heightMatchPreferencesImperialInteractor;
        }

        public b6.d<?, ?> a() {
            return (b6.d) g.d(this.f35399b.a());
        }

        /* renamed from: b */
        public void l1(HeightMatchPreferencesImperialInteractor heightMatchPreferencesImperialInteractor) {
            c(heightMatchPreferencesImperialInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
