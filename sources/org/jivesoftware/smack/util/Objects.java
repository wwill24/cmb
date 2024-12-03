package org.jivesoftware.smack.util;

import java.util.Collection;

public class Objects {
    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> T requireNonNull(T t10, String str) throws IllegalArgumentException {
        if (t10 != null) {
            return t10;
        }
        if (str == null) {
            str = "Can not provide null argument";
        }
        throw new IllegalArgumentException(str);
    }

    public static <T extends Collection<?>> T requireNonNullNorEmpty(T t10, String str) {
        if (!((Collection) requireNonNull(t10)).isEmpty()) {
            return t10;
        }
        throw new IllegalArgumentException(str);
    }

    public static <T> T requireNonNull(T t10) {
        return requireNonNull(t10, (String) null);
    }
}
