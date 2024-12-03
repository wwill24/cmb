package com.coffeemeetsbagel.new_user_experience.location;

import b6.t;
import com.coffeemeetsbagel.new_user_experience.location.d;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f35123a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f35124b;

        private a() {
        }

        public d.a a() {
            g.a(this.f35123a, d.b.class);
            g.a(this.f35124b, d.c.class);
            return new C0424b(this.f35123a, this.f35124b);
        }

        public a b(d.b bVar) {
            this.f35123a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35124b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.location.b$b  reason: collision with other inner class name */
    private static final class C0424b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f35125a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f35126b;

        /* renamed from: c  reason: collision with root package name */
        private final C0424b f35127c;

        private C0424b(d.b bVar, d.c cVar) {
            this.f35127c = this;
            this.f35125a = bVar;
            this.f35126b = cVar;
        }

        private f c(f fVar) {
            t.a(fVar, e.a(this.f35125a));
            g.a(fVar, (na.b) g.d(this.f35126b.j()));
            return fVar;
        }

        /* renamed from: b */
        public void l1(f fVar) {
            c(fVar);
        }
    }

    public static a a() {
        return new a();
    }
}
