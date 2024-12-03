package ed;

import gd.b;
import gd.d;
import java.util.concurrent.Executor;

public final class k implements b<Executor> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final k f40747a = new k();
    }

    public static k a() {
        return a.f40747a;
    }

    public static Executor b() {
        return (Executor) d.c(j.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: c */
    public Executor get() {
        return b();
    }
}
