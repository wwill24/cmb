package com.coffeemeetsbagel.new_user_experience.introductions;

import b6.t;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.new_user_experience.introductions.d;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f35089a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f35090b;

        private a() {
        }

        public d.a a() {
            g.a(this.f35089a, d.b.class);
            g.a(this.f35090b, d.c.class);
            return new C0422b(this.f35089a, this.f35090b);
        }

        public a b(d.b bVar) {
            this.f35089a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35090b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.introductions.b$b  reason: collision with other inner class name */
    private static final class C0422b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f35091a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f35092b;

        /* renamed from: c  reason: collision with root package name */
        private final C0422b f35093c;

        private C0422b(d.b bVar, d.c cVar) {
            this.f35093c = this;
            this.f35091a = bVar;
            this.f35092b = cVar;
        }

        private IntroductionsInteractor c(IntroductionsInteractor introductionsInteractor) {
            t.a(introductionsInteractor, e.a(this.f35091a));
            i.c(introductionsInteractor, (na.b) g.d(this.f35092b.j()));
            i.d(introductionsInteractor, (ProfileRepository) g.d(this.f35092b.A()));
            i.b(introductionsInteractor, (d7.g) g.d(this.f35092b.E()));
            i.a(introductionsInteractor, (a7.a) g.d(this.f35092b.c()));
            return introductionsInteractor;
        }

        /* renamed from: b */
        public void l1(IntroductionsInteractor introductionsInteractor) {
            c(introductionsInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
