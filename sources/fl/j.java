package fl;

import bl.d;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.android.gms.common.api.a;
import com.leanplum.internal.Constants;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.e;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.t;
import okhttp3.u;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ(\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001b¨\u0006\u001f"}, d2 = {"Lfl/j;", "Lokhttp3/u;", "Ljava/io/IOException;", "e", "Lokhttp3/internal/connection/e;", "call", "Lokhttp3/y;", "userRequest", "", "requestSendStarted", "d", "c", "Lokhttp3/a0;", "userResponse", "Lokhttp3/internal/connection/c;", "exchange", "b", "", "method", "a", "", "defaultDelay", "f", "Lokhttp3/u$a;", "chain", "intercept", "Lokhttp3/x;", "Lokhttp3/x;", "client", "<init>", "(Lokhttp3/x;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class j implements u {

    /* renamed from: b  reason: collision with root package name */
    public static final a f29675b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final x f29676a;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lfl/j$a;", "", "", "MAX_FOLLOW_UPS", "I", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j(x xVar) {
        kotlin.jvm.internal.j.g(xVar, Constants.Params.CLIENT);
        this.f29676a = xVar;
    }

    private final y a(a0 a0Var, String str) {
        String m10;
        t r10;
        boolean z10;
        z zVar = null;
        if (!this.f29676a.s() || (m10 = a0.m(a0Var, "Location", (String) null, 2, (Object) null)) == null || (r10 = a0Var.F().j().r(m10)) == null) {
            return null;
        }
        if (!kotlin.jvm.internal.j.b(r10.s(), a0Var.F().j().s()) && !this.f29676a.t()) {
            return null;
        }
        y.a h10 = a0Var.F().h();
        if (f.a(str)) {
            int f10 = a0Var.f();
            f fVar = f.f29661a;
            if (fVar.c(str) || f10 == 308 || f10 == 307) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!fVar.b(str) || f10 == 308 || f10 == 307) {
                if (z10) {
                    zVar = a0Var.F().a();
                }
                h10.h(str, zVar);
            } else {
                h10.h("GET", (z) null);
            }
            if (!z10) {
                h10.j("Transfer-Encoding");
                h10.j(HttpHeaders.CONTENT_LENGTH);
                h10.j(HttpHeaders.CONTENT_TYPE);
            }
        }
        if (!d.j(a0Var.F().j(), r10)) {
            h10.j("Authorization");
        }
        return h10.r(r10).b();
    }

    private final y b(a0 a0Var, c cVar) throws IOException {
        c0 c0Var;
        RealConnection h10;
        if (cVar == null || (h10 = cVar.h()) == null) {
            c0Var = null;
        } else {
            c0Var = h10.z();
        }
        int f10 = a0Var.f();
        String g10 = a0Var.F().g();
        if (!(f10 == 307 || f10 == 308)) {
            if (f10 == 401) {
                return this.f29676a.d().a(c0Var, a0Var);
            }
            if (f10 == 421) {
                z a10 = a0Var.F().a();
                if ((a10 != null && a10.h()) || cVar == null || !cVar.k()) {
                    return null;
                }
                cVar.h().x();
                return a0Var.F();
            } else if (f10 == 503) {
                a0 y10 = a0Var.y();
                if ((y10 == null || y10.f() != 503) && f(a0Var, a.e.API_PRIORITY_OTHER) == 0) {
                    return a0Var.F();
                }
                return null;
            } else if (f10 == 407) {
                kotlin.jvm.internal.j.d(c0Var);
                if (c0Var.b().type() == Proxy.Type.HTTP) {
                    return this.f29676a.B().a(c0Var, a0Var);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            } else if (f10 != 408) {
                switch (f10) {
                    case MessageTemplateConstants.Values.CENTER_POPUP_WIDTH:
                    case 301:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            } else if (!this.f29676a.E()) {
                return null;
            } else {
                z a11 = a0Var.F().a();
                if (a11 != null && a11.h()) {
                    return null;
                }
                a0 y11 = a0Var.y();
                if ((y11 == null || y11.f() != 408) && f(a0Var, 0) <= 0) {
                    return a0Var.F();
                }
                return null;
            }
        }
        return a(a0Var, g10);
    }

    private final boolean c(IOException iOException, boolean z10) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z10) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private final boolean d(IOException iOException, e eVar, y yVar, boolean z10) {
        if (!this.f29676a.E()) {
            return false;
        }
        if ((!z10 || !e(iOException, yVar)) && c(iOException, z10) && eVar.z()) {
            return true;
        }
        return false;
    }

    private final boolean e(IOException iOException, y yVar) {
        z a10 = yVar.a();
        if ((a10 == null || !a10.h()) && !(iOException instanceof FileNotFoundException)) {
            return false;
        }
        return true;
    }

    private final int f(a0 a0Var, int i10) {
        String m10 = a0.m(a0Var, "Retry-After", (String) null, 2, (Object) null);
        if (m10 == null) {
            return i10;
        }
        if (!new Regex("\\d+").e(m10)) {
            return a.e.API_PRIORITY_OTHER;
        }
        Integer valueOf = Integer.valueOf(m10);
        kotlin.jvm.internal.j.f(valueOf, "valueOf(header)");
        return valueOf.intValue();
    }

    public a0 intercept(u.a aVar) throws IOException {
        boolean z10;
        kotlin.jvm.internal.j.g(aVar, "chain");
        g gVar = (g) aVar;
        y j10 = gVar.j();
        e e10 = gVar.e();
        List j11 = q.j();
        a0 a0Var = null;
        boolean z11 = true;
        int i10 = 0;
        while (true) {
            e10.j(j10, z11);
            try {
                if (!e10.m()) {
                    a0 a10 = gVar.a(j10);
                    if (a0Var != null) {
                        a10 = a10.x().p(a0Var.x().b((b0) null).c()).c();
                    }
                    a0Var = a10;
                    c r10 = e10.r();
                    y b10 = b(a0Var, r10);
                    if (b10 == null) {
                        if (r10 != null && r10.l()) {
                            e10.B();
                        }
                        e10.k(false);
                        return a0Var;
                    }
                    z a11 = b10.a();
                    if (a11 == null || !a11.h()) {
                        b0 a12 = a0Var.a();
                        if (a12 != null) {
                            d.m(a12);
                        }
                        i10++;
                        if (i10 <= 20) {
                            e10.k(true);
                            j10 = b10;
                            z11 = true;
                        } else {
                            throw new ProtocolException(kotlin.jvm.internal.j.p("Too many follow-up requests: ", Integer.valueOf(i10)));
                        }
                    } else {
                        e10.k(false);
                        return a0Var;
                    }
                } else {
                    throw new IOException("Canceled");
                }
            } catch (RouteException e11) {
                if (d(e11.c(), e10, j10, false)) {
                    j11 = CollectionsKt___CollectionsKt.i0(j11, e11.b());
                    e10.k(true);
                    z11 = false;
                } else {
                    throw d.Y(e11.b(), j11);
                }
            } catch (IOException e12) {
                if (!(e12 instanceof ConnectionShutdownException)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (d(e12, e10, j10, z10)) {
                    j11 = CollectionsKt___CollectionsKt.i0(j11, e12);
                    e10.k(true);
                    z11 = false;
                } else {
                    throw d.Y(e12, j11);
                }
            } catch (Throwable th2) {
                e10.k(true);
                throw th2;
            }
        }
    }
}
