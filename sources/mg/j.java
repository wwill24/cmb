package mg;

import com.google.gson.ToNumberPolicy;
import com.google.gson.d;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class j extends q<Object> {

    /* renamed from: c  reason: collision with root package name */
    private static final r f23692c = f(ToNumberPolicy.DOUBLE);

    /* renamed from: a  reason: collision with root package name */
    private final d f23693a;

    /* renamed from: b  reason: collision with root package name */
    private final p f23694b;

    class a implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f23695a;

        a(p pVar) {
            this.f23695a = pVar;
        }

        public <T> q<T> a(d dVar, qg.a<T> aVar) {
            if (aVar.c() == Object.class) {
                return new j(dVar, this.f23695a, (a) null);
            }
            return null;
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23696a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.gson.stream.JsonToken[] r0 = com.google.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23696a = r0
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23696a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23696a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23696a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f23696a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f23696a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: mg.j.b.<clinit>():void");
        }
    }

    /* synthetic */ j(d dVar, p pVar, a aVar) {
        this(dVar, pVar);
    }

    public static r e(p pVar) {
        if (pVar == ToNumberPolicy.DOUBLE) {
            return f23692c;
        }
        return f(pVar);
    }

    private static r f(p pVar) {
        return new a(pVar);
    }

    private Object g(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i10 = b.f23696a[jsonToken.ordinal()];
        if (i10 == 3) {
            return jsonReader.nextString();
        }
        if (i10 == 4) {
            return this.f23694b.a(jsonReader);
        }
        if (i10 == 5) {
            return Boolean.valueOf(jsonReader.nextBoolean());
        }
        if (i10 == 6) {
            jsonReader.nextNull();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + jsonToken);
    }

    private Object h(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i10 = b.f23696a[jsonToken.ordinal()];
        if (i10 == 1) {
            jsonReader.beginArray();
            return new ArrayList();
        } else if (i10 != 2) {
            return null;
        } else {
            jsonReader.beginObject();
            return new LinkedTreeMap();
        }
    }

    public Object b(JsonReader jsonReader) throws IOException {
        boolean z10;
        JsonToken peek = jsonReader.peek();
        Object h10 = h(jsonReader, peek);
        if (h10 == null) {
            return g(jsonReader, peek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (jsonReader.hasNext()) {
                String str = null;
                if (h10 instanceof Map) {
                    str = jsonReader.nextName();
                }
                JsonToken peek2 = jsonReader.peek();
                Object h11 = h(jsonReader, peek2);
                if (h11 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (h11 == null) {
                    h11 = g(jsonReader, peek2);
                }
                if (h10 instanceof List) {
                    ((List) h10).add(h11);
                } else {
                    ((Map) h10).put(str, h11);
                }
                if (z10) {
                    arrayDeque.addLast(h10);
                    h10 = h11;
                }
            } else {
                if (h10 instanceof List) {
                    jsonReader.endArray();
                } else {
                    jsonReader.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return h10;
                }
                h10 = arrayDeque.removeLast();
            }
        }
    }

    public void d(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        q<?> n10 = this.f23693a.n(obj.getClass());
        if (n10 instanceof j) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        n10.d(jsonWriter, obj);
    }

    private j(d dVar, p pVar) {
        this.f23693a = dVar;
        this.f23694b = pVar;
    }
}
