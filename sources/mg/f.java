package mg;

import com.google.gson.g;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.m;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;

public final class f extends JsonReader {

    /* renamed from: e  reason: collision with root package name */
    private static final Reader f23670e = new a();

    /* renamed from: f  reason: collision with root package name */
    private static final Object f23671f = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Object[] f23672a = new Object[32];

    /* renamed from: b  reason: collision with root package name */
    private int f23673b = 0;

    /* renamed from: c  reason: collision with root package name */
    private String[] f23674c = new String[32];

    /* renamed from: d  reason: collision with root package name */
    private int[] f23675d = new int[32];

    class a extends Reader {
        a() {
        }

        public void close() {
            throw new AssertionError();
        }

        public int read(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23676a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.gson.stream.JsonToken[] r0 = com.google.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23676a = r0
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NAME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23676a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23676a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23676a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: mg.f.b.<clinit>():void");
        }
    }

    public f(j jVar) {
        super(f23670e);
        h(jVar);
    }

    private void a(JsonToken jsonToken) throws IOException {
        if (peek() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + locationString());
        }
    }

    private String c(boolean z10) throws IOException {
        String str;
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) e()).next();
        String str2 = (String) entry.getKey();
        String[] strArr = this.f23674c;
        int i10 = this.f23673b - 1;
        if (z10) {
            str = "<skipped>";
        } else {
            str = str2;
        }
        strArr[i10] = str;
        h(entry.getValue());
        return str2;
    }

    private Object e() {
        return this.f23672a[this.f23673b - 1];
    }

    private Object f() {
        Object[] objArr = this.f23672a;
        int i10 = this.f23673b - 1;
        this.f23673b = i10;
        Object obj = objArr[i10];
        objArr[i10] = null;
        return obj;
    }

    private String getPath(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = 0;
        while (true) {
            int i11 = this.f23673b;
            if (i10 >= i11) {
                return sb2.toString();
            }
            Object[] objArr = this.f23672a;
            Object obj = objArr[i10];
            if (obj instanceof g) {
                i10++;
                if (i10 < i11 && (objArr[i10] instanceof Iterator)) {
                    int i12 = this.f23675d[i10];
                    if (z10 && i12 > 0 && (i10 == i11 - 1 || i10 == i11 - 2)) {
                        i12--;
                    }
                    sb2.append('[');
                    sb2.append(i12);
                    sb2.append(PropertyUtils.INDEXED_DELIM2);
                }
            } else if ((obj instanceof l) && (i10 = i10 + 1) < i11 && (objArr[i10] instanceof Iterator)) {
                sb2.append('.');
                String str = this.f23674c[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i10++;
        }
    }

    private void h(Object obj) {
        int i10 = this.f23673b;
        Object[] objArr = this.f23672a;
        if (i10 == objArr.length) {
            int i11 = i10 * 2;
            this.f23672a = Arrays.copyOf(objArr, i11);
            this.f23675d = Arrays.copyOf(this.f23675d, i11);
            this.f23674c = (String[]) Arrays.copyOf(this.f23674c, i11);
        }
        Object[] objArr2 = this.f23672a;
        int i12 = this.f23673b;
        this.f23673b = i12 + 1;
        objArr2[i12] = obj;
    }

    private String locationString() {
        return " at path " + getPath();
    }

    /* access modifiers changed from: package-private */
    public j b() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.NAME || peek == JsonToken.END_ARRAY || peek == JsonToken.END_OBJECT || peek == JsonToken.END_DOCUMENT) {
            throw new IllegalStateException("Unexpected " + peek + " when reading a JsonElement.");
        }
        j jVar = (j) e();
        skipValue();
        return jVar;
    }

    public void beginArray() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        h(((g) e()).iterator());
        this.f23675d[this.f23673b - 1] = 0;
    }

    public void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        h(((l) e()).o().iterator());
    }

    public void close() throws IOException {
        this.f23672a = new Object[]{f23671f};
        this.f23673b = 1;
    }

    public void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        f();
        f();
        int i10 = this.f23673b;
        if (i10 > 0) {
            int[] iArr = this.f23675d;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    public void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        this.f23674c[this.f23673b - 1] = null;
        f();
        f();
        int i10 = this.f23673b;
        if (i10 > 0) {
            int[] iArr = this.f23675d;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    public void g() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) e()).next();
        h(entry.getValue());
        h(new m((String) entry.getKey()));
    }

    public String getPreviousPath() {
        return getPath(true);
    }

    public boolean hasNext() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.END_OBJECT || peek == JsonToken.END_ARRAY || peek == JsonToken.END_DOCUMENT) {
            return false;
        }
        return true;
    }

    public boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean n10 = ((m) f()).n();
        int i10 = this.f23673b;
        if (i10 > 0) {
            int[] iArr = this.f23675d;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return n10;
    }

    public double nextDouble() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek == jsonToken || peek == JsonToken.STRING) {
            double o10 = ((m) e()).o();
            if (isLenient() || (!Double.isNaN(o10) && !Double.isInfinite(o10))) {
                f();
                int i10 = this.f23673b;
                if (i10 > 0) {
                    int[] iArr = this.f23675d;
                    int i11 = i10 - 1;
                    iArr[i11] = iArr[i11] + 1;
                }
                return o10;
            }
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + o10);
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
    }

    public int nextInt() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek == jsonToken || peek == JsonToken.STRING) {
            int p10 = ((m) e()).p();
            f();
            int i10 = this.f23673b;
            if (i10 > 0) {
                int[] iArr = this.f23675d;
                int i11 = i10 - 1;
                iArr[i11] = iArr[i11] + 1;
            }
            return p10;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
    }

    public long nextLong() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek == jsonToken || peek == JsonToken.STRING) {
            long q10 = ((m) e()).q();
            f();
            int i10 = this.f23673b;
            if (i10 > 0) {
                int[] iArr = this.f23675d;
                int i11 = i10 - 1;
                iArr[i11] = iArr[i11] + 1;
            }
            return q10;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
    }

    public String nextName() throws IOException {
        return c(false);
    }

    public void nextNull() throws IOException {
        a(JsonToken.NULL);
        f();
        int i10 = this.f23673b;
        if (i10 > 0) {
            int[] iArr = this.f23675d;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    public String nextString() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.STRING;
        if (peek == jsonToken || peek == JsonToken.NUMBER) {
            String s10 = ((m) f()).s();
            int i10 = this.f23673b;
            if (i10 > 0) {
                int[] iArr = this.f23675d;
                int i11 = i10 - 1;
                iArr[i11] = iArr[i11] + 1;
            }
            return s10;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
    }

    public JsonToken peek() throws IOException {
        if (this.f23673b == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object e10 = e();
        if (e10 instanceof Iterator) {
            boolean z10 = this.f23672a[this.f23673b - 2] instanceof l;
            Iterator it = (Iterator) e10;
            if (it.hasNext()) {
                if (z10) {
                    return JsonToken.NAME;
                }
                h(it.next());
                return peek();
            } else if (z10) {
                return JsonToken.END_OBJECT;
            } else {
                return JsonToken.END_ARRAY;
            }
        } else if (e10 instanceof l) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (e10 instanceof g) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (e10 instanceof m) {
                m mVar = (m) e10;
                if (mVar.w()) {
                    return JsonToken.STRING;
                }
                if (mVar.t()) {
                    return JsonToken.BOOLEAN;
                }
                if (mVar.v()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (e10 instanceof k) {
                return JsonToken.NULL;
            } else {
                if (e10 == f23671f) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new MalformedJsonException("Custom JsonElement subclass " + e10.getClass().getName() + " is not supported");
            }
        }
    }

    public void skipValue() throws IOException {
        int i10 = b.f23676a[peek().ordinal()];
        if (i10 == 1) {
            c(true);
        } else if (i10 == 2) {
            endArray();
        } else if (i10 == 3) {
            endObject();
        } else if (i10 != 4) {
            f();
            int i11 = this.f23673b;
            if (i11 > 0) {
                int[] iArr = this.f23675d;
                int i12 = i11 - 1;
                iArr[i12] = iArr[i12] + 1;
            }
        }
    }

    public String toString() {
        return f.class.getSimpleName() + locationString();
    }

    public String getPath() {
        return getPath(false);
    }
}
