package com.google.crypto.tink.shaded.protobuf;

final class i0 {

    /* renamed from: a  reason: collision with root package name */
    private static final g0 f20821a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final g0 f20822b = new h0();

    static g0 a() {
        return f20821a;
    }

    static g0 b() {
        return f20822b;
    }

    private static g0 c() {
        try {
            return (g0) Class.forName("com.google.crypto.tink.shaded.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
