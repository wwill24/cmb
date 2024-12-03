package retrofit2;

import com.facebook.stetho.server.http.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.c;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okhttp3.w;
import retrofit2.n;
import vn.b;
import vn.d;
import vn.e;
import vn.f;
import vn.g;
import vn.h;
import vn.i;
import vn.j;
import vn.k;
import vn.l;
import vn.m;
import vn.n;
import vn.o;
import vn.p;
import vn.r;
import vn.u;
import vn.x;
import vn.y;

final class q {

    /* renamed from: a  reason: collision with root package name */
    private final Method f42378a;

    /* renamed from: b  reason: collision with root package name */
    private final t f42379b;

    /* renamed from: c  reason: collision with root package name */
    final String f42380c;

    /* renamed from: d  reason: collision with root package name */
    private final String f42381d;

    /* renamed from: e  reason: collision with root package name */
    private final s f42382e;

    /* renamed from: f  reason: collision with root package name */
    private final v f42383f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f42384g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f42385h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f42386i;

    /* renamed from: j  reason: collision with root package name */
    private final n<?>[] f42387j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f42388k;

    static final class a {

        /* renamed from: x  reason: collision with root package name */
        private static final Pattern f42389x = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* renamed from: y  reason: collision with root package name */
        private static final Pattern f42390y = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: a  reason: collision with root package name */
        final s f42391a;

        /* renamed from: b  reason: collision with root package name */
        final Method f42392b;

        /* renamed from: c  reason: collision with root package name */
        final Annotation[] f42393c;

        /* renamed from: d  reason: collision with root package name */
        final Annotation[][] f42394d;

        /* renamed from: e  reason: collision with root package name */
        final Type[] f42395e;

        /* renamed from: f  reason: collision with root package name */
        boolean f42396f;

        /* renamed from: g  reason: collision with root package name */
        boolean f42397g;

        /* renamed from: h  reason: collision with root package name */
        boolean f42398h;

        /* renamed from: i  reason: collision with root package name */
        boolean f42399i;

        /* renamed from: j  reason: collision with root package name */
        boolean f42400j;

        /* renamed from: k  reason: collision with root package name */
        boolean f42401k;

        /* renamed from: l  reason: collision with root package name */
        boolean f42402l;

        /* renamed from: m  reason: collision with root package name */
        boolean f42403m;

        /* renamed from: n  reason: collision with root package name */
        String f42404n;

        /* renamed from: o  reason: collision with root package name */
        boolean f42405o;

        /* renamed from: p  reason: collision with root package name */
        boolean f42406p;

        /* renamed from: q  reason: collision with root package name */
        boolean f42407q;

        /* renamed from: r  reason: collision with root package name */
        String f42408r;

        /* renamed from: s  reason: collision with root package name */
        s f42409s;

        /* renamed from: t  reason: collision with root package name */
        v f42410t;

        /* renamed from: u  reason: collision with root package name */
        Set<String> f42411u;

        /* renamed from: v  reason: collision with root package name */
        n<?>[] f42412v;

        /* renamed from: w  reason: collision with root package name */
        boolean f42413w;

        a(s sVar, Method method) {
            this.f42391a = sVar;
            this.f42392b = method;
            this.f42393c = method.getAnnotations();
            this.f42395e = method.getGenericParameterTypes();
            this.f42394d = method.getParameterAnnotations();
        }

        private static Class<?> a(Class<?> cls) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            if (Short.TYPE == cls) {
                return Short.class;
            }
            return cls;
        }

        private s c(String[] strArr) {
            s.a aVar = new s.a();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw w.m(this.f42392b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if (HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(substring)) {
                    try {
                        this.f42410t = v.e(trim);
                    } catch (IllegalArgumentException e10) {
                        throw w.n(this.f42392b, e10, "Malformed content type: %s", trim);
                    }
                } else {
                    aVar.a(substring, trim);
                }
            }
            return aVar.f();
        }

