package mg;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import net.bytebuddy.utility.JavaConstant;

public final class o {
    public static final com.google.gson.q<BigInteger> A = new h();
    public static final com.google.gson.q<LazilyParsedNumber> B = new i();
    public static final com.google.gson.r C;
    public static final com.google.gson.q<StringBuilder> D;
    public static final com.google.gson.r E;
    public static final com.google.gson.q<StringBuffer> F;
    public static final com.google.gson.r G;
    public static final com.google.gson.q<URL> H;
    public static final com.google.gson.r I;
    public static final com.google.gson.q<URI> J;
    public static final com.google.gson.r K;
    public static final com.google.gson.q<InetAddress> L;
    public static final com.google.gson.r M;
    public static final com.google.gson.q<UUID> N;
    public static final com.google.gson.r O;
    public static final com.google.gson.q<Currency> P;
    public static final com.google.gson.r Q;
    public static final com.google.gson.q<Calendar> R;
    public static final com.google.gson.r S;
    public static final com.google.gson.q<Locale> T;
    public static final com.google.gson.r U;
    public static final com.google.gson.q<com.google.gson.j> V;
    public static final com.google.gson.r W;
    public static final com.google.gson.r X = new u();

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.gson.q<Class> f23734a;

    /* renamed from: b  reason: collision with root package name */
    public static final com.google.gson.r f23735b;

    /* renamed from: c  reason: collision with root package name */
    public static final com.google.gson.q<BitSet> f23736c;

    /* renamed from: d  reason: collision with root package name */
    public static final com.google.gson.r f23737d;

    /* renamed from: e  reason: collision with root package name */
    public static final com.google.gson.q<Boolean> f23738e;

    /* renamed from: f  reason: collision with root package name */
    public static final com.google.gson.q<Boolean> f23739f = new c0();

    /* renamed from: g  reason: collision with root package name */
    public static final com.google.gson.r f23740g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.google.gson.q<Number> f23741h;

    /* renamed from: i  reason: collision with root package name */
    public static final com.google.gson.r f23742i;

    /* renamed from: j  reason: collision with root package name */
    public static final com.google.gson.q<Number> f23743j;

    /* renamed from: k  reason: collision with root package name */
    public static final com.google.gson.r f23744k;

    /* renamed from: l  reason: collision with root package name */
    public static final com.google.gson.q<Number> f23745l;

    /* renamed from: m  reason: collision with root package name */
    public static final com.google.gson.r f23746m;

    /* renamed from: n  reason: collision with root package name */
    public static final com.google.gson.q<AtomicInteger> f23747n;

    /* renamed from: o  reason: collision with root package name */
    public static final com.google.gson.r f23748o;

    /* renamed from: p  reason: collision with root package name */
    public static final com.google.gson.q<AtomicBoolean> f23749p;

    /* renamed from: q  reason: collision with root package name */
    public static final com.google.gson.r f23750q;

    /* renamed from: r  reason: collision with root package name */
    public static final com.google.gson.q<AtomicIntegerArray> f23751r;

    /* renamed from: s  reason: collision with root package name */
    public static final com.google.gson.r f23752s;

    /* renamed from: t  reason: collision with root package name */
    public static final com.google.gson.q<Number> f23753t = new b();

    /* renamed from: u  reason: collision with root package name */
    public static final com.google.gson.q<Number> f23754u = new c();

    /* renamed from: v  reason: collision with root package name */
    public static final com.google.gson.q<Number> f23755v = new d();

    /* renamed from: w  reason: collision with root package name */
    public static final com.google.gson.q<Character> f23756w;

    /* renamed from: x  reason: collision with root package name */
    public static final com.google.gson.r f23757x;

    /* renamed from: y  reason: collision with root package name */
    public static final com.google.gson.q<String> f23758y;

    /* renamed from: z  reason: collision with root package name */
    public static final com.google.gson.q<BigDecimal> f23759z = new g();

    class a extends com.google.gson.q<AtomicIntegerArray> {
        a() {
        }

