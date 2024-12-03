package md;

import gd.b;
import gd.d;

public final class j implements b<e> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final j f41206a = new j();
    }

    public static j a() {
        return a.f41206a;
    }

    public static e c() {
        return (e) d.c(f.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: b */
    public e get() {
        return c();
    }
}
