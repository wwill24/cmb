package com.google.crypto.tink.shaded.protobuf;

final class r {

    /* renamed from: a  reason: collision with root package name */
    private static final p<?> f20894a = new q();

    /* renamed from: b  reason: collision with root package name */
    private static final p<?> f20895b = c();

    static p<?> a() {
        p<?> pVar = f20895b;
        if (pVar != null) {
            return pVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static p<?> b() {
        return f20894a;
    }

    private static p<?> c() {
        try {
            return (p) Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
