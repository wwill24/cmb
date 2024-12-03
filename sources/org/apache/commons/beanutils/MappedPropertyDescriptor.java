package org.apache.commons.beanutils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MappedPropertyDescriptor extends PropertyDescriptor {
    /* access modifiers changed from: private */
    public static final Class<?>[] STRING_CLASS_PARAMETER = {String.class};
    private Reference<Class<?>> mappedPropertyTypeRef;
    private MappedMethodReference mappedReadMethodRef;
    private MappedMethodReference mappedWriteMethodRef;

    private static class MappedMethodReference {
        private String className;
        private Reference<Class<?>> classRef;
        private String methodName;
        private Reference<Method> methodRef;
        private String[] writeParamClassNames;
        private Reference<Class<?>> writeParamTypeRef0;
        private Reference<Class<?>> writeParamTypeRef1;

        MappedMethodReference(Method method) {
            if (method != null) {
                this.className = method.getDeclaringClass().getName();
                this.methodName = method.getName();
                this.methodRef = new SoftReference(method);
                this.classRef = new WeakReference(method.getDeclaringClass());
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 2) {
                    this.writeParamTypeRef0 = new WeakReference(parameterTypes[0]);
                    this.writeParamTypeRef1 = new WeakReference(parameterTypes[1]);
                    String[] strArr = new String[2];
                    this.writeParamClassNames = strArr;
                    strArr[0] = parameterTypes[0].getName();
                    this.writeParamClassNames[1] = parameterTypes[1].getName();
                }
            }
        }

        /* access modifiers changed from: private */
        public Method get() {
            Class[] clsArr;
            Reference<Method> reference = this.methodRef;
            if (reference == null) {
                return null;
            }
            Method method = reference.get();
            if (method == null) {
                Class<?> cls = this.classRef.get();
                if (cls == null && (cls = reLoadClass()) != null) {
                    this.classRef = new WeakReference(cls);
                }
                if (cls != null) {
                    if (this.writeParamClassNames != null) {
                        clsArr = new Class[2];
                        Class cls2 = this.writeParamTypeRef0.get();
                        clsArr[0] = cls2;
                        if (cls2 == null) {
                            Class<?> reLoadClass = reLoadClass(this.writeParamClassNames[0]);
                            clsArr[0] = reLoadClass;
                            if (reLoadClass != null) {
                                this.writeParamTypeRef0 = new WeakReference(clsArr[0]);
                            }
                        }
                        Class cls3 = this.writeParamTypeRef1.get();
                        clsArr[1] = cls3;
                        if (cls3 == null) {
                            Class<?> reLoadClass2 = reLoadClass(this.writeParamClassNames[1]);
                            clsArr[1] = reLoadClass2;
                            if (reLoadClass2 != null) {
                                this.writeParamTypeRef1 = new WeakReference(clsArr[1]);
                            }
                        }
                    } else {
                        clsArr = MappedPropertyDescriptor.STRING_CLASS_PARAMETER;
                    }
                    try {
                        method = cls.getMethod(this.methodName, clsArr);
                        this.methodRef = new SoftReference(method);
                    } catch (NoSuchMethodException unused) {
                        throw new RuntimeException("Method " + this.methodName + " for " + this.className + " could not be reconstructed - method not found");
                    }
                } else {
                    throw new RuntimeException("Method " + this.methodName + " for " + this.className + " could not be reconstructed - class reference has gone");
                }
            }
            return method;
        }

        private Class<?> reLoadClass() {
            return reLoadClass(this.className);
        }

        private Class<?> reLoadClass(String str) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                try {
                    return contextClassLoader.loadClass(str);
                } catch (ClassNotFoundException unused) {
                }
            }
            try {
                return MappedPropertyDescriptor.class.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0067, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r4 = getMethod(r10, "is" + r2, STRING_CLASS_PARAMETER);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MappedPropertyDescriptor(java.lang.String r9, java.lang.Class<?> r10) throws java.beans.IntrospectionException {
        /*
            r8 = this;
            java.lang.String r0 = "set"
            r1 = 0
            r8.<init>(r9, r1, r1)
            if (r9 == 0) goto L_0x00b7
            int r2 = r9.length()
            if (r2 == 0) goto L_0x00b7
            r8.setName(r9)
            java.lang.String r2 = capitalizePropertyName(r9)
            r3 = 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IntrospectionException -> 0x002e }
            r4.<init>()     // Catch:{ IntrospectionException -> 0x002e }
            java.lang.String r5 = "get"
            r4.append(r5)     // Catch:{ IntrospectionException -> 0x002e }
            r4.append(r2)     // Catch:{ IntrospectionException -> 0x002e }
            java.lang.String r4 = r4.toString()     // Catch:{ IntrospectionException -> 0x002e }
            java.lang.Class<?>[] r5 = STRING_CLASS_PARAMETER     // Catch:{ IntrospectionException -> 0x002e }
            java.lang.reflect.Method r4 = getMethod((java.lang.Class<?>) r10, (java.lang.String) r4, (java.lang.Class<?>[]) r5)     // Catch:{ IntrospectionException -> 0x002e }
            goto L_0x0045
        L_0x002e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IntrospectionException -> 0x0067 }
            r4.<init>()     // Catch:{ IntrospectionException -> 0x0067 }
            java.lang.String r5 = "is"
            r4.append(r5)     // Catch:{ IntrospectionException -> 0x0067 }
            r4.append(r2)     // Catch:{ IntrospectionException -> 0x0067 }
            java.lang.String r4 = r4.toString()     // Catch:{ IntrospectionException -> 0x0067 }
            java.lang.Class<?>[] r5 = STRING_CLASS_PARAMETER     // Catch:{ IntrospectionException -> 0x0067 }
            java.lang.reflect.Method r4 = getMethod((java.lang.Class<?>) r10, (java.lang.String) r4, (java.lang.Class<?>[]) r5)     // Catch:{ IntrospectionException -> 0x0067 }
        L_0x0045:
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ IntrospectionException -> 0x0068 }
            r6 = 0
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r5[r6] = r7     // Catch:{ IntrospectionException -> 0x0068 }
            r6 = 1
            java.lang.Class r7 = r4.getReturnType()     // Catch:{ IntrospectionException -> 0x0068 }
            r5[r6] = r7     // Catch:{ IntrospectionException -> 0x0068 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IntrospectionException -> 0x0068 }
            r6.<init>()     // Catch:{ IntrospectionException -> 0x0068 }
            r6.append(r0)     // Catch:{ IntrospectionException -> 0x0068 }
            r6.append(r2)     // Catch:{ IntrospectionException -> 0x0068 }
            java.lang.String r6 = r6.toString()     // Catch:{ IntrospectionException -> 0x0068 }
            java.lang.reflect.Method r1 = getMethod((java.lang.Class<?>) r10, (java.lang.String) r6, (java.lang.Class<?>[]) r5)     // Catch:{ IntrospectionException -> 0x0068 }
            goto L_0x0068
        L_0x0067:
            r4 = r1
        L_0x0068:
            if (r4 != 0) goto L_0x007d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r2)
            java.lang.String r0 = r1.toString()
            java.lang.reflect.Method r1 = getMethod((java.lang.Class<?>) r10, (java.lang.String) r0, (int) r3)
        L_0x007d:
            if (r4 != 0) goto L_0x00a5
            if (r1 == 0) goto L_0x0082
            goto L_0x00a5
        L_0x0082:
            java.beans.IntrospectionException r0 = new java.beans.IntrospectionException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Property '"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = "' not found on "
            r1.append(r9)
            java.lang.String r9 = r10.getName()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            throw r0
        L_0x00a5:
            org.apache.commons.beanutils.MappedPropertyDescriptor$MappedMethodReference r9 = new org.apache.commons.beanutils.MappedPropertyDescriptor$MappedMethodReference
            r9.<init>(r4)
            r8.mappedReadMethodRef = r9
            org.apache.commons.beanutils.MappedPropertyDescriptor$MappedMethodReference r9 = new org.apache.commons.beanutils.MappedPropertyDescriptor$MappedMethodReference
            r9.<init>(r1)
            r8.mappedWriteMethodRef = r9
            r8.findMappedPropertyType()
            return
        L_0x00b7:
            java.beans.IntrospectionException r0 = new java.beans.IntrospectionException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "bad property name: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = " on class: "
            r1.append(r9)
            java.lang.Class r9 = r10.getClass()
            java.lang.String r9 = r9.getName()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.beanutils.MappedPropertyDescriptor.<init>(java.lang.String, java.lang.Class):void");
    }

    private static String capitalizePropertyName(String str) {
        if (str.length() == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        return new String(charArray);
    }

    private void findMappedPropertyType() throws IntrospectionException {
        try {
            Method mappedReadMethod = getMappedReadMethod();
            Method mappedWriteMethod = getMappedWriteMethod();
            Class<?> cls = null;
            if (mappedReadMethod != null) {
                if (mappedReadMethod.getParameterTypes().length == 1) {
                    cls = mappedReadMethod.getReturnType();
                    if (cls == Void.TYPE) {
                        throw new IntrospectionException("mapped read method " + mappedReadMethod.getName() + " returns void");
                    }
                } else {
                    throw new IntrospectionException("bad mapped read method arg count");
                }
            }
            if (mappedWriteMethod != null) {
                Class<?>[] parameterTypes = mappedWriteMethod.getParameterTypes();
                if (parameterTypes.length == 2) {
                    if (cls != null) {
                        if (cls != parameterTypes[1]) {
                            throw new IntrospectionException("type mismatch between mapped read and write methods");
                        }
                    }
                    cls = parameterTypes[1];
                } else {
                    throw new IntrospectionException("bad mapped write method arg count");
                }
            }
            this.mappedPropertyTypeRef = new SoftReference(cls);
        } catch (IntrospectionException e10) {
            throw e10;
        }
    }

    private static Method getMethod(Class<?> cls, String str, int i10) throws IntrospectionException {
        if (str == null) {
            return null;
        }
        Method internalGetMethod = internalGetMethod(cls, str, i10);
        if (internalGetMethod != null) {
            return internalGetMethod;
        }
        throw new IntrospectionException("No method \"" + str + "\" with " + i10 + " parameter(s)");
    }

    private static Method internalGetMethod(Class<?> cls, String str, int i10) {
        Class<?> cls2 = cls;
        while (true) {
            int i11 = 0;
            if (cls2 != null) {
                Method[] declaredMethods = cls2.getDeclaredMethods();
                while (i11 < declaredMethods.length) {
                    Method method = declaredMethods[i11];
                    if (method != null) {
                        int modifiers = method.getModifiers();
                        if (Modifier.isPublic(modifiers) && !Modifier.isStatic(modifiers) && method.getName().equals(str) && method.getParameterTypes().length == i10) {
                            return method;
                        }
                    }
                    i11++;
                }
                cls2 = cls2.getSuperclass();
            } else {
                Class[] interfaces = cls.getInterfaces();
                while (i11 < interfaces.length) {
                    Method internalGetMethod = internalGetMethod(interfaces[i11], str, i10);
                    if (internalGetMethod != null) {
                        return internalGetMethod;
                    }
                    i11++;
                }
                return null;
            }
        }
    }

    public Class<?> getMappedPropertyType() {
        return this.mappedPropertyTypeRef.get();
    }

    public Method getMappedReadMethod() {
        return this.mappedReadMethodRef.get();
    }

    public Method getMappedWriteMethod() {
        return this.mappedWriteMethodRef.get();
    }

    public void setMappedReadMethod(Method method) throws IntrospectionException {
        this.mappedReadMethodRef = new MappedMethodReference(method);
        findMappedPropertyType();
    }

    public void setMappedWriteMethod(Method method) throws IntrospectionException {
        this.mappedWriteMethodRef = new MappedMethodReference(method);
        findMappedPropertyType();
    }

    private static Method getMethod(Class<?> cls, String str, Class<?>[] clsArr) throws IntrospectionException {
        int i10;
        if (str == null) {
            return null;
        }
        Method matchingAccessibleMethod = MethodUtils.getMatchingAccessibleMethod(cls, str, clsArr);
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod;
        }
        if (clsArr == null) {
            i10 = 0;
        } else {
            i10 = clsArr.length;
        }
        throw new IntrospectionException("No method \"" + str + "\" with " + i10 + " parameter(s) of matching types.");
    }

    public MappedPropertyDescriptor(String str, Class<?> cls, String str2, String str3) throws IntrospectionException {
        super(str, (Method) null, (Method) null);
        Method method;
        if (str == null || str.length() == 0) {
            throw new IntrospectionException("bad property name: " + str);
        }
        setName(str);
        Method method2 = getMethod(cls, str2, STRING_CLASS_PARAMETER);
        if (method2 != null) {
            method = getMethod(cls, str3, (Class<?>[]) new Class[]{String.class, method2.getReturnType()});
        } else {
            method = getMethod(cls, str3, 2);
        }
        this.mappedReadMethodRef = new MappedMethodReference(method2);
        this.mappedWriteMethodRef = new MappedMethodReference(method);
        findMappedPropertyType();
    }

    public MappedPropertyDescriptor(String str, Method method, Method method2) throws IntrospectionException {
        super(str, method, method2);
        if (str == null || str.length() == 0) {
            throw new IntrospectionException("bad property name: " + str);
        }
        setName(str);
        this.mappedReadMethodRef = new MappedMethodReference(method);
        this.mappedWriteMethodRef = new MappedMethodReference(method2);
        findMappedPropertyType();
    }
}
