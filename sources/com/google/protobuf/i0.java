package com.google.protobuf;

final class i0 {

    /* renamed from: a  reason: collision with root package name */
    private static final g0 f21862a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final g0 f21863b = new h0();

    static g0 a() {
        return f21862a;
    }

    static g0 b() {
        return f21863b;
    }

    private static g0 c() {
        try {
            return (g0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
