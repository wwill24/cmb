package com.squareup.moshi;

import com.squareup.moshi.JsonReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;

final class n extends JsonReader {

    /* renamed from: h  reason: collision with root package name */
    private static final Object f22980h = new Object();

    /* renamed from: g  reason: collision with root package name */
    private Object[] f22981g;

    static final class a implements Iterator<Object>, Cloneable {

        /* renamed from: a  reason: collision with root package name */
        final JsonReader.Token f22982a;

        /* renamed from: b  reason: collision with root package name */
        final Object[] f22983b;

        /* renamed from: c  reason: collision with root package name */
        int f22984c;

        a(JsonReader.Token token, Object[] objArr, int i10) {
            this.f22982a = token;
            this.f22983b = objArr;
            this.f22984c = i10;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a clone() {
            return new a(this.f22982a, this.f22983b, this.f22984c);
        }

        public boolean hasNext() {
            return this.f22984c < this.f22983b.length;
        }

        public Object next() {
            Object[] objArr = this.f22983b;
            int i10 = this.f22984c;
            this.f22984c = i10 + 1;
            return objArr[i10];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    n(Object obj) {
        int[] iArr = this.f22865b;
        int i10 = this.f22864a;
        iArr[i10] = 7;
        Object[] objArr = new Object[32];
        this.f22981g = objArr;
        this.f22864a = i10 + 1;
        objArr[i10] = obj;
    }

    private void f0(Object obj) {
        int i10 = this.f22864a;
        if (i10 == this.f22981g.length) {
            if (i10 != 256) {
                int[] iArr = this.f22865b;
                this.f22865b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f22866c;
                this.f22866c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f22867d;
                this.f22867d = Arrays.copyOf(iArr2, iArr2.length * 2);
                Object[] objArr = this.f22981g;
                this.f22981g = Arrays.copyOf(objArr, objArr.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        Object[] objArr2 = this.f22981g;
        int i11 = this.f22864a;
        this.f22864a = i11 + 1;
        objArr2[i11] = obj;
    }

    private void i0() {
        int i10 = this.f22864a - 1;
        this.f22864a = i10;
        Object[] objArr = this.f22981g;
        objArr[i10] = null;
        this.f22865b[i10] = 0;
        if (i10 > 0) {
            int[] iArr = this.f22867d;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
            Object obj = objArr[i10 - 1];
            if (obj instanceof Iterator) {
                Iterator it = (Iterator) obj;
                if (it.hasNext()) {
                    f0(it.next());
                }
            }
        }
    }

    private <T> T m0(Class<T> cls, JsonReader.Token token) throws IOException {
        Object obj;
        int i10 = this.f22864a;
        if (i10 != 0) {
            obj = this.f22981g[i10 - 1];
        } else {
            obj = null;
        }
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        if (obj == null && token == JsonReader.Token.NULL) {
            return null;
        }
        if (obj == f22980h) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw e0(obj, token);
    }

    private String q0(Map.Entry<?, ?> entry) {
        Object key = entry.getKey();
        if (key instanceof String) {
            return (String) key;
        }
        throw e0(key, JsonReader.Token.NAME);
    }

    public JsonReader.Token E() throws IOException {
        int i10 = this.f22864a;
        if (i10 == 0) {
            return JsonReader.Token.END_DOCUMENT;
        }
        Object obj = this.f22981g[i10 - 1];
        if (obj instanceof a) {
            return ((a) obj).f22982a;
        }
        if (obj instanceof List) {
            return JsonReader.Token.BEGIN_ARRAY;
        }
        if (obj instanceof Map) {
            return JsonReader.Token.BEGIN_OBJECT;
        }
        if (obj instanceof Map.Entry) {
            return JsonReader.Token.NAME;
        }
        if (obj instanceof String) {
            return JsonReader.Token.STRING;
        }
        if (obj instanceof Boolean) {
            return JsonReader.Token.BOOLEAN;
        }
        if (obj instanceof Number) {
            return JsonReader.Token.NUMBER;
        }
        if (obj == null) {
            return JsonReader.Token.NULL;
        }
        if (obj == f22980h) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw e0(obj, "a JSON value");
    }

    public JsonReader F() {
        return new n(this);
    }

    public void G() throws IOException {
        if (g()) {
            f0(u());
        }
    }

    public int L(JsonReader.b bVar) throws IOException {
        Map.Entry entry = (Map.Entry) m0(Map.Entry.class, JsonReader.Token.NAME);
        String q02 = q0(entry);
        int length = bVar.f22882a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (bVar.f22882a[i10].equals(q02)) {
                this.f22981g[this.f22864a - 1] = entry.getValue();
                this.f22866c[this.f22864a - 2] = q02;
                return i10;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int N(com.squareup.moshi.JsonReader.b r6) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f22864a
            if (r0 == 0) goto L_0x000b
            java.lang.Object[] r1 = r5.f22981g
            int r0 = r0 + -1
            r0 = r1[r0]
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            boolean r1 = r0 instanceof java.lang.String
            r2 = -1
            if (r1 != 0) goto L_0x001e
            java.lang.Object r6 = f22980h
            if (r0 == r6) goto L_0x0016
            return r2
        L_0x0016:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "JsonReader is closed"
            r6.<init>(r0)
            throw r6
        L_0x001e:
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            java.lang.String[] r3 = r6.f22882a
            int r3 = r3.length
        L_0x0024:
            if (r1 >= r3) goto L_0x0037
            java.lang.String[] r4 = r6.f22882a
            r4 = r4[r1]
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r5.i0()
            return r1
        L_0x0034:
            int r1 = r1 + 1
            goto L_0x0024
        L_0x0037:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.n.N(com.squareup.moshi.JsonReader$b):int");
    }

    public void S() throws IOException {
        if (!this.f22869f) {
            this.f22981g[this.f22864a - 1] = ((Map.Entry) m0(Map.Entry.class, JsonReader.Token.NAME)).getValue();
            this.f22866c[this.f22864a - 2] = "null";
            return;
        }
        JsonReader.Token E = E();
        u();
        throw new JsonDataException("Cannot skip unexpected " + E + " at " + getPath());
    }

    public void Y() throws IOException {
        Object obj;
        if (!this.f22869f) {
            int i10 = this.f22864a;
            if (i10 > 1) {
                this.f22866c[i10 - 2] = "null";
            }
            if (i10 != 0) {
                obj = this.f22981g[i10 - 1];
            } else {
                obj = null;
            }
            if (obj instanceof a) {
                throw new JsonDataException("Expected a value but was " + E() + " at path " + getPath());
            } else if (obj instanceof Map.Entry) {
                Object[] objArr = this.f22981g;
                objArr[i10 - 1] = ((Map.Entry) objArr[i10 - 1]).getValue();
            } else if (i10 > 0) {
                i0();
            } else {
                throw new JsonDataException("Expected a value but was " + E() + " at path " + getPath());
            }
        } else {
            throw new JsonDataException("Cannot skip unexpected " + E() + " at " + getPath());
        }
    }

    public void a() throws IOException {
        List list = (List) m0(List.class, JsonReader.Token.BEGIN_ARRAY);
        a aVar = new a(JsonReader.Token.END_ARRAY, list.toArray(new Object[list.size()]), 0);
        Object[] objArr = this.f22981g;
        int i10 = this.f22864a;
        objArr[i10 - 1] = aVar;
        this.f22865b[i10 - 1] = 1;
        this.f22867d[i10 - 1] = 0;
        if (aVar.hasNext()) {
            f0(aVar.next());
        }
    }

    public void b() throws IOException {
        Map map = (Map) m0(Map.class, JsonReader.Token.BEGIN_OBJECT);
        a aVar = new a(JsonReader.Token.END_OBJECT, map.entrySet().toArray(new Object[map.size()]), 0);
        Object[] objArr = this.f22981g;
        int i10 = this.f22864a;
        objArr[i10 - 1] = aVar;
        this.f22865b[i10 - 1] = 3;
        if (aVar.hasNext()) {
            f0(aVar.next());
        }
    }

    public void c() throws IOException {
        JsonReader.Token token = JsonReader.Token.END_ARRAY;
        a aVar = (a) m0(a.class, token);
        if (aVar.f22982a != token || aVar.hasNext()) {
            throw e0(aVar, token);
        }
        i0();
    }

    public void close() throws IOException {
        Arrays.fill(this.f22981g, 0, this.f22864a, (Object) null);
        this.f22981g[0] = f22980h;
        this.f22865b[0] = 8;
        this.f22864a = 1;
    }

    public void e() throws IOException {
        JsonReader.Token token = JsonReader.Token.END_OBJECT;
        a aVar = (a) m0(a.class, token);
        if (aVar.f22982a != token || aVar.hasNext()) {
            throw e0(aVar, token);
        }
        this.f22866c[this.f22864a - 1] = null;
        i0();
    }

    public boolean g() throws IOException {
        int i10 = this.f22864a;
        if (i10 == 0) {
            return false;
        }
        Object obj = this.f22981g[i10 - 1];
        if (!(obj instanceof Iterator) || ((Iterator) obj).hasNext()) {
            return true;
        }
        return false;
    }

    public boolean k() throws IOException {
        i0();
        return ((Boolean) m0(Boolean.class, JsonReader.Token.BOOLEAN)).booleanValue();
    }

    public double l() throws IOException {
        double d10;
        JsonReader.Token token = JsonReader.Token.NUMBER;
        Object m02 = m0(Object.class, token);
        if (m02 instanceof Number) {
            d10 = ((Number) m02).doubleValue();
        } else if (m02 instanceof String) {
            try {
                d10 = Double.parseDouble((String) m02);
            } catch (NumberFormatException unused) {
                throw e0(m02, JsonReader.Token.NUMBER);
            }
        } else {
            throw e0(m02, token);
        }
        if (this.f22868e || (!Double.isNaN(d10) && !Double.isInfinite(d10))) {
            i0();
            return d10;
        }
        throw new JsonEncodingException("JSON forbids NaN and infinities: " + d10 + " at path " + getPath());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        throw e0(r0, com.squareup.moshi.JsonReader.Token.NUMBER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = new java.math.BigDecimal((java.lang.String) r0).intValueExact();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m() throws java.io.IOException {
        /*
            r3 = this;
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            java.lang.Object r0 = r3.m0(r0, r1)
            boolean r2 = r0 instanceof java.lang.Number
            if (r2 == 0) goto L_0x0013
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            goto L_0x002b
        L_0x0013:
            boolean r2 = r0 instanceof java.lang.String
            if (r2 == 0) goto L_0x0036
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NumberFormatException -> 0x001f }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x001f }
            goto L_0x002b
        L_0x001f:
            java.math.BigDecimal r1 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x002f }
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NumberFormatException -> 0x002f }
            r1.<init>(r2)     // Catch:{ NumberFormatException -> 0x002f }
            int r0 = r1.intValueExact()     // Catch:{ NumberFormatException -> 0x002f }
        L_0x002b:
            r3.i0()
            return r0
        L_0x002f:
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            com.squareup.moshi.JsonDataException r0 = r3.e0(r0, r1)
            throw r0
        L_0x0036:
            com.squareup.moshi.JsonDataException r0 = r3.e0(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.n.m():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        throw e0(r0, com.squareup.moshi.JsonReader.Token.NUMBER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = new java.math.BigDecimal((java.lang.String) r0).longValueExact();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long n() throws java.io.IOException {
        /*
            r3 = this;
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            java.lang.Object r0 = r3.m0(r0, r1)
            boolean r2 = r0 instanceof java.lang.Number
            if (r2 == 0) goto L_0x0013
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            goto L_0x002b
        L_0x0013:
            boolean r2 = r0 instanceof java.lang.String
            if (r2 == 0) goto L_0x0036
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NumberFormatException -> 0x001f }
            long r0 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x001f }
            goto L_0x002b
        L_0x001f:
            java.math.BigDecimal r1 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x002f }
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NumberFormatException -> 0x002f }
            r1.<init>(r2)     // Catch:{ NumberFormatException -> 0x002f }
            long r0 = r1.longValueExact()     // Catch:{ NumberFormatException -> 0x002f }
        L_0x002b:
            r3.i0()
            return r0
        L_0x002f:
            com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER
            com.squareup.moshi.JsonDataException r0 = r3.e0(r0, r1)
            throw r0
        L_0x0036:
            com.squareup.moshi.JsonDataException r0 = r3.e0(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.n.n():long");
    }

    public String u() throws IOException {
        Map.Entry entry = (Map.Entry) m0(Map.Entry.class, JsonReader.Token.NAME);
        String q02 = q0(entry);
        this.f22981g[this.f22864a - 1] = entry.getValue();
        this.f22866c[this.f22864a - 2] = q02;
        return q02;
    }

    public <T> T v() throws IOException {
        m0(Void.class, JsonReader.Token.NULL);
        i0();
        return null;
    }

    public BufferedSource x() throws IOException {
        Object J = J();
        Buffer buffer = new Buffer();
        q x10 = q.x(buffer);
        try {
            x10.n(J);
            x10.close();
            return buffer;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public String y() throws IOException {
        String str;
        int i10 = this.f22864a;
        if (i10 != 0) {
            str = this.f22981g[i10 - 1];
        } else {
            str = null;
        }
        if (str instanceof String) {
            i0();
            return str;
        } else if (str instanceof Number) {
            i0();
            return str.toString();
        } else if (str == f22980h) {
            throw new IllegalStateException("JsonReader is closed");
        } else {
            throw e0(str, JsonReader.Token.STRING);
        }
    }

    n(n nVar) {
        super(nVar);
        this.f22981g = (Object[]) nVar.f22981g.clone();
        for (int i10 = 0; i10 < this.f22864a; i10++) {
            Object[] objArr = this.f22981g;
            Object obj = objArr[i10];
            if (obj instanceof a) {
                objArr[i10] = ((a) obj).clone();
            }
        }
    }
}
