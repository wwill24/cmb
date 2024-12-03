package com.squareup.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

public abstract class JsonReader implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    int f22864a;

    /* renamed from: b  reason: collision with root package name */
    int[] f22865b;

    /* renamed from: c  reason: collision with root package name */
    String[] f22866c;

    /* renamed from: d  reason: collision with root package name */
    int[] f22867d;

    /* renamed from: e  reason: collision with root package name */
    boolean f22868e;

    /* renamed from: f  reason: collision with root package name */
    boolean f22869f;

    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22881a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.squareup.moshi.JsonReader$Token[] r0 = com.squareup.moshi.JsonReader.Token.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22881a = r0
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22881a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22881a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22881a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f22881a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f22881a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonReader.a.<clinit>():void");
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final String[] f22882a;

        /* renamed from: b  reason: collision with root package name */
        final Options f22883b;

        private b(String[] strArr, Options options) {
            this.f22882a = strArr;
            this.f22883b = options;
        }

        public static b a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    m.q0(buffer, strArr[i10]);
                    buffer.readByte();
                    byteStringArr[i10] = buffer.y1();
                }
                return new b((String[]) strArr.clone(), Options.o(byteStringArr));
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    JsonReader() {
        this.f22865b = new int[32];
        this.f22866c = new String[32];
        this.f22867d = new int[32];
    }

    public static JsonReader C(BufferedSource bufferedSource) {
        return new l(bufferedSource);
    }

    public abstract Token E() throws IOException;

    public abstract JsonReader F();

    public abstract void G() throws IOException;

    /* access modifiers changed from: package-private */
    public final void I(int i10) {
        int i11 = this.f22864a;
        int[] iArr = this.f22865b;
        if (i11 == iArr.length) {
            if (i11 != 256) {
                this.f22865b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f22866c;
                this.f22866c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f22867d;
                this.f22867d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.f22865b;
        int i12 = this.f22864a;
        this.f22864a = i12 + 1;
        iArr3[i12] = i10;
    }

    public final Object J() throws IOException {
        switch (a.f22881a[E().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                a();
                while (g()) {
                    arrayList.add(J());
                }
                c();
                return arrayList;
            case 2:
                LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
                b();
                while (g()) {
                    String u10 = u();
                    Object J = J();
                    Object put = linkedHashTreeMap.put(u10, J);
                    if (put != null) {
                        throw new JsonDataException("Map key '" + u10 + "' has multiple values at path " + getPath() + ": " + put + " and " + J);
                    }
                }
                e();
                return linkedHashTreeMap;
            case 3:
                return y();
            case 4:
                return Double.valueOf(l());
            case 5:
                return Boolean.valueOf(k());
            case 6:
                return v();
            default:
                throw new IllegalStateException("Expected a value but was " + E() + " at path " + getPath());
        }
    }

    public abstract int L(b bVar) throws IOException;

    public abstract int N(b bVar) throws IOException;

    public final void O(boolean z10) {
        this.f22869f = z10;
    }

    public final void P(boolean z10) {
        this.f22868e = z10;
    }

    public abstract void S() throws IOException;

    public abstract void Y() throws IOException;

    public abstract void a() throws IOException;

    public abstract void b() throws IOException;

    public abstract void c() throws IOException;

    /* access modifiers changed from: package-private */
    public final JsonEncodingException c0(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    public abstract void e() throws IOException;

    /* access modifiers changed from: package-private */
    public final JsonDataException e0(Object obj, Object obj2) {
        if (obj == null) {
            return new JsonDataException("Expected " + obj2 + " but was null at path " + getPath());
        }
        return new JsonDataException("Expected " + obj2 + " but was " + obj + ", a " + obj.getClass().getName() + ", at path " + getPath());
    }

    public final boolean f() {
        return this.f22869f;
    }

    public abstract boolean g() throws IOException;

    public final String getPath() {
        return k.a(this.f22864a, this.f22865b, this.f22866c, this.f22867d);
    }

    public final boolean h() {
        return this.f22868e;
    }

    public abstract boolean k() throws IOException;

    public abstract double l() throws IOException;

    public abstract int m() throws IOException;

    public abstract long n() throws IOException;

    public abstract String u() throws IOException;

    public abstract <T> T v() throws IOException;

    public abstract BufferedSource x() throws IOException;

    public abstract String y() throws IOException;

    JsonReader(JsonReader jsonReader) {
        this.f22864a = jsonReader.f22864a;
        this.f22865b = (int[]) jsonReader.f22865b.clone();
        this.f22866c = (String[]) jsonReader.f22866c.clone();
        this.f22867d = (int[]) jsonReader.f22867d.clone();
        this.f22868e = jsonReader.f22868e;
        this.f22869f = jsonReader.f22869f;
    }
}
