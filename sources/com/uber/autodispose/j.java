package com.uber.autodispose;

final class j {
    static <T> T a(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }
}
