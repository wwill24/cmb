package dl;

import bl.d;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.server.http.HttpHeaders;
import dl.b;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.Protocol;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c;
import okhttp3.internal.connection.e;
import okhttp3.q;
import okhttp3.s;
import okhttp3.u;
import okhttp3.y;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Ldl/a;", "Lokhttp3/u;", "Lokhttp3/u$a;", "chain", "Lokhttp3/a0;", "intercept", "Lokhttp3/c;", "cache", "<init>", "(Lokhttp3/c;)V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a implements u {

    /* renamed from: a  reason: collision with root package name */
    public static final C0338a f29562a = new C0338a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¨\u0006\u0010"}, d2 = {"Ldl/a$a;", "", "Lokhttp3/a0;", "response", "f", "Lokhttp3/s;", "cachedHeaders", "networkHeaders", "c", "", "fieldName", "", "e", "d", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    /* renamed from: dl.a$a  reason: collision with other inner class name */
    public static final class C0338a {
        private C0338a() {
        }

        public /* synthetic */ C0338a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final s c(s sVar, s sVar2) {
            s.a aVar = new s.a();
            int size = sVar.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                int i12 = i11 + 1;
                String f10 = sVar.f(i11);
                String n10 = sVar.n(i11);
                if ((!r.t("Warning", f10, true) || !r.J(n10, AppEventsConstants.EVENT_PARAM_VALUE_YES, false, 2, (Object) null)) && (d(f10) || !e(f10) || sVar2.b(f10) == null)) {
                    aVar.d(f10, n10);
                }
                i11 = i12;
            }
            int size2 = sVar2.size();
            while (i10 < size2) {
                int i13 = i10 + 1;
                String f11 = sVar2.f(i10);
                if (!d(f11) && e(f11)) {
                    aVar.d(f11, sVar2.n(i10));
                }
                i10 = i13;
            }
            return aVar.f();
        }

        private final boolean d(String str) {
            if (r.t(HttpHeaders.CONTENT_LENGTH, str, true) || r.t("Content-Encoding", str, true) || r.t(HttpHeaders.CONTENT_TYPE, str, true)) {
                return true;
            }
            return false;
        }

        private final boolean e(String str) {
            if (r.t("Connection", str, true) || r.t("Keep-Alive", str, true) || r.t("Proxy-Authenticate", str, true) || r.t("Proxy-Authorization", str, true) || r.t("TE", str, true) || r.t("Trailers", str, true) || r.t("Transfer-Encoding", str, true) || r.t("Upgrade", str, true)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public final a0 f(a0 a0Var) {
            b0 b0Var;
            if (a0Var == null) {
                b0Var = null;
            } else {
                b0Var = a0Var.a();
            }
            if (b0Var != null) {
                return a0Var.x().b((b0) null).c();
            }
            return a0Var;
        }
    }

    public a(c cVar) {
    }

    public a0 intercept(u.a aVar) throws IOException {
        e eVar;
        q qVar;
        j.g(aVar, "chain");
        okhttp3.e call = aVar.call();
        b b10 = new b.C0339b(System.currentTimeMillis(), aVar.g(), (a0) null).b();
        y b11 = b10.b();
        a0 a10 = b10.a();
        if (call instanceof e) {
            eVar = (e) call;
        } else {
            eVar = null;
        }
        if (eVar == null) {
            qVar = null;
        } else {
            qVar = eVar.p();
        }
        if (qVar == null) {
            qVar = q.f33158b;
        }
        if (b11 == null && a10 == null) {
            a0 c10 = new a0.a().s(aVar.g()).q(Protocol.HTTP_1_1).g(504).n("Unsatisfiable Request (only-if-cached)").b(d.f24930c).t(-1).r(System.currentTimeMillis()).c();
            qVar.z(call, c10);
            return c10;
        } else if (b11 == null) {
            j.d(a10);
            a0 c11 = a10.x().d(f29562a.f(a10)).c();
            qVar.b(call, c11);
            return c11;
        } else {
            if (a10 != null) {
                qVar.a(call, a10);
            }
            a0 a11 = aVar.a(b11);
            if (a10 != null) {
                boolean z10 = false;
                if (a11 != null && a11.f() == 304) {
                    z10 = true;
                }
                if (!z10) {
                    b0 a12 = a10.a();
                    if (a12 != null) {
                        d.m(a12);
                    }
                } else {
                    a0.a x10 = a10.x();
                    C0338a aVar2 = f29562a;
                    x10.l(aVar2.c(a10.n(), a11.n())).t(a11.G()).r(a11.E()).d(aVar2.f(a10)).o(aVar2.f(a11)).c();
                    b0 a13 = a11.a();
                    j.d(a13);
                    a13.close();
                    j.d((Object) null);
                    throw null;
                }
            }
            j.d(a11);
            a0.a x11 = a11.x();
            C0338a aVar3 = f29562a;
            return x11.d(aVar3.f(a10)).o(aVar3.f(a11)).c();
        }
    }
}
