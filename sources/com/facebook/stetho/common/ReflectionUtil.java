package com.facebook.stetho.common;

import java.lang.reflect.Field;

public final class ReflectionUtil {
    private ReflectionUtil() {
    }

    public static Object getFieldValue(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static Class<?> tryGetClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Field tryGetDeclaredField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e10) {
            LogUtil.d(e10, "Could not retrieve %s field from %s", str, cls);
            return null;
        }
    }
}
