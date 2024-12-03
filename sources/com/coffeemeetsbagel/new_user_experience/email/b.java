package com.coffeemeetsbagel.new_user_experience.email;

import b6.t;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.email.d;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f34965a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f34966b;

        private a() {
        }

        public d.a a() {
            g.a(this.f34965a, d.b.class);
            g.a(this.f34966b, d.c.class);
            return new C0418b(this.f34965a, this.f34966b);
        }

        public a b(d.b bVar) {
            this.f34965a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f34966b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.email.b$b  reason: collision with other inner class name */
    private static final class C0418b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f34967a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f34968b;

        /* renamed from: c  reason: collision with root package name */
        private final C0418b f34969c;

        private C0418b(d.b bVar, d.c cVar) {
            this.f34969c = this;
            this.f34967a = bVar;
            this.f34968b = cVar;
        }

        private EmailInteractor c(EmailInteractor emailInteractor) {
            t.a(emailInteractor, e.a(this.f34967a));
            g.b(emailInteractor, (na.b) g.d(this.f34968b.j()));
            g.c(emailInteractor, (ProfileManager) g.d(this.f34968b.V()));
            g.d(emailInteractor, (ProfileRepository) g.d(this.f34968b.A()));
            g.a(emailInteractor, (d7.g) g.d(this.f34968b.E()));
            return emailInteractor;
        }

        /* renamed from: b */
        public void l1(EmailInteractor emailInteractor) {
            c(emailInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
