package org.apache.commons.beanutils;

public class ConvertUtils {
    public static String convert(Object obj) {
        return ConvertUtilsBean.getInstance().convert(obj);
    }

    public static void deregister() {
        ConvertUtilsBean.getInstance().deregister();
    }

    @Deprecated
    public static boolean getDefaultBoolean() {
        return ConvertUtilsBean.getInstance().getDefaultBoolean();
    }

    @Deprecated
    public static byte getDefaultByte() {
        return ConvertUtilsBean.getInstance().getDefaultByte();
    }

    @Deprecated
    public static char getDefaultCharacter() {
        return ConvertUtilsBean.getInstance().getDefaultCharacter();
    }

    @Deprecated
    public static double getDefaultDouble() {
        return ConvertUtilsBean.getInstance().getDefaultDouble();
    }

    @Deprecated
    public static float getDefaultFloat() {
        return ConvertUtilsBean.getInstance().getDefaultFloat();
    }

    @Deprecated
    public static int getDefaultInteger() {
        return ConvertUtilsBean.getInstance().getDefaultInteger();
    }

    @Deprecated
    public static long getDefaultLong() {
        return ConvertUtilsBean.getInstance().getDefaultLong();
    }

    @Deprecated
    public static short getDefaultShort() {
        return ConvertUtilsBean.getInstance().getDefaultShort();
    }

    public static Converter lookup(Class<?> cls) {
        return ConvertUtilsBean.getInstance().lookup(cls);
    }

    public static <T> Class<T> primitiveToWrapper(Class<T> cls) {
        if (cls == null || !cls.isPrimitive()) {
            return cls;
        }
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Character.TYPE) {
            return Character.class;
        }
        return cls;
    }

    public static void register(Converter converter, Class<?> cls) {
        ConvertUtilsBean.getInstance().register(converter, cls);
    }

    @Deprecated
    public static void setDefaultBoolean(boolean z10) {
        ConvertUtilsBean.getInstance().setDefaultBoolean(z10);
    }

    @Deprecated
    public static void setDefaultByte(byte b10) {
        ConvertUtilsBean.getInstance().setDefaultByte(b10);
    }

    @Deprecated
    public static void setDefaultCharacter(char c10) {
        ConvertUtilsBean.getInstance().setDefaultCharacter(c10);
    }

    @Deprecated
    public static void setDefaultDouble(double d10) {
        ConvertUtilsBean.getInstance().setDefaultDouble(d10);
    }

    @Deprecated
    public static void setDefaultFloat(float f10) {
        ConvertUtilsBean.getInstance().setDefaultFloat(f10);
    }

    @Deprecated
    public static void setDefaultInteger(int i10) {
        ConvertUtilsBean.getInstance().setDefaultInteger(i10);
    }

    @Deprecated
    public static void setDefaultLong(long j10) {
        ConvertUtilsBean.getInstance().setDefaultLong(j10);
    }

    @Deprecated
    public static void setDefaultShort(short s10) {
        ConvertUtilsBean.getInstance().setDefaultShort(s10);
    }

    public static Object convert(String str, Class<?> cls) {
        return ConvertUtilsBean.getInstance().convert(str, cls);
    }

    public static void deregister(Class<?> cls) {
        ConvertUtilsBean.getInstance().deregister(cls);
    }

    public static Converter lookup(Class<?> cls, Class<?> cls2) {
        return ConvertUtilsBean.getInstance().lookup(cls, cls2);
    }

    public static Object convert(String[] strArr, Class<?> cls) {
        return ConvertUtilsBean.getInstance().convert(strArr, cls);
    }

    public static Object convert(Object obj, Class<?> cls) {
        return ConvertUtilsBean.getInstance().convert(obj, cls);
    }
}
