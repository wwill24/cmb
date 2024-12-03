package od;

import gd.b;
import gd.d;

public final class c implements b<a> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final c f41330a = new c();
    }

    public static c a() {
        return a.f41330a;
    }

    public static a b() {
        return (a) d.c(b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: c */
    public a get() {
        return b();
    }
}
