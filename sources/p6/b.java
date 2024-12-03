package p6;

import b6.t;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import fj.g;
import p6.d;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f17033a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f17034b;

        private a() {
        }

        public d.a a() {
            g.a(this.f17033a, d.b.class);
            g.a(this.f17034b, d.c.class);
            return new C0188b(this.f17033a, this.f17034b);
        }

        public a b(d.b bVar) {
            this.f17033a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f17034b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: p6.b$b  reason: collision with other inner class name */
    private static final class C0188b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f17035a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f17036b;

        /* renamed from: c  reason: collision with root package name */
        private final C0188b f17037c;

        private C0188b(d.b bVar, d.c cVar) {
            this.f17037c = this;
            this.f17035a = bVar;
            this.f17036b = cVar;
        }

        private g c(g gVar) {
            t.a(gVar, e.a(this.f17035a));
            i.a(gVar, (v7.d) g.d(this.f17036b.G()));
            i.b(gVar, (ActivityMain) g.d(this.f17036b.a()));
            return gVar;
        }

        public ActivityMain a() {
            return (ActivityMain) g.d(this.f17036b.a());
        }

        /* renamed from: b */
        public void l1(g gVar) {
            c(gVar);
        }
    }

    public static a a() {
        return new a();
    }
}
