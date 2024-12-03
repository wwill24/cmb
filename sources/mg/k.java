package mg;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.f;
import com.google.gson.internal.h;
import com.google.gson.internal.i;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class k implements r {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.internal.b f23697a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.gson.c f23698b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.gson.internal.c f23699c;

    /* renamed from: d  reason: collision with root package name */
    private final e f23700d;

    /* renamed from: e  reason: collision with root package name */
    private final List<ReflectionAccessFilter> f23701e;

    class a extends c {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f23702f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Method f23703g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f23704h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ q f23705i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ com.google.gson.d f23706j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ qg.a f23707k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ boolean f23708l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ boolean f23709m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, Field field, boolean z10, boolean z11, boolean z12, Method method, boolean z13, q qVar, com.google.gson.d dVar, qg.a aVar, boolean z14, boolean z15) {
            super(str, field, z10, z11);
            this.f23702f = z12;
            this.f23703g = method;
            this.f23704h = z13;
            this.f23705i = qVar;
            this.f23706j = dVar;
            this.f23707k = aVar;
            this.f23708l = z14;
            this.f23709m = z15;
        }

        /* access modifiers changed from: package-private */
        public void a(JsonReader jsonReader, int i10, Object[] objArr) throws IOException, JsonParseException {
            Object b10 = this.f23705i.b(jsonReader);
            if (b10 != null || !this.f23708l) {
                objArr[i10] = b10;
                return;
            }
            throw new JsonParseException("null is not allowed as value for record component '" + this.f23714c + "' of primitive type; at path " + jsonReader.getPath());
        }

        /* access modifiers changed from: package-private */
        public void b(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
            Object b10 = this.f23705i.b(jsonReader);
            if (b10 != null || !this.f23708l) {
                if (this.f23702f) {
                    k.c(obj, this.f23713b);
                } else if (this.f23709m) {
                    String g10 = og.a.g(this.f23713b, false);
                    throw new JsonIOException("Cannot set value of 'static final' " + g10);
                }
                this.f23713b.set(obj, b10);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
            Object obj2;
            q qVar;
            if (this.f23715d) {
                if (this.f23702f) {
                    Method method = this.f23703g;
                    if (method == null) {
                        k.c(obj, this.f23713b);
                    } else {
                        k.c(obj, method);
                    }
                }
                Method method2 = this.f23703g;
                if (method2 != null) {
                    try {
                        obj2 = method2.invoke(obj, new Object[0]);
                    } catch (InvocationTargetException e10) {
                        String g10 = og.a.g(this.f23703g, false);
                        throw new JsonIOException("Accessor " + g10 + " threw exception", e10.getCause());
                    }
                } else {
                    obj2 = this.f23713b.get(obj);
                }
                if (obj2 != obj) {
                    jsonWriter.name(this.f23712a);
                    if (this.f23704h) {
                        qVar = this.f23705i;
                    } else {
                        qVar = new n(this.f23706j, this.f23705i, this.f23707k.d());
                    }
                    qVar.d(jsonWriter, obj2);
                }
            }
        }
    }

    public static abstract class b<T, A> extends q<T> {

        /* renamed from: a  reason: collision with root package name */
        final Map<String, c> f23711a;

        b(Map<String, c> map) {
            this.f23711a = map;
        }

        public T b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Object e10 = e();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    c cVar = this.f23711a.get(jsonReader.nextName());
                    if (cVar != null) {
                        if (cVar.f23716e) {
                            g(e10, jsonReader, cVar);
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return f(e10);
            } catch (IllegalStateException e11) {
                throw new JsonSyntaxException((Throwable) e11);
            } catch (IllegalAccessException e12) {
                throw og.a.e(e12);
            }
        }

        public void d(JsonWriter jsonWriter, T t10) throws IOException {
            if (t10 == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (c c10 : this.f23711a.values()) {
                    c10.c(jsonWriter, t10);
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e10) {
                throw og.a.e(e10);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract A e();

        /* access modifiers changed from: package-private */
        public abstract T f(A a10);

        /* access modifiers changed from: package-private */
        public abstract void g(A a10, JsonReader jsonReader, c cVar) throws IllegalAccessException, IOException;
    }

    static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final String f23712a;

        /* renamed from: b  reason: collision with root package name */
        final Field f23713b;

        /* renamed from: c  reason: collision with root package name */
        final String f23714c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f23715d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f23716e;

        protected c(String str, Field field, boolean z10, boolean z11) {
            this.f23712a = str;
            this.f23713b = field;
            this.f23714c = field.getName();
            this.f23715d = z10;
            this.f23716e = z11;
        }

        /* access modifiers changed from: package-private */
        public abstract void a(JsonReader jsonReader, int i10, Object[] objArr) throws IOException, JsonParseException;

        /* access modifiers changed from: package-private */
        public abstract void b(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract void c(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;
    }

    private static final class d<T> extends b<T, T> {

        /* renamed from: b  reason: collision with root package name */
        private final f<T> f23717b;

        d(f<T> fVar, Map<String, c> map) {
            super(map);
            this.f23717b = fVar;
        }

        /* access modifiers changed from: package-private */
        public T e() {
            return this.f23717b.a();
        }

        /* access modifiers changed from: package-private */
        public T f(T t10) {
            return t10;
        }

        /* access modifiers changed from: package-private */
        public void g(T t10, JsonReader jsonReader, c cVar) throws IllegalAccessException, IOException {
            cVar.b(jsonReader, t10);
        }
    }

    private static final class e<T> extends b<T, Object[]> {

        /* renamed from: e  reason: collision with root package name */
        static final Map<Class<?>, Object> f23718e = j();

        /* renamed from: b  reason: collision with root package name */
        private final Constructor<T> f23719b;

        /* renamed from: c  reason: collision with root package name */
        private final Object[] f23720c;

        /* renamed from: d  reason: collision with root package name */
        private final Map<String, Integer> f23721d = new HashMap();

        e(Class<T> cls, Map<String, c> map, boolean z10) {
            super(map);
            Constructor<T> i10 = og.a.i(cls);
            this.f23719b = i10;
            if (z10) {
                k.c((Object) null, i10);
            } else {
                og.a.l(i10);
            }
            String[] j10 = og.a.j(cls);
            for (int i11 = 0; i11 < j10.length; i11++) {
                this.f23721d.put(j10[i11], Integer.valueOf(i11));
            }
            Class[] parameterTypes = this.f23719b.getParameterTypes();
            this.f23720c = new Object[parameterTypes.length];
            for (int i12 = 0; i12 < parameterTypes.length; i12++) {
                this.f23720c[i12] = f23718e.get(parameterTypes[i12]);
            }
        }

        private static Map<Class<?>, Object> j() {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf(0.0d));
            hashMap.put(Character.TYPE, 0);
            hashMap.put(Boolean.TYPE, Boolean.FALSE);
            return hashMap;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public Object[] e() {
            return (Object[]) this.f23720c.clone();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public T f(Object[] objArr) {
            try {
                return this.f23719b.newInstance(objArr);
            } catch (IllegalAccessException e10) {
                throw og.a.e(e10);
            } catch (IllegalArgumentException | InstantiationException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + og.a.c(this.f23719b) + "' with args " + Arrays.toString(objArr), e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke constructor '" + og.a.c(this.f23719b) + "' with args " + Arrays.toString(objArr), e12.getCause());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void g(Object[] objArr, JsonReader jsonReader, c cVar) throws IOException {
            Integer num = this.f23721d.get(cVar.f23714c);
            if (num != null) {
                cVar.a(jsonReader, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + og.a.c(this.f23719b) + "' for field with name '" + cVar.f23714c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public k(com.google.gson.internal.b bVar, com.google.gson.c cVar, com.google.gson.internal.c cVar2, e eVar, List<ReflectionAccessFilter> list) {
        this.f23697a = bVar;
        this.f23698b = cVar;
        this.f23699c = cVar2;
        this.f23700d = eVar;
        this.f23701e = list;
    }

    /* access modifiers changed from: private */
    public static <M extends AccessibleObject & Member> void c(Object obj, M m10) {
        if (Modifier.isStatic(((Member) m10).getModifiers())) {
            obj = null;
        }
        if (!i.a(m10, obj)) {
            String g10 = og.a.g(m10, true);
            throw new JsonIOException(g10 + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
        }
    }

    private c d(com.google.gson.d dVar, Field field, Method method, String str, qg.a<?> aVar, boolean z10, boolean z11, boolean z12) {
        boolean z13;
        boolean z14;
        q<?> qVar;
        com.google.gson.d dVar2 = dVar;
        qg.a<?> aVar2 = aVar;
        boolean a10 = h.a(aVar.c());
        int modifiers = field.getModifiers();
        if (!Modifier.isStatic(modifiers) || !Modifier.isFinal(modifiers)) {
            z13 = false;
        } else {
            z13 = true;
        }
        lg.b bVar = (lg.b) field.getAnnotation(lg.b.class);
        q<?> qVar2 = null;
        if (bVar != null) {
            qVar2 = this.f23700d.b(this.f23697a, dVar2, aVar2, bVar);
        }
        if (qVar2 != null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (qVar2 == null) {
            qVar = dVar2.o(aVar2);
        } else {
            qVar = qVar2;
        }
        return new a(str, field, z10, z11, z12, method, z14, qVar, dVar, aVar, a10, z13);
    }

    private Map<String, c> e(com.google.gson.d dVar, qg.a<?> aVar, Class<?> cls, boolean z10, boolean z11) {
        boolean z12;
        int i10;
        int i11;
        Method method;
        boolean z13;
        boolean z14;
        k kVar = this;
        Class<?> cls2 = cls;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        qg.a<?> aVar2 = aVar;
        boolean z15 = z10;
        Class<? super Object> cls3 = cls2;
        while (cls3 != Object.class) {
            Field[] declaredFields = cls3.getDeclaredFields();
            boolean z16 = true;
            boolean z17 = false;
            if (cls3 != cls2 && declaredFields.length > 0) {
                ReflectionAccessFilter.FilterResult b10 = i.b(kVar.f23701e, cls3);
                if (b10 == ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
                    throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + cls3 + " (supertype of " + cls2 + "). Register a TypeAdapter for this type or adjust the access filter.");
                } else if (b10 == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) {
                    z15 = true;
                } else {
                    z15 = false;
                }
            }
            boolean z18 = z15;
            int length = declaredFields.length;
            int i12 = 0;
            while (i12 < length) {
                Field field = declaredFields[i12];
                boolean g10 = kVar.g(field, z16);
                boolean g11 = kVar.g(field, z17);
                if (g10 || g11) {
                    c cVar = null;
                    if (!z11) {
                        z13 = g11;
                        method = null;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        z13 = z17;
                    } else {
                        Method h10 = og.a.h(cls3, field);
                        if (!z18) {
                            og.a.l(h10);
                        }
                        if (h10.getAnnotation(lg.c.class) == null || field.getAnnotation(lg.c.class) != null) {
                            z13 = g11;
                            method = h10;
                        } else {
                            throw new JsonIOException("@SerializedName on " + og.a.g(h10, z17) + " is not supported");
                        }
                    }
                    if (!z18 && method == null) {
                        og.a.l(field);
                    }
                    Type o10 = C$Gson$Types.o(aVar2.d(), cls3, field.getGenericType());
                    List<String> f10 = kVar.f(field);
                    int size = f10.size();
                    int i13 = z17;
                    while (i13 < size) {
                        String str = f10.get(i13);
                        if (i13 != 0) {
                            z14 = z17;
                        } else {
                            z14 = g10;
                        }
                        int i14 = i13;
                        c cVar2 = cVar;
                        int i15 = size;
                        List<String> list = f10;
                        Field field2 = field;
                        int i16 = i12;
                        int i17 = length;
                        boolean z19 = z17;
                        c cVar3 = (c) linkedHashMap.put(str, d(dVar, field, method, str, qg.a.b(o10), z14, z13, z18));
                        if (cVar2 == null) {
                            cVar = cVar3;
                        } else {
                            cVar = cVar2;
                        }
                        i13 = i14 + 1;
                        g10 = z14;
                        i12 = i16;
                        size = i15;
                        f10 = list;
                        field = field2;
                        length = i17;
                        z17 = z19;
                    }
                    c cVar4 = cVar;
                    Field field3 = field;
                    i11 = i12;
                    i10 = length;
                    z12 = z17;
                    if (cVar4 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + cVar4.f23712a + "'; conflict is caused by fields " + og.a.f(cVar4.f23713b) + " and " + og.a.f(field3));
                    }
                } else {
                    i11 = i12;
                    i10 = length;
                    z12 = z17;
                }
                i12 = i11 + 1;
                z16 = true;
                kVar = this;
                length = i10;
                z17 = z12;
            }
            aVar2 = qg.a.b(C$Gson$Types.o(aVar2.d(), cls3, cls3.getGenericSuperclass()));
            cls3 = aVar2.c();
            kVar = this;
            z15 = z18;
        }
        return linkedHashMap;
    }

    private List<String> f(Field field) {
        lg.c cVar = (lg.c) field.getAnnotation(lg.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f23698b.a(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        Collections.addAll(arrayList, alternate);
        return arrayList;
    }

    private boolean g(Field field, boolean z10) {
        return !this.f23699c.c(field.getType(), z10) && !this.f23699c.h(field, z10);
    }

    public <T> q<T> a(com.google.gson.d dVar, qg.a<T> aVar) {
        boolean z10;
        Class<? super T> c10 = aVar.c();
        if (!Object.class.isAssignableFrom(c10)) {
            return null;
        }
        ReflectionAccessFilter.FilterResult b10 = i.b(this.f23701e, c10);
        if (b10 != ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
            if (b10 == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z11 = z10;
            if (og.a.k(c10)) {
                return new e(c10, e(dVar, aVar, c10, z11, true), z11);
            }
            return new d(this.f23697a.b(aVar), e(dVar, aVar, c10, z11, false));
        }
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + c10 + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
