package com.squareup.moshi;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

abstract class c<T> {

    class a extends c<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Constructor f22936a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f22937b;

        a(Constructor constructor, Class cls) {
            this.f22936a = constructor;
            this.f22937b = cls;
        }

        public T b() throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return this.f22936a.newInstance((Object[]) null);
        }

        public String toString() {
            return this.f22937b.getName();
        }
    }

    class b extends c<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f22938a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f22939b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Class f22940c;

        b(Method method, Object obj, Class cls) {
            this.f22938a = method;
            this.f22939b = obj;
            this.f22940c = cls;
        }

        public T b() throws InvocationTargetException, IllegalAccessException {
            return this.f22938a.invoke(this.f22939b, new Object[]{this.f22940c});
        }

        public String toString() {
            return this.f22940c.getName();
        }
    }

    /* renamed from: com.squareup.moshi.c$c  reason: collision with other inner class name */
    class C0265c extends c<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f22941a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f22942b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f22943c;

        C0265c(Method method, Class cls, int i10) {
            this.f22941a = method;
            this.f22942b = cls;
            this.f22943c = i10;
        }

        public T b() throws InvocationTargetException, IllegalAccessException {
            return this.f22941a.invoke((Object) null, new Object[]{this.f22942b, Integer.valueOf(this.f22943c)});
        }

        public String toString() {
            return this.f22942b.getName();
        }
    }

    class d extends c<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f22944a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f22945b;

        d(Method method, Class cls) {
            this.f22944a = method;
            this.f22945b = cls;
        }

        public T b() throws InvocationTargetException, IllegalAccessException {
            return this.f22944a.invoke((Object) null, new Object[]{this.f22945b, Object.class});
        }

        public String toString() {
            return this.f22945b.getName();
        }
    }

    c() {
    }

    public static <T> c<T> a(Class<?> cls) {
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return new a(declaredConstructor, cls);
        } catch (NoSuchMethodException unused) {
            try {
                Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                Field declaredField = cls2.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                return new b(cls2.getMethod("allocateInstance", new Class[]{Class.class}), declaredField.get((Object) null), cls);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused3) {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke((Object) null, new Object[]{Object.class})).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, new Class[]{Class.class, Integer.TYPE});
                    declaredMethod2.setAccessible(true);
                    return new C0265c(declaredMethod2, cls, intValue);
                } catch (IllegalAccessException unused4) {
                    throw new AssertionError();
                } catch (InvocationTargetException e10) {
                    throw bi.c.t(e10);
                } catch (NoSuchMethodException unused5) {
                    try {
                        Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, new Class[]{Class.class, Class.class});
                        declaredMethod3.setAccessible(true);
                        return new d(declaredMethod3, cls);
                    } catch (Exception unused6) {
                        throw new IllegalArgumentException("cannot construct instances of " + cls.getName());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T b() throws InvocationTargetException, IllegalAccessException, InstantiationException;
}
