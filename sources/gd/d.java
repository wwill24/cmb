package gd;

public final class d {
    public static <T> void a(T t10, Class<T> cls) {
        if (t10 == null) {
            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
        }
    }

    public static <T> T b(T t10) {
        t10.getClass();
        return t10;
    }

    public static <T> T c(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }
}
