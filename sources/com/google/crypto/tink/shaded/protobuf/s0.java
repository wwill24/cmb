package com.google.crypto.tink.shaded.protobuf;

final class s0 {

    /* renamed from: a  reason: collision with root package name */
    private static final q0 f20896a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final q0 f20897b = new r0();

    static q0 a() {
        return f20896a;
    }

    static q0 b() {
        return f20897b;
    }

    private static q0 c() {
        try {
            return (q0) Class.forName("com.google.crypto.tink.shaded.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
