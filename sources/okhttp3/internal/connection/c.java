package okhttp3.internal.connection;

import com.facebook.stetho.server.http.HttpHeaders;
import fl.d;
import fl.h;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.MethodDelegation;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.q;
import okhttp3.y;
import okhttp3.z;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(bv = {}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u001f\u0018B'\u0012\u0006\u0010&\u001a\u00020\"\u0012\u0006\u0010+\u001a\u00020'\u0012\u0006\u00100\u001a\u00020,\u0012\u0006\u00103\u001a\u000201¢\u0006\u0004\b@\u0010AJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J9\u0010\u001f\u001a\u00028\u0000\"\n\b\u0000\u0010\u001a*\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010!\u001a\u00020\u0004R\u001a\u0010&\u001a\u00020\"8\u0000X\u0004¢\u0006\f\n\u0004\b\u001f\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010+\u001a\u00020'8\u0000X\u0004¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b)\u0010*R\u001a\u00100\u001a\u00020,8\u0000X\u0004¢\u0006\f\n\u0004\b\f\u0010-\u001a\u0004\b.\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u00102R$\u00108\u001a\u00020\t2\u0006\u00104\u001a\u00020\t8\u0000@BX\u000e¢\u0006\f\n\u0004\b\u0003\u00105\u001a\u0004\b6\u00107R\u001a\u0010=\u001a\u0002098\u0000X\u0004¢\u0006\f\n\u0004\b\r\u0010:\u001a\u0004\b;\u0010<R\u0014\u0010?\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b>\u00107¨\u0006B"}, d2 = {"Lokhttp3/internal/connection/c;", "", "Ljava/io/IOException;", "e", "", "s", "Lokhttp3/y;", "request", "t", "", "duplex", "Lokio/Sink;", "c", "f", "r", "expectContinue", "Lokhttp3/a0$a;", "p", "Lokhttp3/a0;", "response", "q", "Lokhttp3/b0;", "o", "m", "b", "d", "E", "", "bytesRead", "responseDone", "requestDone", "a", "(JZZLjava/io/IOException;)Ljava/io/IOException;", "n", "Lokhttp3/internal/connection/e;", "Lokhttp3/internal/connection/e;", "g", "()Lokhttp3/internal/connection/e;", "call", "Lokhttp3/q;", "Lokhttp3/q;", "i", "()Lokhttp3/q;", "eventListener", "Lokhttp3/internal/connection/d;", "Lokhttp3/internal/connection/d;", "j", "()Lokhttp3/internal/connection/d;", "finder", "Lfl/d;", "Lfl/d;", "codec", "<set-?>", "Z", "l", "()Z", "isDuplex", "Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/connection/RealConnection;", "h", "()Lokhttp3/internal/connection/RealConnection;", "connection", "k", "isCoalescedConnection", "<init>", "(Lokhttp3/internal/connection/e;Lokhttp3/q;Lokhttp3/internal/connection/d;Lfl/d;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final e f33020a;

    /* renamed from: b  reason: collision with root package name */
    private final q f33021b;

    /* renamed from: c  reason: collision with root package name */
    private final d f33022c;

    /* renamed from: d  reason: collision with root package name */
    private final d f33023d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f33024e;

    /* renamed from: f  reason: collision with root package name */
    private final RealConnection f33025f;

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0018\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/connection/c$a;", "Lokio/ForwardingSink;", "Ljava/io/IOException;", "E", "e", "a", "(Ljava/io/IOException;)Ljava/io/IOException;", "Lokio/Buffer;", "source", "", "byteCount", "", "k0", "flush", "close", "b", "J", "contentLength", "", "c", "Z", "completed", "d", "bytesReceived", "closed", "Lokio/Sink;", "delegate", "<init>", "(Lokhttp3/internal/connection/c;Lokio/Sink;J)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    private final class a extends ForwardingSink {

        /* renamed from: b  reason: collision with root package name */
        private final long f33026b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f33027c;

        /* renamed from: d  reason: collision with root package name */
        private long f33028d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f33029e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ c f33030f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, Sink sink, long j10) {
            super(sink);
            j.g(cVar, "this$0");
            j.g(sink, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
            this.f33030f = cVar;
            this.f33026b = j10;
        }

        private final <E extends IOException> E a(E e10) {
            if (this.f33027c) {
                return e10;
            }
            this.f33027c = true;
            return this.f33030f.a(this.f33028d, false, true, e10);
        }

        public void close() throws IOException {
            if (!this.f33029e) {
                this.f33029e = true;
                long j10 = this.f33026b;
                if (j10 == -1 || this.f33028d == j10) {
                    try {
                        super.close();
                        a((IOException) null);
                    } catch (IOException e10) {
                        throw a(e10);
                    }
                } else {
                    throw new ProtocolException("unexpected end of stream");
                }
            }
        }

        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e10) {
                throw a(e10);
            }
        }

        public void k0(Buffer buffer, long j10) throws IOException {
            j.g(buffer, "source");
            if (!this.f33029e) {
                long j11 = this.f33026b;
                if (j11 == -1 || this.f33028d + j10 <= j11) {
                    try {
                        super.k0(buffer, j10);
                        this.f33028d += j10;
                    } catch (IOException e10) {
                        throw a(e10);
                    }
                } else {
                    throw new ProtocolException("expected " + this.f33026b + " bytes but received " + (this.f33028d + j10));
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J!\u0010\f\u001a\u00028\u0000\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/connection/c$b;", "Lokio/ForwardingSource;", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "", "close", "Ljava/io/IOException;", "E", "e", "b", "(Ljava/io/IOException;)Ljava/io/IOException;", "J", "contentLength", "c", "bytesReceived", "", "d", "Z", "invokeStartEvent", "completed", "f", "closed", "Lokio/Source;", "delegate", "<init>", "(Lokhttp3/internal/connection/c;Lokio/Source;J)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class b extends ForwardingSource {

        /* renamed from: b  reason: collision with root package name */
        private final long f33031b;

        /* renamed from: c  reason: collision with root package name */
        private long f33032c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f33033d = true;

        /* renamed from: e  reason: collision with root package name */
        private boolean f33034e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f33035f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ c f33036g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, Source source, long j10) {
            super(source);
            j.g(cVar, "this$0");
            j.g(source, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
            this.f33036g = cVar;
            this.f33031b = j10;
            if (j10 == 0) {
                b((IOException) null);
            }
        }

        public long N1(Buffer buffer, long j10) throws IOException {
            j.g(buffer, "sink");
            if (!this.f33035f) {
                try {
                    long N1 = a().N1(buffer, j10);
                    if (this.f33033d) {
                        this.f33033d = false;
                        this.f33036g.i().v(this.f33036g.g());
                    }
                    if (N1 == -1) {
                        b((IOException) null);
                        return -1;
                    }
                    long j11 = this.f33032c + N1;
                    long j12 = this.f33031b;
                    if (j12 != -1) {
                        if (j11 > j12) {
                            throw new ProtocolException("expected " + this.f33031b + " bytes but received " + j11);
                        }
                    }
                    this.f33032c = j11;
                    if (j11 == j12) {
                        b((IOException) null);
                    }
                    return N1;
                } catch (IOException e10) {
                    throw b(e10);
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }

        public final <E extends IOException> E b(E e10) {
            if (this.f33034e) {
                return e10;
            }
            this.f33034e = true;
            if (e10 == null && this.f33033d) {
                this.f33033d = false;
                this.f33036g.i().v(this.f33036g.g());
            }
            return this.f33036g.a(this.f33032c, true, false, e10);
        }

        public void close() throws IOException {
            if (!this.f33035f) {
                this.f33035f = true;
                try {
                    super.close();
                    b((IOException) null);
                } catch (IOException e10) {
                    throw b(e10);
                }
            }
        }
    }

    public c(e eVar, q qVar, d dVar, d dVar2) {
        j.g(eVar, "call");
        j.g(qVar, "eventListener");
        j.g(dVar, "finder");
        j.g(dVar2, "codec");
        this.f33020a = eVar;
        this.f33021b = qVar;
        this.f33022c = dVar;
        this.f33023d = dVar2;
        this.f33025f = dVar2.getConnection();
    }

    private final void s(IOException iOException) {
        this.f33022c.h(iOException);
        this.f33023d.getConnection().G(this.f33020a, iOException);
    }

    public final <E extends IOException> E a(long j10, boolean z10, boolean z11, E e10) {
        if (e10 != null) {
            s(e10);
        }
        if (z11) {
            if (e10 != null) {
                this.f33021b.r(this.f33020a, e10);
            } else {
                this.f33021b.p(this.f33020a, j10);
            }
        }
        if (z10) {
            if (e10 != null) {
                this.f33021b.w(this.f33020a, e10);
            } else {
                this.f33021b.u(this.f33020a, j10);
            }
        }
        return this.f33020a.v(this, z11, z10, e10);
    }

    public final void b() {
        this.f33023d.cancel();
    }

    public final Sink c(y yVar, boolean z10) throws IOException {
        j.g(yVar, "request");
        this.f33024e = z10;
        z a10 = yVar.a();
        j.d(a10);
        long a11 = a10.a();
        this.f33021b.q(this.f33020a);
        return new a(this, this.f33023d.d(yVar, a11), a11);
    }

    public final void d() {
        this.f33023d.cancel();
        this.f33020a.v(this, true, true, null);
    }

    public final void e() throws IOException {
        try {
            this.f33023d.a();
        } catch (IOException e10) {
            this.f33021b.r(this.f33020a, e10);
            s(e10);
            throw e10;
        }
    }

    public final void f() throws IOException {
        try {
            this.f33023d.g();
        } catch (IOException e10) {
            this.f33021b.r(this.f33020a, e10);
            s(e10);
            throw e10;
        }
    }

    public final e g() {
        return this.f33020a;
    }

    public final RealConnection h() {
        return this.f33025f;
    }

    public final q i() {
        return this.f33021b;
    }

    public final d j() {
        return this.f33022c;
    }

    public final boolean k() {
        return !j.b(this.f33022c.d().l().i(), this.f33025f.z().a().l().i());
    }

    public final boolean l() {
        return this.f33024e;
    }

    public final void m() {
        this.f33023d.getConnection().y();
    }

    public final void n() {
        this.f33020a.v(this, true, false, null);
    }

    public final b0 o(a0 a0Var) throws IOException {
        j.g(a0Var, "response");
        try {
            String m10 = a0.m(a0Var, HttpHeaders.CONTENT_TYPE, (String) null, 2, (Object) null);
            long c10 = this.f33023d.c(a0Var);
            return new h(m10, c10, Okio.c(new b(this, this.f33023d.b(a0Var), c10)));
        } catch (IOException e10) {
            this.f33021b.w(this.f33020a, e10);
            s(e10);
            throw e10;
        }
    }

    public final a0.a p(boolean z10) throws IOException {
        try {
            a0.a f10 = this.f33023d.f(z10);
            if (f10 != null) {
                f10.m(this);
            }
            return f10;
        } catch (IOException e10) {
            this.f33021b.w(this.f33020a, e10);
            s(e10);
            throw e10;
        }
    }

    public final void q(a0 a0Var) {
        j.g(a0Var, "response");
        this.f33021b.x(this.f33020a, a0Var);
    }

    public final void r() {
        this.f33021b.y(this.f33020a);
    }

    public final void t(y yVar) throws IOException {
        j.g(yVar, "request");
        try {
            this.f33021b.t(this.f33020a);
            this.f33023d.e(yVar);
            this.f33021b.s(this.f33020a, yVar);
        } catch (IOException e10) {
            this.f33021b.r(this.f33020a, e10);
            s(e10);
            throw e10;
        }
    }
}
