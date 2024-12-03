package com.google.protobuf;

final class s0 {

    /* renamed from: a  reason: collision with root package name */
    private static final q0 f21940a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final q0 f21941b = new r0();

    static q0 a() {
        return f21940a;
    }

    static q0 b() {
        return f21941b;
    }

    private static q0 c() {
        try {
            return (q0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
