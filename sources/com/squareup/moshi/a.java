package com.squareup.moshi;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

final class a implements h.e {

    /* renamed from: a  reason: collision with root package name */
    private final List<f> f22907a;

    /* renamed from: b  reason: collision with root package name */
    private final List<f> f22908b;

    /* renamed from: com.squareup.moshi.a$a  reason: collision with other inner class name */
    class C0264a extends h<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f22909a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f22910b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ s f22911c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ f f22912d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Set f22913e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Type f22914f;

        C0264a(f fVar, h hVar, s sVar, f fVar2, Set set, Type type) {
            this.f22909a = fVar;
            this.f22910b = hVar;
            this.f22911c = sVar;
            this.f22912d = fVar2;
            this.f22913e = set;
            this.f22914f = type;
        }

        public Object fromJson(JsonReader jsonReader) throws IOException {
            f fVar = this.f22912d;
            if (fVar == null) {
                return this.f22910b.fromJson(jsonReader);
            }
            if (fVar.f22932g || jsonReader.E() != JsonReader.Token.NULL) {
                try {
                    return this.f22912d.b(this.f22911c, jsonReader);
                } catch (InvocationTargetException e10) {
                    Throwable cause = e10.getCause();
                    if (cause instanceof IOException) {
                        throw ((IOException) cause);
                    }
                    throw new JsonDataException(cause + " at " + jsonReader.getPath(), cause);
                }
            } else {
                jsonReader.v();
                return null;
            }
        }

        public void toJson(q qVar, Object obj) throws IOException {
            f fVar = this.f22909a;
            if (fVar == null) {
                this.f22910b.toJson(qVar, obj);
            } else if (fVar.f22932g || obj != null) {
                try {
                    fVar.e(this.f22911c, qVar, obj);
                } catch (InvocationTargetException e10) {
                    Throwable cause = e10.getCause();
                    if (cause instanceof IOException) {
                        throw ((IOException) cause);
                    }
                    throw new JsonDataException(cause + " at " + qVar.getPath(), cause);
                }
            } else {
                qVar.v();
            }
        }

