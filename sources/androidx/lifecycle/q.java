package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;
import net.bytebuddy.utility.JavaConstant;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f6060a = new q();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<?>, Integer> f6061b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<?>, List<Constructor<? extends e>>> f6062c = new HashMap();

    private q() {
    }

    private final e a(Constructor<? extends e> constructor, Object obj) {
        try {
            Object newInstance = constructor.newInstance(new Object[]{obj});
            j.f(newInstance, "{\n            constructo…tance(`object`)\n        }");
            return (e) newInstance;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    private final Constructor<? extends e> b(Class<?> cls) {
        String str;
        boolean z10;
        boolean z11;
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            if (packageR != null) {
                str = packageR.getName();
            } else {
                str = "";
            }
            j.f(str, "fullPackage");
            if (str.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                j.f(canonicalName, "name");
                canonicalName = canonicalName.substring(str.length() + 1);
                j.f(canonicalName, "this as java.lang.String).substring(startIndex)");
            }
            j.f(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String c10 = c(canonicalName);
            if (str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                c10 = str + '.' + c10;
            }
            Class<?> cls2 = Class.forName(c10);
            j.e(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(new Class[]{cls});
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static final String c(String str) {
        j.g(str, "className");
        return r.D(str, ".", JavaConstant.Dynamic.DEFAULT_NAME, false, 4, (Object) null) + "_LifecycleAdapter";
    }

    private final int d(Class<?> cls) {
        Map<Class<?>, Integer> map = f6061b;
        Integer num = map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int g10 = g(cls);
        map.put(cls, Integer.valueOf(g10));
        return g10;
    }

    private final boolean e(Class<?> cls) {
        return cls != null && k.class.isAssignableFrom(cls);
    }

    public static final i f(Object obj) {
        j.g(obj, "object");
        boolean z10 = obj instanceof i;
        boolean z11 = obj instanceof DefaultLifecycleObserver;
        if (z10 && z11) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) obj, (i) obj);
        }
        if (z11) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) obj, (i) null);
        }
        if (z10) {
            return (i) obj;
        }
        Class<?> cls = obj.getClass();
        q qVar = f6060a;
        if (qVar.d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List<Constructor<? extends e>> list = f6062c.get(cls);
        j.d(list);
        List list2 = list;
        if (list2.size() == 1) {
            return new SingleGeneratedAdapterObserver(qVar.a((Constructor) list2.get(0), obj));
        }
        int size = list2.size();
        e[] eVarArr = new e[size];
        for (int i10 = 0; i10 < size; i10++) {
            eVarArr[i10] = f6060a.a((Constructor) list2.get(i10), obj);
        }
        return new CompositeGeneratedAdaptersObserver(eVarArr);
    }

    private final int g(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends e> b10 = b(cls);
        if (b10 != null) {
            f6062c.put(cls, p.e(b10));
            return 2;
        } else if (b.f6001c.d(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (e(superclass)) {
                j.f(superclass, "superclass");
                if (d(superclass) == 1) {
                    return 1;
                }
                List<Constructor<? extends e>> list = f6062c.get(superclass);
                j.d(list);
                arrayList = new ArrayList(list);
            }
            Class[] interfaces = cls.getInterfaces();
            j.f(interfaces, "klass.interfaces");
            for (Class cls2 : interfaces) {
                if (e(cls2)) {
                    j.f(cls2, "intrface");
                    if (d(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    List<Constructor<? extends e>> list2 = f6062c.get(cls2);
                    j.d(list2);
                    arrayList.addAll(list2);
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f6062c.put(cls, arrayList);
            return 2;
        }
    }
}
