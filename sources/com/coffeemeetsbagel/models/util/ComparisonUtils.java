package com.coffeemeetsbagel.models.util;

public class ComparisonUtils {
    public static <T extends Comparable<T>> int compareWithNullCheck(T t10, T t11) {
        if (t10 == null) {
            return t11 == null ? 0 : -1;
        }
        if (t11 == null) {
            return 1;
        }
        return t10.compareTo(t11);
    }

    public static boolean doesNotEqualWithNullCheck(Object obj, Object obj2) {
        return !equalsWithNullCheck(obj, obj2);
    }

    public static boolean equalsWithNullCheck(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static <T extends Comparable<T>> boolean isEqualToWithNullCheck(T t10, T t11) {
        return compareWithNullCheck(t10, t11) == 0;
    }

    public static <T extends Comparable<T>> boolean isGreaterThanWithNullCheck(T t10, T t11) {
        return compareWithNullCheck(t10, t11) > 0;
    }

    public static <T extends Comparable<T>> boolean isLessThanWithNullCheck(T t10, T t11) {
        return compareWithNullCheck(t10, t11) < 0;
    }
}
