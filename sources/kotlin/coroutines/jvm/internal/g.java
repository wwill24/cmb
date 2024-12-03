package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.j;

final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f32084a = new g();

    /* renamed from: b  reason: collision with root package name */
    private static final a f32085b = new a((Method) null, (Method) null, (Method) null);

    /* renamed from: c  reason: collision with root package name */
    private static a f32086c;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Method f32087a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f32088b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f32089c;

        public a(Method method, Method method2, Method method3) {
            this.f32087a = method;
            this.f32088b = method2;
            this.f32089c = method3;
        }
    }

    private g() {
    }

    private final a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f32086c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f32085b;
            f32086c = aVar2;
            return aVar2;
        }
    }

    public final String b(BaseContinuationImpl baseContinuationImpl) {
        Object obj;
        Object obj2;
        Object obj3;
        j.g(baseContinuationImpl, "continuation");
        a aVar = f32086c;
        if (aVar == null) {
            aVar = a(baseContinuationImpl);
        }
        if (aVar == f32085b) {
            return null;
        }
        Method method = aVar.f32087a;
        if (method != null) {
            obj = method.invoke(baseContinuationImpl.getClass(), new Object[0]);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        Method method2 = aVar.f32088b;
        if (method2 != null) {
            obj2 = method2.invoke(obj, new Object[0]);
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        Method method3 = aVar.f32089c;
        if (method3 != null) {
            obj3 = method3.invoke(obj2, new Object[0]);
        } else {
            obj3 = null;
        }
        if (obj3 instanceof String) {
            return (String) obj3;
        }
        return null;
    }
}
