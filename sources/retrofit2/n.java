package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import okhttp3.s;
import okhttp3.w;
import okhttp3.z;

abstract class n<T> {

    class a extends n<Iterable<T>> {
        a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void a(p pVar, Iterable<T> iterable) throws IOException {
            if (iterable != null) {
                for (T a10 : iterable) {
                    n.this.a(pVar, a10);
                }
            }
        }
    }

    class b extends n<Object> {
        b() {
        }

        /* access modifiers changed from: package-private */
        public void a(p pVar, Object obj) throws IOException {
            if (obj != null) {
                int length = Array.getLength(obj);
                for (int i10 = 0; i10 < length; i10++) {
                    n.this.a(pVar, Array.get(obj, i10));
                }
            }
        }
    }

    static final class c<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Method f42316a;

        /* renamed from: b  reason: collision with root package name */
        private final int f42317b;

        /* renamed from: c  reason: collision with root package name */
        private final f<T, z> f42318c;

        c(Method method, int i10, f<T, z> fVar) {
            this.f42316a = method;
            this.f42317b = i10;
            this.f42318c = fVar;
        }

        /* access modifiers changed from: package-private */
        public void a(p pVar, T t10) {
            if (t10 != null) {
                try {
                    pVar.l(this.f42318c.convert(t10));
                } catch (IOException e10) {
                    Method method = this.f42316a;
                    int i10 = this.f42317b;
                    throw w.p(method, e10, i10, "Unable to convert " + t10 + " to RequestBody", new Object[0]);
                }
            } else {
                throw w.o(this.f42316a, this.f42317b, "Body parameter value must not be null.", new Object[0]);
            }
        }
    }

    static final class d<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f42319a;

        /* renamed from: b  reason: collision with root package name */
        private final f<T, String> f42320b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f42321c;

        d(String str, f<T, String> fVar, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.f42319a = str;
            this.f42320b = fVar;
            this.f42321c = z10;
        }

        /* access modifiers changed from: package-private */
        public void a(p pVar, T t10) throws IOException {
            String convert;
            if (t10 != null && (convert = this.f42320b.convert(t10)) != null) {
                pVar.a(this.f42319a, convert, this.f42321c);
            }
        }
    }

    static final class e<T> extends n<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        private final Method f42322a;

        /* renamed from: b  reason: collision with root package name */
        private final int f42323b;

        /* renamed from: c  reason: collision with root package name */
        private final f<T, String> f42324c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f42325d;

        e(Method method, int i10, f<T, String> fVar, boolean z10) {
            this.f42322a = method;
            this.f42323b = i10;
            this.f42324c = fVar;
            this.f42325d = z10;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void a(p pVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            String convert = this.f42324c.convert(value);
                            if (convert != null) {
                                pVar.a(str, convert, this.f42325d);
                            } else {
                                Method method = this.f42322a;
                                int i10 = this.f42323b;
                                throw w.o(method, i10, "Field map value '" + value + "' converted to null by " + this.f42324c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                            }
                        } else {
                            Method method2 = this.f42322a;
                            int i11 = this.f42323b;
                            throw w.o(method2, i11, "Field map contained null value for key '" + str + "'.", new Object[0]);
                        }
                    } else {
                        throw w.o(this.f42322a, this.f42323b, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw w.o(this.f42322a, this.f42323b, "Field map was null.", new Object[0]);
        }
    }

    static final class f<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f42326a;

        /* renamed from: b  reason: collision with root package name */
        private final f<T, String> f42327b;

        f(String str, f<T, String> fVar) {
            Objects.requireNonNull(str, "name == null");
            this.f42326a = str;
            this.f42327b = fVar;
        }

        /* access modifiers changed from: package-private */
        public void a(p pVar, T t10) throws IOException {
            String convert;
            if (t10 != null && (convert = this.f42327b.convert(t10)) != null) {
                pVar.b(this.f42326a, convert);
            }
        }
    }

    static final class g<T> extends n<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        private final Method f42328a;

        /* renamed from: b  reason: collision with root package name */
        private final int f42329b;

        /* renamed from: c  reason: collision with root package name */
        private final f<T, String> f42330c;

        g(Method method, int i10, f<T, String> fVar) {
            this.f42328a = method;
            this.f42329b = i10;
            this.f42330c = fVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void a(p pVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            pVar.b(str, this.f42330c.convert(value));
                        } else {
                            Method method = this.f42328a;
                            int i10 = this.f42329b;
                            throw w.o(method, i10, "Header map contained null value for key '" + str + "'.", new Object[0]);
                        }
                    } else {
                        throw w.o(this.f42328a, this.f42329b, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw w.o(this.f42328a, this.f42329b, "Header map was null.", new Object[0]);
        }
    }

    static final class h extends n<s> {

        /* renamed from: a  reason: collision with root package name */
        private final Method f42331a;

        /* renamed from: b  reason: collision with root package name */
        private final int f42332b;

        h(Method method, int i10) {
            this.f42331a = method;
            this.f42332b = i10;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void a(p pVar, s sVar) {
            if (sVar != null) {
                pVar.c(sVar);
                return;
            }
            throw w.o(this.f42331a, this.f42332b, "Headers parameter must not be null.", new Object[0]);
        }
    }

    static final class i<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Method f42333a;

        /* renamed from: b  reason: collision with root package name */
        private final int f42334b;

        /* renamed from: c  reason: collision with root package name */
        private final s f42335c;

        /* renamed from: d  reason: collision with root package name */
        private final f<T, z> f42336d;

        i(Method method, int i10, s sVar, f<T, z> fVar) {
            this.f42333a = method;
            this.f42334b = i10;
            this.f42335c = sVar;
            this.f42336d = fVar;
        }

        /* access modifiers changed from: package-private */
        public void a(p pVar, T t10) {
            if (t10 != null) {
                try {
                    pVar.d(this.f42335c, this.f42336d.convert(t10));
                } catch (IOException e10) {
                    Method method = this.f42333a;
                    int i10 = this.f42334b;
                    throw w.o(method, i10, "Unable to convert " + t10 + " to RequestBody", e10);
                }
            }
        }
    }

    static final class j<T> extends n<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        private final Method f42337a;

        /* renamed from: b  reason: collision with root package name */
        private final int f42338b;

        /* renamed from: c  reason: collision with root package name */
        private final f<T, z> f42339c;

        /* renamed from: d  reason: collision with root package name */
        private final String f42340d;

        j(Method method, int i10, f<T, z> fVar, String str) {
            this.f42337a = method;
            this.f42338b = i10;
            this.f42339c = fVar;
            this.f42340d = str;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void a(p pVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            pVar.d(s.m("Content-Disposition", "form-data; name=\"" + str + "\"", "Content-Transfer-Encoding", this.f42340d), this.f42339c.convert(value));
                        } else {
                            Method method = this.f42337a;
                            int i10 = this.f42338b;
                            throw w.o(method, i10, "Part map contained null value for key '" + str + "'.", new Object[0]);
                        }
                    } else {
                        throw w.o(this.f42337a, this.f42338b, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw w.o(this.f42337a, this.f42338b, "Part map was null.", new Object[0]);
        }
    }

    static final class k<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Method f42341a;

        /* renamed from: b  reason: collision with root package name */
        private final int f42342b;

        /* renamed from: c  reason: collision with root package name */
        private final String f42343c;

        /* renamed from: d  reason: collision with root package name */
        private final f<T, String> f42344d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f42345e;

        k(Method method, int i10, String str, f<T, String> fVar, boolean z10) {
            this.f42341a = method;
            this.f42342b = i10;
            Objects.requireNonNull(str, "name == null");
            this.f42343c = str;
            this.f42344d = fVar;
            this.f42345e = z10;
        }

        /* access modifiers changed from: package-private */
        public void a(p pVar, T t10) throws IOException {
            if (t10 != null) {
                pVar.f(this.f42343c, this.f42344d.convert(t10), this.f42345e);
                return;
            }
            Method method = this.f42341a;
            int i10 = this.f42342b;
            throw w.o(method, i10, "Path parameter \"" + this.f42343c + "\" value must not be null.", new Object[0]);
        }
    }

    static final class l<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f42346a;

        /* renamed from: b  reason: collision with root package name */
        private final f<T, String> f42347b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f42348c;

        l(String str, f<T, String> fVar, boolean z10) {
            Objects.requireNonNull(str, "name == null");
            this.f42346a = str;
            this.f42347b = fVar;
            this.f42348c = z10;
        }

        /* access modifiers changed from: package-private */
        public void a(p pVar, T t10) throws IOException {
            String convert;
            if (t10 != null && (convert = this.f42347b.convert(t10)) != null) {
                pVar.g(this.f42346a, convert, this.f42348c);
            }
        }
    }

    static final class m<T> extends n<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        private final Method f42349a;

        /* renamed from: b  reason: collision with root package name */
        private final int f42350b;

        /* renamed from: c  reason: collision with root package name */
        private final f<T, String> f42351c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f42352d;

        m(Method method, int i10, f<T, String> fVar, boolean z10) {
            this.f42349a = method;
            this.f42350b = i10;
            this.f42351c = fVar;
            this.f42352d = z10;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void a(p pVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            String convert = this.f42351c.convert(value);
                            if (convert != null) {
                                pVar.g(str, convert, this.f42352d);
                            } else {
                                Method method = this.f42349a;
                                int i10 = this.f42350b;
                                throw w.o(method, i10, "Query map value '" + value + "' converted to null by " + this.f42351c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                            }
                        } else {
                            Method method2 = this.f42349a;
                            int i11 = this.f42350b;
                            throw w.o(method2, i11, "Query map contained null value for key '" + str + "'.", new Object[0]);
                        }
                    } else {
                        throw w.o(this.f42349a, this.f42350b, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw w.o(this.f42349a, this.f42350b, "Query map was null", new Object[0]);
        }
    }

    /* renamed from: retrofit2.n$n  reason: collision with other inner class name */
    static final class C0517n<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        private final f<T, String> f42353a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f42354b;

        C0517n(f<T, String> fVar, boolean z10) {
            this.f42353a = fVar;
            this.f42354b = z10;
        }

        /* access modifiers changed from: package-private */
        public void a(p pVar, T t10) throws IOException {
            if (t10 != null) {
                pVar.g(this.f42353a.convert(t10), (String) null, this.f42354b);
            }
        }
    }

    static final class o extends n<w.c> {

        /* renamed from: a  reason: collision with root package name */
        static final o f42355a = new o();

        private o() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void a(p pVar, w.c cVar) {
            if (cVar != null) {
                pVar.e(cVar);
            }
        }
    }

    static final class p extends n<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Method f42356a;

        /* renamed from: b  reason: collision with root package name */
        private final int f42357b;

        p(Method method, int i10) {
            this.f42356a = method;
            this.f42357b = i10;
        }

        /* access modifiers changed from: package-private */
        public void a(p pVar, Object obj) {
            if (obj != null) {
                pVar.m(obj);
                return;
            }
            throw w.o(this.f42356a, this.f42357b, "@Url parameter is null.", new Object[0]);
        }
    }

    static final class q<T> extends n<T> {

        /* renamed from: a  reason: collision with root package name */
        final Class<T> f42358a;

        q(Class<T> cls) {
            this.f42358a = cls;
        }

        /* access modifiers changed from: package-private */
        public void a(p pVar, T t10) {
            pVar.h(this.f42358a, t10);
        }
    }

    n() {
    }

    /* access modifiers changed from: package-private */
    public abstract void a(p pVar, T t10) throws IOException;

    /* access modifiers changed from: package-private */
    public final n<Object> b() {
        return new b();
    }

    /* access modifiers changed from: package-private */
    public final n<Iterable<T>> c() {
        return new a();
    }
}
