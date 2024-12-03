package com.coffeemeetsbagel.new_user_experience.new_to_online_dating;

import b6.t;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.new_user_experience.new_to_online_dating.d;
import fj.g;
import hb.c;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f35523a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f35524b;

        private a() {
        }

        public d.a a() {
            g.a(this.f35523a, d.b.class);
            g.a(this.f35524b, d.c.class);
            return new C0434b(this.f35523a, this.f35524b);
        }

        public a b(d.b bVar) {
            this.f35523a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35524b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.new_to_online_dating.b$b  reason: collision with other inner class name */
    private static final class C0434b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f35525a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f35526b;

        /* renamed from: c  reason: collision with root package name */
        private final C0434b f35527c;

        private C0434b(d.b bVar, d.c cVar) {
            this.f35527c = this;
            this.f35525a = bVar;
            this.f35526b = cVar;
        }

        private NewToOnlineDatingInteractor c(NewToOnlineDatingInteractor newToOnlineDatingInteractor) {
            t.a(newToOnlineDatingInteractor, e.a(this.f35525a));
            g.c(newToOnlineDatingInteractor, (na.b) g.d(this.f35526b.j()));
            g.e(newToOnlineDatingInteractor, (ProfileRepository) g.d(this.f35526b.A()));
            g.b(newToOnlineDatingInteractor, (d7.g) g.d(this.f35526b.E()));
            g.d(newToOnlineDatingInteractor, (c) g.d(this.f35526b.y0()));
            g.a(newToOnlineDatingInteractor, (a7.a) g.d(this.f35526b.c()));
            return newToOnlineDatingInteractor;
        }

        /* renamed from: b */
        public void l1(NewToOnlineDatingInteractor newToOnlineDatingInteractor) {
            c(newToOnlineDatingInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