        private void d(String str, String str2, boolean z10) {
            String str3 = this.f42404n;
            if (str3 == null) {
                this.f42404n = str;
                this.f42405o = z10;
                if (!str2.isEmpty()) {
                    int indexOf = str2.indexOf(63);
                    if (indexOf != -1 && indexOf < str2.length() - 1) {
                        String substring = str2.substring(indexOf + 1);
                        if (f42389x.matcher(substring).find()) {
                            throw w.m(this.f42392b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                        }
                    }
                    this.f42408r = str2;
                    this.f42411u = h(str2);
                    return;
                }
                return;
            }
            throw w.m(this.f42392b, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        private void e(Annotation annotation) {
            if (annotation instanceof b) {
                d(FirebasePerformance.HttpMethod.DELETE, ((b) annotation).value(), false);
            } else if (annotation instanceof f) {
                d("GET", ((f) annotation).value(), false);
            } else if (annotation instanceof g) {
                d(FirebasePerformance.HttpMethod.HEAD, ((g) annotation).value(), false);
            } else if (annotation instanceof n) {
                d(FirebasePerformance.HttpMethod.PATCH, ((n) annotation).value(), true);
            } else if (annotation instanceof o) {
                d("POST", ((o) annotation).value(), true);
            } else if (annotation instanceof p) {
                d(FirebasePerformance.HttpMethod.PUT, ((p) annotation).value(), true);
            } else if (annotation instanceof m) {
                d(FirebasePerformance.HttpMethod.OPTIONS, ((m) annotation).value(), false);
            } else if (annotation instanceof h) {
                h hVar = (h) annotation;
                d(hVar.method(), hVar.path(), hVar.hasBody());
            } else if (annotation instanceof k) {
                String[] value = ((k) annotation).value();
                if (value.length != 0) {
                    this.f42409s = c(value);
                    return;
                }
                throw w.m(this.f42392b, "@Headers annotation is empty.", new Object[0]);
            } else if (annotation instanceof l) {
                if (!this.f42406p) {
                    this.f42407q = true;
                    return;
                }
                throw w.m(this.f42392b, "Only one encoding annotation is allowed.", new Object[0]);
            } else if (!(annotation instanceof e)) {
            } else {
                if (!this.f42407q) {
                    this.f42406p = true;
                    return;
                }
                throw w.m(this.f42392b, "Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        private n<?> f(int i10, Type type, Annotation[] annotationArr, boolean z10) {
            n<?> nVar;
            if (annotationArr != null) {
                nVar = null;
                for (Annotation g10 : annotationArr) {
                    n<?> g11 = g(i10, type, annotationArr, g10);
                    if (g11 != null) {
                        if (nVar == null) {
                            nVar = g11;
                        } else {
                            throw w.o(this.f42392b, i10, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                    }
                }
            } else {
                nVar = null;
            }
            if (nVar != null) {
                return nVar;
            }
            if (z10) {
                try {
                    if (w.h(type) == c.class) {
                        this.f42413w = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw w.o(this.f42392b, i10, "No Retrofit annotation found.", new Object[0]);
        }

        private n<?> g(int i10, Type type, Annotation[] annotationArr, Annotation annotation) {
            Class<String> cls = String.class;
            Class<w.c> cls2 = w.c.class;
            if (annotation instanceof y) {
                j(i10, type);
                if (this.f42403m) {
                    throw w.o(this.f42392b, i10, "Multiple @Url method annotations found.", new Object[0]);
                } else if (this.f42399i) {
                    throw w.o(this.f42392b, i10, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.f42400j) {
                    throw w.o(this.f42392b, i10, "A @Url parameter must not come after a @Query.", new Object[0]);
                } else if (this.f42401k) {
                    throw w.o(this.f42392b, i10, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                } else if (this.f42402l) {
                    throw w.o(this.f42392b, i10, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                } else if (this.f42408r == null) {
                    this.f42403m = true;
                    if (type == t.class || type == cls || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                        return new n.p(this.f42392b, i10);
                    }
                    throw w.o(this.f42392b, i10, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                } else {
                    throw w.o(this.f42392b, i10, "@Url cannot be used with @%s URL", this.f42404n);
                }
            } else if (annotation instanceof vn.s) {
                j(i10, type);
                if (this.f42400j) {
                    throw w.o(this.f42392b, i10, "A @Path parameter must not come after a @Query.", new Object[0]);
                } else if (this.f42401k) {
                    throw w.o(this.f42392b, i10, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                } else if (this.f42402l) {
                    throw w.o(this.f42392b, i10, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                } else if (this.f42403m) {
                    throw w.o(this.f42392b, i10, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.f42408r != null) {
                    this.f42399i = true;
                    vn.s sVar = (vn.s) annotation;
                    String value = sVar.value();
                    i(i10, value);
                    return new n.k(this.f42392b, i10, value, this.f42391a.i(type, annotationArr), sVar.encoded());
                } else {
                    throw w.o(this.f42392b, i10, "@Path can only be used with relative url on @%s", this.f42404n);
                }
            } else if (annotation instanceof vn.t) {
                j(i10, type);
                vn.t tVar = (vn.t) annotation;
                String value2 = tVar.value();
                boolean encoded = tVar.encoded();
                Class<?> h10 = w.h(type);
                this.f42400j = true;
                if (Iterable.class.isAssignableFrom(h10)) {
                    if (type instanceof ParameterizedType) {
                        return new n.l(value2, this.f42391a.i(w.g(0, (ParameterizedType) type), annotationArr), encoded).c();
                    }
                    throw w.o(this.f42392b, i10, h10.getSimpleName() + " must include generic type (e.g., " + h10.getSimpleName() + "<String>)", new Object[0]);
                } else if (!h10.isArray()) {
                    return new n.l(value2, this.f42391a.i(type, annotationArr), encoded);
                } else {
                    return new n.l(value2, this.f42391a.i(a(h10.getComponentType()), annotationArr), encoded).b();
                }
            } else if (annotation instanceof vn.v) {
                j(i10, type);
                boolean encoded2 = ((vn.v) annotation).encoded();
                Class<?> h11 = w.h(type);
                this.f42401k = true;
                if (Iterable.class.isAssignableFrom(h11)) {
                    if (type instanceof ParameterizedType) {
                        return new n.C0517n(this.f42391a.i(w.g(0, (ParameterizedType) type), annotationArr), encoded2).c();
                    }
                    throw w.o(this.f42392b, i10, h11.getSimpleName() + " must include generic type (e.g., " + h11.getSimpleName() + "<String>)", new Object[0]);
                } else if (!h11.isArray()) {
                    return new n.C0517n(this.f42391a.i(type, annotationArr), encoded2);
                } else {
                    return new n.C0517n(this.f42391a.i(a(h11.getComponentType()), annotationArr), encoded2).b();
                }
            } else if (annotation instanceof u) {
                j(i10, type);
                Class<?> h12 = w.h(type);
                this.f42402l = true;
                if (Map.class.isAssignableFrom(h12)) {
                    Type i11 = w.i(type, h12, Map.class);
                    if (i11 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) i11;
                        Type g10 = w.g(0, parameterizedType);
                        if (cls == g10) {
                            return new n.m(this.f42392b, i10, this.f42391a.i(w.g(1, parameterizedType), annotationArr), ((u) annotation).encoded());
                        }
                        throw w.o(this.f42392b, i10, "@QueryMap keys must be of type String: " + g10, new Object[0]);
                    }
                    throw w.o(this.f42392b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw w.o(this.f42392b, i10, "@QueryMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof i) {
                j(i10, type);
                String value3 = ((i) annotation).value();
                Class<?> h13 = w.h(type);
                if (Iterable.class.isAssignableFrom(h13)) {
                    if (type instanceof ParameterizedType) {
                        return new n.f(value3, this.f42391a.i(w.g(0, (ParameterizedType) type), annotationArr)).c();
                    }
                    throw w.o(this.f42392b, i10, h13.getSimpleName() + " must include generic type (e.g., " + h13.getSimpleName() + "<String>)", new Object[0]);
                } else if (!h13.isArray()) {
                    return new n.f(value3, this.f42391a.i(type, annotationArr));
                } else {
                    return new n.f(value3, this.f42391a.i(a(h13.getComponentType()), annotationArr)).b();
                }
            } else if (annotation instanceof j) {
                if (type == s.class) {
                    return new n.h(this.f42392b, i10);
                }
                j(i10, type);
                Class<?> h14 = w.h(type);
                if (Map.class.isAssignableFrom(h14)) {
                    Type i12 = w.i(type, h14, Map.class);
                    if (i12 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) i12;
                        Type g11 = w.g(0, parameterizedType2);
                        if (cls == g11) {
                            return new n.g(this.f42392b, i10, this.f42391a.i(w.g(1, parameterizedType2), annotationArr));
                        }
                        throw w.o(this.f42392b, i10, "@HeaderMap keys must be of type String: " + g11, new Object[0]);
                    }
                    throw w.o(this.f42392b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw w.o(this.f42392b, i10, "@HeaderMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof vn.c) {
                j(i10, type);
                if (this.f42406p) {
                    vn.c cVar = (vn.c) annotation;
                    String value4 = cVar.value();
                    boolean encoded3 = cVar.encoded();
                    this.f42396f = true;
                    Class<?> h15 = w.h(type);
                    if (Iterable.class.isAssignableFrom(h15)) {
                        if (type instanceof ParameterizedType) {
                            return new n.d(value4, this.f42391a.i(w.g(0, (ParameterizedType) type), annotationArr), encoded3).c();
                        }
                        throw w.o(this.f42392b, i10, h15.getSimpleName() + " must include generic type (e.g., " + h15.getSimpleName() + "<String>)", new Object[0]);
                    } else if (!h15.isArray()) {
                        return new n.d(value4, this.f42391a.i(type, annotationArr), encoded3);
                    } else {
                        return new n.d(value4, this.f42391a.i(a(h15.getComponentType()), annotationArr), encoded3).b();
                    }
                } else {
                    throw w.o(this.f42392b, i10, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
            } else if (annotation instanceof d) {
                j(i10, type);
                if (this.f42406p) {
                    Class<?> h16 = w.h(type);
                    if (Map.class.isAssignableFrom(h16)) {
                        Type i13 = w.i(type, h16, Map.class);
                        if (i13 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) i13;
                            Type g12 = w.g(0, parameterizedType3);
                            if (cls == g12) {
                                f i14 = this.f42391a.i(w.g(1, parameterizedType3), annotationArr);
                                this.f42396f = true;
                                return new n.e(this.f42392b, i10, i14, ((d) annotation).encoded());
                            }
                            throw w.o(this.f42392b, i10, "@FieldMap keys must be of type String: " + g12, new Object[0]);
                        }
                        throw w.o(this.f42392b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw w.o(this.f42392b, i10, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw w.o(this.f42392b, i10, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof vn.q) {
                j(i10, type);
                if (this.f42407q) {
                    vn.q qVar = (vn.q) annotation;
                    this.f42397g = true;
                    String value5 = qVar.value();
                    Class<?> h17 = w.h(type);
                    if (!value5.isEmpty()) {
                        s m10 = s.m("Content-Disposition", "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", qVar.encoding());
                        if (Iterable.class.isAssignableFrom(h17)) {
                            if (type instanceof ParameterizedType) {
                                Type g13 = w.g(0, (ParameterizedType) type);
                                if (!cls2.isAssignableFrom(w.h(g13))) {
                                    return new n.i(this.f42392b, i10, m10, this.f42391a.g(g13, annotationArr, this.f42393c)).c();
                                }
                                throw w.o(this.f42392b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                            }
                            throw w.o(this.f42392b, i10, h17.getSimpleName() + " must include generic type (e.g., " + h17.getSimpleName() + "<String>)", new Object[0]);
                        } else if (h17.isArray()) {
                            Class<?> a10 = a(h17.getComponentType());
                            if (!cls2.isAssignableFrom(a10)) {
                                return new n.i(this.f42392b, i10, m10, this.f42391a.g(a10, annotationArr, this.f42393c)).b();
                            }
                            throw w.o(this.f42392b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        } else if (!cls2.isAssignableFrom(h17)) {
                            return new n.i(this.f42392b, i10, m10, this.f42391a.g(type, annotationArr, this.f42393c));
                        } else {
                            throw w.o(this.f42392b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                    } else if (Iterable.class.isAssignableFrom(h17)) {
                        if (!(type instanceof ParameterizedType)) {
                            throw w.o(this.f42392b, i10, h17.getSimpleName() + " must include generic type (e.g., " + h17.getSimpleName() + "<String>)", new Object[0]);
                        } else if (cls2.isAssignableFrom(w.h(w.g(0, (ParameterizedType) type)))) {
                            return n.o.f42355a.c();
                        } else {
                            throw w.o(this.f42392b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                    } else if (h17.isArray()) {
                        if (cls2.isAssignableFrom(h17.getComponentType())) {
                            return n.o.f42355a.b();
                        }
                        throw w.o(this.f42392b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    } else if (cls2.isAssignableFrom(h17)) {
                        return n.o.f42355a;
                    } else {
                        throw w.o(this.f42392b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                } else {
                    throw w.o(this.f42392b, i10, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
            } else if (annotation instanceof r) {
                j(i10, type);
                if (this.f42407q) {
                    this.f42397g = true;
                    Class<?> h18 = w.h(type);
                    if (Map.class.isAssignableFrom(h18)) {
                        Type i15 = w.i(type, h18, Map.class);
                        if (i15 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) i15;
                            Type g14 = w.g(0, parameterizedType4);
                            if (cls == g14) {
                                Type g15 = w.g(1, parameterizedType4);
                                if (!cls2.isAssignableFrom(w.h(g15))) {
                                    return new n.j(this.f42392b, i10, this.f42391a.g(g15, annotationArr, this.f42393c), ((r) annotation).encoding());
                                }
                                throw w.o(this.f42392b, i10, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            throw w.o(this.f42392b, i10, "@PartMap keys must be of type String: " + g14, new Object[0]);
                        }
                        throw w.o(this.f42392b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw w.o(this.f42392b, i10, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw w.o(this.f42392b, i10, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            } else if (annotation instanceof vn.a) {
                j(i10, type);
                if (this.f42406p || this.f42407q) {
                    throw w.o(this.f42392b, i10, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                } else if (!this.f42398h) {
                    try {
                        f g16 = this.f42391a.g(type, annotationArr, this.f42393c);
                        this.f42398h = true;
                        return new n.c(this.f42392b, i10, g16);
                    } catch (RuntimeException e10) {
                        throw w.p(this.f42392b, e10, i10, "Unable to create @Body converter for %s", type);
                    }
                } else {
                    throw w.o(this.f42392b, i10, "Multiple @Body method annotations found.", new Object[0]);
                }
            } else if (!(annotation instanceof x)) {
                return null;
            } else {
                j(i10, type);
                Class<?> h19 = w.h(type);
                int i16 = i10 - 1;
                while (i16 >= 0) {
                    n<?> nVar = this.f42412v[i16];
                    if (!(nVar instanceof n.q) || !((n.q) nVar).f42358a.equals(h19)) {
                        i16--;
                    } else {
                        throw w.o(this.f42392b, i10, "@Tag type " + h19.getName() + " is duplicate of parameter #" + (i16 + 1) + " and would always overwrite its value.", new Object[0]);
                    }
                }
                return new n.q(h19);
            }
        }

        static Set<String> h(String str) {
            Matcher matcher = f42389x.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void i(int i10, String str) {
            if (!f42390y.matcher(str).matches()) {
                throw w.o(this.f42392b, i10, "@Path parameter name must match %s. Found: %s", f42389x.pattern(), str);
            } else if (!this.f42411u.contains(str)) {
                throw w.o(this.f42392b, i10, "URL \"%s\" does not contain \"{%s}\".", this.f42408r, str);
            }
        }

        private void j(int i10, Type type) {
            if (w.j(type)) {
                throw w.o(this.f42392b, i10, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        /* access modifiers changed from: package-private */
        public q b() {
            for (Annotation e10 : this.f42393c) {
                e(e10);
            }
            if (this.f42404n != null) {
                if (!this.f42405o) {
                    if (this.f42407q) {
                        throw w.m(this.f42392b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (this.f42406p) {
                        throw w.m(this.f42392b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.f42394d.length;
                this.f42412v = new n[length];
                int i10 = length - 1;
                int i11 = 0;
                while (true) {
                    boolean z10 = true;
                    if (i11 >= length) {
                        break;
                    }
                    n<?>[] nVarArr = this.f42412v;
                    Type type = this.f42395e[i11];
                    Annotation[] annotationArr = this.f42394d[i11];
                    if (i11 != i10) {
                        z10 = false;
                    }
                    nVarArr[i11] = f(i11, type, annotationArr, z10);
                    i11++;
                }
                if (this.f42408r != null || this.f42403m) {
                    boolean z11 = this.f42406p;
                    if (!z11 && !this.f42407q && !this.f42405o && this.f42398h) {
                        throw w.m(this.f42392b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                    } else if (z11 && !this.f42396f) {
                        throw w.m(this.f42392b, "Form-encoded method must contain at least one @Field.", new Object[0]);
                    } else if (!this.f42407q || this.f42397g) {
                        return new q(this);
                    } else {
                        throw w.m(this.f42392b, "Multipart method must contain at least one @Part.", new Object[0]);
                    }
                } else {
                    throw w.m(this.f42392b, "Missing either @%s URL or @Url parameter.", this.f42404n);
                }
            } else {
                throw w.m(this.f42392b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
        }
    }

    q(a aVar) {
        this.f42378a = aVar.f42392b;
        this.f42379b = aVar.f42391a.f42419c;
        this.f42380c = aVar.f42404n;
        this.f42381d = aVar.f42408r;
        this.f42382e = aVar.f42409s;
        this.f42383f = aVar.f42410t;
        this.f42384g = aVar.f42405o;
        this.f42385h = aVar.f42406p;
        this.f42386i = aVar.f42407q;
        this.f42387j = aVar.f42412v;
        this.f42388k = aVar.f42413w;
    }

    static q b(s sVar, Method method) {
        return new a(sVar, method).b();
    }

    /* access modifiers changed from: package-private */
    public okhttp3.y a(Object[] objArr) throws IOException {
        n<?>[] nVarArr = this.f42387j;
        int length = objArr.length;
        if (length == nVarArr.length) {
            p pVar = new p(this.f42380c, this.f42379b, this.f42381d, this.f42382e, this.f42383f, this.f42384g, this.f42385h, this.f42386i);
            if (this.f42388k) {
                length--;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add(objArr[i10]);
                nVarArr[i10].a(pVar, objArr[i10]);
            }
            return pVar.k().p(k.class, new k(this.f42378a, arrayList)).b();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + nVarArr.length + ")");
    }
}
