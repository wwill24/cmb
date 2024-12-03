package okhttp3;

import bl.d;
import com.google.firebase.analytics.FirebaseAnalytics;
import fl.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.j;
import okhttp3.s;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eBC\b\u0000\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001e\u0012\u0016\u0010%\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0004\b/\u00100J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J%\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0007¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010!\u001a\u0004\u0018\u00010\u001e8\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b\u000e\u0010 R*\u0010%\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010\"8\u0000X\u0004¢\u0006\f\n\u0004\b\u001b\u0010#\u001a\u0004\b\u0019\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0011\u0010,\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b'\u0010+R\u0011\u0010.\u001a\u00020&8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010-¨\u00061"}, d2 = {"Lokhttp3/y;", "", "", "name", "d", "T", "Ljava/lang/Class;", "type", "i", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lokhttp3/y$a;", "h", "toString", "Lokhttp3/t;", "a", "Lokhttp3/t;", "j", "()Lokhttp3/t;", "url", "b", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "method", "Lokhttp3/s;", "c", "Lokhttp3/s;", "e", "()Lokhttp3/s;", "headers", "Lokhttp3/z;", "Lokhttp3/z;", "()Lokhttp3/z;", "body", "", "Ljava/util/Map;", "()Ljava/util/Map;", "tags", "Lokhttp3/d;", "f", "Lokhttp3/d;", "lazyCacheControl", "", "()Z", "isHttps", "()Lokhttp3/d;", "cacheControl", "<init>", "(Lokhttp3/t;Ljava/lang/String;Lokhttp3/s;Lokhttp3/z;Ljava/util/Map;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private final t f33263a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33264b;

    /* renamed from: c  reason: collision with root package name */
    private final s f33265c;

    /* renamed from: d  reason: collision with root package name */
    private final z f33266d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, Object> f33267e;

    /* renamed from: f  reason: collision with root package name */
    private d f33268f;

    public y(t tVar, String str, s sVar, z zVar, Map<Class<?>, ? extends Object> map) {
        j.g(tVar, "url");
        j.g(str, FirebaseAnalytics.Param.METHOD);
        j.g(sVar, HeadersExtension.ELEMENT);
        j.g(map, "tags");
        this.f33263a = tVar;
        this.f33264b = str;
        this.f33265c = sVar;
        this.f33266d = zVar;
        this.f33267e = map;
    }

    public final z a() {
        return this.f33266d;
    }

    public final d b() {
        d dVar = this.f33268f;
        if (dVar != null) {
            return dVar;
        }
        d b10 = d.f32899n.b(this.f33265c);
        this.f33268f = b10;
        return b10;
    }

    public final Map<Class<?>, Object> c() {
        return this.f33267e;
    }

    public final String d(String str) {
        j.g(str, "name");
        return this.f33265c.b(str);
    }

    public final s e() {
        return this.f33265c;
    }

    public final boolean f() {
        return this.f33263a.j();
    }

    public final String g() {
        return this.f33264b;
    }

    public final a h() {
        return new a(this);
    }

    public final <T> T i(Class<? extends T> cls) {
        j.g(cls, "type");
        return cls.cast(this.f33267e.get(cls));
    }

    public final t j() {
        return this.f33263a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request{method=");
        sb2.append(g());
        sb2.append(", url=");
        sb2.append(j());
        if (e().size() != 0) {
            sb2.append(", headers=[");
            int i10 = 0;
            for (Object next : e()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    q.s();
                }
                Pair pair = (Pair) next;
                String str = (String) pair.a();
                String str2 = (String) pair.b();
                if (i10 > 0) {
                    sb2.append(", ");
                }
                sb2.append(str);
                sb2.append(':');
                sb2.append(str2);
                i10 = i11;
            }
            sb2.append(PropertyUtils.INDEXED_DELIM2);
        }
        if (!c().isEmpty()) {
            sb2.append(", tags=");
            sb2.append(c());
        }
        sb2.append('}');
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b;\u0010<B\u0011\b\u0010\u0012\u0006\u0010=\u001a\u00020\u001d¢\u0006\u0004\b;\u0010>J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u001a\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J/\u0010\u001b\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u00172\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00182\b\u0010\u001a\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u001dH\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u0015\u001a\u00020\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010\r\u001a\u00020)8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b+\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R2\u0010:\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0004\u0012\u00020\u0001048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b5\u00107\"\u0004\b8\u00109¨\u0006?"}, d2 = {"Lokhttp3/y$a;", "", "Lokhttp3/t;", "url", "r", "", "q", "name", "value", "f", "a", "j", "Lokhttp3/s;", "headers", "g", "Lokhttp3/d;", "cacheControl", "c", "Lokhttp3/z;", "body", "i", "method", "h", "T", "Ljava/lang/Class;", "type", "tag", "p", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/y$a;", "Lokhttp3/y;", "b", "Lokhttp3/t;", "getUrl$okhttp", "()Lokhttp3/t;", "o", "(Lokhttp3/t;)V", "Ljava/lang/String;", "getMethod$okhttp", "()Ljava/lang/String;", "m", "(Ljava/lang/String;)V", "Lokhttp3/s$a;", "Lokhttp3/s$a;", "d", "()Lokhttp3/s$a;", "l", "(Lokhttp3/s$a;)V", "Lokhttp3/z;", "getBody$okhttp", "()Lokhttp3/z;", "k", "(Lokhttp3/z;)V", "", "e", "Ljava/util/Map;", "()Ljava/util/Map;", "n", "(Ljava/util/Map;)V", "tags", "<init>", "()V", "request", "(Lokhttp3/y;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private t f33269a;

        /* renamed from: b  reason: collision with root package name */
        private String f33270b;

        /* renamed from: c  reason: collision with root package name */
        private s.a f33271c;

        /* renamed from: d  reason: collision with root package name */
        private z f33272d;

        /* renamed from: e  reason: collision with root package name */
        private Map<Class<?>, Object> f33273e;

        public a() {
            this.f33273e = new LinkedHashMap();
            this.f33270b = "GET";
            this.f33271c = new s.a();
        }

        public a a(String str, String str2) {
            j.g(str, "name");
            j.g(str2, "value");
            d().a(str, str2);
            return this;
        }

        public y b() {
            t tVar = this.f33269a;
            if (tVar != null) {
                return new y(tVar, this.f33270b, this.f33271c.f(), this.f33272d, d.T(this.f33273e));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public a c(d dVar) {
            boolean z10;
            j.g(dVar, "cacheControl");
            String dVar2 = dVar.toString();
            if (dVar2.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return j("Cache-Control");
            }
            return f("Cache-Control", dVar2);
        }

        public final s.a d() {
            return this.f33271c;
        }

        public final Map<Class<?>, Object> e() {
            return this.f33273e;
        }

        public a f(String str, String str2) {
            j.g(str, "name");
            j.g(str2, "value");
            d().i(str, str2);
            return this;
        }

        public a g(s sVar) {
            j.g(sVar, HeadersExtension.ELEMENT);
            l(sVar.j());
            return this;
        }

        public a h(String str, z zVar) {
            boolean z10;
            j.g(str, FirebaseAnalytics.Param.METHOD);
            if (str.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                if (zVar == null) {
                    if (!(true ^ f.d(str))) {
                        throw new IllegalArgumentException(("method " + str + " must have a request body.").toString());
                    }
                } else if (!f.a(str)) {
                    throw new IllegalArgumentException(("method " + str + " must not have a request body.").toString());
                }
                m(str);
                k(zVar);
                return this;
            }
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }

        public a i(z zVar) {
            j.g(zVar, "body");
            return h("POST", zVar);
        }

        public a j(String str) {
            j.g(str, "name");
            d().h(str);
            return this;
        }

        public final void k(z zVar) {
            this.f33272d = zVar;
        }

        public final void l(s.a aVar) {
            j.g(aVar, "<set-?>");
            this.f33271c = aVar;
        }

        public final void m(String str) {
            j.g(str, "<set-?>");
            this.f33270b = str;
        }

        public final void n(Map<Class<?>, Object> map) {
            j.g(map, "<set-?>");
            this.f33273e = map;
        }

        public final void o(t tVar) {
            this.f33269a = tVar;
        }

        public <T> a p(Class<? super T> cls, T t10) {
            j.g(cls, "type");
            if (t10 == null) {
                e().remove(cls);
            } else {
                if (e().isEmpty()) {
                    n(new LinkedHashMap());
                }
                Map<Class<?>, Object> e10 = e();
                Object cast = cls.cast(t10);
                j.d(cast);
                e10.put(cls, cast);
            }
            return this;
        }

        public a q(String str) {
            j.g(str, "url");
            if (r.H(str, "ws:", true)) {
                String substring = str.substring(3);
                j.f(substring, "this as java.lang.String).substring(startIndex)");
                str = j.p("http:", substring);
            } else if (r.H(str, "wss:", true)) {
                String substring2 = str.substring(4);
                j.f(substring2, "this as java.lang.String).substring(startIndex)");
                str = j.p("https:", substring2);
            }
            return r(t.f33169k.d(str));
        }

        public a r(t tVar) {
            j.g(tVar, "url");
            o(tVar);
            return this;
        }

        public a(y yVar) {
            Map<Class<?>, Object> map;
            j.g(yVar, "request");
            this.f33273e = new LinkedHashMap();
            this.f33269a = yVar.j();
            this.f33270b = yVar.g();
            this.f33272d = yVar.a();
            if (yVar.c().isEmpty()) {
                map = new LinkedHashMap<>();
            } else {
                map = h0.w(yVar.c());
            }
            this.f33273e = map;
            this.f33271c = yVar.e().j();
        }
    }
}