        public String toString() {
            return "JsonAdapter" + this.f22913e + "(" + this.f22914f + ")";
        }
    }

    class b extends f {
        b(Type type, Set set, Object obj, Method method, int i10, int i11, boolean z10) {
            super(type, set, obj, method, i10, i11, z10);
        }

        public void e(s sVar, q qVar, Object obj) throws IOException, InvocationTargetException {
            d(qVar, obj);
        }
    }

    class c extends f {

        /* renamed from: h  reason: collision with root package name */
        private h<Object> f22916h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ Type[] f22917i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Type f22918j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ Set f22919k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ Set f22920l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Type type, Set set, Object obj, Method method, int i10, int i11, boolean z10, Type[] typeArr, Type type2, Set set2, Set set3) {
            super(type, set, obj, method, i10, i11, z10);
            this.f22917i = typeArr;
            this.f22918j = type2;
            this.f22919k = set2;
            this.f22920l = set3;
        }

        public void a(s sVar, h.e eVar) {
            h<Object> hVar;
            super.a(sVar, eVar);
            if (!w.d(this.f22917i[0], this.f22918j) || !this.f22919k.equals(this.f22920l)) {
                hVar = sVar.e(this.f22918j, this.f22920l);
            } else {
                hVar = sVar.i(eVar, this.f22918j, this.f22920l);
            }
            this.f22916h = hVar;
        }

        public void e(s sVar, q qVar, Object obj) throws IOException, InvocationTargetException {
            this.f22916h.toJson(qVar, c(obj));
        }
    }

    class d extends f {
        d(Type type, Set set, Object obj, Method method, int i10, int i11, boolean z10) {
            super(type, set, obj, method, i10, i11, z10);
        }

        public Object b(s sVar, JsonReader jsonReader) throws IOException, InvocationTargetException {
            return c(jsonReader);
        }
    }

    class e extends f {

        /* renamed from: h  reason: collision with root package name */
        h<Object> f22921h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ Type[] f22922i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Type f22923j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ Set f22924k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ Set f22925l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Type type, Set set, Object obj, Method method, int i10, int i11, boolean z10, Type[] typeArr, Type type2, Set set2, Set set3) {
            super(type, set, obj, method, i10, i11, z10);
            this.f22922i = typeArr;
            this.f22923j = type2;
            this.f22924k = set2;
            this.f22925l = set3;
        }

        public void a(s sVar, h.e eVar) {
            h<Object> hVar;
            super.a(sVar, eVar);
            if (!w.d(this.f22922i[0], this.f22923j) || !this.f22924k.equals(this.f22925l)) {
                hVar = sVar.e(this.f22922i[0], this.f22924k);
            } else {
                hVar = sVar.i(eVar, this.f22922i[0], this.f22924k);
            }
            this.f22921h = hVar;
        }

        public Object b(s sVar, JsonReader jsonReader) throws IOException, InvocationTargetException {
            return c(this.f22921h.fromJson(jsonReader));
        }
    }

    static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        final Type f22926a;

        /* renamed from: b  reason: collision with root package name */
        final Set<? extends Annotation> f22927b;

        /* renamed from: c  reason: collision with root package name */
        final Object f22928c;

        /* renamed from: d  reason: collision with root package name */
        final Method f22929d;

        /* renamed from: e  reason: collision with root package name */
        final int f22930e;

        /* renamed from: f  reason: collision with root package name */
        final h<?>[] f22931f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f22932g;

        f(Type type, Set<? extends Annotation> set, Object obj, Method method, int i10, int i11, boolean z10) {
            this.f22926a = bi.c.a(type);
            this.f22927b = set;
            this.f22928c = obj;
            this.f22929d = method;
            this.f22930e = i11;
            this.f22931f = new h[(i10 - i11)];
            this.f22932g = z10;
        }

        public void a(s sVar, h.e eVar) {
            h<?> hVar;
            if (this.f22931f.length > 0) {
                Type[] genericParameterTypes = this.f22929d.getGenericParameterTypes();
                Annotation[][] parameterAnnotations = this.f22929d.getParameterAnnotations();
                int length = genericParameterTypes.length;
                for (int i10 = this.f22930e; i10 < length; i10++) {
                    Type type = ((ParameterizedType) genericParameterTypes[i10]).getActualTypeArguments()[0];
                    Set<? extends Annotation> l10 = bi.c.l(parameterAnnotations[i10]);
                    h<?>[] hVarArr = this.f22931f;
                    int i11 = i10 - this.f22930e;
                    if (!w.d(this.f22926a, type) || !this.f22927b.equals(l10)) {
                        hVar = sVar.e(type, l10);
                    } else {
                        hVar = sVar.i(eVar, type, l10);
                    }
                    hVarArr[i11] = hVar;
                }
            }
        }

        public Object b(s sVar, JsonReader jsonReader) throws IOException, InvocationTargetException {
            throw new AssertionError();
        }

        /* access modifiers changed from: protected */
        public Object c(Object obj) throws InvocationTargetException {
            h<?>[] hVarArr = this.f22931f;
            Object[] objArr = new Object[(hVarArr.length + 1)];
            objArr[0] = obj;
            System.arraycopy(hVarArr, 0, objArr, 1, hVarArr.length);
            try {
                return this.f22929d.invoke(this.f22928c, objArr);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: protected */
        public Object d(Object obj, Object obj2) throws InvocationTargetException {
            h<?>[] hVarArr = this.f22931f;
            Object[] objArr = new Object[(hVarArr.length + 2)];
            objArr[0] = obj;
            objArr[1] = obj2;
            System.arraycopy(hVarArr, 0, objArr, 2, hVarArr.length);
            try {
                return this.f22929d.invoke(this.f22928c, objArr);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }

        public void e(s sVar, q qVar, Object obj) throws IOException, InvocationTargetException {
            throw new AssertionError();
        }
    }

    a(List<f> list, List<f> list2) {
        this.f22907a = list;
        this.f22908b = list2;
    }

    static f a(Object obj, Method method) {
        method.setAccessible(true);
        Type genericReturnType = method.getGenericReturnType();
        Set<? extends Annotation> k10 = bi.c.k(method);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (genericParameterTypes.length >= 1 && genericParameterTypes[0] == JsonReader.class && genericReturnType != Void.TYPE && d(1, genericParameterTypes)) {
            return new d(genericReturnType, k10, obj, method, genericParameterTypes.length, 1, true);
        } else if (genericParameterTypes.length != 1 || genericReturnType == Void.TYPE) {
            throw new IllegalArgumentException("Unexpected signature for " + method + ".\n@FromJson method signatures may have one of the following structures:\n    <any access modifier> R fromJson(JsonReader jsonReader) throws <any>;\n    <any access modifier> R fromJson(JsonReader jsonReader, JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> R fromJson(T value) throws <any>;\n");
        } else {
            Set<? extends Annotation> l10 = bi.c.l(parameterAnnotations[0]);
            return new e(genericReturnType, k10, obj, method, genericParameterTypes.length, 1, bi.c.f(parameterAnnotations[0]), genericParameterTypes, genericReturnType, l10, k10);
        }
    }

    private static f b(List<f> list, Type type, Set<? extends Annotation> set) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            f fVar = list.get(i10);
            if (w.d(fVar.f22926a, type) && fVar.f22927b.equals(set)) {
                return fVar;
            }
        }
        return null;
    }

    public static a c(Object obj) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Class cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(v.class)) {
                    f e10 = e(obj, method);
                    f b10 = b(arrayList, e10.f22926a, e10.f22927b);
                    if (b10 == null) {
                        arrayList.add(e10);
                    } else {
                        throw new IllegalArgumentException("Conflicting @ToJson methods:\n    " + b10.f22929d + "\n    " + e10.f22929d);
                    }
                }
                if (method.isAnnotationPresent(f.class)) {
                    f a10 = a(obj, method);
                    f b11 = b(arrayList2, a10.f22926a, a10.f22927b);
                    if (b11 == null) {
                        arrayList2.add(a10);
                    } else {
                        throw new IllegalArgumentException("Conflicting @FromJson methods:\n    " + b11.f22929d + "\n    " + a10.f22929d);
                    }
                }
            }
        }
        if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
            return new a(arrayList, arrayList2);
        }
        throw new IllegalArgumentException("Expected at least one @ToJson or @FromJson method on " + obj.getClass().getName());
    }

    private static boolean d(int i10, Type[] typeArr) {
        int length = typeArr.length;
        while (i10 < length) {
            ParameterizedType parameterizedType = typeArr[i10];
            if (!(parameterizedType instanceof ParameterizedType) || parameterizedType.getRawType() != h.class) {
                return false;
            }
            i10++;
        }
        return true;
    }

    static f e(Object obj, Method method) {
        method.setAccessible(true);
        Type genericReturnType = method.getGenericReturnType();
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (genericParameterTypes.length >= 2 && genericParameterTypes[0] == q.class && genericReturnType == Void.TYPE && d(2, genericParameterTypes)) {
            return new b(genericParameterTypes[1], bi.c.l(parameterAnnotations[1]), obj, method, genericParameterTypes.length, 2, true);
        } else if (genericParameterTypes.length != 1 || genericReturnType == Void.TYPE) {
            throw new IllegalArgumentException("Unexpected signature for " + method + ".\n@ToJson method signatures may have one of the following structures:\n    <any access modifier> void toJson(JsonWriter writer, T value) throws <any>;\n    <any access modifier> void toJson(JsonWriter writer, T value, JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> R toJson(T value) throws <any>;\n");
        } else {
            Set<? extends Annotation> k10 = bi.c.k(method);
            Set<? extends Annotation> l10 = bi.c.l(parameterAnnotations[0]);
            return new c(genericParameterTypes[0], l10, obj, method, genericParameterTypes.length, 1, bi.c.f(parameterAnnotations[0]), genericParameterTypes, genericReturnType, l10, k10);
        }
    }

    public h<?> create(Type type, Set<? extends Annotation> set, s sVar) {
        String str;
        f b10 = b(this.f22907a, type, set);
        f b11 = b(this.f22908b, type, set);
        h<T> hVar = null;
        if (b10 == null && b11 == null) {
            return null;
        }
        if (b10 == null || b11 == null) {
            try {
                hVar = sVar.i(this, type, set);
            } catch (IllegalArgumentException e10) {
                if (b10 == null) {
                    str = "@ToJson";
                } else {
                    str = "@FromJson";
                }
                throw new IllegalArgumentException("No " + str + " adapter for " + bi.c.u(type, set), e10);
            }
        }
        h<T> hVar2 = hVar;
        if (b10 != null) {
            b10.a(sVar, this);
        }
        if (b11 != null) {
            b11.a(sVar, this);
        }
        return new C0264a(b10, hVar2, sVar, b11, set, type);
    }
}
