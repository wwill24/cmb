package mg;

import com.google.gson.JsonSyntaxException;
import com.google.gson.d;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.b;
import com.google.gson.internal.e;
import com.google.gson.internal.f;
import com.google.gson.j;
import com.google.gson.m;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class h implements r {

    /* renamed from: a  reason: collision with root package name */
    private final b f23682a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f23683b;

    private final class a<K, V> extends q<Map<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private final q<K> f23684a;

        /* renamed from: b  reason: collision with root package name */
        private final q<V> f23685b;

        /* renamed from: c  reason: collision with root package name */
        private final f<? extends Map<K, V>> f23686c;

        public a(d dVar, Type type, q<K> qVar, Type type2, q<V> qVar2, f<? extends Map<K, V>> fVar) {
            this.f23684a = new n(dVar, qVar, type);
            this.f23685b = new n(dVar, qVar2, type2);
            this.f23686c = fVar;
        }

        private String e(j jVar) {
            if (jVar.m()) {
                m f10 = jVar.f();
                if (f10.v()) {
                    return String.valueOf(f10.r());
                }
                if (f10.t()) {
                    return Boolean.toString(f10.n());
                }
                if (f10.w()) {
                    return f10.s();
                }
                throw new AssertionError();
            } else if (jVar.i()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        /* renamed from: f */
        public Map<K, V> b(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map<K, V> map = (Map) this.f23686c.a();
            if (peek == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    K b10 = this.f23684a.b(jsonReader);
                    if (map.put(b10, this.f23685b.b(jsonReader)) == null) {
                        jsonReader.endArray();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + b10);
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    e.INSTANCE.promoteNameToValue(jsonReader);
                    K b11 = this.f23684a.b(jsonReader);
                    if (map.put(b11, this.f23685b.b(jsonReader)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b11);
                    }
                }
                jsonReader.endObject();
            }
            return map;
        }

        /* renamed from: g */
        public void d(JsonWriter jsonWriter, Map<K, V> map) throws IOException {
            boolean z10;
            if (map == null) {
                jsonWriter.nullValue();
            } else if (!h.this.f23683b) {
                jsonWriter.beginObject();
                for (Map.Entry next : map.entrySet()) {
                    jsonWriter.name(String.valueOf(next.getKey()));
                    this.f23685b.d(jsonWriter, next.getValue());
                }
                jsonWriter.endObject();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i10 = 0;
                boolean z11 = false;
                for (Map.Entry next2 : map.entrySet()) {
                    j c10 = this.f23684a.c(next2.getKey());
                    arrayList.add(c10);
                    arrayList2.add(next2.getValue());
                    if (c10.g() || c10.j()) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 |= z10;
                }
                if (z11) {
                    jsonWriter.beginArray();
                    int size = arrayList.size();
                    while (i10 < size) {
                        jsonWriter.beginArray();
                        com.google.gson.internal.j.b((j) arrayList.get(i10), jsonWriter);
                        this.f23685b.d(jsonWriter, arrayList2.get(i10));
                        jsonWriter.endArray();
                        i10++;
                    }
                    jsonWriter.endArray();
                    return;
                }
                jsonWriter.beginObject();
                int size2 = arrayList.size();
                while (i10 < size2) {
                    jsonWriter.name(e((j) arrayList.get(i10)));
                    this.f23685b.d(jsonWriter, arrayList2.get(i10));
                    i10++;
                }
                jsonWriter.endObject();
            }
        }
    }

    public h(b bVar, boolean z10) {
        this.f23682a = bVar;
        this.f23683b = z10;
    }

    private q<?> b(d dVar, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return o.f23739f;
        }
        return dVar.o(qg.a.b(type));
    }

    public <T> q<T> a(d dVar, qg.a<T> aVar) {
        Type d10 = aVar.d();
        Class<? super T> c10 = aVar.c();
        if (!Map.class.isAssignableFrom(c10)) {
            return null;
        }
        Type[] j10 = C$Gson$Types.j(d10, c10);
        return new a(dVar, j10[0], b(dVar, j10[0]), j10[1], dVar.o(qg.a.b(j10[1])), this.f23682a.b(aVar));
    }
}
