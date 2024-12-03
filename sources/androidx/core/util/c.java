package androidx.core.util;

import androidx.annotation.NonNull;
import java.util.Objects;

public class c {

    static class a {
        static boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        static int b(Object... objArr) {
            return Objects.hash(objArr);
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return a.a(obj, obj2);
    }

    public static int b(Object... objArr) {
        return a.b(objArr);
    }

    @NonNull
    public static <T> T c(T t10) {
        t10.getClass();
        return t10;
    }

    @NonNull
    public static <T> T d(T t10, @NonNull String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }

    public static String e(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }
}
