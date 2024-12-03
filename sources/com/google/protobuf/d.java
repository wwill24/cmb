package com.google.protobuf;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f21772a;

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f21773b = a("libcore.io.Memory");

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f21774c;

    static {
        boolean z10;
        if (f21772a || a("org.robolectric.Robolectric") == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        f21774c = z10;
    }

    private static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class<?> b() {
        return f21773b;
    }

    static boolean c() {
        return f21772a || (f21773b != null && !f21774c);
    }
}
