package com.google.gson.internal;

import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Type, com.google.gson.f<?>> f21328a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21329b;

    /* renamed from: c  reason: collision with root package name */
    private final List<ReflectionAccessFilter> f21330c;

    class a implements f<T> {
        a() {
        }

        public T a() {
            return new TreeSet();
        }
    }

    /* renamed from: com.google.gson.internal.b$b  reason: collision with other inner class name */
    class C0246b implements f<T> {
        C0246b() {
        }

        public T a() {
            return new LinkedHashSet();
        }
    }

    class c implements f<T> {
        c() {
        }

        public T a() {
            return new ArrayDeque();
        }
    }

    class d implements f<T> {
        d() {
        }

        public T a() {
            return new ArrayList();
        }
    }

    class e implements f<T> {
        e() {
        }

        public T a() {
            return new ConcurrentSkipListMap();
        }
    }

    class f implements f<T> {
        f() {
        }

        public T a() {
            return new ConcurrentHashMap();
        }
    }

    class g implements f<T> {
        g() {
        }

        public T a() {
            return new TreeMap();
        }
    }

    class h implements f<T> {
        h() {
        }

        public T a() {
            return new LinkedHashMap();
        }
    }

    class i implements f<T> {
        i() {
        }

        public T a() {
            return new LinkedTreeMap();
        }
    }

    class j implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f21331a;

        j(Class cls) {
            this.f21331a = cls;
        }

        public T a() {
            try {
                return k.f21370a.d(this.f21331a);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to create instance of " + this.f21331a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e10);
            }
        }
    }

    class k implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.gson.f f21333a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Type f21334b;

        k(com.google.gson.f fVar, Type type) {
            this.f21333a = fVar;
            this.f21334b = type;
        }

        public T a() {
            return this.f21333a.a(this.f21334b);
        }
    }

    class l implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f21336a;

        l(String str) {
            this.f21336a = str;
        }

        public T a() {
            throw new JsonIOException(this.f21336a);
        }
    }

    class m implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.gson.f f21338a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Type f21339b;

        m(com.google.gson.f fVar, Type type) {
            this.f21338a = fVar;
            this.f21339b = type;
        }

        public T a() {
            return this.f21338a.a(this.f21339b);
        }
    }

    class n implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f21341a;

        n(String str) {
            this.f21341a = str;
        }

        public T a() {
            throw new JsonIOException(this.f21341a);
        }
    }

    class o implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f21343a;

        o(String str) {
            this.f21343a = str;
        }

        public T a() {
            throw new JsonIOException(this.f21343a);
        }
    }

    class p implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f21345a;

        p(Type type) {
            this.f21345a = type;
        }

        public T a() {
            Type type = this.f21345a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.f21345a.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.f21345a.toString());
        }
    }

    class q implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f21346a;

        q(Type type) {
            this.f21346a = type;
        }

        public T a() {
            Type type = this.f21346a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return new EnumMap((Class) type2);
                }
                throw new JsonIOException("Invalid EnumMap type: " + this.f21346a.toString());
            }
            throw new JsonIOException("Invalid EnumMap type: " + this.f21346a.toString());
        }
    }

    class r implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f21347a;

        r(String str) {
            this.f21347a = str;
        }

        public T a() {
            throw new JsonIOException(this.f21347a);
        }
    }

    class s implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f21348a;

        s(String str) {
            this.f21348a = str;
        }

        public T a() {
            throw new JsonIOException(this.f21348a);
        }
    }

    class t implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Constructor f21349a;

        t(Constructor constructor) {
            this.f21349a = constructor;
        }

        public T a() {
            try {
                return this.f21349a.newInstance(new Object[0]);
            } catch (InstantiationException e10) {
                throw new RuntimeException("Failed to invoke constructor '" + og.a.c(this.f21349a) + "' with no args", e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + og.a.c(this.f21349a) + "' with no args", e11.getCause());
            } catch (IllegalAccessException e12) {
                throw og.a.e(e12);
            }
        }
    }

    public b(Map<Type, com.google.gson.f<?>> map, boolean z10, List<ReflectionAccessFilter> list) {
        this.f21328a = map;
        this.f21329b = z10;
        this.f21330c = list;
    }

    static String a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        } else if (!Modifier.isAbstract(modifiers)) {
            return null;
        } else {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
        }
    }

    private static <T> f<T> c(Class<? super T> cls, ReflectionAccessFilter.FilterResult filterResult) {
        String m10;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        boolean z10 = false;
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            ReflectionAccessFilter.FilterResult filterResult2 = ReflectionAccessFilter.FilterResult.ALLOW;
            if (filterResult == filterResult2 || (i.a(declaredConstructor, (Object) null) && (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                z10 = true;
            }
            if (!z10) {
                return new r("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
            } else if (filterResult != filterResult2 || (m10 = og.a.m(declaredConstructor)) == null) {
                return new t(declaredConstructor);
            } else {
                return new s(m10);
            }
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static <T> f<T> d(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new C0246b();
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new c();
            }
            return new d();
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new e();
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new f();
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new g();
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(qg.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) {
                return new i();
            }
            return new h();
        }
    }

    private static <T> f<T> e(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new p(type);
        }
        if (cls == EnumMap.class) {
            return new q(type);
        }
        return null;
    }

    private <T> f<T> f(Class<? super T> cls) {
        if (this.f21329b) {
            return new j(cls);
        }
        return new l("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public <T> f<T> b(qg.a<T> aVar) {
        Type d10 = aVar.d();
        Class<? super T> c10 = aVar.c();
        com.google.gson.f fVar = this.f21328a.get(d10);
        if (fVar != null) {
            return new k(fVar, d10);
        }
        com.google.gson.f fVar2 = this.f21328a.get(c10);
        if (fVar2 != null) {
            return new m(fVar2, d10);
        }
        f<T> e10 = e(d10, c10);
        if (e10 != null) {
            return e10;
        }
        ReflectionAccessFilter.FilterResult b10 = i.b(this.f21330c, c10);
        f<T> c11 = c(c10, b10);
        if (c11 != null) {
            return c11;
        }
        f<T> d11 = d(d10, c10);
        if (d11 != null) {
            return d11;
        }
        String a10 = a(c10);
        if (a10 != null) {
            return new n(a10);
        }
        if (b10 == ReflectionAccessFilter.FilterResult.ALLOW) {
            return f(c10);
        }
        return new o("Unable to create instance of " + c10 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    public String toString() {
        return this.f21328a.toString();
    }
}
