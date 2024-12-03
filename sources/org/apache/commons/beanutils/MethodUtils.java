package org.apache.commons.beanutils;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MethodUtils {
    private static boolean CACHE_METHODS = true;
    /* access modifiers changed from: private */
    public static final Class<?>[] EMPTY_CLASS_PARAMETERS = new Class[0];
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    private static final Map<MethodDescriptor, Reference<Method>> cache = Collections.synchronizedMap(new WeakHashMap());
    private static boolean loggedAccessibleWarning = false;

    private static class MethodDescriptor {
        private final Class<?> cls;
        private final boolean exact;
        private final int hashCode;
        private final String methodName;
        private final Class<?>[] paramTypes;

        public MethodDescriptor(Class<?> cls2, String str, Class<?>[] clsArr, boolean z10) {
            if (cls2 == null) {
                throw new IllegalArgumentException("Class cannot be null");
            } else if (str != null) {
                clsArr = clsArr == null ? MethodUtils.EMPTY_CLASS_PARAMETERS : clsArr;
                this.cls = cls2;
                this.methodName = str;
                this.paramTypes = clsArr;
                this.exact = z10;
                this.hashCode = str.length();
            } else {
                throw new IllegalArgumentException("Method Name cannot be null");
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof MethodDescriptor)) {
                return false;
            }
            MethodDescriptor methodDescriptor = (MethodDescriptor) obj;
            if (this.exact != methodDescriptor.exact || !this.methodName.equals(methodDescriptor.methodName) || !this.cls.equals(methodDescriptor.cls) || !Arrays.equals(this.paramTypes, methodDescriptor.paramTypes)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    private static void cacheMethod(MethodDescriptor methodDescriptor, Method method) {
        if (CACHE_METHODS && method != null) {
            cache.put(methodDescriptor, new WeakReference(method));
        }
    }

    public static synchronized int clearCache() {
        int size;
        synchronized (MethodUtils.class) {
            Map<MethodDescriptor, Reference<Method>> map = cache;
            size = map.size();
            map.clear();
        }
        return size;
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?> cls2) {
        return getAccessibleMethod(cls, str, (Class<?>[]) new Class[]{cls2});
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>[] clsArr) {
        Method method = null;
        for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            Class[] interfaces = cls2.getInterfaces();
            for (int i10 = 0; i10 < interfaces.length; i10++) {
                if (Modifier.isPublic(interfaces[i10].getModifiers())) {
                    try {
                        method = interfaces[i10].getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                    }
                    if (method != null) {
                        return method;
                    }
                    method = getAccessibleMethodFromInterfaceNest(interfaces[i10], str, clsArr);
                    if (method != null) {
                        return method;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Method getAccessibleMethodFromSuperclass(java.lang.Class<?> r2, java.lang.String r3, java.lang.Class<?>[] r4) {
        /*
            java.lang.Class r2 = r2.getSuperclass()
        L_0x0004:
            r0 = 0
            if (r2 == 0) goto L_0x001c
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isPublic(r1)
            if (r1 == 0) goto L_0x0017
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0016 }
            return r2
        L_0x0016:
            return r0
        L_0x0017:
            java.lang.Class r2 = r2.getSuperclass()
            goto L_0x0004
        L_0x001c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.beanutils.MethodUtils.getAccessibleMethodFromSuperclass(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    private static Method getCachedMethod(MethodDescriptor methodDescriptor) {
        Reference reference;
        if (!CACHE_METHODS || (reference = cache.get(methodDescriptor)) == null) {
            return null;
        }
        return (Method) reference.get();
    }

    public static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        boolean z10;
        Class<?> cls2 = cls;
        String str2 = str;
        Class<?>[] clsArr2 = clsArr;
        Log log = LogFactory.getLog(MethodUtils.class);
        if (log.isTraceEnabled()) {
            log.trace("Matching name=" + str2 + " on " + cls2);
        }
        int i10 = 0;
        MethodDescriptor methodDescriptor = new MethodDescriptor(cls2, str2, clsArr2, false);
        try {
            Method cachedMethod = getCachedMethod(methodDescriptor);
            if (cachedMethod != null) {
                return cachedMethod;
            }
            Method method = cls.getMethod(str, clsArr);
            if (log.isTraceEnabled()) {
                log.trace("Found straight match: " + method);
                log.trace("isPublic:" + Modifier.isPublic(method.getModifiers()));
            }
            setMethodAccessible(method);
            cacheMethod(methodDescriptor, method);
            return method;
        } catch (NoSuchMethodException unused) {
            int length = clsArr2.length;
            Method method2 = null;
            Method[] methods = cls.getMethods();
            float f10 = Float.MAX_VALUE;
            int length2 = methods.length;
            int i11 = 0;
            while (i11 < length2) {
                if (methods[i11].getName().equals(str2)) {
                    if (log.isTraceEnabled()) {
                        log.trace("Found matching name:");
                        log.trace(methods[i11]);
                    }
                    Class[] parameterTypes = methods[i11].getParameterTypes();
                    int length3 = parameterTypes.length;
                    if (length3 == length) {
                        int i12 = i10;
                        while (true) {
                            if (i12 >= length3) {
                                z10 = true;
                                break;
                            }
                            if (log.isTraceEnabled()) {
                                log.trace("Param=" + clsArr2[i12].getName());
                                log.trace("Method=" + parameterTypes[i12].getName());
                            }
                            if (!isAssignmentCompatible(parameterTypes[i12], clsArr2[i12])) {
                                if (log.isTraceEnabled()) {
                                    log.trace(parameterTypes[i12] + " is not assignable from " + clsArr2[i12]);
                                }
                                z10 = false;
                            } else {
                                i12++;
                            }
                        }
                        if (z10) {
                            Method accessibleMethod = getAccessibleMethod(cls2, methods[i11]);
                            if (accessibleMethod != null) {
                                if (log.isTraceEnabled()) {
                                    log.trace(accessibleMethod + " accessible version of " + methods[i11]);
                                }
                                setMethodAccessible(accessibleMethod);
                                float totalTransformationCost = getTotalTransformationCost(clsArr2, accessibleMethod.getParameterTypes());
                                if (totalTransformationCost < f10) {
                                    method2 = accessibleMethod;
                                    f10 = totalTransformationCost;
                                }
                            }
                            log.trace("Couldn't find accessible method.");
                        }
                    }
                }
                i11++;
                i10 = 0;
            }
            if (method2 != null) {
                cacheMethod(methodDescriptor, method2);
            } else {
                log.trace("No match found.");
            }
            return method2;
        }
    }

    private static float getObjectTransformationCost(Class<?> cls, Class<?> cls2) {
        Class<?> primitiveWrapper;
        float f10 = 0.0f;
        Class<? super Object> cls3 = cls;
        while (true) {
            if (cls3 == null || cls2.equals(cls3)) {
                break;
            } else if ((!cls2.isPrimitive() || (primitiveWrapper = getPrimitiveWrapper(cls2)) == null || !primitiveWrapper.equals(cls3)) && (!cls2.isInterface() || !isAssignmentCompatible(cls2, cls3))) {
                f10 += 1.0f;
                cls3 = cls3.getSuperclass();
            }
        }
        f10 += 0.25f;
        if (cls3 == null) {
            return f10 + 1.5f;
        }
        return f10;
    }

    public static Class<?> getPrimitiveType(Class<?> cls) {
        if (Boolean.class.equals(cls)) {
            return Boolean.TYPE;
        }
        if (Float.class.equals(cls)) {
            return Float.TYPE;
        }
        if (Long.class.equals(cls)) {
            return Long.TYPE;
        }
        if (Integer.class.equals(cls)) {
            return Integer.TYPE;
        }
        if (Short.class.equals(cls)) {
            return Short.TYPE;
        }
        if (Byte.class.equals(cls)) {
            return Byte.TYPE;
        }
        if (Double.class.equals(cls)) {
            return Double.TYPE;
        }
        if (Character.class.equals(cls)) {
            return Character.TYPE;
        }
        Log log = LogFactory.getLog(MethodUtils.class);
        if (!log.isDebugEnabled()) {
            return null;
        }
        log.debug("Not a known primitive wrapper class: " + cls);
        return null;
    }

    public static Class<?> getPrimitiveWrapper(Class<?> cls) {
        if (Boolean.TYPE.equals(cls)) {
            return Boolean.class;
        }
        if (Float.TYPE.equals(cls)) {
            return Float.class;
        }
        if (Long.TYPE.equals(cls)) {
            return Long.class;
        }
        if (Integer.TYPE.equals(cls)) {
            return Integer.class;
        }
        if (Short.TYPE.equals(cls)) {
            return Short.class;
        }
        if (Byte.TYPE.equals(cls)) {
            return Byte.class;
        }
        if (Double.TYPE.equals(cls)) {
            return Double.class;
        }
        if (Character.TYPE.equals(cls)) {
            return Character.class;
        }
        return null;
    }

    private static float getTotalTransformationCost(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float f10 = 0.0f;
        for (int i10 = 0; i10 < clsArr.length; i10++) {
            f10 += getObjectTransformationCost(clsArr[i10], clsArr2[i10]);
        }
        return f10;
    }

    public static Object invokeExactMethod(Object obj, String str, Object obj2) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeExactMethod(obj, str, toArray(obj2));
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_PARAMETERS;
        }
        Method accessibleMethod = getAccessibleMethod(cls, str, clsArr);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke((Object) null, objArr);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
    }

    public static Object invokeMethod(Object obj, String str, Object obj2) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeMethod(obj, str, toArray(obj2));
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeStaticMethod(cls, str, toArray(obj));
    }

    public static final boolean isAssignmentCompatible(Class<?> cls, Class<?> cls2) {
        Class<?> primitiveWrapper;
        if (cls.isAssignableFrom(cls2)) {
            return true;
        }
        if (!cls.isPrimitive() || (primitiveWrapper = getPrimitiveWrapper(cls)) == null) {
            return false;
        }
        return primitiveWrapper.equals(cls2);
    }

    public static synchronized void setCacheMethods(boolean z10) {
        synchronized (MethodUtils.class) {
            CACHE_METHODS = z10;
            if (!z10) {
                clearCache();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
        if (r2.charAt(2) == '3') goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void setMethodAccessible(java.lang.reflect.Method r8) {
        /*
            r0 = 1
            boolean r1 = r8.isAccessible()     // Catch:{ SecurityException -> 0x000b }
            if (r1 != 0) goto L_0x0053
            r8.setAccessible(r0)     // Catch:{ SecurityException -> 0x000b }
            goto L_0x0053
        L_0x000b:
            r8 = move-exception
            java.lang.Class<org.apache.commons.beanutils.MethodUtils> r1 = org.apache.commons.beanutils.MethodUtils.class
            org.apache.commons.logging.Log r1 = org.apache.commons.logging.LogFactory.getLog(r1)
            boolean r2 = loggedAccessibleWarning
            if (r2 != 0) goto L_0x004e
            java.lang.String r2 = "java.specification.version"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{ SecurityException -> 0x0044 }
            r3 = 0
            char r4 = r2.charAt(r3)     // Catch:{ SecurityException -> 0x0044 }
            r5 = 49
            if (r4 != r5) goto L_0x0045
            r4 = 2
            char r6 = r2.charAt(r4)     // Catch:{ SecurityException -> 0x0044 }
            r7 = 48
            if (r6 == r7) goto L_0x0044
            char r6 = r2.charAt(r4)     // Catch:{ SecurityException -> 0x0044 }
            if (r6 == r5) goto L_0x0044
            char r5 = r2.charAt(r4)     // Catch:{ SecurityException -> 0x0044 }
            r6 = 50
            if (r5 == r6) goto L_0x0044
            char r2 = r2.charAt(r4)     // Catch:{ SecurityException -> 0x0044 }
            r4 = 51
            if (r2 != r4) goto L_0x0045
        L_0x0044:
            r3 = r0
        L_0x0045:
            if (r3 == 0) goto L_0x004c
            java.lang.String r2 = "Current Security Manager restricts use of workarounds for reflection bugs  in pre-1.4 JVMs."
            r1.warn(r2)
        L_0x004c:
            loggedAccessibleWarning = r0
        L_0x004e:
            java.lang.String r0 = "Cannot setAccessible on method. Therefore cannot use jvm access bug workaround."
            r1.debug(r0, r8)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.beanutils.MethodUtils.setMethodAccessible(java.lang.reflect.Method):void");
    }

    private static Object[] toArray(Object obj) {
        if (obj == null) {
            return null;
        }
        return new Object[]{obj};
    }

    public static Class<?> toNonPrimitiveClass(Class<?> cls) {
        Class<?> primitiveWrapper;
        if (!cls.isPrimitive() || (primitiveWrapper = getPrimitiveWrapper(cls)) == null) {
            return cls;
        }
        return primitiveWrapper;
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        try {
            MethodDescriptor methodDescriptor = new MethodDescriptor(cls, str, clsArr, true);
            Method cachedMethod = getCachedMethod(methodDescriptor);
            if (cachedMethod != null) {
                return cachedMethod;
            }
            Method accessibleMethod = getAccessibleMethod(cls, cls.getMethod(str, clsArr));
            cacheMethod(methodDescriptor, accessibleMethod);
            return accessibleMethod;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i10 = 0; i10 < length; i10++) {
            clsArr[i10] = objArr[i10].getClass();
        }
        return invokeExactMethod(obj, str, objArr, clsArr);
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i10 = 0; i10 < length; i10++) {
            clsArr[i10] = objArr[i10].getClass();
        }
        return invokeMethod(obj, str, objArr, clsArr);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i10 = 0; i10 < length; i10++) {
            clsArr[i10] = objArr[i10].getClass();
        }
        return invokeStaticMethod(cls, str, objArr, clsArr);
    }

    public static Method getAccessibleMethod(Method method) {
        if (method == null) {
            return null;
        }
        return getAccessibleMethod(method.getDeclaringClass(), method);
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeExactStaticMethod(cls, str, toArray(obj));
    }

    public static Method getAccessibleMethod(Class<?> cls, Method method) {
        if (method == null || !Modifier.isPublic(method.getModifiers())) {
            return null;
        }
        boolean z10 = true;
        if (cls == null) {
            cls = method.getDeclaringClass();
        } else {
            z10 = cls.equals(method.getDeclaringClass());
            if (!method.getDeclaringClass().isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls.getName() + " is not assignable from " + method.getDeclaringClass().getName());
            }
        }
        if (Modifier.isPublic(cls.getModifiers())) {
            if (!z10 && !Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
                setMethodAccessible(method);
            }
            return method;
        }
        String name = method.getName();
        Class[] parameterTypes = method.getParameterTypes();
        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(cls, name, parameterTypes);
        return accessibleMethodFromInterfaceNest == null ? getAccessibleMethodFromSuperclass(cls, name, parameterTypes) : accessibleMethodFromInterfaceNest;
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_PARAMETERS;
        }
        Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, clsArr);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(obj, objArr);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i10 = 0; i10 < length; i10++) {
            clsArr[i10] = objArr[i10].getClass();
        }
        return invokeExactStaticMethod(cls, str, objArr, clsArr);
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_PARAMETERS;
        }
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(obj.getClass(), str, clsArr);
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke(obj, objArr);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_PARAMETERS;
        }
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, clsArr);
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke((Object) null, objArr);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
    }
}
