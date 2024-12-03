package kotlin.jvm.internal;

import com.leanplum.internal.Constants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.Var;
import pk.b;
import pk.e;
import pk.f;
import pk.g;
import pk.h;
import pk.i;
import pk.j;
import pk.k;
import pk.l;
import pk.m;
import pk.n;
import pk.o;
import pk.p;
import pk.q;
import pk.r;
import pk.s;
import pk.t;
import wk.c;

public final class d implements c<Object>, c {

    /* renamed from: b  reason: collision with root package name */
    public static final a f32127b = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Map<Class<? extends gk.c<?>>, Integer> f32128c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f32129d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<String, String> f32130e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, String> f32131f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Map<String, String> f32132g;

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f32133a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Class<?> cls) {
            String str;
            j.g(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive() && (str = (String) d.f32131f.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "kotlin.Array";
                }
                return str2;
            }
            String str3 = (String) d.f32131f.get(cls.getName());
            if (str3 == null) {
                return cls.getCanonicalName();
            }
            return str3;
        }

        public final String b(Class<?> cls) {
            String str;
            j.g(cls, "jClass");
            String str2 = null;
            if (!cls.isAnonymousClass()) {
                if (cls.isLocalClass()) {
                    String simpleName = cls.getSimpleName();
                    Method enclosingMethod = cls.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        j.f(simpleName, "name");
                        String N0 = StringsKt__StringsKt.N0(simpleName, enclosingMethod.getName() + '$', (String) null, 2, (Object) null);
                        if (N0 != null) {
                            return N0;
                        }
                    }
                    Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                    if (enclosingConstructor != null) {
                        j.f(simpleName, "name");
                        return StringsKt__StringsKt.N0(simpleName, enclosingConstructor.getName() + '$', (String) null, 2, (Object) null);
                    }
                    j.f(simpleName, "name");
                    return StringsKt__StringsKt.M0(simpleName, '$', (String) null, 2, (Object) null);
                } else if (cls.isArray()) {
                    Class<?> componentType = cls.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) d.f32132g.get(componentType.getName())) != null) {
                        str2 = str + "Array";
                    }
                    if (str2 == null) {
                        return "Array";
                    }
                } else {
                    String str3 = (String) d.f32132g.get(cls.getName());
                    if (str3 == null) {
                        return cls.getSimpleName();
                    }
                    return str3;
                }
            }
            return str2;
        }

        public final boolean c(Object obj, Class<?> cls) {
            j.g(cls, "jClass");
            Map f10 = d.f32128c;
            j.e(f10, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) f10.get(cls);
            if (num != null) {
                return p.i(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = ok.a.b(ok.a.c(cls));
            }
            return cls.isInstance(obj);
        }
    }

    static {
        int i10 = 0;
        List m10 = q.m(Function0.class, Function1.class, Function2.class, n.class, o.class, p.class, q.class, r.class, s.class, t.class, pk.a.class, b.class, pk.c.class, pk.d.class, e.class, f.class, g.class, h.class, i.class, j.class, k.class, l.class, m.class);
        ArrayList arrayList = new ArrayList(r.t(m10, 10));
        for (Object next : m10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                q.s();
            }
            arrayList.add(gk.h.a((Class) next, Integer.valueOf(i10)));
            i10 = i11;
        }
        f32128c = h0.s(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put(Var.JSTYPE_INT, "kotlin.Int");
        hashMap.put(Constants.Kinds.FLOAT, "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f32129d = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f32130e = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put(Validator.BEAN_PARAM, "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        j.f(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("kotlin.jvm.internal.");
            j.f(str, "kotlinName");
            sb2.append(StringsKt__StringsKt.P0(str, '.', (String) null, 2, (Object) null));
            sb2.append("CompanionObject");
            String sb3 = sb2.toString();
            Pair a10 = gk.h.a(sb3, str + ".Companion");
            hashMap3.put(a10.c(), a10.d());
        }
        for (Map.Entry next2 : f32128c.entrySet()) {
            int intValue = ((Number) next2.getValue()).intValue();
            String name = ((Class) next2.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        f32131f = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.e(hashMap3.size()));
        for (Map.Entry entry : hashMap3.entrySet()) {
            linkedHashMap.put(entry.getKey(), StringsKt__StringsKt.P0((String) entry.getValue(), '.', (String) null, 2, (Object) null));
        }
        f32132g = linkedHashMap;
    }

    public d(Class<?> cls) {
        j.g(cls, "jClass");
        this.f32133a = cls;
    }

    public Class<?> c() {
        return this.f32133a;
    }

    public String d() {
        return f32127b.a(c());
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && j.b(ok.a.b(this), ok.a.b((c) obj));
    }

    public String getSimpleName() {
        return f32127b.b(c());
    }

    public int hashCode() {
        return ok.a.b(this).hashCode();
    }

    public boolean isInstance(Object obj) {
        return f32127b.c(obj, c());
    }

    public String toString() {
        return c().toString() + " (Kotlin reflection is not available)";
    }
}
