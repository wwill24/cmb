package hl;

import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.leanplum.internal.Constants;
import fl.d;
import fl.g;
import fl.i;
import fl.k;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.Protocol;
import okhttp3.a0;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.s;
import okhttp3.x;
import okhttp3.y;
import okio.Sink;
import okio.Source;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;

@Metadata(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB'\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001e¢\u0006\u0004\b+\u0010,J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016R\u001a\u0010\u001a\u001a\u00020\u00168\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010%R\u0016\u0010(\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010'¨\u0006-"}, d2 = {"Lhl/e;", "Lfl/d;", "Lokhttp3/y;", "request", "", "contentLength", "Lokio/Sink;", "d", "", "e", "g", "a", "", "expectContinue", "Lokhttp3/a0$a;", "f", "Lokhttp3/a0;", "response", "c", "Lokio/Source;", "b", "cancel", "Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connection", "Lfl/g;", "Lfl/g;", "chain", "Lhl/d;", "Lhl/d;", "http2Connection", "Lhl/g;", "Lhl/g;", "stream", "Lokhttp3/Protocol;", "Lokhttp3/Protocol;", "protocol", "Z", "canceled", "Lokhttp3/x;", "client", "<init>", "(Lokhttp3/x;Lokhttp3/internal/connection/RealConnection;Lfl/g;Lhl/d;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class e implements d {

    /* renamed from: g  reason: collision with root package name */
    public static final a f29876g = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final List<String> f29877h = bl.d.w(ModelDeeplinkData.VALUE_PAGE_CONNECTION, JingleS5BTransportCandidate.ATTR_HOST, "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final List<String> f29878i = bl.d.w(ModelDeeplinkData.VALUE_PAGE_CONNECTION, JingleS5BTransportCandidate.ATTR_HOST, "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a  reason: collision with root package name */
    private final RealConnection f29879a;

    /* renamed from: b  reason: collision with root package name */
    private final g f29880b;

    /* renamed from: c  reason: collision with root package name */
    private final d f29881c;

    /* renamed from: d  reason: collision with root package name */
    private volatile g f29882d;

    /* renamed from: e  reason: collision with root package name */
    private final Protocol f29883e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f29884f;

    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000e\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u000f¨\u0006\u001c"}, d2 = {"Lhl/e$a;", "", "Lokhttp3/y;", "request", "", "Lhl/a;", "a", "Lokhttp3/s;", "headerBlock", "Lokhttp3/Protocol;", "protocol", "Lokhttp3/a0$a;", "b", "", "CONNECTION", "Ljava/lang/String;", "ENCODING", "HOST", "HTTP_2_SKIPPED_REQUEST_HEADERS", "Ljava/util/List;", "HTTP_2_SKIPPED_RESPONSE_HEADERS", "KEEP_ALIVE", "PROXY_CONNECTION", "TE", "TRANSFER_ENCODING", "UPGRADE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<a> a(y yVar) {
            j.g(yVar, "request");
            s e10 = yVar.e();
            ArrayList arrayList = new ArrayList(e10.size() + 4);
            arrayList.add(new a(a.f29753g, yVar.g()));
            arrayList.add(new a(a.f29754h, i.f29674a.c(yVar.j())));
            String d10 = yVar.d("Host");
            if (d10 != null) {
                arrayList.add(new a(a.f29756j, d10));
            }
            arrayList.add(new a(a.f29755i, yVar.j().s()));
            int i10 = 0;
            int size = e10.size();
            while (i10 < size) {
                int i11 = i10 + 1;
                String f10 = e10.f(i10);
                Locale locale = Locale.US;
                j.f(locale, "US");
                String lowerCase = f10.toLowerCase(locale);
                j.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (!e.f29877h.contains(lowerCase) || (j.b(lowerCase, "te") && j.b(e10.n(i10), "trailers"))) {
                    arrayList.add(new a(lowerCase, e10.n(i10)));
                }
                i10 = i11;
            }
            return arrayList;
        }

        public final a0.a b(s sVar, Protocol protocol) {
            j.g(sVar, "headerBlock");
            j.g(protocol, "protocol");
            s.a aVar = new s.a();
            int size = sVar.size();
            k kVar = null;
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                String f10 = sVar.f(i10);
                String n10 = sVar.n(i10);
                if (j.b(f10, ":status")) {
                    kVar = k.f29677d.a(j.p("HTTP/1.1 ", n10));
                } else if (!e.f29878i.contains(f10)) {
                    aVar.d(f10, n10);
                }
                i10 = i11;
            }
            if (kVar != null) {
                return new a0.a().q(protocol).g(kVar.f29679b).n(kVar.f29680c).l(aVar.f());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    public e(x xVar, RealConnection realConnection, g gVar, d dVar) {
        j.g(xVar, Constants.Params.CLIENT);
        j.g(realConnection, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
        j.g(gVar, "chain");
        j.g(dVar, "http2Connection");
        this.f29879a = realConnection;
        this.f29880b = gVar;
        this.f29881c = dVar;
        List<Protocol> z10 = xVar.z();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.f29883e = !z10.contains(protocol) ? Protocol.HTTP_2 : protocol;
    }

    public void a() {
        g gVar = this.f29882d;
        j.d(gVar);
        gVar.n().close();
    }

    public Source b(a0 a0Var) {
        j.g(a0Var, "response");
        g gVar = this.f29882d;
        j.d(gVar);
        return gVar.p();
    }

    public long c(a0 a0Var) {
        j.g(a0Var, "response");
        if (!fl.e.b(a0Var)) {
            return 0;
        }
        return bl.d.v(a0Var);
    }

    public void cancel() {
        this.f29884f = true;
        g gVar = this.f29882d;
        if (gVar != null) {
            gVar.f(ErrorCode.CANCEL);
        }
    }

    public Sink d(y yVar, long j10) {
        j.g(yVar, "request");
        g gVar = this.f29882d;
        j.d(gVar);
        return gVar.n();
    }

    public void e(y yVar) {
        boolean z10;
        j.g(yVar, "request");
        if (this.f29882d == null) {
            if (yVar.a() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f29882d = this.f29881c.t0(f29876g.a(yVar), z10);
            if (!this.f29884f) {
                g gVar = this.f29882d;
                j.d(gVar);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                gVar.v().g((long) this.f29880b.i(), timeUnit);
                g gVar2 = this.f29882d;
                j.d(gVar2);
                gVar2.G().g((long) this.f29880b.k(), timeUnit);
                return;
            }
            g gVar3 = this.f29882d;
            j.d(gVar3);
            gVar3.f(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
    }

    public a0.a f(boolean z10) {
        g gVar = this.f29882d;
        j.d(gVar);
        a0.a b10 = f29876g.b(gVar.E(), this.f29883e);
        if (!z10 || b10.h() != 100) {
            return b10;
        }
        return null;
    }

    public void g() {
        this.f29881c.flush();
    }

    public RealConnection getConnection() {
        return this.f29879a;
    }
}
