package ed;

import cd.b;
import cd.c;
import cd.d;
import ed.c;

abstract class o {

    public static abstract class a {
        public abstract o a();

        /* access modifiers changed from: package-private */
        public abstract a b(b bVar);

        /* access modifiers changed from: package-private */
        public abstract a c(c<?> cVar);

        /* access modifiers changed from: package-private */
        public abstract a d(d<?, byte[]> dVar);

        public abstract a e(p pVar);

        public abstract a f(String str);
    }

    o() {
    }

    public static a a() {
        return new c.b();
    }

    public abstract b b();

    /* access modifiers changed from: package-private */
    public abstract cd.c<?> c();

    public byte[] d() {
        return e().apply(c().b());
    }

    /* access modifiers changed from: package-private */
    public abstract d<?, byte[]> e();

    public abstract p f();

    public abstract String g();
}
