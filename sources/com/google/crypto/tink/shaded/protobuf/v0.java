package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class v0 {

    /* renamed from: c  reason: collision with root package name */
    private static final v0 f20908c = new v0();

    /* renamed from: a  reason: collision with root package name */
    private final a1 f20909a = new e0();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, z0<?>> f20910b = new ConcurrentHashMap();

    private v0() {
    }

    public static v0 a() {
        return f20908c;
    }

    public <T> void b(T t10, y0 y0Var, o oVar) throws IOException {
        e(t10).f(t10, y0Var, oVar);
    }

    public z0<?> c(Class<?> cls, z0<?> z0Var) {
        x.b(cls, "messageType");
        x.b(z0Var, "schema");
        return this.f20910b.putIfAbsent(cls, z0Var);
    }

    public <T> z0<T> d(Class<T> cls) {
        x.b(cls, "messageType");
        z0<T> z0Var = this.f20910b.get(cls);
        if (z0Var != null) {
            return z0Var;
        }
        z0<T> a10 = this.f20909a.a(cls);
        z0<?> c10 = c(cls, a10);
        if (c10 != null) {
            return c10;
        }
        return a10;
    }

    public <T> z0<T> e(T t10) {
        return d(t10.getClass());
    }
}
