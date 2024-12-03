package com.squareup.moshi;

import com.squareup.moshi.h;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

abstract class e<C extends Collection<T>, T> extends h<C> {

    /* renamed from: b  reason: collision with root package name */
    public static final h.e f22953b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final h<T> f22954a;

    class a implements h.e {
        a() {
        }

        public h<?> create(Type type, Set<? extends Annotation> set, s sVar) {
            Class<?> g10 = w.g(type);
            if (!set.isEmpty()) {
                return null;
            }
            if (g10 == List.class || g10 == Collection.class) {
                return e.b(type, sVar).nullSafe();
            }
            if (g10 == Set.class) {
                return e.d(type, sVar).nullSafe();
            }
            return null;
        }
    }

    class b extends e<Collection<T>, T> {
        b(h hVar) {
            super(hVar, (a) null);
        }

        /* access modifiers changed from: package-private */
        public Collection<T> c() {
            return new ArrayList();
        }

        public /* bridge */ /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
            return e.super.a(jsonReader);
        }

        public /* bridge */ /* synthetic */ void toJson(q qVar, Object obj) throws IOException {
            e.super.e(qVar, (Collection) obj);
        }
    }

    class c extends e<Set<T>, T> {
        c(h hVar) {
            super(hVar, (a) null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public Set<T> c() {
            return new LinkedHashSet();
        }

        public /* bridge */ /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
            return e.super.a(jsonReader);
        }

        public /* bridge */ /* synthetic */ void toJson(q qVar, Object obj) throws IOException {
            e.super.e(qVar, (Collection) obj);
        }
    }

    /* synthetic */ e(h hVar, a aVar) {
        this(hVar);
    }

    static <T> h<Collection<T>> b(Type type, s sVar) {
        return new b(sVar.d(w.c(type, Collection.class)));
    }

    static <T> h<Set<T>> d(Type type, s sVar) {
        return new c(sVar.d(w.c(type, Collection.class)));
    }

    public C a(JsonReader jsonReader) throws IOException {
        C c10 = c();
        jsonReader.a();
        while (jsonReader.g()) {
            c10.add(this.f22954a.fromJson(jsonReader));
        }
        jsonReader.c();
        return c10;
    }

    /* access modifiers changed from: package-private */
    public abstract C c();

    public void e(q qVar, C c10) throws IOException {
        qVar.a();
        for (Object json : c10) {
            this.f22954a.toJson(qVar, json);
        }
        qVar.f();
    }

    public String toString() {
        return this.f22954a + ".collection()";
    }

    private e(h<T> hVar) {
        this.f22954a = hVar;
    }
}
