package com.google.crypto.tink.shaded.protobuf;

final class n {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?> f20863a = c();

    public static o a() {
        o b10 = b("getEmptyRegistry");
        if (b10 != null) {
            return b10;
        }
        return o.f20866d;
    }

    private static final o b(String str) {
        Class<?> cls = f20863a;
        if (cls == null) {
            return null;
        }
        try {
            return (o) cls.getDeclaredMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static Class<?> c() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
