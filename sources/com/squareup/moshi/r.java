package com.squareup.moshi;

import com.squareup.moshi.h;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

final class r<K, V> extends h<Map<K, V>> {

    /* renamed from: c  reason: collision with root package name */
    public static final h.e f23009c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final h<K> f23010a;

    /* renamed from: b  reason: collision with root package name */
    private final h<V> f23011b;

    class a implements h.e {
        a() {
        }

        public h<?> create(Type type, Set<? extends Annotation> set, s sVar) {
            Class<?> g10;
            if (!set.isEmpty() || (g10 = w.g(type)) != Map.class) {
                return null;
            }
            Type[] i10 = w.i(type, g10);
            return new r(sVar, i10[0], i10[1]).nullSafe();
        }
    }

    r(s sVar, Type type, Type type2) {
        this.f23010a = sVar.d(type);
        this.f23011b = sVar.d(type2);
    }

    /* renamed from: a */
    public Map<K, V> fromJson(JsonReader jsonReader) throws IOException {
        LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
        jsonReader.b();
        while (jsonReader.g()) {
            jsonReader.G();
            K fromJson = this.f23010a.fromJson(jsonReader);
            V fromJson2 = this.f23011b.fromJson(jsonReader);
            Object put = linkedHashTreeMap.put(fromJson, fromJson2);
            if (put != null) {
                throw new JsonDataException("Map key '" + fromJson + "' has multiple values at path " + jsonReader.getPath() + ": " + put + " and " + fromJson2);
            }
        }
        jsonReader.e();
        return linkedHashTreeMap;
    }

    /* renamed from: b */
    public void toJson(q qVar, Map<K, V> map) throws IOException {
        qVar.c();
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() != null) {
                qVar.C();
                this.f23010a.toJson(qVar, next.getKey());
                this.f23011b.toJson(qVar, next.getValue());
            } else {
                throw new JsonDataException("Map key is null at " + qVar.getPath());
            }
        }
        qVar.h();
    }

    public String toString() {
        return "JsonAdapter(" + this.f23010a + "=" + this.f23011b + ")";
    }
}
