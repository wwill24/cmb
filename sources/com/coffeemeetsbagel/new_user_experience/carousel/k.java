package com.coffeemeetsbagel.new_user_experience.carousel;

import b6.t;
import com.coffeemeetsbagel.new_user_experience.carousel.a;
import fj.g;

public final class k {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private a.b f34945a;

        /* renamed from: b  reason: collision with root package name */
        private a.c f34946b;

        private a() {
        }

        public a.C0417a a() {
            g.a(this.f34945a, a.b.class);
            g.a(this.f34946b, a.c.class);
            return new b(this.f34945a, this.f34946b);
        }

        public a b(a.b bVar) {
            this.f34945a = (a.b) g.b(bVar);
            return this;
        }

        public a c(a.c cVar) {
            this.f34946b = (a.c) g.b(cVar);
            return this;
        }
    }

    private static final class b implements a.C0417a {

        /* renamed from: a  reason: collision with root package name */
        private final a.b f34947a;

        /* renamed from: b  reason: collision with root package name */
        private final a.c f34948b;

        /* renamed from: c  reason: collision with root package name */
        private final b f34949c;

        private b(a.b bVar, a.c cVar) {
            this.f34949c = this;
            this.f34947a = bVar;
            this.f34948b = cVar;
        }

        private c c(c cVar) {
            t.a(cVar, b.a(this.f34947a));
            d.b(cVar, (na.b) g.d(this.f34948b.j()));
            d.a(cVar, (a7.a) g.d(this.f34948b.c()));
            return cVar;
        }

        /* renamed from: b */
        public void l1(c cVar) {
            c(cVar);
        }
    }

    public static a a() {
        return new a();
    }
}
