package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
final class b {

    /* renamed from: c  reason: collision with root package name */
    static b f6001c = new b();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, a> f6002a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Boolean> f6003b = new HashMap();

    @Deprecated
    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Map<Lifecycle.Event, List<C0061b>> f6004a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<C0061b, Lifecycle.Event> f6005b;

        a(Map<C0061b, Lifecycle.Event> map) {
            this.f6005b = map;
            for (Map.Entry next : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) next.getValue();
                List list = this.f6004a.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.f6004a.put(event, list);
                }
                list.add((C0061b) next.getKey());
            }
        }

        private static void b(List<C0061b> list, l lVar, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(lVar, event, obj);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, Lifecycle.Event event, Object obj) {
            b(this.f6004a.get(event), lVar, event, obj);
            b(this.f6004a.get(Lifecycle.Event.ON_ANY), lVar, event, obj);
        }
    }

    @Deprecated
    /* renamed from: androidx.lifecycle.b$b  reason: collision with other inner class name */
    static final class C0061b {

        /* renamed from: a  reason: collision with root package name */
        final int f6006a;

        /* renamed from: b  reason: collision with root package name */
        final Method f6007b;

        C0061b(int i10, Method method) {
            this.f6006a = i10;
            this.f6007b = method;
            method.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, Lifecycle.Event event, Object obj) {
            try {
                int i10 = this.f6006a;
                if (i10 == 0) {
                    this.f6007b.invoke(obj, new Object[0]);
                } else if (i10 == 1) {
                    this.f6007b.invoke(obj, new Object[]{lVar});
                } else if (i10 == 2) {
                    this.f6007b.invoke(obj, new Object[]{lVar, event});
                }
            } catch (InvocationTargetException e10) {
                throw new RuntimeException("Failed to call observer method", e10.getCause());
            } catch (IllegalAccessException e11) {
                throw new RuntimeException(e11);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0061b)) {
                return false;
            }
            C0061b bVar = (C0061b) obj;
            if (this.f6006a != bVar.f6006a || !this.f6007b.getName().equals(bVar.f6007b.getName())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f6006a * 31) + this.f6007b.getName().hashCode();
        }
    }

    b() {
    }

    private a a(Class<?> cls, Method[] methodArr) {
        int i10;
        a c10;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (c10 = c(superclass)) == null)) {
            hashMap.putAll(c10.f6005b);
        }
        for (Class c11 : cls.getInterfaces()) {
            for (Map.Entry next : c(c11).f6005b.entrySet()) {
                e(hashMap, (C0061b) next.getKey(), (Lifecycle.Event) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            v vVar = (v) method.getAnnotation(v.class);
            if (vVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i10 = 0;
                } else if (l.class.isAssignableFrom(parameterTypes[0])) {
                    i10 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Lifecycle.Event value = vVar.value();
                if (parameterTypes.length > 1) {
                    if (!Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == Lifecycle.Event.ON_ANY) {
                        i10 = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    e(hashMap, new C0061b(i10, method), value, cls);
                    z10 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.f6002a.put(cls, aVar);
        this.f6003b.put(cls, Boolean.valueOf(z10));
        return aVar;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
        }
    }

    private void e(Map<C0061b, Lifecycle.Event> map, C0061b bVar, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(bVar);
        if (event2 != null && event != event2) {
            Method method = bVar.f6007b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(bVar, event);
        }
    }

    /* access modifiers changed from: package-private */
    public a c(Class<?> cls) {
        a aVar = this.f6002a.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return a(cls, (Method[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean d(Class<?> cls) {
        Boolean bool = this.f6003b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b10 = b(cls);
        for (Method annotation : b10) {
            if (((v) annotation.getAnnotation(v.class)) != null) {
                a(cls, b10);
                return true;
            }
        }
        this.f6003b.put(cls, Boolean.FALSE);
        return false;
    }
}
