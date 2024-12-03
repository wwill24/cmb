package ai;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class b<T> implements h.e {

    /* renamed from: a  reason: collision with root package name */
    final Class<T> f18857a;

    /* renamed from: b  reason: collision with root package name */
    final String f18858b;

    /* renamed from: c  reason: collision with root package name */
    final List<String> f18859c;

    /* renamed from: d  reason: collision with root package name */
    final List<Type> f18860d;

    /* renamed from: e  reason: collision with root package name */
    final h<Object> f18861e;

    class a extends h<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f18862a;

        a(Object obj) {
            this.f18862a = obj;
        }

        public Object fromJson(JsonReader jsonReader) throws IOException {
            jsonReader.Y();
            return this.f18862a;
        }

        public void toJson(q qVar, Object obj) throws IOException {
            throw new IllegalArgumentException("Expected one of " + b.this.f18860d + " but found " + obj + ", a " + obj.getClass() + ". Register this subtype.");
        }
    }

    /* renamed from: ai.b$b  reason: collision with other inner class name */
    static final class C0227b extends h<Object> {

        /* renamed from: a  reason: collision with root package name */
        final String f18864a;

        /* renamed from: b  reason: collision with root package name */
        final List<String> f18865b;

        /* renamed from: c  reason: collision with root package name */
        final List<Type> f18866c;

        /* renamed from: d  reason: collision with root package name */
        final List<h<Object>> f18867d;

        /* renamed from: e  reason: collision with root package name */
        final h<Object> f18868e;

        /* renamed from: f  reason: collision with root package name */
        final JsonReader.b f18869f;

        /* renamed from: g  reason: collision with root package name */
        final JsonReader.b f18870g;

        C0227b(String str, List<String> list, List<Type> list2, List<h<Object>> list3, h<Object> hVar) {
            this.f18864a = str;
            this.f18865b = list;
            this.f18866c = list2;
            this.f18867d = list3;
            this.f18868e = hVar;
            this.f18869f = JsonReader.b.a(str);
            this.f18870g = JsonReader.b.a((String[]) list.toArray(new String[0]));
        }

        private int a(JsonReader jsonReader) throws IOException {
            jsonReader.b();
            while (jsonReader.g()) {
                if (jsonReader.L(this.f18869f) == -1) {
                    jsonReader.S();
                    jsonReader.Y();
                } else {
                    int N = jsonReader.N(this.f18870g);
                    if (N != -1 || this.f18868e != null) {
                        return N;
                    }
                    throw new JsonDataException("Expected one of " + this.f18865b + " for key '" + this.f18864a + "' but found '" + jsonReader.y() + "'. Register a subtype for this label.");
                }
            }
            throw new JsonDataException("Missing label for " + this.f18864a);
        }

        /* JADX INFO: finally extract failed */
        public Object fromJson(JsonReader jsonReader) throws IOException {
            JsonReader F = jsonReader.F();
            F.O(false);
            try {
                int a10 = a(F);
                F.close();
                if (a10 == -1) {
                    return this.f18868e.fromJson(jsonReader);
                }
                return this.f18867d.get(a10).fromJson(jsonReader);
            } catch (Throwable th2) {
                F.close();
                throw th2;
            }
        }

        public void toJson(q qVar, Object obj) throws IOException {
            h<Object> hVar;
            int indexOf = this.f18866c.indexOf(obj.getClass());
            if (indexOf == -1) {
                hVar = this.f18868e;
                if (hVar == null) {
                    throw new IllegalArgumentException("Expected one of " + this.f18866c + " but found " + obj + ", a " + obj.getClass() + ". Register this subtype.");
                }
            } else {
                hVar = this.f18867d.get(indexOf);
            }
            qVar.c();
            if (hVar != this.f18868e) {
                qVar.u(this.f18864a).S(this.f18865b.get(indexOf));
            }
            int b10 = qVar.b();
            hVar.toJson(qVar, obj);
            qVar.g(b10);
            qVar.h();
        }

        public String toString() {
            return "PolymorphicJsonAdapter(" + this.f18864a + ")";
        }
    }

    b(Class<T> cls, String str, List<String> list, List<Type> list2, h<Object> hVar) {
        this.f18857a = cls;
        this.f18858b = str;
        this.f18859c = list;
        this.f18860d = list2;
        this.f18861e = hVar;
    }

    private h<Object> a(T t10) {
        return new a(t10);
    }

    public static <T> b<T> b(Class<T> cls, String str) {
        if (cls == null) {
            throw new NullPointerException("baseType == null");
        } else if (str != null) {
            return new b(cls, str, Collections.emptyList(), Collections.emptyList(), (h<Object>) null);
        } else {
            throw new NullPointerException("labelKey == null");
        }
    }

    public b<T> c(T t10) {
        return d(a(t10));
    }

    public h<?> create(Type type, Set<? extends Annotation> set, s sVar) {
        if (w.g(type) != this.f18857a || !set.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f18860d.size());
        int size = this.f18860d.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(sVar.d(this.f18860d.get(i10)));
        }
        return new C0227b(this.f18858b, this.f18859c, this.f18860d, arrayList, this.f18861e).nullSafe();
    }

    public b<T> d(h<Object> hVar) {
        return new b(this.f18857a, this.f18858b, this.f18859c, this.f18860d, hVar);
    }

    public b<T> e(Class<? extends T> cls, String str) {
        if (cls == null) {
            throw new NullPointerException("subtype == null");
        } else if (str == null) {
            throw new NullPointerException("label == null");
        } else if (!this.f18859c.contains(str)) {
            ArrayList arrayList = new ArrayList(this.f18859c);
            arrayList.add(str);
            ArrayList arrayList2 = new ArrayList(this.f18860d);
            arrayList2.add(cls);
            return new b(this.f18857a, this.f18858b, arrayList, arrayList2, this.f18861e);
        } else {
            throw new IllegalArgumentException("Labels must be unique.");
        }
    }
}
