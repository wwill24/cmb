package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.j;

public final class d0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final List<Class<?>> f6015a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final List<Class<?>> f6016b;

    static {
        Class<a0> cls = a0.class;
        f6015a = q.m(Application.class, cls);
        f6016b = p.e(cls);
    }

    public static final <T> Constructor<T> c(Class<T> cls, List<? extends Class<?>> list) {
        j.g(cls, "modelClass");
        j.g(list, "signature");
        Constructor<T>[] constructors = cls.getConstructors();
        j.f(constructors, "modelClass.constructors");
        int length = constructors.length;
        int i10 = 0;
        while (i10 < length) {
            Constructor<T> constructor = constructors[i10];
            Class[] parameterTypes = constructor.getParameterTypes();
            j.f(parameterTypes, "constructor.parameterTypes");
            List p02 = l.p0(parameterTypes);
            if (j.b(list, p02)) {
                j.e(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            } else if (list.size() != p02.size() || !p02.containsAll(list)) {
                i10++;
            } else {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final <T extends f0> T d(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        j.g(cls, "modelClass");
        j.g(constructor, "constructor");
        j.g(objArr, "params");
        try {
            return (f0) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Failed to access " + cls, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e12.getCause());
        }
    }
}
