package com.google.protobuf;

final class m {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?> f21899a = c();

    public static n a() {
        n b10 = b("getEmptyRegistry");
        if (b10 != null) {
            return b10;
        }
        return n.f21902d;
    }

    private static final n b(String str) {
        Class<?> cls = f21899a;
        if (cls == null) {
            return null;
        }
        try {
            return (n) cls.getDeclaredMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
