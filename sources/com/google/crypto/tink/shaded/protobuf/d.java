package com.google.crypto.tink.shaded.protobuf;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f20772a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f20773b;

    static {
        boolean z10;
        if (a("org.robolectric.Robolectric") != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        f20773b = z10;
    }

    private static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class<?> b() {
        return f20772a;
    }

    static boolean c() {
        return f20772a != null && !f20773b;
    }
}
