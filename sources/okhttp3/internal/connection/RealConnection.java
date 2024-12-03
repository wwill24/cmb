package okhttp3.internal.connection;

import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.google.firebase.perf.FirebasePerformance;
import com.leanplum.internal.Constants;
import el.e;
import hl.d;
import hl.g;
import hl.k;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.a0;
import okhttp3.c0;
import okhttp3.i;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.q;
import okhttp3.t;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

@Metadata(bv = {}, d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001BB\u0019\u0012\u0006\u0010S\u001a\u00020N\u0012\u0006\u0010U\u001a\u00020\u001b¢\u0006\u0006\b\u0001\u0010\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J*\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0016\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010!\u001a\u00020 H\u0002J\u000f\u0010#\u001a\u00020\u000bH\u0000¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000bH\u0000¢\u0006\u0004\b%\u0010$J\u000f\u0010&\u001a\u00020\u000bH\u0000¢\u0006\u0004\b&\u0010$J>\u0010(\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ'\u0010,\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020)2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0000¢\u0006\u0004\b,\u0010-J\u001f\u00103\u001a\u0002022\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0000¢\u0006\u0004\b3\u00104J\b\u00105\u001a\u00020\u001bH\u0016J\u0006\u00106\u001a\u00020\u000bJ\b\u00108\u001a\u000207H\u0016J\u000e\u0010:\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u001dJ\u0010\u0010=\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020;H\u0016J\u0018\u0010B\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@H\u0016J\n\u0010C\u001a\u0004\u0018\u00010 H\u0016J'\u0010G\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.2\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020EH\u0000¢\u0006\u0004\bG\u0010HJ!\u0010J\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020I2\b\u0010\"\u001a\u0004\u0018\u00010EH\u0000¢\u0006\u0004\bJ\u0010KJ\b\u0010M\u001a\u00020LH\u0016R\u0017\u0010S\u001a\u00020N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010TR\u0018\u0010W\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010VR\u0018\u0010X\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010VR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010YR\u0018\u0010\\\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010]R\u0018\u0010a\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010cR\"\u0010j\u001a\u00020\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0016\u0010k\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010eR\"\u0010r\u001a\u00020\u00038\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0016\u0010t\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bs\u0010mR\u0016\u0010u\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010mR\u0016\u0010v\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010mR#\u0010{\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0x0w8\u0006¢\u0006\f\n\u0004\bC\u0010y\u001a\u0004\bl\u0010zR$\u0010\u0001\u001a\u00020|8\u0000@\u0000X\u000e¢\u0006\u0013\n\u0004\b&\u0010}\u001a\u0004\bs\u0010~\"\u0005\b\u0010\u0001R\u0016\u0010\u0001\u001a\u00020\u001d8@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010g¨\u0006\u0001"}, d2 = {"Lokhttp3/internal/connection/RealConnection;", "Lhl/d$c;", "Lokhttp3/i;", "", "connectTimeout", "readTimeout", "writeTimeout", "Lokhttp3/e;", "call", "Lokhttp3/q;", "eventListener", "", "j", "h", "Lokhttp3/internal/connection/b;", "connectionSpecSelector", "pingIntervalMillis", "m", "E", "i", "Lokhttp3/y;", "tunnelRequest", "Lokhttp3/t;", "url", "k", "l", "", "Lokhttp3/c0;", "candidates", "", "A", "F", "Lokhttp3/Handshake;", "handshake", "e", "y", "()V", "x", "s", "connectionRetryEnabled", "f", "Lokhttp3/a;", "address", "routes", "t", "(Lokhttp3/a;Ljava/util/List;)Z", "Lokhttp3/x;", "client", "Lfl/g;", "chain", "Lfl/d;", "w", "(Lokhttp3/x;Lfl/g;)Lfl/d;", "z", "d", "Ljava/net/Socket;", "D", "doExtensiveChecks", "u", "Lhl/g;", "stream", "b", "Lhl/d;", "connection", "Lhl/k;", "settings", "a", "r", "failedRoute", "Ljava/io/IOException;", "failure", "g", "(Lokhttp3/x;Lokhttp3/c0;Ljava/io/IOException;)V", "Lokhttp3/internal/connection/e;", "G", "(Lokhttp3/internal/connection/e;Ljava/io/IOException;)V", "", "toString", "Lokhttp3/internal/connection/f;", "c", "Lokhttp3/internal/connection/f;", "getConnectionPool", "()Lokhttp3/internal/connection/f;", "connectionPool", "Lokhttp3/c0;", "route", "Ljava/net/Socket;", "rawSocket", "socket", "Lokhttp3/Handshake;", "Lokhttp3/Protocol;", "Lokhttp3/Protocol;", "protocol", "Lhl/d;", "http2Connection", "Lokio/BufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/BufferedSink;", "Lokio/BufferedSink;", "sink", "Z", "p", "()Z", "C", "(Z)V", "noNewExchanges", "noCoalescedConnections", "n", "I", "q", "()I", "setRouteFailureCount$okhttp", "(I)V", "routeFailureCount", "o", "successCount", "refusedStreamCount", "allocationLimit", "", "Ljava/lang/ref/Reference;", "Ljava/util/List;", "()Ljava/util/List;", "calls", "", "J", "()J", "B", "(J)V", "idleAtNs", "v", "isMultiplexed", "<init>", "(Lokhttp3/internal/connection/f;Lokhttp3/c0;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class RealConnection extends d.c implements i {

    /* renamed from: t  reason: collision with root package name */
    public static final a f32996t = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private final f f32997c;

    /* renamed from: d  reason: collision with root package name */
    private final c0 f32998d;

    /* renamed from: e  reason: collision with root package name */
    private Socket f32999e;

    /* renamed from: f  reason: collision with root package name */
    private Socket f33000f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Handshake f33001g;

    /* renamed from: h  reason: collision with root package name */
    private Protocol f33002h;

    /* renamed from: i  reason: collision with root package name */
    private d f33003i;

    /* renamed from: j  reason: collision with root package name */
    private BufferedSource f33004j;

    /* renamed from: k  reason: collision with root package name */
    private BufferedSink f33005k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f33006l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f33007m;

    /* renamed from: n  reason: collision with root package name */
    private int f33008n;

    /* renamed from: o  reason: collision with root package name */
    private int f33009o;

    /* renamed from: p  reason: collision with root package name */
    private int f33010p;

    /* renamed from: q  reason: collision with root package name */
    private int f33011q = 1;

    /* renamed from: r  reason: collision with root package name */
    private final List<Reference<e>> f33012r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    private long f33013s = Long.MAX_VALUE;

    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lokhttp3/internal/connection/RealConnection$a;", "", "", "IDLE_CONNECTION_HEALTHY_NS", "J", "", "MAX_TUNNEL_ATTEMPTS", "I", "", "NPE_THROW_WITH_NULL", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33014a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
            f33014a = iArr;
        }
    }

    public RealConnection(f fVar, c0 c0Var) {
        j.g(fVar, "connectionPool");
        j.g(c0Var, "route");
        this.f32997c = fVar;
        this.f32998d = c0Var;
    }

    private final boolean A(List<c0> list) {
        boolean z10;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (c0 c0Var : list) {
                if (c0Var.b().type() == Proxy.Type.DIRECT && this.f32998d.b().type() == Proxy.Type.DIRECT && j.b(this.f32998d.d(), c0Var.d())) {
                    z10 = true;
                    continue;
                } else {
                    z10 = false;
                    continue;
                }
                if (z10) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void E(int i10) throws IOException {
        Socket socket = this.f33000f;
        j.d(socket);
        BufferedSource bufferedSource = this.f33004j;
        j.d(bufferedSource);
        BufferedSink bufferedSink = this.f33005k;
        j.d(bufferedSink);
        socket.setSoTimeout(0);
        d a10 = new d.a(true, e.f29630i).s(socket, this.f32998d.a().l().i(), bufferedSource, bufferedSink).k(this).l(i10).a();
        this.f33003i = a10;
        this.f33011q = d.J.a().d();
        d.U0(a10, false, (e) null, 3, (Object) null);
    }

    private final boolean F(t tVar) {
        Handshake handshake;
        if (!bl.d.f24935h || Thread.holdsLock(this)) {
            t l10 = this.f32998d.a().l();
            if (tVar.o() != l10.o()) {
                return false;
            }
            if (j.b(tVar.i(), l10.i())) {
                return true;
            }
            if (this.f33007m || (handshake = this.f33001g) == null) {
                return false;
            }
            j.d(handshake);
            if (e(tVar, handshake)) {
                return true;
            }
            return false;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    private final boolean e(t tVar, Handshake handshake) {
        List<Certificate> d10 = handshake.d();
        if (!(!d10.isEmpty()) || !ll.d.f32787a.e(tVar.i(), (X509Certificate) d10.get(0))) {
            return false;
        }
        return true;
    }

    private final void h(int i10, int i11, okhttp3.e eVar, q qVar) throws IOException {
        int i12;
        Socket socket;
        Proxy b10 = this.f32998d.b();
        okhttp3.a a10 = this.f32998d.a();
        Proxy.Type type = b10.type();
        if (type == null) {
            i12 = -1;
        } else {
            i12 = b.f33014a[type.ordinal()];
        }
        if (i12 == 1 || i12 == 2) {
            socket = a10.j().createSocket();
            j.d(socket);
        } else {
            socket = new Socket(b10);
        }
        this.f32999e = socket;
        qVar.i(eVar, this.f32998d.d(), b10);
        socket.setSoTimeout(i11);
        try {
            il.j.f30050a.g().f(socket, this.f32998d.d(), i10);
            try {
                this.f33004j = Okio.c(Okio.k(socket));
                this.f33005k = Okio.b(Okio.g(socket));
            } catch (NullPointerException e10) {
                if (j.b(e10.getMessage(), "throw with null exception")) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException(j.p("Failed to connect to ", this.f32998d.d()));
            connectException.initCause(e11);
            throw connectException;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x017f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void i(okhttp3.internal.connection.b r11) throws java.io.IOException {
        /*
            r10 = this;
            okhttp3.c0 r0 = r10.f32998d
            okhttp3.a r0 = r0.a()
            javax.net.ssl.SSLSocketFactory r1 = r0.k()
            r2 = 0
            kotlin.jvm.internal.j.d(r1)     // Catch:{ all -> 0x0170 }
            java.net.Socket r3 = r10.f32999e     // Catch:{ all -> 0x0170 }
            okhttp3.t r4 = r0.l()     // Catch:{ all -> 0x0170 }
            java.lang.String r4 = r4.i()     // Catch:{ all -> 0x0170 }
            okhttp3.t r5 = r0.l()     // Catch:{ all -> 0x0170 }
            int r5 = r5.o()     // Catch:{ all -> 0x0170 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ all -> 0x0170 }
            if (r1 == 0) goto L_0x0168
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ all -> 0x0170 }
            okhttp3.k r11 = r11.a(r1)     // Catch:{ all -> 0x0165 }
            boolean r3 = r11.h()     // Catch:{ all -> 0x0165 }
            if (r3 == 0) goto L_0x0048
            il.j$a r3 = il.j.f30050a     // Catch:{ all -> 0x0165 }
            il.j r3 = r3.g()     // Catch:{ all -> 0x0165 }
            okhttp3.t r4 = r0.l()     // Catch:{ all -> 0x0165 }
            java.lang.String r4 = r4.i()     // Catch:{ all -> 0x0165 }
            java.util.List r5 = r0.f()     // Catch:{ all -> 0x0165 }
            r3.e(r1, r4, r5)     // Catch:{ all -> 0x0165 }
        L_0x0048:
            r1.startHandshake()     // Catch:{ all -> 0x0165 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ all -> 0x0165 }
            okhttp3.Handshake$Companion r4 = okhttp3.Handshake.f32827e     // Catch:{ all -> 0x0165 }
            java.lang.String r5 = "sslSocketSession"
            kotlin.jvm.internal.j.f(r3, r5)     // Catch:{ all -> 0x0165 }
            okhttp3.Handshake r4 = r4.a(r3)     // Catch:{ all -> 0x0165 }
            javax.net.ssl.HostnameVerifier r5 = r0.e()     // Catch:{ all -> 0x0165 }
            kotlin.jvm.internal.j.d(r5)     // Catch:{ all -> 0x0165 }
            okhttp3.t r7 = r0.l()     // Catch:{ all -> 0x0165 }
            java.lang.String r7 = r7.i()     // Catch:{ all -> 0x0165 }
            boolean r3 = r5.verify(r7, r3)     // Catch:{ all -> 0x0165 }
            if (r3 != 0) goto L_0x00f9
            java.util.List r11 = r4.d()     // Catch:{ all -> 0x0165 }
            boolean r3 = r11.isEmpty()     // Catch:{ all -> 0x0165 }
            r3 = r3 ^ r6
            if (r3 == 0) goto L_0x00d5
            r3 = 0
            java.lang.Object r11 = r11.get(r3)     // Catch:{ all -> 0x0165 }
            java.security.cert.X509Certificate r11 = (java.security.cert.X509Certificate) r11     // Catch:{ all -> 0x0165 }
            javax.net.ssl.SSLPeerUnverifiedException r3 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ all -> 0x0165 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
            r4.<init>()     // Catch:{ all -> 0x0165 }
            java.lang.String r5 = "\n              |Hostname "
            r4.append(r5)     // Catch:{ all -> 0x0165 }
            okhttp3.t r0 = r0.l()     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = r0.i()     // Catch:{ all -> 0x0165 }
            r4.append(r0)     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = " not verified:\n              |    certificate: "
            r4.append(r0)     // Catch:{ all -> 0x0165 }
            okhttp3.CertificatePinner$b r0 = okhttp3.CertificatePinner.f32819c     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = r0.a(r11)     // Catch:{ all -> 0x0165 }
            r4.append(r0)     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = "\n              |    DN: "
            r4.append(r0)     // Catch:{ all -> 0x0165 }
            java.security.Principal r0 = r11.getSubjectDN()     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0165 }
            r4.append(r0)     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = "\n              |    subjectAltNames: "
            r4.append(r0)     // Catch:{ all -> 0x0165 }
            ll.d r0 = ll.d.f32787a     // Catch:{ all -> 0x0165 }
            java.util.List r11 = r0.a(r11)     // Catch:{ all -> 0x0165 }
            r4.append(r11)     // Catch:{ all -> 0x0165 }
            java.lang.String r11 = "\n              "
            r4.append(r11)     // Catch:{ all -> 0x0165 }
            java.lang.String r11 = r4.toString()     // Catch:{ all -> 0x0165 }
            java.lang.String r11 = kotlin.text.StringsKt__IndentKt.h(r11, r2, r6, r2)     // Catch:{ all -> 0x0165 }
            r3.<init>(r11)     // Catch:{ all -> 0x0165 }
            throw r3     // Catch:{ all -> 0x0165 }
        L_0x00d5:
            javax.net.ssl.SSLPeerUnverifiedException r11 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ all -> 0x0165 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
            r2.<init>()     // Catch:{ all -> 0x0165 }
            java.lang.String r3 = "Hostname "
            r2.append(r3)     // Catch:{ all -> 0x0165 }
            okhttp3.t r0 = r0.l()     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = r0.i()     // Catch:{ all -> 0x0165 }
            r2.append(r0)     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = " not verified (no certificates)"
            r2.append(r0)     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0165 }
            r11.<init>(r0)     // Catch:{ all -> 0x0165 }
            throw r11     // Catch:{ all -> 0x0165 }
        L_0x00f9:
            okhttp3.CertificatePinner r3 = r0.a()     // Catch:{ all -> 0x0165 }
            kotlin.jvm.internal.j.d(r3)     // Catch:{ all -> 0x0165 }
            okhttp3.Handshake r5 = new okhttp3.Handshake     // Catch:{ all -> 0x0165 }
            okhttp3.TlsVersion r6 = r4.e()     // Catch:{ all -> 0x0165 }
            okhttp3.h r7 = r4.a()     // Catch:{ all -> 0x0165 }
            java.util.List r8 = r4.c()     // Catch:{ all -> 0x0165 }
            okhttp3.internal.connection.RealConnection$connectTls$1 r9 = new okhttp3.internal.connection.RealConnection$connectTls$1     // Catch:{ all -> 0x0165 }
            r9.<init>(r3, r4, r0)     // Catch:{ all -> 0x0165 }
            r5.<init>(r6, r7, r8, r9)     // Catch:{ all -> 0x0165 }
            r10.f33001g = r5     // Catch:{ all -> 0x0165 }
            okhttp3.t r0 = r0.l()     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = r0.i()     // Catch:{ all -> 0x0165 }
            okhttp3.internal.connection.RealConnection$connectTls$2 r4 = new okhttp3.internal.connection.RealConnection$connectTls$2     // Catch:{ all -> 0x0165 }
            r4.<init>(r10)     // Catch:{ all -> 0x0165 }
            r3.b(r0, r4)     // Catch:{ all -> 0x0165 }
            boolean r11 = r11.h()     // Catch:{ all -> 0x0165 }
            if (r11 == 0) goto L_0x0138
            il.j$a r11 = il.j.f30050a     // Catch:{ all -> 0x0165 }
            il.j r11 = r11.g()     // Catch:{ all -> 0x0165 }
            java.lang.String r2 = r11.g(r1)     // Catch:{ all -> 0x0165 }
        L_0x0138:
            r10.f33000f = r1     // Catch:{ all -> 0x0165 }
            okio.Source r11 = okio.Okio.k(r1)     // Catch:{ all -> 0x0165 }
            okio.BufferedSource r11 = okio.Okio.c(r11)     // Catch:{ all -> 0x0165 }
            r10.f33004j = r11     // Catch:{ all -> 0x0165 }
            okio.Sink r11 = okio.Okio.g(r1)     // Catch:{ all -> 0x0165 }
            okio.BufferedSink r11 = okio.Okio.b(r11)     // Catch:{ all -> 0x0165 }
            r10.f33005k = r11     // Catch:{ all -> 0x0165 }
            if (r2 == 0) goto L_0x0157
            okhttp3.Protocol$a r11 = okhttp3.Protocol.f32832a     // Catch:{ all -> 0x0165 }
            okhttp3.Protocol r11 = r11.a(r2)     // Catch:{ all -> 0x0165 }
            goto L_0x0159
        L_0x0157:
            okhttp3.Protocol r11 = okhttp3.Protocol.HTTP_1_1     // Catch:{ all -> 0x0165 }
        L_0x0159:
            r10.f33002h = r11     // Catch:{ all -> 0x0165 }
            il.j$a r11 = il.j.f30050a
            il.j r11 = r11.g()
            r11.b(r1)
            return
        L_0x0165:
            r11 = move-exception
            r2 = r1
            goto L_0x0171
        L_0x0168:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException     // Catch:{ all -> 0x0170 }
            java.lang.String r0 = "null cannot be cast to non-null type javax.net.ssl.SSLSocket"
            r11.<init>(r0)     // Catch:{ all -> 0x0170 }
            throw r11     // Catch:{ all -> 0x0170 }
        L_0x0170:
            r11 = move-exception
        L_0x0171:
            if (r2 == 0) goto L_0x017c
            il.j$a r0 = il.j.f30050a
            il.j r0 = r0.g()
            r0.b(r2)
        L_0x017c:
            if (r2 != 0) goto L_0x017f
            goto L_0x0182
        L_0x017f:
            bl.d.n(r2)
        L_0x0182:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.i(okhttp3.internal.connection.b):void");
    }

    private final void j(int i10, int i11, int i12, okhttp3.e eVar, q qVar) throws IOException {
        y l10 = l();
        t j10 = l10.j();
        int i13 = 0;
        while (i13 < 21) {
            i13++;
            h(i10, i11, eVar, qVar);
            l10 = k(i11, i12, l10, j10);
            if (l10 != null) {
                Socket socket = this.f32999e;
                if (socket != null) {
                    bl.d.n(socket);
                }
                this.f32999e = null;
                this.f33005k = null;
                this.f33004j = null;
                qVar.g(eVar, this.f32998d.d(), this.f32998d.b(), (Protocol) null);
            } else {
                return;
            }
        }
    }

    private final y k(int i10, int i11, y yVar, t tVar) throws IOException {
        String str = "CONNECT " + bl.d.Q(tVar, true) + " HTTP/1.1";
        while (true) {
            BufferedSource bufferedSource = this.f33004j;
            j.d(bufferedSource);
            BufferedSink bufferedSink = this.f33005k;
            j.d(bufferedSink);
            gl.b bVar = new gl.b((x) null, this, bufferedSource, bufferedSink);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            bufferedSource.p().g((long) i10, timeUnit);
            bufferedSink.p().g((long) i11, timeUnit);
            bVar.z(yVar.e(), str);
            bVar.a();
            a0.a f10 = bVar.f(false);
            j.d(f10);
            a0 c10 = f10.s(yVar).c();
            bVar.y(c10);
            int f11 = c10.f();
            if (f11 != 200) {
                if (f11 == 407) {
                    y a10 = this.f32998d.a().h().a(this.f32998d, c10);
                    if (a10 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if (r.t(Close.ELEMENT, a0.m(c10, "Connection", (String) null, 2, (Object) null), true)) {
                        return a10;
                    } else {
                        yVar = a10;
                    }
                } else {
                    throw new IOException(j.p("Unexpected response code for CONNECT: ", Integer.valueOf(c10.f())));
                }
            } else if (bufferedSource.d().Y0() && bufferedSink.d().Y0()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private final y l() throws IOException {
        y b10 = new y.a().r(this.f32998d.a().l()).h(FirebasePerformance.HttpMethod.CONNECT, (z) null).f("Host", bl.d.Q(this.f32998d.a().l(), true)).f("Proxy-Connection", "Keep-Alive").f("User-Agent", "okhttp/4.10.0").b();
        y a10 = this.f32998d.a().h().a(this.f32998d, new a0.a().s(b10).q(Protocol.HTTP_1_1).g(407).n("Preemptive Authenticate").b(bl.d.f24930c).t(-1).r(-1).k("Proxy-Authenticate", "OkHttp-Preemptive").c());
        if (a10 == null) {
            return b10;
        }
        return a10;
    }

    private final void m(b bVar, int i10, okhttp3.e eVar, q qVar) throws IOException {
        if (this.f32998d.a().k() == null) {
            List<Protocol> f10 = this.f32998d.a().f();
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (f10.contains(protocol)) {
                this.f33000f = this.f32999e;
                this.f33002h = protocol;
                E(i10);
                return;
            }
            this.f33000f = this.f32999e;
            this.f33002h = Protocol.HTTP_1_1;
            return;
        }
        qVar.B(eVar);
        i(bVar);
        qVar.A(eVar, this.f33001g);
        if (this.f33002h == Protocol.HTTP_2) {
            E(i10);
        }
    }

    public final void B(long j10) {
        this.f33013s = j10;
    }

    public final void C(boolean z10) {
        this.f33006l = z10;
    }

    public Socket D() {
        Socket socket = this.f33000f;
        j.d(socket);
        return socket;
    }

    public final synchronized void G(e eVar, IOException iOException) {
        j.g(eVar, "call");
        if (iOException instanceof StreamResetException) {
            if (((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                int i10 = this.f33010p + 1;
                this.f33010p = i10;
                if (i10 > 1) {
                    this.f33006l = true;
                    this.f33008n++;
                }
            } else if (((StreamResetException) iOException).errorCode != ErrorCode.CANCEL || !eVar.m()) {
                this.f33006l = true;
                this.f33008n++;
            }
        } else if (!v() || (iOException instanceof ConnectionShutdownException)) {
            this.f33006l = true;
            if (this.f33009o == 0) {
                if (iOException != null) {
                    g(eVar.l(), this.f32998d, iOException);
                }
                this.f33008n++;
            }
        }
    }

    public synchronized void a(d dVar, k kVar) {
        j.g(dVar, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
        j.g(kVar, ModelDeeplinkData.VALUE_PAGE_SETTINGS);
        this.f33011q = kVar.d();
    }

    public void b(g gVar) throws IOException {
        j.g(gVar, "stream");
        gVar.d(ErrorCode.REFUSED_STREAM, (IOException) null);
    }

    public final void d() {
        Socket socket = this.f32999e;
        if (socket != null) {
            bl.d.n(socket);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a2 A[Catch:{ IOException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(int r17, int r18, int r19, int r20, boolean r21, okhttp3.e r22, okhttp3.q r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            java.lang.String r0 = "call"
            kotlin.jvm.internal.j.g(r8, r0)
            java.lang.String r0 = "eventListener"
            kotlin.jvm.internal.j.g(r9, r0)
            okhttp3.Protocol r0 = r7.f33002h
            r10 = 1
            if (r0 != 0) goto L_0x0017
            r0 = r10
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x015c
            okhttp3.c0 r0 = r7.f32998d
            okhttp3.a r0 = r0.a()
            java.util.List r0 = r0.b()
            okhttp3.internal.connection.b r11 = new okhttp3.internal.connection.b
            r11.<init>(r0)
            okhttp3.c0 r1 = r7.f32998d
            okhttp3.a r1 = r1.a()
            javax.net.ssl.SSLSocketFactory r1 = r1.k()
            if (r1 != 0) goto L_0x0086
            okhttp3.k r1 = okhttp3.k.f33120k
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0079
            okhttp3.c0 r0 = r7.f32998d
            okhttp3.a r0 = r0.a()
            okhttp3.t r0 = r0.l()
            java.lang.String r0 = r0.i()
            il.j$a r1 = il.j.f30050a
            il.j r1 = r1.g()
            boolean r1 = r1.i(r0)
            if (r1 == 0) goto L_0x0058
            goto L_0x0098
        L_0x0058:
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "CLEARTEXT communication to "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x0079:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0086:
            okhttp3.c0 r0 = r7.f32998d
            okhttp3.a r0 = r0.a()
            java.util.List r0 = r0.f()
            okhttp3.Protocol r1 = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x014f
        L_0x0098:
            r12 = 0
            r13 = r12
        L_0x009a:
            okhttp3.c0 r0 = r7.f32998d     // Catch:{ IOException -> 0x00fd }
            boolean r0 = r0.c()     // Catch:{ IOException -> 0x00fd }
            if (r0 == 0) goto L_0x00bb
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.j(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00fd }
            java.net.Socket r0 = r7.f32999e     // Catch:{ IOException -> 0x00fd }
            if (r0 != 0) goto L_0x00b6
            goto L_0x00d8
        L_0x00b6:
            r14 = r17
            r15 = r18
            goto L_0x00c2
        L_0x00bb:
            r14 = r17
            r15 = r18
            r7.h(r14, r15, r8, r9)     // Catch:{ IOException -> 0x00fb }
        L_0x00c2:
            r6 = r20
            r7.m(r11, r6, r8, r9)     // Catch:{ IOException -> 0x00f9 }
            okhttp3.c0 r0 = r7.f32998d     // Catch:{ IOException -> 0x00f9 }
            java.net.InetSocketAddress r0 = r0.d()     // Catch:{ IOException -> 0x00f9 }
            okhttp3.c0 r1 = r7.f32998d     // Catch:{ IOException -> 0x00f9 }
            java.net.Proxy r1 = r1.b()     // Catch:{ IOException -> 0x00f9 }
            okhttp3.Protocol r2 = r7.f33002h     // Catch:{ IOException -> 0x00f9 }
            r9.g(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00f9 }
        L_0x00d8:
            okhttp3.c0 r0 = r7.f32998d
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x00f2
            java.net.Socket r0 = r7.f32999e
            if (r0 == 0) goto L_0x00e5
            goto L_0x00f2
        L_0x00e5:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.ProtocolException r1 = new java.net.ProtocolException
            java.lang.String r2 = "Too many tunnel connections attempted: 21"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x00f2:
            long r0 = java.lang.System.nanoTime()
            r7.f33013s = r0
            return
        L_0x00f9:
            r0 = move-exception
            goto L_0x0104
        L_0x00fb:
            r0 = move-exception
            goto L_0x0102
        L_0x00fd:
            r0 = move-exception
            r14 = r17
            r15 = r18
        L_0x0102:
            r6 = r20
        L_0x0104:
            java.net.Socket r1 = r7.f33000f
            if (r1 != 0) goto L_0x0109
            goto L_0x010c
        L_0x0109:
            bl.d.n(r1)
        L_0x010c:
            java.net.Socket r1 = r7.f32999e
            if (r1 != 0) goto L_0x0111
            goto L_0x0114
        L_0x0111:
            bl.d.n(r1)
        L_0x0114:
            r7.f33000f = r12
            r7.f32999e = r12
            r7.f33004j = r12
            r7.f33005k = r12
            r7.f33001g = r12
            r7.f33002h = r12
            r7.f33003i = r12
            r7.f33011q = r10
            okhttp3.c0 r1 = r7.f32998d
            java.net.InetSocketAddress r3 = r1.d()
            okhttp3.c0 r1 = r7.f32998d
            java.net.Proxy r4 = r1.b()
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.h(r2, r3, r4, r5, r6)
            if (r13 != 0) goto L_0x0141
            okhttp3.internal.connection.RouteException r13 = new okhttp3.internal.connection.RouteException
            r13.<init>(r0)
            goto L_0x0144
        L_0x0141:
            r13.a(r0)
        L_0x0144:
            if (r21 == 0) goto L_0x014e
            boolean r0 = r11.b(r0)
            if (r0 == 0) goto L_0x014e
            goto L_0x009a
        L_0x014e:
            throw r13
        L_0x014f:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x015c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.f(int, int, int, int, boolean, okhttp3.e, okhttp3.q):void");
    }

    public final void g(x xVar, c0 c0Var, IOException iOException) {
        j.g(xVar, Constants.Params.CLIENT);
        j.g(c0Var, "failedRoute");
        j.g(iOException, "failure");
        if (c0Var.b().type() != Proxy.Type.DIRECT) {
            okhttp3.a a10 = c0Var.a();
            a10.i().connectFailed(a10.l().t(), c0Var.b().address(), iOException);
        }
        xVar.u().b(c0Var);
    }

    public final List<Reference<e>> n() {
        return this.f33012r;
    }

    public final long o() {
        return this.f33013s;
    }

    public final boolean p() {
        return this.f33006l;
    }

    public final int q() {
        return this.f33008n;
    }

    public Handshake r() {
        return this.f33001g;
    }

    public final synchronized void s() {
        this.f33009o++;
    }

    public final boolean t(okhttp3.a aVar, List<c0> list) {
        j.g(aVar, "address");
        if (bl.d.f24935h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        } else if (this.f33012r.size() >= this.f33011q || this.f33006l || !this.f32998d.a().d(aVar)) {
            return false;
        } else {
            if (j.b(aVar.l().i(), z().a().l().i())) {
                return true;
            }
            if (this.f33003i == null || list == null || !A(list) || aVar.e() != ll.d.f32787a || !F(aVar.l())) {
                return false;
            }
            try {
                CertificatePinner a10 = aVar.a();
                j.d(a10);
                String i10 = aVar.l().i();
                Handshake r10 = r();
                j.d(r10);
                a10.a(i10, r10.d());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
    }

    public String toString() {
        Object a10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.f32998d.a().l().i());
        sb2.append(':');
        sb2.append(this.f32998d.a().l().o());
        sb2.append(", proxy=");
        sb2.append(this.f32998d.b());
        sb2.append(" hostAddress=");
        sb2.append(this.f32998d.d());
        sb2.append(" cipherSuite=");
        Handshake handshake = this.f33001g;
        Object obj = "none";
        if (!(handshake == null || (a10 = handshake.a()) == null)) {
            obj = a10;
        }
        sb2.append(obj);
        sb2.append(" protocol=");
        sb2.append(this.f33002h);
        sb2.append('}');
        return sb2.toString();
    }

    public final boolean u(boolean z10) {
        long o10;
        if (!bl.d.f24935h || !Thread.holdsLock(this)) {
            long nanoTime = System.nanoTime();
            Socket socket = this.f32999e;
            j.d(socket);
            Socket socket2 = this.f33000f;
            j.d(socket2);
            BufferedSource bufferedSource = this.f33004j;
            j.d(bufferedSource);
            if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
                return false;
            }
            d dVar = this.f33003i;
            if (dVar != null) {
                return dVar.r0(nanoTime);
            }
            synchronized (this) {
                o10 = nanoTime - o();
            }
            if (o10 < 10000000000L || !z10) {
                return true;
            }
            return bl.d.F(socket2, bufferedSource);
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final boolean v() {
        return this.f33003i != null;
    }

    public final fl.d w(x xVar, fl.g gVar) throws SocketException {
        j.g(xVar, Constants.Params.CLIENT);
        j.g(gVar, "chain");
        Socket socket = this.f33000f;
        j.d(socket);
        BufferedSource bufferedSource = this.f33004j;
        j.d(bufferedSource);
        BufferedSink bufferedSink = this.f33005k;
        j.d(bufferedSink);
        d dVar = this.f33003i;
        if (dVar != null) {
            return new hl.e(xVar, this, gVar, dVar);
        }
        socket.setSoTimeout(gVar.l());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        bufferedSource.p().g((long) gVar.i(), timeUnit);
        bufferedSink.p().g((long) gVar.k(), timeUnit);
        return new gl.b(xVar, this, bufferedSource, bufferedSink);
    }

    public final synchronized void x() {
        this.f33007m = true;
    }

    public final synchronized void y() {
        this.f33006l = true;
    }

    public c0 z() {
        return this.f32998d;
    }
}
