package w1;

import android.annotation.SuppressLint;
import android.os.Trace;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static long f18162a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f18163b;

    public static void a(@NonNull String str) {
        c.a(str);
    }

    public static void b() {
        c.b();
    }

    private static void c(@NonNull String str, @NonNull Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unable to call ");
        sb2.append(str);
        sb2.append(" via reflection");
    }

    @SuppressLint({"NewApi"})
    public static boolean d() {
        try {
            if (f18163b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return e();
    }

    private static boolean e() {
        try {
            if (f18163b == null) {
                f18162a = Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                f18163b = Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});
            }
            return ((Boolean) f18163b.invoke((Object) null, new Object[]{Long.valueOf(f18162a)})).booleanValue();
        } catch (Exception e10) {
            c("isTagEnabled", e10);
            return false;
        }
    }
}
