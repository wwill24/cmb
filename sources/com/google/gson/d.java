package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.h;
import com.google.gson.internal.j;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import mg.i;
import mg.k;
import mg.l;
import mg.o;

public final class d {
    static final c A = FieldNamingPolicy.IDENTITY;
    static final p B = ToNumberPolicy.DOUBLE;
    static final p C = ToNumberPolicy.LAZILY_PARSED_NUMBER;

    /* renamed from: z  reason: collision with root package name */
    static final String f21257z = null;

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<Map<qg.a<?>, q<?>>> f21258a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap<qg.a<?>, q<?>> f21259b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.gson.internal.b f21260c;

    /* renamed from: d  reason: collision with root package name */
    private final mg.e f21261d;

    /* renamed from: e  reason: collision with root package name */
    final List<r> f21262e;

    /* renamed from: f  reason: collision with root package name */
    final com.google.gson.internal.c f21263f;

    /* renamed from: g  reason: collision with root package name */
    final c f21264g;

    /* renamed from: h  reason: collision with root package name */
    final Map<Type, f<?>> f21265h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f21266i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f21267j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f21268k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f21269l;

    /* renamed from: m  reason: collision with root package name */
    final boolean f21270m;

    /* renamed from: n  reason: collision with root package name */
    final boolean f21271n;

    /* renamed from: o  reason: collision with root package name */
    final boolean f21272o;

    /* renamed from: p  reason: collision with root package name */
    final boolean f21273p;

    /* renamed from: q  reason: collision with root package name */
    final String f21274q;

    /* renamed from: r  reason: collision with root package name */
    final int f21275r;

    /* renamed from: s  reason: collision with root package name */
    final int f21276s;

    /* renamed from: t  reason: collision with root package name */
    final LongSerializationPolicy f21277t;

    /* renamed from: u  reason: collision with root package name */
    final List<r> f21278u;

    /* renamed from: v  reason: collision with root package name */
    final List<r> f21279v;

    /* renamed from: w  reason: collision with root package name */
    final p f21280w;

    /* renamed from: x  reason: collision with root package name */
    final p f21281x;

    /* renamed from: y  reason: collision with root package name */
    final List<ReflectionAccessFilter> f21282y;

    class a extends q<Number> {
        a() {
        }

