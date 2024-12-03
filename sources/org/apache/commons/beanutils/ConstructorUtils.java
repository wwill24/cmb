package org.apache.commons.beanutils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class ConstructorUtils {
    private static final Class<?>[] EMPTY_CLASS_PARAMETERS = new Class[0];
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

    public static <T> Constructor<T> getAccessibleConstructor(Class<T> cls, Class<?> cls2) {
        return getAccessibleConstructor(cls, (Class<?>[]) new Class[]{cls2});
    }

    private static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>[] clsArr) {
        boolean z10;
        Constructor<T> accessibleConstructor;
        try {
            Constructor<T> constructor = cls.getConstructor(clsArr);
            try {
                constructor.setAccessible(true);
            } catch (SecurityException unused) {
            }
            return constructor;
        } catch (NoSuchMethodException unused2) {
            int length = clsArr.length;
            Constructor[] constructors = cls.getConstructors();
            int length2 = constructors.length;
            for (int i10 = 0; i10 < length2; i10++) {
                Class[] parameterTypes = constructors[i10].getParameterTypes();
                int length3 = parameterTypes.length;
                if (length3 == length) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length3) {
                            z10 = true;
                            break;
                        } else if (!MethodUtils.isAssignmentCompatible(parameterTypes[i11], clsArr[i11])) {
                            z10 = false;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (z10 && (accessibleConstructor = getAccessibleConstructor(constructors[i10])) != null) {
                        try {
                            accessibleConstructor.setAccessible(true);
                        } catch (SecurityException unused3) {
                        }
                        return accessibleConstructor;
                    }
                }
            }
            return null;
        }
    }

    public static <T> T invokeConstructor(Class<T> cls, Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return invokeConstructor(cls, toArray(obj));
    }

    public static <T> T invokeExactConstructor(Class<T> cls, Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return invokeExactConstructor(cls, toArray(obj));
    }

    private static Object[] toArray(Object obj) {
        if (obj == null) {
            return null;
        }
        return new Object[]{obj};
    }

    public static <T> Constructor<T> getAccessibleConstructor(Class<T> cls, Class<?>[] clsArr) {
        try {
            return getAccessibleConstructor(cls.getConstructor(clsArr));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static <T> Constructor<T> getAccessibleConstructor(Constructor<T> constructor) {
        if (constructor != null && Modifier.isPublic(constructor.getModifiers()) && Modifier.isPublic(constructor.getDeclaringClass().getModifiers())) {
            return constructor;
        }
        return null;
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i10 = 0; i10 < length; i10++) {
            clsArr[i10] = objArr[i10].getClass();
        }
        return invokeConstructor(cls, objArr, clsArr);
    }

    public static <T> T invokeExactConstructor(Class<T> cls, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i10 = 0; i10 < length; i10++) {
            clsArr[i10] = objArr[i10].getClass();
        }
        return invokeExactConstructor(cls, objArr, clsArr);
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_PARAMETERS;
        }
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        Constructor<T> matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, clsArr);
        if (matchingAccessibleConstructor != null) {
            return matchingAccessibleConstructor.newInstance(objArr);
        }
        throw new NoSuchMethodException("No such accessible constructor on object: " + cls.getName());
    }

    public static <T> T invokeExactConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_PARAMETERS;
        }
        Constructor<T> accessibleConstructor = getAccessibleConstructor(cls, clsArr);
        if (accessibleConstructor != null) {
            return accessibleConstructor.newInstance(objArr);
        }
        throw new NoSuchMethodException("No such accessible constructor on object: " + cls.getName());
    }
}
