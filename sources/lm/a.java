package lm;

import java.lang.reflect.Array;

public class a {
    public static <T> T a(T t10, T t11) {
        if (!t10.getClass().isArray() || !t11.getClass().isArray()) {
            throw new IllegalArgumentException();
        }
        int length = Array.getLength(t10);
        int length2 = Array.getLength(t11);
        T newInstance = Array.newInstance(t10.getClass().getComponentType(), length + length2);
        System.arraycopy(t10, 0, newInstance, 0, length);
        System.arraycopy(t11, 0, newInstance, length, length2);
        return newInstance;
    }
}
