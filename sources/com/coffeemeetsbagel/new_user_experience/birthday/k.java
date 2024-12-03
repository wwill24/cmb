package com.coffeemeetsbagel.new_user_experience.birthday;

import b6.t;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.birthday.a;
import com.coffeemeetsbagel.profile.r0;
import fj.g;

public final class k {

    private static final class a implements a.C0416a {

        /* renamed from: a  reason: collision with root package name */
        private final a.b f34921a;

        /* renamed from: b  reason: collision with root package name */
        private final a.c f34922b;

        /* renamed from: c  reason: collision with root package name */
        private final a f34923c;

        private a(a.b bVar, a.c cVar) {
            this.f34923c = this;
            this.f34921a = bVar;
            this.f34922b = cVar;
        }

        private BirthdayInteractor c(BirthdayInteractor birthdayInteractor) {
            t.a(birthdayInteractor, b.a(this.f34921a));
            e.a(birthdayInteractor, (na.b) g.d(this.f34922b.j()));
            e.b(birthdayInteractor, (ProfileManager) g.d(this.f34922b.V()));
            e.c(birthdayInteractor, (r0) g.d(this.f34922b.v0()));
            return birthdayInteractor;
        }

        /* renamed from: b */
        public void l1(BirthdayInteractor birthdayInteractor) {
            c(birthdayInteractor);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private a.b f34924a;

        /* renamed from: b  reason: collision with root package name */
        private a.c f34925b;

        private b() {
        }

        public b a(a.b bVar) {
            this.f34924a = (a.b) g.b(bVar);
            return this;
        }

        public a.C0416a b() {
            g.a(this.f34924a, a.b.class);
            g.a(this.f34925b, a.c.class);
            return new a(this.f34924a, this.f34925b);
        }

        public b c(a.c cVar) {
            this.f34925b = (a.c) g.b(cVar);
            return this;
        }
    }

    public static b a() {
        return new b();
    }
}
