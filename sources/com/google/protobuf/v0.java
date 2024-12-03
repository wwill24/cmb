package com.google.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class v0 {

    /* renamed from: c  reason: collision with root package name */
    private static final v0 f21949c = new v0();

    /* renamed from: a  reason: collision with root package name */
    private final a1 f21950a = new e0();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, z0<?>> f21951b = new ConcurrentHashMap();

    private v0() {
    }

    public static v0 a() {
        return f21949c;
    }

    public z0<?> b(Class<?> cls, z0<?> z0Var) {
        w.b(cls, "messageType");
        w.b(z0Var, "schema");
        return this.f21951b.putIfAbsent(cls, z0Var);
    }

    public <T> z0<T> c(Class<T> cls) {
        w.b(cls, "messageType");
        z0<T> z0Var = this.f21951b.get(cls);
        if (z0Var != null) {
            return z0Var;
        }
        z0<T> a10 = this.f21950a.a(cls);
        z0<?> b10 = b(cls, a10);
        if (b10 != null) {
            return b10;
        }
        return a10;
    }

    public <T> z0<T> d(T t10) {
        return c(t10.getClass());
    }
}
