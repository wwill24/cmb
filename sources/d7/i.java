package d7;

import d7.l;
import fj.g;

public final class i {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private l.c f14490a;

        private a() {
        }

        public l.b a() {
            g.a(this.f14490a, l.c.class);
            return new b(this.f14490a);
        }

        public a b(l.c cVar) {
            this.f14490a = (l.c) g.b(cVar);
            return this;
        }
    }

    private static final class b implements l.b {

        /* renamed from: a  reason: collision with root package name */
        private final b f14491a;

        private b(l.c cVar) {
            this.f14491a = this;
        }
    }

    public static a a() {
        return new a();
    }
}
