package com.squareup.moshi;

import com.squareup.moshi.h;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

final class b extends h<Object> {

    /* renamed from: c  reason: collision with root package name */
    public static final h.e f22933c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f22934a;

    /* renamed from: b  reason: collision with root package name */
    private final h<Object> f22935b;

    class a implements h.e {
        a() {
        }

        public h<?> create(Type type, Set<? extends Annotation> set, s sVar) {
            Type a10 = w.a(type);
            if (a10 != null && set.isEmpty()) {
                return new b(w.g(a10), sVar.d(a10)).nullSafe();
            }
            return null;
        }
    }

    b(Class<?> cls, h<Object> hVar) {
        this.f22934a = cls;
        this.f22935b = hVar;
    }

    public Object fromJson(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.a();
        while (jsonReader.g()) {
            arrayList.add(this.f22935b.fromJson(jsonReader));
        }
        jsonReader.c();
        Object newInstance = Array.newInstance(this.f22934a, arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            Array.set(newInstance, i10, arrayList.get(i10));
        }
        return newInstance;
    }

    public void toJson(q qVar, Object obj) throws IOException {
        qVar.a();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f22935b.toJson(qVar, Array.get(obj, i10));
        }
        qVar.f();
    }

    public String toString() {
        return this.f22935b + ".array()";
    }
}
