package ca;

import android.app.Activity;
import ca.h;
import fj.g;

final class b {

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private h.b f8013a;

        private a() {
        }

        public h.a a() {
            g.a(this.f8013a, h.b.class);
            return new C0097b(this.f8013a);
        }

        public a b(h.b bVar) {
            this.f8013a = (h.b) g.b(bVar);
            return this;
        }
    }

    /* renamed from: ca.b$b  reason: collision with other inner class name */
    private static final class C0097b implements h.a {

        /* renamed from: a  reason: collision with root package name */
        private final h.b f8014a;

        /* renamed from: b  reason: collision with root package name */
        private final C0097b f8015b;

        private C0097b(h.b bVar) {
            this.f8015b = this;
            this.f8014a = bVar;
        }

        private h c(h hVar) {
            i.a(hVar, (Activity) g.d(this.f8014a.i()));
            return hVar;
        }

        /* renamed from: b */
        public void a(h hVar) {
            c(hVar);
        }
    }

    public static a a() {
        return new a();
    }
}
