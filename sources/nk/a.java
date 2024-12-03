package nk;

public final class a {
    public static final void a(AutoCloseable autoCloseable, Throwable th2) {
        if (autoCloseable == null) {
            return;
        }
        if (th2 == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th3) {
            b.a(th2, th3);
        }
    }
}
