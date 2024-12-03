package od;

import gd.b;

public final class d implements b<a> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final d f41331a = new d();
    }

    public static d a() {
        return a.f41331a;
    }

    public static a c() {
        return (a) gd.d.c(b.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: b */
    public a get() {
        return c();
    }
}
