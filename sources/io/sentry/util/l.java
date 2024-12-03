package io.sentry.util;

import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class l {
    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static <T> T c(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException(str);
    }
}
