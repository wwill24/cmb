package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class u0 {

    /* renamed from: c  reason: collision with root package name */
    private static final u0 f5373c = new u0();

    /* renamed from: a  reason: collision with root package name */
    private final z0 f5374a = new d0();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, y0<?>> f5375b = new ConcurrentHashMap();

    private u0() {
    }

    public static u0 a() {
        return f5373c;
    }

    public <T> void b(T t10, x0 x0Var, n nVar) throws IOException {
        e(t10).e(t10, x0Var, nVar);
    }

    public y0<?> c(Class<?> cls, y0<?> y0Var) {
        w.b(cls, "messageType");
        w.b(y0Var, "schema");
        return this.f5375b.putIfAbsent(cls, y0Var);
    }

    public <T> y0<T> d(Class<T> cls) {
        w.b(cls, "messageType");
        y0<T> y0Var = this.f5375b.get(cls);
        if (y0Var != null) {
            return y0Var;
        }
        y0<T> a10 = this.f5374a.a(cls);
        y0<?> c10 = c(cls, a10);
        if (c10 != null) {
            return c10;
        }
        return a10;
    }

    public <T> y0<T> e(T t10) {
        return d(t10.getClass());
    }
}
