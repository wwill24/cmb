package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

public class j {

    public static class a {
        private a() {
        }
    }

    private j() {
    }

    public static boolean a(Double d10, double d11) {
        return d10 != null && d10.doubleValue() == d11;
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) n(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void d(Object obj) {
        if (obj == null) {
            q();
        }
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            r(str);
        }
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) n(new NullPointerException(str + " must not be null")));
        }
    }

    public static void g(Object obj, String str) {
        if (obj == null) {
            u(str);
        }
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            t(str);
        }
    }

    public static int i(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 == i11 ? 0 : 1;
    }

    public static int j(long j10, long j11) {
        int i10 = (j10 > j11 ? 1 : (j10 == j11 ? 0 : -1));
        if (i10 < 0) {
            return -1;
        }
        return i10 == 0 ? 0 : 1;
    }

    private static String k(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = j.class.getName();
        int i10 = 0;
        while (!stackTrace[i10].getClassName().equals(name)) {
            i10++;
        }
        while (stackTrace[i10].getClassName().equals(name)) {
            i10++;
        }
        StackTraceElement stackTraceElement = stackTrace[i10];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    public static void l() {
        v();
    }

    public static void m(int i10, String str) {
        v();
    }

    private static <T extends Throwable> T n(T t10) {
        return o(t10, j.class.getName());
    }

    static <T extends Throwable> T o(T t10, String str) {
        StackTraceElement[] stackTrace = t10.getStackTrace();
        int length = stackTrace.length;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.equals(stackTrace[i11].getClassName())) {
                i10 = i11;
            }
        }
        t10.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i10 + 1, length));
        return t10;
    }

    public static String p(String str, Object obj) {
        return str + obj;
    }

    public static void q() {
        throw ((NullPointerException) n(new NullPointerException()));
    }

    public static void r(String str) {
        throw ((NullPointerException) n(new NullPointerException(str)));
    }

    public static void s() {
        throw ((KotlinNullPointerException) n(new KotlinNullPointerException()));
    }

    private static void t(String str) {
        throw ((IllegalArgumentException) n(new IllegalArgumentException(k(str))));
    }

    private static void u(String str) {
        throw ((NullPointerException) n(new NullPointerException(k(str))));
    }

    public static void v() {
        w("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void w(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void x(String str) {
        throw ((UninitializedPropertyAccessException) n(new UninitializedPropertyAccessException(str)));
    }

    public static void y(String str) {
        x("lateinit property " + str + " has not been initialized");
    }
}
