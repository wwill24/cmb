package ca;

import android.app.Activity;
import ca.j;
import fj.g;

final class e {

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private j.b f8016a;

        private a() {
        }

        public j.a a() {
            g.a(this.f8016a, j.b.class);
            return new b(this.f8016a);
        }

        public a b(j.b bVar) {
            this.f8016a = (j.b) g.b(bVar);
            return this;
        }
    }

    private static final class b implements j.a {

        /* renamed from: a  reason: collision with root package name */
        private final j.b f8017a;

        /* renamed from: b  reason: collision with root package name */
        private final b f8018b;

        private b(j.b bVar) {
            this.f8018b = this;
            this.f8017a = bVar;
        }

        private j c(j jVar) {
            k.a(jVar, (Activity) g.d(this.f8017a.i()));
            return jVar;
        }

        /* renamed from: b */
        public void a(j jVar) {
            c(jVar);
        }
    }

    public static a a() {
        return new a();
    }
}
