package androidx.datastore.preferences.protobuf;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f5231a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f5232b;

    static {
        boolean z10;
        if (a("org.robolectric.Robolectric") != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        f5232b = z10;
    }

    private static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class<?> b() {
        return f5231a;
    }

    static boolean c() {
        return f5231a != null && !f5232b;
    }
}
