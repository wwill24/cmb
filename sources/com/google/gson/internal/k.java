package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public static final k f21370a = c();

    class a extends k {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Method f21371b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f21372c;

        a(Method method, Object obj) {
            this.f21371b = method;
            this.f21372c = obj;
        }

        public <T> T d(Class<T> cls) throws Exception {
            k.b(cls);
            return this.f21371b.invoke(this.f21372c, new Object[]{cls});
        }
    }

    class b extends k {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Method f21373b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f21374c;

        b(Method method, int i10) {
            this.f21373b = method;
            this.f21374c = i10;
        }

        public <T> T d(Class<T> cls) throws Exception {
            k.b(cls);
            return this.f21373b.invoke((Object) null, new Object[]{cls, Integer.valueOf(this.f21374c)});
        }
    }

    class c extends k {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Method f21375b;

        c(Method method) {
            this.f21375b = method;
        }

        public <T> T d(Class<T> cls) throws Exception {
            k.b(cls);
            return this.f21375b.invoke((Object) null, new Object[]{cls, Object.class});
        }
    }

    class d extends k {
        d() {
        }

        public <T> T d(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    /* access modifiers changed from: private */
    public static void b(Class<?> cls) {
        String a10 = b.a(cls);
        if (a10 != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + a10);
        }
    }

    private static k c() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", new Class[]{Class.class}), declaredField.get((Object) null));
        } catch (Exception unused) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke((Object) null, new Object[]{Object.class})).intValue();
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, new Class[]{Class.class, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                return new b(declaredMethod2, intValue);
            } catch (Exception unused2) {
                try {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, new Class[]{Class.class, Class.class});
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                } catch (Exception unused3) {
                    return new d();
                }
            }
        }
    }

    public abstract <T> T d(Class<T> cls) throws Exception;
}
