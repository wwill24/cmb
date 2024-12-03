package com.google.protobuf;

final class q {

    /* renamed from: a  reason: collision with root package name */
    private static final o<?> f21932a = new p();

    /* renamed from: b  reason: collision with root package name */
    private static final o<?> f21933b = c();

    static o<?> a() {
        o<?> oVar = f21933b;
        if (oVar != null) {
            return oVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static o<?> b() {
        return f21932a;
    }

    private static o<?> c() {
        try {
            return (o) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
