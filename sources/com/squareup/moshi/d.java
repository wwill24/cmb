package com.squareup.moshi;

import bi.c;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

final class d<T> extends h<T> {

    /* renamed from: d  reason: collision with root package name */
    public static final h.e f22946d = new a();

    /* renamed from: a  reason: collision with root package name */
    private final c<T> f22947a;

    /* renamed from: b  reason: collision with root package name */
    private final b<?>[] f22948b;

    /* renamed from: c  reason: collision with root package name */
    private final JsonReader.b f22949c;

    class a implements h.e {
        a() {
        }

        private void a(s sVar, Type type, Map<String, b<?>> map) {
            g gVar;
            Class<?> g10 = w.g(type);
            boolean j10 = c.j(g10);
            for (Field field : g10.getDeclaredFields()) {
                if (b(j10, field.getModifiers()) && ((gVar = (g) field.getAnnotation(g.class)) == null || !gVar.ignore())) {
                    Type q10 = c.q(type, g10, field.getGenericType());
                    Set<? extends Annotation> k10 = c.k(field);
                    String name = field.getName();
                    h<T> f10 = sVar.f(q10, k10, name);
                    field.setAccessible(true);
                    String m10 = c.m(name, gVar);
                    b bVar = new b(m10, field, f10);
                    b put = map.put(m10, bVar);
                    if (put != null) {
                        throw new IllegalArgumentException("Conflicting fields:\n    " + put.f22951b + "\n    " + bVar.f22951b);
                    }
                }
            }
        }

        private boolean b(boolean z10, int i10) {
            if (Modifier.isStatic(i10) || Modifier.isTransient(i10)) {
                return false;
            }
            if (Modifier.isPublic(i10) || Modifier.isProtected(i10) || !z10) {
                return true;
            }
            return false;
        }

        private void c(Type type, Class<?> cls) {
            Class<?> g10 = w.g(type);
            if (cls.isAssignableFrom(g10)) {
                throw new IllegalArgumentException("No JsonAdapter for " + type + ", you should probably use " + cls.getSimpleName() + " instead of " + g10.getSimpleName() + " (Moshi only supports the collection interfaces by default) or else register a custom JsonAdapter.");
            }
        }

        public h<?> create(Type type, Set<? extends Annotation> set, s sVar) {
            if (!(type instanceof Class) && !(type instanceof ParameterizedType)) {
                return null;
            }
            Class<?> g10 = w.g(type);
            if (g10.isInterface() || g10.isEnum() || !set.isEmpty()) {
                return null;
            }
            if (c.j(g10)) {
                c(type, List.class);
                c(type, Set.class);
                c(type, Map.class);
                c(type, Collection.class);
                String str = "Platform " + g10;
                if (type instanceof ParameterizedType) {
                    str = str + " in " + type;
                }
                throw new IllegalArgumentException(str + " requires explicit JsonAdapter to be registered");
            } else if (g10.isAnonymousClass()) {
                throw new IllegalArgumentException("Cannot serialize anonymous class " + g10.getName());
            } else if (g10.isLocalClass()) {
                throw new IllegalArgumentException("Cannot serialize local class " + g10.getName());
            } else if (g10.getEnclosingClass() != null && !Modifier.isStatic(g10.getModifiers())) {
                throw new IllegalArgumentException("Cannot serialize non-static nested class " + g10.getName());
            } else if (Modifier.isAbstract(g10.getModifiers())) {
                throw new IllegalArgumentException("Cannot serialize abstract class " + g10.getName());
            } else if (!c.i(g10)) {
                c<?> a10 = c.a(g10);
                TreeMap treeMap = new TreeMap();
                while (type != Object.class) {
                    a(sVar, type, treeMap);
                    type = w.f(type);
                }
                return new d(a10, treeMap).nullSafe();
            } else {
                throw new IllegalArgumentException("Cannot serialize Kotlin type " + g10.getName() + ". Reflective serialization of Kotlin classes without using kotlin-reflect has undefined and unexpected behavior. Please use KotlinJsonAdapterFactory from the moshi-kotlin artifact or use code gen from the moshi-kotlin-codegen artifact.");
            }
        }
    }

    static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        final String f22950a;

        /* renamed from: b  reason: collision with root package name */
        final Field f22951b;

        /* renamed from: c  reason: collision with root package name */
        final h<T> f22952c;

        b(String str, Field field, h<T> hVar) {
            this.f22950a = str;
            this.f22951b = field;
            this.f22952c = hVar;
        }

        /* access modifiers changed from: package-private */
        public void a(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
            this.f22951b.set(obj, this.f22952c.fromJson(jsonReader));
        }

        /* access modifiers changed from: package-private */
        public void b(q qVar, Object obj) throws IllegalAccessException, IOException {
            this.f22952c.toJson(qVar, this.f22951b.get(obj));
        }
    }

    d(c<T> cVar, Map<String, b<?>> map) {
        this.f22947a = cVar;
        this.f22948b = (b[]) map.values().toArray(new b[map.size()]);
        this.f22949c = JsonReader.b.a((String[]) map.keySet().toArray(new String[map.size()]));
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        try {
            T b10 = this.f22947a.b();
            try {
                jsonReader.b();
                while (jsonReader.g()) {
                    int L = jsonReader.L(this.f22949c);
                    if (L == -1) {
                        jsonReader.S();
                        jsonReader.Y();
                    } else {
                        this.f22948b[L].a(jsonReader, b10);
                    }
                }
                jsonReader.e();
                return b10;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        } catch (InstantiationException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw c.t(e11);
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    public void toJson(q qVar, T t10) throws IOException {
        try {
            qVar.c();
            for (b<?> bVar : this.f22948b) {
                qVar.u(bVar.f22950a);
                bVar.b(qVar, t10);
            }
            qVar.h();
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        }
    }

    public String toString() {
        return "JsonAdapter(" + this.f22947a + ")";
    }
}
