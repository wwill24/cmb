package com.squareup.moshi;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.asm.Advice;

final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final h.e f23030a = new c();

    /* renamed from: b  reason: collision with root package name */
    static final h<Boolean> f23031b = new d();

    /* renamed from: c  reason: collision with root package name */
    static final h<Byte> f23032c = new e();

    /* renamed from: d  reason: collision with root package name */
    static final h<Character> f23033d = new f();

    /* renamed from: e  reason: collision with root package name */
    static final h<Double> f23034e = new g();

    /* renamed from: f  reason: collision with root package name */
    static final h<Float> f23035f = new h();

    /* renamed from: g  reason: collision with root package name */
    static final h<Integer> f23036g = new i();

    /* renamed from: h  reason: collision with root package name */
    static final h<Long> f23037h = new j();

    /* renamed from: i  reason: collision with root package name */
    static final h<Short> f23038i = new k();

    /* renamed from: j  reason: collision with root package name */
    static final h<String> f23039j = new a();

    class a extends h<String> {
        a() {
        }

        /* renamed from: a */
        public String fromJson(JsonReader jsonReader) throws IOException {
            return jsonReader.y();
        }

        /* renamed from: b */
        public void toJson(q qVar, String str) throws IOException {
            qVar.S(str);
        }

        public String toString() {
            return "JsonAdapter(String)";
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23040a;

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
                f23040a = r0
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23040a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23040a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23040a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f23040a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f23040a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.u.b.<clinit>():void");
        }
    }

    class c implements h.e {
        c() {
        }

        public h<?> create(Type type, Set<? extends Annotation> set, s sVar) {
            if (!set.isEmpty()) {
                return null;
            }
            if (type == Boolean.TYPE) {
                return u.f23031b;
            }
            if (type == Byte.TYPE) {
                return u.f23032c;
            }
            if (type == Character.TYPE) {
                return u.f23033d;
            }
            if (type == Double.TYPE) {
                return u.f23034e;
            }
            if (type == Float.TYPE) {
                return u.f23035f;
            }
            if (type == Integer.TYPE) {
                return u.f23036g;
            }
            if (type == Long.TYPE) {
                return u.f23037h;
            }
            if (type == Short.TYPE) {
                return u.f23038i;
            }
            if (type == Boolean.class) {
                return u.f23031b.nullSafe();
            }
            if (type == Byte.class) {
                return u.f23032c.nullSafe();
            }
            if (type == Character.class) {
                return u.f23033d.nullSafe();
            }
            if (type == Double.class) {
                return u.f23034e.nullSafe();
            }
            if (type == Float.class) {
                return u.f23035f.nullSafe();
            }
            if (type == Integer.class) {
                return u.f23036g.nullSafe();
            }
            if (type == Long.class) {
                return u.f23037h.nullSafe();
            }
            if (type == Short.class) {
                return u.f23038i.nullSafe();
            }
            if (type == String.class) {
                return u.f23039j.nullSafe();
            }
            if (type == Object.class) {
                return new m(sVar).nullSafe();
            }
            Class<?> g10 = w.g(type);
            h<?> d10 = bi.c.d(sVar, type, g10);
            if (d10 != null) {
                return d10;
            }
            if (g10.isEnum()) {
                return new l(g10).nullSafe();
            }
            return null;
        }
    }

    class d extends h<Boolean> {
        d() {
        }

        /* renamed from: a */
        public Boolean fromJson(JsonReader jsonReader) throws IOException {
            return Boolean.valueOf(jsonReader.k());
        }

        /* renamed from: b */
        public void toJson(q qVar, Boolean bool) throws IOException {
            qVar.Y(bool.booleanValue());
        }

        public String toString() {
            return "JsonAdapter(Boolean)";
        }
    }

    class e extends h<Byte> {
        e() {
        }

        /* renamed from: a */
        public Byte fromJson(JsonReader jsonReader) throws IOException {
            return Byte.valueOf((byte) u.a(jsonReader, "a byte", -128, 255));
        }

        /* renamed from: b */
        public void toJson(q qVar, Byte b10) throws IOException {
            qVar.N((long) (b10.intValue() & 255));
        }

        public String toString() {
            return "JsonAdapter(Byte)";
        }
    }

    class f extends h<Character> {
        f() {
        }

        /* renamed from: a */
        public Character fromJson(JsonReader jsonReader) throws IOException {
            String y10 = jsonReader.y();
            if (y10.length() <= 1) {
                return Character.valueOf(y10.charAt(0));
            }
            throw new JsonDataException(String.format("Expected %s but was %s at path %s", new Object[]{"a char", '\"' + y10 + '\"', jsonReader.getPath()}));
        }

        /* renamed from: b */
        public void toJson(q qVar, Character ch2) throws IOException {
            qVar.S(ch2.toString());
        }

        public String toString() {
            return "JsonAdapter(Character)";
        }
    }

    class g extends h<Double> {
        g() {
        }

        /* renamed from: a */
        public Double fromJson(JsonReader jsonReader) throws IOException {
            return Double.valueOf(jsonReader.l());
        }

        /* renamed from: b */
        public void toJson(q qVar, Double d10) throws IOException {
            qVar.L(d10.doubleValue());
        }

        public String toString() {
            return "JsonAdapter(Double)";
        }
    }

    class h extends h<Float> {
        h() {
        }

        /* renamed from: a */
        public Float fromJson(JsonReader jsonReader) throws IOException {
            float l10 = (float) jsonReader.l();
            if (jsonReader.h() || !Float.isInfinite(l10)) {
                return Float.valueOf(l10);
            }
            throw new JsonDataException("JSON forbids NaN and infinities: " + l10 + " at path " + jsonReader.getPath());
        }

        /* renamed from: b */
        public void toJson(q qVar, Float f10) throws IOException {
            f10.getClass();
            qVar.P(f10);
        }

        public String toString() {
            return "JsonAdapter(Float)";
        }
    }

    class i extends h<Integer> {
        i() {
        }

        /* renamed from: a */
        public Integer fromJson(JsonReader jsonReader) throws IOException {
            return Integer.valueOf(jsonReader.m());
        }

        /* renamed from: b */
        public void toJson(q qVar, Integer num) throws IOException {
            qVar.N((long) num.intValue());
        }

        public String toString() {
            return "JsonAdapter(Integer)";
        }
    }

    class j extends h<Long> {
        j() {
        }

        /* renamed from: a */
        public Long fromJson(JsonReader jsonReader) throws IOException {
            return Long.valueOf(jsonReader.n());
        }

        /* renamed from: b */
        public void toJson(q qVar, Long l10) throws IOException {
            qVar.N(l10.longValue());
        }

        public String toString() {
            return "JsonAdapter(Long)";
        }
    }

    class k extends h<Short> {
        k() {
        }

        /* renamed from: a */
        public Short fromJson(JsonReader jsonReader) throws IOException {
            return Short.valueOf((short) u.a(jsonReader, "a short", -32768, Advice.MethodSizeHandler.UNDEFINED_SIZE));
        }

        /* renamed from: b */
        public void toJson(q qVar, Short sh2) throws IOException {
            qVar.N((long) sh2.intValue());
        }

        public String toString() {
            return "JsonAdapter(Short)";
        }
    }

    static final class l<T extends Enum<T>> extends h<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f23041a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f23042b;

        /* renamed from: c  reason: collision with root package name */
        private final T[] f23043c;

        /* renamed from: d  reason: collision with root package name */
        private final JsonReader.b f23044d;

        l(Class<T> cls) {
            this.f23041a = cls;
            try {
                T[] tArr = (Enum[]) cls.getEnumConstants();
                this.f23043c = tArr;
                this.f23042b = new String[tArr.length];
                int i10 = 0;
                while (true) {
                    T[] tArr2 = this.f23043c;
                    if (i10 < tArr2.length) {
                        String name = tArr2[i10].name();
                        this.f23042b[i10] = bi.c.n(name, cls.getField(name));
                        i10++;
                    } else {
                        this.f23044d = JsonReader.b.a(this.f23042b);
                        return;
                    }
                }
            } catch (NoSuchFieldException e10) {
                throw new AssertionError("Missing field in " + cls.getName(), e10);
            }
        }

        /* renamed from: a */
        public T fromJson(JsonReader jsonReader) throws IOException {
            int N = jsonReader.N(this.f23044d);
            if (N != -1) {
                return this.f23043c[N];
            }
            String path = jsonReader.getPath();
            String y10 = jsonReader.y();
            throw new JsonDataException("Expected one of " + Arrays.asList(this.f23042b) + " but was " + y10 + " at path " + path);
        }

        /* renamed from: b */
        public void toJson(q qVar, T t10) throws IOException {
            qVar.S(this.f23042b[t10.ordinal()]);
        }

        public String toString() {
            return "JsonAdapter(" + this.f23041a.getName() + ")";
        }
    }

    static final class m extends h<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final s f23045a;

        /* renamed from: b  reason: collision with root package name */
        private final h<List> f23046b;

        /* renamed from: c  reason: collision with root package name */
        private final h<Map> f23047c;

        /* renamed from: d  reason: collision with root package name */
        private final h<String> f23048d;

        /* renamed from: e  reason: collision with root package name */
        private final h<Double> f23049e;

        /* renamed from: f  reason: collision with root package name */
        private final h<Boolean> f23050f;

        m(s sVar) {
            this.f23045a = sVar;
            this.f23046b = sVar.c(List.class);
            this.f23047c = sVar.c(Map.class);
            this.f23048d = sVar.c(String.class);
            this.f23049e = sVar.c(Double.class);
            this.f23050f = sVar.c(Boolean.class);
        }

        private Class<?> a(Class<?> cls) {
            if (Map.class.isAssignableFrom(cls)) {
                return Map.class;
            }
            if (Collection.class.isAssignableFrom(cls)) {
                return Collection.class;
            }
            return cls;
        }

        public Object fromJson(JsonReader jsonReader) throws IOException {
            switch (b.f23040a[jsonReader.E().ordinal()]) {
                case 1:
                    return this.f23046b.fromJson(jsonReader);
                case 2:
                    return this.f23047c.fromJson(jsonReader);
                case 3:
                    return this.f23048d.fromJson(jsonReader);
                case 4:
                    return this.f23049e.fromJson(jsonReader);
                case 5:
                    return this.f23050f.fromJson(jsonReader);
                case 6:
                    return jsonReader.v();
                default:
                    throw new IllegalStateException("Expected a value but was " + jsonReader.E() + " at path " + jsonReader.getPath());
            }
        }

        public void toJson(q qVar, Object obj) throws IOException {
            Class<?> cls = obj.getClass();
            if (cls == Object.class) {
                qVar.c();
                qVar.h();
                return;
            }
            this.f23045a.e(a(cls), bi.c.f18956a).toJson(qVar, obj);
        }

        public String toString() {
            return "JsonAdapter(Object)";
        }
    }

    static int a(JsonReader jsonReader, String str, int i10, int i11) throws IOException {
        int m10 = jsonReader.m();
        if (m10 >= i10 && m10 <= i11) {
            return m10;
        }
        throw new JsonDataException(String.format("Expected %s but was %s at path %s", new Object[]{str, Integer.valueOf(m10), jsonReader.getPath()}));
    }
}