        /* renamed from: e */
        public Double b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            double doubleValue = number.doubleValue();
            d.d(doubleValue);
            jsonWriter.value(doubleValue);
        }
    }

    class b extends q<Number> {
        b() {
        }

        /* renamed from: e */
        public Float b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            float floatValue = number.floatValue();
            d.d((double) floatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(floatValue);
            }
            jsonWriter.value(number);
        }
    }

    class c extends q<Number> {
        c() {
        }

        /* renamed from: e */
        public Number b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Long.valueOf(jsonReader.nextLong());
            }
            jsonReader.nextNull();
            return null;
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.toString());
            }
        }
    }

    /* renamed from: com.google.gson.d$d  reason: collision with other inner class name */
    class C0245d extends q<AtomicLong> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f21285a;

        C0245d(q qVar) {
            this.f21285a = qVar;
        }

        /* renamed from: e */
        public AtomicLong b(JsonReader jsonReader) throws IOException {
            return new AtomicLong(((Number) this.f21285a.b(jsonReader)).longValue());
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicLong atomicLong) throws IOException {
            this.f21285a.d(jsonWriter, Long.valueOf(atomicLong.get()));
        }
    }

    class e extends q<AtomicLongArray> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f21286a;

        e(q qVar) {
            this.f21286a = qVar;
        }

        /* renamed from: e */
        public AtomicLongArray b(JsonReader jsonReader) throws IOException {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(Long.valueOf(((Number) this.f21286a.b(jsonReader)).longValue()));
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicLongArray.set(i10, ((Long) arrayList.get(i10)).longValue());
            }
            return atomicLongArray;
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) throws IOException {
            jsonWriter.beginArray();
            int length = atomicLongArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                this.f21286a.d(jsonWriter, Long.valueOf(atomicLongArray.get(i10)));
            }
            jsonWriter.endArray();
        }
    }

    static class f<T> extends l<T> {

        /* renamed from: a  reason: collision with root package name */
        private q<T> f21287a = null;

        f() {
        }

        private q<T> f() {
            q<T> qVar = this.f21287a;
            if (qVar != null) {
                return qVar;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        public T b(JsonReader jsonReader) throws IOException {
            return f().b(jsonReader);
        }

        public void d(JsonWriter jsonWriter, T t10) throws IOException {
            f().d(jsonWriter, t10);
        }

        public q<T> e() {
            return f();
        }

        public void g(q<T> qVar) {
            if (this.f21287a == null) {
                this.f21287a = qVar;
                return;
            }
            throw new AssertionError("Delegate is already set");
        }
    }

    public d() {
        this(com.google.gson.internal.c.f21350g, A, Collections.emptyMap(), false, false, false, true, false, false, false, true, LongSerializationPolicy.DEFAULT, f21257z, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), B, C, Collections.emptyList());
    }

    private static void a(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonSyntaxException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e10) {
                throw new JsonSyntaxException((Throwable) e10);
            } catch (IOException e11) {
                throw new JsonIOException((Throwable) e11);
            }
        }
    }

    private static q<AtomicLong> b(q<Number> qVar) {
        return new C0245d(qVar).a();
    }

    private static q<AtomicLongArray> c(q<Number> qVar) {
        return new e(qVar).a();
    }

    static void d(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            throw new IllegalArgumentException(d10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private q<Number> e(boolean z10) {
        if (z10) {
            return o.f23755v;
        }
        return new a();
    }

    private q<Number> f(boolean z10) {
        if (z10) {
            return o.f23754u;
        }
        return new b();
    }

    private static q<Number> q(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return o.f23753t;
        }
        return new c();
    }

    public void A(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            z(obj, type, s(j.c(appendable)));
        } catch (IOException e10) {
            throw new JsonIOException((Throwable) e10);
        }
    }

    public <T> T g(j jVar, Class<T> cls) throws JsonSyntaxException {
        return h.b(cls).cast(h(jVar, qg.a.a(cls)));
    }

    public <T> T h(j jVar, qg.a<T> aVar) throws JsonSyntaxException {
        if (jVar == null) {
            return null;
        }
        return i(new mg.f(jVar), aVar);
    }

    public <T> T i(JsonReader jsonReader, qg.a<T> aVar) throws JsonIOException, JsonSyntaxException {
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            jsonReader.peek();
            T b10 = o(aVar).b(jsonReader);
            jsonReader.setLenient(isLenient);
            return b10;
        } catch (EOFException e10) {
            if (1 != 0) {
                jsonReader.setLenient(isLenient);
                return null;
            }
            throw new JsonSyntaxException((Throwable) e10);
        } catch (IllegalStateException e11) {
            throw new JsonSyntaxException((Throwable) e11);
        } catch (IOException e12) {
            throw new JsonSyntaxException((Throwable) e12);
        } catch (AssertionError e13) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e13.getMessage(), e13);
        } catch (Throwable th2) {
            jsonReader.setLenient(isLenient);
            throw th2;
        }
    }

    public <T> T j(Reader reader, qg.a<T> aVar) throws JsonIOException, JsonSyntaxException {
        JsonReader r10 = r(reader);
        T i10 = i(r10, aVar);
        a(i10, r10);
        return i10;
    }

    public <T> T k(String str, Class<T> cls) throws JsonSyntaxException {
        return h.b(cls).cast(m(str, qg.a.a(cls)));
    }

    public <T> T l(String str, Type type) throws JsonSyntaxException {
        return m(str, qg.a.b(type));
    }

    public <T> T m(String str, qg.a<T> aVar) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return j(new StringReader(str), aVar);
    }

    public <T> q<T> n(Class<T> cls) {
        return o(qg.a.a(cls));
    }

    public <T> q<T> o(qg.a<T> aVar) {
        Objects.requireNonNull(aVar, "type must not be null");
        q<T> qVar = this.f21259b.get(aVar);
        if (qVar != null) {
            return qVar;
        }
        Map map = this.f21258a.get();
        boolean z10 = false;
        if (map == null) {
            map = new HashMap();
            this.f21258a.set(map);
            z10 = true;
        } else {
            q<T> qVar2 = (q) map.get(aVar);
            if (qVar2 != null) {
                return qVar2;
            }
        }
        q<T> qVar3 = null;
        try {
            f fVar = new f();
            map.put(aVar, fVar);
            Iterator<r> it = this.f21262e.iterator();
            while (true) {
                if (it.hasNext()) {
                    qVar3 = it.next().a(this, aVar);
                    if (qVar3 != null) {
                        fVar.g(qVar3);
                        map.put(aVar, qVar3);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (qVar3 != null) {
                if (z10) {
                    this.f21259b.putAll(map);
                }
                return qVar3;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + aVar);
        } finally {
            if (z10) {
                this.f21258a.remove();
            }
        }
    }

    public <T> q<T> p(r rVar, qg.a<T> aVar) {
        if (!this.f21262e.contains(rVar)) {
            rVar = this.f21261d;
        }
        boolean z10 = false;
        for (r next : this.f21262e) {
            if (z10) {
                q<T> a10 = next.a(this, aVar);
                if (a10 != null) {
                    return a10;
                }
            } else if (next == rVar) {
                z10 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public JsonReader r(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.f21271n);
        return jsonReader;
    }

    public JsonWriter s(Writer writer) throws IOException {
        if (this.f21268k) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.f21270m) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setHtmlSafe(this.f21269l);
        jsonWriter.setLenient(this.f21271n);
        jsonWriter.setSerializeNulls(this.f21266i);
        return jsonWriter;
    }

    public String t(j jVar) {
        StringWriter stringWriter = new StringWriter();
        x(jVar, stringWriter);
        return stringWriter.toString();
    }

    public String toString() {
        return "{serializeNulls:" + this.f21266i + ",factories:" + this.f21262e + ",instanceCreators:" + this.f21260c + "}";
    }

    public String u(Object obj) {
        if (obj == null) {
            return t(k.f21376a);
        }
        return v(obj, obj.getClass());
    }

    public String v(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        A(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void w(j jVar, JsonWriter jsonWriter) throws JsonIOException {
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f21269l);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.f21266i);
        try {
            j.b(jVar, jsonWriter);
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        } catch (IOException e10) {
            throw new JsonIOException((Throwable) e10);
        } catch (AssertionError e11) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
        } catch (Throwable th2) {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
            throw th2;
        }
    }

    public void x(j jVar, Appendable appendable) throws JsonIOException {
        try {
            w(jVar, s(j.c(appendable)));
        } catch (IOException e10) {
            throw new JsonIOException((Throwable) e10);
        }
    }

    public void y(Object obj, Appendable appendable) throws JsonIOException {
        if (obj != null) {
            A(obj, obj.getClass(), appendable);
        } else {
            x(k.f21376a, appendable);
        }
    }

    public void z(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        q<?> o10 = o(qg.a.b(type));
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f21269l);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.f21266i);
        try {
            o10.d(jsonWriter, obj);
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        } catch (IOException e10) {
            throw new JsonIOException((Throwable) e10);
        } catch (AssertionError e11) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
        } catch (Throwable th2) {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
            throw th2;
        }
    }

    d(com.google.gson.internal.c cVar, c cVar2, Map<Type, f<?>> map, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, LongSerializationPolicy longSerializationPolicy, String str, int i10, int i11, List<r> list, List<r> list2, List<r> list3, p pVar, p pVar2, List<ReflectionAccessFilter> list4) {
        Map<Type, f<?>> map2 = map;
        boolean z18 = z11;
        boolean z19 = z16;
        boolean z20 = z17;
        List<ReflectionAccessFilter> list5 = list4;
        this.f21258a = new ThreadLocal<>();
        this.f21259b = new ConcurrentHashMap();
        this.f21263f = cVar;
        this.f21264g = cVar2;
        this.f21265h = map2;
        com.google.gson.internal.b bVar = new com.google.gson.internal.b(map2, z20, list5);
        this.f21260c = bVar;
        this.f21266i = z10;
        this.f21267j = z18;
        this.f21268k = z12;
        this.f21269l = z13;
        this.f21270m = z14;
        this.f21271n = z15;
        this.f21272o = z19;
        this.f21273p = z20;
        this.f21277t = longSerializationPolicy;
        this.f21274q = str;
        this.f21275r = i10;
        this.f21276s = i11;
        this.f21278u = list;
        this.f21279v = list2;
        this.f21280w = pVar;
        this.f21281x = pVar2;
        this.f21282y = list5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(o.W);
        arrayList.add(mg.j.e(pVar));
        arrayList.add(cVar);
        arrayList.addAll(list3);
        arrayList.add(o.C);
        arrayList.add(o.f23746m);
        arrayList.add(o.f23740g);
        arrayList.add(o.f23742i);
        arrayList.add(o.f23744k);
        q<Number> q10 = q(longSerializationPolicy);
        arrayList.add(o.b(Long.TYPE, Long.class, q10));
        arrayList.add(o.b(Double.TYPE, Double.class, e(z19)));
        arrayList.add(o.b(Float.TYPE, Float.class, f(z19)));
        arrayList.add(i.e(pVar2));
        arrayList.add(o.f23748o);
        arrayList.add(o.f23750q);
        arrayList.add(o.a(AtomicLong.class, b(q10)));
        arrayList.add(o.a(AtomicLongArray.class, c(q10)));
        arrayList.add(o.f23752s);
        arrayList.add(o.f23757x);
        arrayList.add(o.E);
        arrayList.add(o.G);
        arrayList.add(o.a(BigDecimal.class, o.f23759z));
        arrayList.add(o.a(BigInteger.class, o.A));
        arrayList.add(o.a(LazilyParsedNumber.class, o.B));
        arrayList.add(o.I);
        arrayList.add(o.K);
        arrayList.add(o.O);
        arrayList.add(o.Q);
        arrayList.add(o.U);
        arrayList.add(o.M);
        arrayList.add(o.f23737d);
        arrayList.add(mg.c.f23663b);
        arrayList.add(o.S);
        if (pg.d.f24377a) {
            arrayList.add(pg.d.f24381e);
            arrayList.add(pg.d.f24380d);
            arrayList.add(pg.d.f24382f);
        }
        arrayList.add(mg.a.f23657c);
        arrayList.add(o.f23735b);
        arrayList.add(new mg.b(bVar));
        arrayList.add(new mg.h(bVar, z18));
        mg.e eVar = new mg.e(bVar);
        this.f21261d = eVar;
        arrayList.add(eVar);
        arrayList.add(o.X);
        arrayList.add(new k(bVar, cVar2, cVar, eVar, list4));
        this.f21262e = Collections.unmodifiableList(arrayList);
    }
}