        /* renamed from: e */
        public AtomicIntegerArray b(JsonReader jsonReader) throws IOException {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException((Throwable) e10);
                }
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
            }
            return atomicIntegerArray;
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
            jsonWriter.beginArray();
            int length = atomicIntegerArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                jsonWriter.value((long) atomicIntegerArray.get(i10));
            }
            jsonWriter.endArray();
        }
    }

    static /* synthetic */ class a0 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23760a;

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
                f23760a = r0
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23760a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23760a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23760a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f23760a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f23760a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: mg.o.a0.<clinit>():void");
        }
    }

    class b extends com.google.gson.q<Number> {
        b() {
        }

        /* renamed from: e */
        public Number b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException((Throwable) e10);
            }
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.longValue());
            }
        }
    }

    class b0 extends com.google.gson.q<Boolean> {
        b0() {
        }

        /* renamed from: e */
        public Boolean b(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            } else if (peek == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
            } else {
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool);
        }
    }

    class c extends com.google.gson.q<Number> {
        c() {
        }

        /* renamed from: e */
        public Number b(JsonReader jsonReader) throws IOException {
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
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            jsonWriter.value(number);
        }
    }

    class c0 extends com.google.gson.q<Boolean> {
        c0() {
        }

        /* renamed from: e */
        public Boolean b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Boolean.valueOf(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.value(bool == null ? "null" : bool.toString());
        }
    }

    class d extends com.google.gson.q<Number> {
        d() {
        }

        /* renamed from: e */
        public Number b(JsonReader jsonReader) throws IOException {
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
            } else {
                jsonWriter.value(number.doubleValue());
            }
        }
    }

    class d0 extends com.google.gson.q<Number> {
        d0() {
        }

        /* renamed from: e */
        public Number b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= 255 && nextInt >= -128) {
                    return Byte.valueOf((byte) nextInt);
                }
                throw new JsonSyntaxException("Lossy conversion from " + nextInt + " to byte; at path " + jsonReader.getPreviousPath());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException((Throwable) e10);
            }
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value((long) number.byteValue());
            }
        }
    }

    class e extends com.google.gson.q<Character> {
        e() {
        }

        /* renamed from: e */
        public Character b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + nextString + "; at " + jsonReader.getPreviousPath());
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Character ch2) throws IOException {
            jsonWriter.value(ch2 == null ? null : String.valueOf(ch2));
        }
    }

    class e0 extends com.google.gson.q<Number> {
        e0() {
        }

        /* renamed from: e */
        public Number b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= 65535 && nextInt >= -32768) {
                    return Short.valueOf((short) nextInt);
                }
                throw new JsonSyntaxException("Lossy conversion from " + nextInt + " to short; at path " + jsonReader.getPreviousPath());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException((Throwable) e10);
            }
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value((long) number.shortValue());
            }
        }
    }

    class f extends com.google.gson.q<String> {
        f() {
        }

        /* renamed from: e */
        public String b(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            } else if (peek == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.nextBoolean());
            } else {
                return jsonReader.nextString();
            }
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, String str) throws IOException {
            jsonWriter.value(str);
        }
    }

    class f0 extends com.google.gson.q<Number> {
        f0() {
        }

        /* renamed from: e */
        public Number b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException((Throwable) e10);
            }
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value((long) number.intValue());
            }
        }
    }

    class g extends com.google.gson.q<BigDecimal> {
        g() {
        }

        /* renamed from: e */
        public BigDecimal b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                return new BigDecimal(nextString);
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as BigDecimal; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
            jsonWriter.value((Number) bigDecimal);
        }
    }

    class g0 extends com.google.gson.q<AtomicInteger> {
        g0() {
        }

        /* renamed from: e */
        public AtomicInteger b(JsonReader jsonReader) throws IOException {
            try {
                return new AtomicInteger(jsonReader.nextInt());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException((Throwable) e10);
            }
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
            jsonWriter.value((long) atomicInteger.get());
        }
    }

    class h extends com.google.gson.q<BigInteger> {
        h() {
        }

        /* renamed from: e */
        public BigInteger b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                return new BigInteger(nextString);
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as BigInteger; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
            jsonWriter.value((Number) bigInteger);
        }
    }

    class h0 extends com.google.gson.q<AtomicBoolean> {
        h0() {
        }

        /* renamed from: e */
        public AtomicBoolean b(JsonReader jsonReader) throws IOException {
            return new AtomicBoolean(jsonReader.nextBoolean());
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
            jsonWriter.value(atomicBoolean.get());
        }
    }

    class i extends com.google.gson.q<LazilyParsedNumber> {
        i() {
        }

        /* renamed from: e */
        public LazilyParsedNumber b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new LazilyParsedNumber(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, LazilyParsedNumber lazilyParsedNumber) throws IOException {
            jsonWriter.value((Number) lazilyParsedNumber);
        }
    }

    private static final class i0<T extends Enum<T>> extends com.google.gson.q<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, T> f23761a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, T> f23762b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private final Map<T, String> f23763c = new HashMap();

        class a implements PrivilegedAction<Field[]> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Class f23764a;

            a(Class cls) {
                this.f23764a = cls;
            }

            /* renamed from: a */
            public Field[] run() {
                Field[] declaredFields = this.f23764a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public i0(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum enumR = (Enum) field.get((Object) null);
                    String name = enumR.name();
                    String str = enumR.toString();
                    lg.c cVar = (lg.c) field.getAnnotation(lg.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String put : cVar.alternate()) {
                            this.f23761a.put(put, enumR);
                        }
                    }
                    this.f23761a.put(name, enumR);
                    this.f23762b.put(str, enumR);
                    this.f23763c.put(enumR, name);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        /* renamed from: e */
        public T b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            T t10 = (Enum) this.f23761a.get(nextString);
            if (t10 == null) {
                return (Enum) this.f23762b.get(nextString);
            }
            return t10;
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, T t10) throws IOException {
            jsonWriter.value(t10 == null ? null : this.f23763c.get(t10));
        }
    }

    class j extends com.google.gson.q<StringBuilder> {
        j() {
        }

        /* renamed from: e */
        public StringBuilder b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuilder(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, StringBuilder sb2) throws IOException {
            jsonWriter.value(sb2 == null ? null : sb2.toString());
        }
    }

    class k extends com.google.gson.q<Class> {
        k() {
        }

        /* renamed from: e */
        public Class b(JsonReader jsonReader) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    class l extends com.google.gson.q<StringBuffer> {
        l() {
        }

        /* renamed from: e */
        public StringBuffer b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuffer(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
            jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    class m extends com.google.gson.q<URL> {
        m() {
        }

        /* renamed from: e */
        public URL b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if ("null".equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, URL url) throws IOException {
            jsonWriter.value(url == null ? null : url.toExternalForm());
        }
    }

    class n extends com.google.gson.q<URI> {
        n() {
        }

        /* renamed from: e */
        public URI b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                String nextString = jsonReader.nextString();
                if ("null".equals(nextString)) {
                    return null;
                }
                return new URI(nextString);
            } catch (URISyntaxException e10) {
                throw new JsonIOException((Throwable) e10);
            }
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, URI uri) throws IOException {
            jsonWriter.value(uri == null ? null : uri.toASCIIString());
        }
    }

    /* renamed from: mg.o$o  reason: collision with other inner class name */
    class C0285o extends com.google.gson.q<InetAddress> {
        C0285o() {
        }

        /* renamed from: e */
        public InetAddress b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return InetAddress.getByName(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
            jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    class p extends com.google.gson.q<UUID> {
        p() {
        }

        /* renamed from: e */
        public UUID b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                return UUID.fromString(nextString);
            } catch (IllegalArgumentException e10) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as UUID; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, UUID uuid) throws IOException {
            jsonWriter.value(uuid == null ? null : uuid.toString());
        }
    }

    class q extends com.google.gson.q<Currency> {
        q() {
        }

        /* renamed from: e */
        public Currency b(JsonReader jsonReader) throws IOException {
            String nextString = jsonReader.nextString();
            try {
                return Currency.getInstance(nextString);
            } catch (IllegalArgumentException e10) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as Currency; at path " + jsonReader.getPreviousPath(), e10);
            }
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Currency currency) throws IOException {
            jsonWriter.value(currency.getCurrencyCode());
        }
    }

    class r extends com.google.gson.q<Calendar> {
        r() {
        }

        /* renamed from: e */
        public Calendar b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String nextName = jsonReader.nextName();
                int nextInt = jsonReader.nextInt();
                if ("year".equals(nextName)) {
                    i10 = nextInt;
                } else if ("month".equals(nextName)) {
                    i11 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i12 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i13 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i14 = nextInt;
                } else if ("second".equals(nextName)) {
                    i15 = nextInt;
                }
            }
            jsonReader.endObject();
            return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Calendar calendar) throws IOException {
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("year");
            jsonWriter.value((long) calendar.get(1));
            jsonWriter.name("month");
            jsonWriter.value((long) calendar.get(2));
            jsonWriter.name("dayOfMonth");
            jsonWriter.value((long) calendar.get(5));
            jsonWriter.name("hourOfDay");
            jsonWriter.value((long) calendar.get(11));
            jsonWriter.name("minute");
            jsonWriter.value((long) calendar.get(12));
            jsonWriter.name("second");
            jsonWriter.value((long) calendar.get(13));
            jsonWriter.endObject();
        }
    }

    class s extends com.google.gson.q<Locale> {
        s() {
        }

        /* renamed from: e */
        public Locale b(JsonReader jsonReader) throws IOException {
            String str;
            String str2;
            String str3 = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), JavaConstant.Dynamic.DEFAULT_NAME);
            if (stringTokenizer.hasMoreElements()) {
                str = stringTokenizer.nextToken();
            } else {
                str = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                str2 = stringTokenizer.nextToken();
            } else {
                str2 = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                str3 = stringTokenizer.nextToken();
            }
            if (str2 == null && str3 == null) {
                return new Locale(str);
            }
            if (str3 == null) {
                return new Locale(str, str2);
            }
            return new Locale(str, str2, str3);
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Locale locale) throws IOException {
            jsonWriter.value(locale == null ? null : locale.toString());
        }
    }

    class t extends com.google.gson.q<com.google.gson.j> {
        t() {
        }

        private com.google.gson.j f(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
            int i10 = a0.f23760a[jsonToken.ordinal()];
            if (i10 == 1) {
                return new com.google.gson.m((Number) new LazilyParsedNumber(jsonReader.nextString()));
            }
            if (i10 == 2) {
                return new com.google.gson.m(jsonReader.nextString());
            }
            if (i10 == 3) {
                return new com.google.gson.m(Boolean.valueOf(jsonReader.nextBoolean()));
            }
            if (i10 == 6) {
                jsonReader.nextNull();
                return com.google.gson.k.f21376a;
            }
            throw new IllegalStateException("Unexpected token: " + jsonToken);
        }

        private com.google.gson.j g(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
            int i10 = a0.f23760a[jsonToken.ordinal()];
            if (i10 == 4) {
                jsonReader.beginArray();
                return new com.google.gson.g();
            } else if (i10 != 5) {
                return null;
            } else {
                jsonReader.beginObject();
                return new com.google.gson.l();
            }
        }

        /* renamed from: e */
        public com.google.gson.j b(JsonReader jsonReader) throws IOException {
            boolean z10;
            if (jsonReader instanceof f) {
                return ((f) jsonReader).b();
            }
            JsonToken peek = jsonReader.peek();
            com.google.gson.j g10 = g(jsonReader, peek);
            if (g10 == null) {
                return f(jsonReader, peek);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (jsonReader.hasNext()) {
                    String str = null;
                    if (g10 instanceof com.google.gson.l) {
                        str = jsonReader.nextName();
                    }
                    JsonToken peek2 = jsonReader.peek();
                    com.google.gson.j g11 = g(jsonReader, peek2);
                    if (g11 != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (g11 == null) {
                        g11 = f(jsonReader, peek2);
                    }
                    if (g10 instanceof com.google.gson.g) {
                        ((com.google.gson.g) g10).n(g11);
                    } else {
                        ((com.google.gson.l) g10).n(str, g11);
                    }
                    if (z10) {
                        arrayDeque.addLast(g10);
                        g10 = g11;
                    }
                } else {
                    if (g10 instanceof com.google.gson.g) {
                        jsonReader.endArray();
                    } else {
                        jsonReader.endObject();
                    }
                    if (arrayDeque.isEmpty()) {
                        return g10;
                    }
                    g10 = (com.google.gson.j) arrayDeque.removeLast();
                }
            }
        }

        /* renamed from: h */
        public void d(JsonWriter jsonWriter, com.google.gson.j jVar) throws IOException {
            if (jVar == null || jVar.i()) {
                jsonWriter.nullValue();
            } else if (jVar.m()) {
                com.google.gson.m f10 = jVar.f();
                if (f10.v()) {
                    jsonWriter.value(f10.r());
                } else if (f10.t()) {
                    jsonWriter.value(f10.n());
                } else {
                    jsonWriter.value(f10.s());
                }
            } else if (jVar.g()) {
                jsonWriter.beginArray();
                Iterator<com.google.gson.j> it = jVar.b().iterator();
                while (it.hasNext()) {
                    d(jsonWriter, it.next());
                }
                jsonWriter.endArray();
            } else if (jVar.j()) {
                jsonWriter.beginObject();
                for (Map.Entry next : jVar.d().o()) {
                    jsonWriter.name((String) next.getKey());
                    d(jsonWriter, (com.google.gson.j) next.getValue());
                }
                jsonWriter.endObject();
            } else {
                throw new IllegalArgumentException("Couldn't write " + jVar.getClass());
            }
        }
    }

    class u implements com.google.gson.r {
        u() {
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [qg.a<T>, qg.a] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> com.google.gson.q<T> a(com.google.gson.d r2, qg.a<T> r3) {
            /*
                r1 = this;
                java.lang.Class<java.lang.Enum> r2 = java.lang.Enum.class
                java.lang.Class r3 = r3.c()
                boolean r0 = r2.isAssignableFrom(r3)
                if (r0 == 0) goto L_0x001f
                if (r3 != r2) goto L_0x000f
                goto L_0x001f
            L_0x000f:
                boolean r2 = r3.isEnum()
                if (r2 != 0) goto L_0x0019
                java.lang.Class r3 = r3.getSuperclass()
            L_0x0019:
                mg.o$i0 r2 = new mg.o$i0
                r2.<init>(r3)
                return r2
            L_0x001f:
                r2 = 0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: mg.o.u.a(com.google.gson.d, qg.a):com.google.gson.q");
        }
    }

    class v extends com.google.gson.q<BitSet> {
        v() {
        }

        /* renamed from: e */
        public BitSet b(JsonReader jsonReader) throws IOException {
            BitSet bitSet = new BitSet();
            jsonReader.beginArray();
            JsonToken peek = jsonReader.peek();
            int i10 = 0;
            while (peek != JsonToken.END_ARRAY) {
                int i11 = a0.f23760a[peek.ordinal()];
                boolean z10 = true;
                if (i11 == 1 || i11 == 2) {
                    int nextInt = jsonReader.nextInt();
                    if (nextInt == 0) {
                        z10 = false;
                    } else if (nextInt != 1) {
                        throw new JsonSyntaxException("Invalid bitset value " + nextInt + ", expected 0 or 1; at path " + jsonReader.getPreviousPath());
                    }
                } else if (i11 == 3) {
                    z10 = jsonReader.nextBoolean();
                } else {
                    throw new JsonSyntaxException("Invalid bitset value type: " + peek + "; at path " + jsonReader.getPath());
                }
                if (z10) {
                    bitSet.set(i10);
                }
                i10++;
                peek = jsonReader.peek();
            }
            jsonReader.endArray();
            return bitSet;
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
            jsonWriter.beginArray();
            int length = bitSet.length();
            for (int i10 = 0; i10 < length; i10++) {
                jsonWriter.value(bitSet.get(i10) ? 1 : 0);
            }
            jsonWriter.endArray();
        }
    }

    class w implements com.google.gson.r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f23766a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f23767b;

        w(Class cls, com.google.gson.q qVar) {
            this.f23766a = cls;
            this.f23767b = qVar;
        }

        public <T> com.google.gson.q<T> a(com.google.gson.d dVar, qg.a<T> aVar) {
            if (aVar.c() == this.f23766a) {
                return this.f23767b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f23766a.getName() + ",adapter=" + this.f23767b + "]";
        }
    }

    class x implements com.google.gson.r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f23768a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f23769b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f23770c;

        x(Class cls, Class cls2, com.google.gson.q qVar) {
            this.f23768a = cls;
            this.f23769b = cls2;
            this.f23770c = qVar;
        }

        public <T> com.google.gson.q<T> a(com.google.gson.d dVar, qg.a<T> aVar) {
            Class<? super T> c10 = aVar.c();
            if (c10 == this.f23768a || c10 == this.f23769b) {
                return this.f23770c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f23769b.getName() + "+" + this.f23768a.getName() + ",adapter=" + this.f23770c + "]";
        }
    }

    class y implements com.google.gson.r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f23771a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f23772b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f23773c;

        y(Class cls, Class cls2, com.google.gson.q qVar) {
            this.f23771a = cls;
            this.f23772b = cls2;
            this.f23773c = qVar;
        }

        public <T> com.google.gson.q<T> a(com.google.gson.d dVar, qg.a<T> aVar) {
            Class<? super T> c10 = aVar.c();
            if (c10 == this.f23771a || c10 == this.f23772b) {
                return this.f23773c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f23771a.getName() + "+" + this.f23772b.getName() + ",adapter=" + this.f23773c + "]";
        }
    }

    class z implements com.google.gson.r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f23774a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f23775b;

        class a extends com.google.gson.q<T1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Class f23776a;

            a(Class cls) {
                this.f23776a = cls;
            }

            public T1 b(JsonReader jsonReader) throws IOException {
                T1 b10 = z.this.f23775b.b(jsonReader);
                if (b10 == null || this.f23776a.isInstance(b10)) {
                    return b10;
                }
                throw new JsonSyntaxException("Expected a " + this.f23776a.getName() + " but was " + b10.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
            }

            public void d(JsonWriter jsonWriter, T1 t12) throws IOException {
                z.this.f23775b.d(jsonWriter, t12);
            }
        }

        z(Class cls, com.google.gson.q qVar) {
            this.f23774a = cls;
            this.f23775b = qVar;
        }

        public <T2> com.google.gson.q<T2> a(com.google.gson.d dVar, qg.a<T2> aVar) {
            Class<? super T2> c10 = aVar.c();
            if (!this.f23774a.isAssignableFrom(c10)) {
                return null;
            }
            return new a(c10);
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f23774a.getName() + ",adapter=" + this.f23775b + "]";
        }
    }

    static {
        com.google.gson.q<Class> a10 = new k().a();
        f23734a = a10;
        f23735b = a(Class.class, a10);
        com.google.gson.q<BitSet> a11 = new v().a();
        f23736c = a11;
        f23737d = a(BitSet.class, a11);
        b0 b0Var = new b0();
        f23738e = b0Var;
        f23740g = b(Boolean.TYPE, Boolean.class, b0Var);
        d0 d0Var = new d0();
        f23741h = d0Var;
        f23742i = b(Byte.TYPE, Byte.class, d0Var);
        e0 e0Var = new e0();
        f23743j = e0Var;
        f23744k = b(Short.TYPE, Short.class, e0Var);
        f0 f0Var = new f0();
        f23745l = f0Var;
        f23746m = b(Integer.TYPE, Integer.class, f0Var);
        com.google.gson.q<AtomicInteger> a12 = new g0().a();
        f23747n = a12;
        f23748o = a(AtomicInteger.class, a12);
        com.google.gson.q<AtomicBoolean> a13 = new h0().a();
        f23749p = a13;
        f23750q = a(AtomicBoolean.class, a13);
        com.google.gson.q<AtomicIntegerArray> a14 = new a().a();
        f23751r = a14;
        f23752s = a(AtomicIntegerArray.class, a14);
        e eVar = new e();
        f23756w = eVar;
        f23757x = b(Character.TYPE, Character.class, eVar);
        f fVar = new f();
        f23758y = fVar;
        C = a(String.class, fVar);
        j jVar = new j();
        D = jVar;
        E = a(StringBuilder.class, jVar);
        l lVar = new l();
        F = lVar;
        G = a(StringBuffer.class, lVar);
        m mVar = new m();
        H = mVar;
        I = a(URL.class, mVar);
        n nVar = new n();
        J = nVar;
        K = a(URI.class, nVar);
        C0285o oVar = new C0285o();
        L = oVar;
        M = d(InetAddress.class, oVar);
        p pVar = new p();
        N = pVar;
        O = a(UUID.class, pVar);
        com.google.gson.q<Currency> a15 = new q().a();
        P = a15;
        Q = a(Currency.class, a15);
        r rVar = new r();
        R = rVar;
        S = c(Calendar.class, GregorianCalendar.class, rVar);
        s sVar = new s();
        T = sVar;
        U = a(Locale.class, sVar);
        t tVar = new t();
        V = tVar;
        W = d(com.google.gson.j.class, tVar);
    }

    public static <TT> com.google.gson.r a(Class<TT> cls, com.google.gson.q<TT> qVar) {
        return new w(cls, qVar);
    }

    public static <TT> com.google.gson.r b(Class<TT> cls, Class<TT> cls2, com.google.gson.q<? super TT> qVar) {
        return new x(cls, cls2, qVar);
    }

    public static <TT> com.google.gson.r c(Class<TT> cls, Class<? extends TT> cls2, com.google.gson.q<? super TT> qVar) {
        return new y(cls, cls2, qVar);
    }

    public static <T1> com.google.gson.r d(Class<T1> cls, com.google.gson.q<T1> qVar) {
        return new z(cls, qVar);
    }
}
