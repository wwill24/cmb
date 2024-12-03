package gl;

import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.google.android.gms.common.api.a;
import fl.i;
import fl.k;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.a0;
import okhttp3.internal.connection.RealConnection;
import okhttp3.m;
import okhttp3.s;
import okhttp3.t;
import okhttp3.x;
import okhttp3.y;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 D2\u00020\u0001:\u0007\u001c\u001a\u0019\u0014\u0016%\u001bB)\u0012\b\u0010)\u001a\u0004\u0018\u00010'\u0012\u0006\u0010.\u001a\u00020*\u0012\u0006\u00101\u001a\u00020/\u0012\u0006\u00104\u001a\u000202¢\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\u0016\u0010!\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fJ\u0012\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010#\u001a\u00020\"H\u0016J\u000e\u0010&\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017R\u0016\u0010)\u001a\u0004\u0018\u00010'8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010(R\u001a\u0010.\u001a\u00020*8\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b,\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u00103R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010;R\u0018\u0010?\u001a\u00020\"*\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0018\u0010?\u001a\u00020\"*\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lgl/b;", "Lfl/d;", "Lokio/Sink;", "t", "w", "", "length", "Lokio/Source;", "v", "Lokhttp3/t;", "url", "u", "x", "Lokio/ForwardingTimeout;", "timeout", "", "q", "Lokhttp3/y;", "request", "contentLength", "d", "cancel", "e", "Lokhttp3/a0;", "response", "c", "b", "g", "a", "Lokhttp3/s;", "headers", "", "requestLine", "z", "", "expectContinue", "Lokhttp3/a0$a;", "f", "y", "Lokhttp3/x;", "Lokhttp3/x;", "client", "Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connection", "Lokio/BufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/BufferedSink;", "Lokio/BufferedSink;", "sink", "", "I", "state", "Lgl/a;", "Lgl/a;", "headersReader", "Lokhttp3/s;", "trailers", "s", "(Lokhttp3/a0;)Z", "isChunked", "r", "(Lokhttp3/y;)Z", "<init>", "(Lokhttp3/x;Lokhttp3/internal/connection/RealConnection;Lokio/BufferedSource;Lokio/BufferedSink;)V", "h", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b implements fl.d {

    /* renamed from: h  reason: collision with root package name */
    public static final d f29718h = new d((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final x f29719a;

    /* renamed from: b  reason: collision with root package name */
    private final RealConnection f29720b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final BufferedSource f29721c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final BufferedSink f29722d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f29723e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final a f29724f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public s f29725g;

    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b¢\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\tR\u001a\u0010\u0010\u001a\u00020\u000b8\u0004X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00118\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0012\u001a\u0004\b\f\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lgl/b$a;", "Lokio/Source;", "Lokio/Timeout;", "p", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "", "b", "Lokio/ForwardingTimeout;", "a", "Lokio/ForwardingTimeout;", "getTimeout", "()Lokio/ForwardingTimeout;", "timeout", "", "Z", "()Z", "c", "(Z)V", "closed", "<init>", "(Lgl/b;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    private abstract class a implements Source {

        /* renamed from: a  reason: collision with root package name */
        private final ForwardingTimeout f29726a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f29727b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f29728c;

        public a(b bVar) {
            j.g(bVar, "this$0");
            this.f29728c = bVar;
            this.f29726a = new ForwardingTimeout(bVar.f29721c.p());
        }

        public long N1(Buffer buffer, long j10) {
            j.g(buffer, "sink");
            try {
                return this.f29728c.f29721c.N1(buffer, j10);
            } catch (IOException e10) {
                this.f29728c.getConnection().y();
                b();
                throw e10;
            }
        }

        /* access modifiers changed from: protected */
        public final boolean a() {
            return this.f29727b;
        }

        public final void b() {
            if (this.f29728c.f29723e != 6) {
                if (this.f29728c.f29723e == 5) {
                    this.f29728c.q(this.f29726a);
                    this.f29728c.f29723e = 6;
                    return;
                }
                throw new IllegalStateException(j.p("state: ", Integer.valueOf(this.f29728c.f29723e)));
            }
        }

        /* access modifiers changed from: protected */
        public final void c(boolean z10) {
            this.f29727b = z10;
        }

        public Timeout p() {
            return this.f29726a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lgl/b$b;", "Lokio/Sink;", "Lokio/Timeout;", "p", "Lokio/Buffer;", "source", "", "byteCount", "", "k0", "flush", "close", "Lokio/ForwardingTimeout;", "a", "Lokio/ForwardingTimeout;", "timeout", "", "b", "Z", "closed", "<init>", "(Lgl/b;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    /* renamed from: gl.b$b  reason: collision with other inner class name */
    private final class C0344b implements Sink {

        /* renamed from: a  reason: collision with root package name */
        private final ForwardingTimeout f29729a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f29730b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f29731c;

        public C0344b(b bVar) {
            j.g(bVar, "this$0");
            this.f29731c = bVar;
            this.f29729a = new ForwardingTimeout(bVar.f29722d.p());
        }

        public synchronized void close() {
            if (!this.f29730b) {
                this.f29730b = true;
                this.f29731c.f29722d.h0("0\r\n\r\n");
                this.f29731c.q(this.f29729a);
                this.f29731c.f29723e = 3;
            }
        }

        public synchronized void flush() {
            if (!this.f29730b) {
                this.f29731c.f29722d.flush();
            }
        }

        public void k0(Buffer buffer, long j10) {
            j.g(buffer, "source");
            if (!(!this.f29730b)) {
                throw new IllegalStateException("closed".toString());
            } else if (j10 != 0) {
                this.f29731c.f29722d.x1(j10);
                this.f29731c.f29722d.h0("\r\n");
                this.f29731c.f29722d.k0(buffer, j10);
                this.f29731c.f29722d.h0("\r\n");
            }
        }

        public Timeout p() {
            return this.f29729a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lgl/b$c;", "Lgl/b$a;", "Lgl/b;", "", "e", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "close", "Lokhttp3/t;", "d", "Lokhttp3/t;", "url", "J", "bytesRemainingInChunk", "", "f", "Z", "hasMoreChunks", "<init>", "(Lgl/b;Lokhttp3/t;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    private final class c extends a {

        /* renamed from: d  reason: collision with root package name */
        private final t f29732d;

        /* renamed from: e  reason: collision with root package name */
        private long f29733e = -1;

        /* renamed from: f  reason: collision with root package name */
        private boolean f29734f = true;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ b f29735g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar, t tVar) {
            super(bVar);
            j.g(bVar, "this$0");
            j.g(tVar, "url");
            this.f29735g = bVar;
            this.f29732d = tVar;
        }

        private final void e() {
            boolean z10;
            if (this.f29733e != -1) {
                this.f29735g.f29721c.w0();
            }
            try {
                this.f29733e = this.f29735g.f29721c.Y1();
                String obj = StringsKt__StringsKt.W0(this.f29735g.f29721c.w0()).toString();
                if (this.f29733e >= 0) {
                    if (obj.length() > 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10 || r.J(obj, ";", false, 2, (Object) null)) {
                        if (this.f29733e == 0) {
                            this.f29734f = false;
                            b bVar = this.f29735g;
                            bVar.f29725g = bVar.f29724f.a();
                            x i10 = this.f29735g.f29719a;
                            j.d(i10);
                            m o10 = i10.o();
                            t tVar = this.f29732d;
                            s n10 = this.f29735g.f29725g;
                            j.d(n10);
                            fl.e.f(o10, tVar, n10);
                            b();
                            return;
                        }
                        return;
                    }
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f29733e + obj + '\"');
            } catch (NumberFormatException e10) {
                throw new ProtocolException(e10.getMessage());
            }
        }

        public long N1(Buffer buffer, long j10) {
            boolean z10;
            j.g(buffer, "sink");
            if (j10 >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalArgumentException(j.p("byteCount < 0: ", Long.valueOf(j10)).toString());
            } else if (!(!a())) {
                throw new IllegalStateException("closed".toString());
            } else if (!this.f29734f) {
                return -1;
            } else {
                long j11 = this.f29733e;
                if (j11 == 0 || j11 == -1) {
                    e();
                    if (!this.f29734f) {
                        return -1;
                    }
                }
                long N1 = super.N1(buffer, Math.min(j10, this.f29733e));
                if (N1 != -1) {
                    this.f29733e -= N1;
                    return N1;
                }
                this.f29735g.getConnection().y();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b();
                throw protocolException;
            }
        }

        public void close() {
            if (!a()) {
                if (this.f29734f && !bl.d.s(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f29735g.getConnection().y();
                    b();
                }
                c(true);
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u0007¨\u0006\u0010"}, d2 = {"Lgl/b$d;", "", "", "NO_CHUNK_YET", "J", "", "STATE_CLOSED", "I", "STATE_IDLE", "STATE_OPEN_REQUEST_BODY", "STATE_OPEN_RESPONSE_BODY", "STATE_READING_RESPONSE_BODY", "STATE_READ_RESPONSE_HEADERS", "STATE_WRITING_REQUEST_BODY", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lgl/b$e;", "Lgl/b$a;", "Lgl/b;", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "", "close", "d", "J", "bytesRemaining", "<init>", "(Lgl/b;J)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    private final class e extends a {

        /* renamed from: d  reason: collision with root package name */
        private long f29736d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b f29737e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(b bVar, long j10) {
            super(bVar);
            j.g(bVar, "this$0");
            this.f29737e = bVar;
            this.f29736d = j10;
            if (j10 == 0) {
                b();
            }
        }

        public long N1(Buffer buffer, long j10) {
            boolean z10;
            j.g(buffer, "sink");
            if (j10 >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalArgumentException(j.p("byteCount < 0: ", Long.valueOf(j10)).toString());
            } else if (!a()) {
                long j11 = this.f29736d;
                if (j11 == 0) {
                    return -1;
                }
                long N1 = super.N1(buffer, Math.min(j11, j10));
                if (N1 != -1) {
                    long j12 = this.f29736d - N1;
                    this.f29736d = j12;
                    if (j12 == 0) {
                        b();
                    }
                    return N1;
                }
                this.f29737e.getConnection().y();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b();
                throw protocolException;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }

        public void close() {
            if (!a()) {
                if (this.f29736d != 0 && !bl.d.s(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f29737e.getConnection().y();
                    b();
                }
                c(true);
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lgl/b$f;", "Lokio/Sink;", "Lokio/Timeout;", "p", "Lokio/Buffer;", "source", "", "byteCount", "", "k0", "flush", "close", "Lokio/ForwardingTimeout;", "a", "Lokio/ForwardingTimeout;", "timeout", "", "b", "Z", "closed", "<init>", "(Lgl/b;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    private final class f implements Sink {

        /* renamed from: a  reason: collision with root package name */
        private final ForwardingTimeout f29738a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f29739b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f29740c;

        public f(b bVar) {
            j.g(bVar, "this$0");
            this.f29740c = bVar;
            this.f29738a = new ForwardingTimeout(bVar.f29722d.p());
        }

        public void close() {
            if (!this.f29739b) {
                this.f29739b = true;
                this.f29740c.q(this.f29738a);
                this.f29740c.f29723e = 3;
            }
        }

        public void flush() {
            if (!this.f29739b) {
                this.f29740c.f29722d.flush();
            }
        }

        public void k0(Buffer buffer, long j10) {
            j.g(buffer, "source");
            if (!this.f29739b) {
                bl.d.l(buffer.size(), 0, j10);
                this.f29740c.f29722d.k0(buffer, j10);
                return;
            }
            throw new IllegalStateException("closed".toString());
        }

        public Timeout p() {
            return this.f29738a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lgl/b$g;", "Lgl/b$a;", "Lgl/b;", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "", "close", "", "d", "Z", "inputExhausted", "<init>", "(Lgl/b;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    private final class g extends a {

        /* renamed from: d  reason: collision with root package name */
        private boolean f29741d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b f29742e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(b bVar) {
            super(bVar);
            j.g(bVar, "this$0");
            this.f29742e = bVar;
        }

        public long N1(Buffer buffer, long j10) {
            boolean z10;
            j.g(buffer, "sink");
            if (j10 >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalArgumentException(j.p("byteCount < 0: ", Long.valueOf(j10)).toString());
            } else if (!(!a())) {
                throw new IllegalStateException("closed".toString());
            } else if (this.f29741d) {
                return -1;
            } else {
                long N1 = super.N1(buffer, j10);
                if (N1 != -1) {
                    return N1;
                }
                this.f29741d = true;
                b();
                return -1;
            }
        }

        public void close() {
            if (!a()) {
                if (!this.f29741d) {
                    b();
                }
                c(true);
            }
        }
    }

    public b(x xVar, RealConnection realConnection, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        j.g(realConnection, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
        j.g(bufferedSource, "source");
        j.g(bufferedSink, "sink");
        this.f29719a = xVar;
        this.f29720b = realConnection;
        this.f29721c = bufferedSource;
        this.f29722d = bufferedSink;
        this.f29724f = new a(bufferedSource);
    }

    /* access modifiers changed from: private */
    public final void q(ForwardingTimeout forwardingTimeout) {
        Timeout j10 = forwardingTimeout.j();
        forwardingTimeout.k(Timeout.f33430e);
        j10.a();
        j10.b();
    }

    private final boolean r(y yVar) {
        return r.t("chunked", yVar.d("Transfer-Encoding"), true);
    }

    private final boolean s(a0 a0Var) {
        return r.t("chunked", a0.m(a0Var, "Transfer-Encoding", (String) null, 2, (Object) null), true);
    }

    private final Sink t() {
        int i10 = this.f29723e;
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        if (z10) {
            this.f29723e = 2;
            return new C0344b(this);
        }
        throw new IllegalStateException(j.p("state: ", Integer.valueOf(i10)).toString());
    }

    private final Source u(t tVar) {
        boolean z10;
        int i10 = this.f29723e;
        if (i10 == 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f29723e = 5;
            return new c(this, tVar);
        }
        throw new IllegalStateException(j.p("state: ", Integer.valueOf(i10)).toString());
    }

    private final Source v(long j10) {
        boolean z10;
        int i10 = this.f29723e;
        if (i10 == 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f29723e = 5;
            return new e(this, j10);
        }
        throw new IllegalStateException(j.p("state: ", Integer.valueOf(i10)).toString());
    }

    private final Sink w() {
        int i10 = this.f29723e;
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        if (z10) {
            this.f29723e = 2;
            return new f(this);
        }
        throw new IllegalStateException(j.p("state: ", Integer.valueOf(i10)).toString());
    }

    private final Source x() {
        boolean z10;
        int i10 = this.f29723e;
        if (i10 == 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f29723e = 5;
            getConnection().y();
            return new g(this);
        }
        throw new IllegalStateException(j.p("state: ", Integer.valueOf(i10)).toString());
    }

    public void a() {
        this.f29722d.flush();
    }

    public Source b(a0 a0Var) {
        j.g(a0Var, "response");
        if (!fl.e.b(a0Var)) {
            return v(0);
        }
        if (s(a0Var)) {
            return u(a0Var.F().j());
        }
        long v10 = bl.d.v(a0Var);
        if (v10 != -1) {
            return v(v10);
        }
        return x();
    }

    public long c(a0 a0Var) {
        j.g(a0Var, "response");
        if (!fl.e.b(a0Var)) {
            return 0;
        }
        if (s(a0Var)) {
            return -1;
        }
        return bl.d.v(a0Var);
    }

    public void cancel() {
        getConnection().d();
    }

    public Sink d(y yVar, long j10) {
        j.g(yVar, "request");
        if (yVar.a() != null && yVar.a().g()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        } else if (r(yVar)) {
            return t();
        } else {
            if (j10 != -1) {
                return w();
            }
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    public void e(y yVar) {
        j.g(yVar, "request");
        i iVar = i.f29674a;
        Proxy.Type type = getConnection().z().b().type();
        j.f(type, "connection.route().proxy.type()");
        z(yVar.e(), iVar.a(yVar, type));
    }

    public a0.a f(boolean z10) {
        int i10 = this.f29723e;
        boolean z11 = true;
        if (!(i10 == 1 || i10 == 3)) {
            z11 = false;
        }
        if (z11) {
            try {
                k a10 = k.f29677d.a(this.f29724f.b());
                a0.a l10 = new a0.a().q(a10.f29678a).g(a10.f29679b).n(a10.f29680c).l(this.f29724f.a());
                if (z10 && a10.f29679b == 100) {
                    return null;
                }
                if (a10.f29679b == 100) {
                    this.f29723e = 3;
                    return l10;
                }
                this.f29723e = 4;
                return l10;
            } catch (EOFException e10) {
                throw new IOException(j.p("unexpected end of stream on ", getConnection().z().a().l().q()), e10);
            }
        } else {
            throw new IllegalStateException(j.p("state: ", Integer.valueOf(i10)).toString());
        }
    }

    public void g() {
        this.f29722d.flush();
    }

    public RealConnection getConnection() {
        return this.f29720b;
    }

    public final void y(a0 a0Var) {
        j.g(a0Var, "response");
        long v10 = bl.d.v(a0Var);
        if (v10 != -1) {
            Source v11 = v(v10);
            bl.d.L(v11, a.e.API_PRIORITY_OTHER, TimeUnit.MILLISECONDS);
            v11.close();
        }
    }

    public final void z(s sVar, String str) {
        boolean z10;
        j.g(sVar, HeadersExtension.ELEMENT);
        j.g(str, "requestLine");
        int i10 = this.f29723e;
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f29722d.h0(str).h0("\r\n");
            int size = sVar.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f29722d.h0(sVar.f(i11)).h0(": ").h0(sVar.n(i11)).h0("\r\n");
            }
            this.f29722d.h0("\r\n");
            this.f29723e = 1;
            return;
        }
        throw new IllegalStateException(j.p("state: ", Integer.valueOf(i10)).toString());
    }
}
