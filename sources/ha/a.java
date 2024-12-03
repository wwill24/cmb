package ha;

import android.os.Looper;

public class a {
    public static void a(Object obj, String str) {
        d(obj != null, str);
    }

    public static void b(String str) {
        fa.a.i(new AssertionError(str));
    }

    public static void c(Thread thread, String str) {
        d(Looper.getMainLooper().getThread() == thread, str);
    }

    public static void d(boolean z10, String str) {
        if (!z10) {
            fa.a.i(new AssertionError(str));
        }
    }
}
