package hl;

import com.coffeemeetsbagel.models.ModelDeeplinkData;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.s;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

@Metadata(bv = {}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 I2\u00020\u0001:\u0004 \u001c!\u0011B3\b\u0000\u0012\u0006\u0010&\u001a\u00020\u0015\u0012\u0006\u0010+\u001a\u00020'\u0012\u0006\u0010`\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\b¢\u0006\u0004\ba\u0010bJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015J\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u001c\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001eJ\u000f\u0010!\u001a\u00020\u0010H\u0000¢\u0006\u0004\b!\u0010\u001dJ\u000f\u0010\"\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\"\u0010\u001dR\u0017\u0010&\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b \u0010#\u001a\u0004\b$\u0010%R\u0017\u0010+\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b\u001c\u0010(\u001a\u0004\b)\u0010*R*\u00102\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001e8\u0006@@X\u000e¢\u0006\u0012\n\u0004\b!\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00105\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001e8\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R*\u00108\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001e8\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010-\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R*\u0010;\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001e8\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010-\u001a\u0004\b9\u0010/\"\u0004\b:\u00101R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\b0<8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010=R\u0016\u0010A\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001e\u0010\u0014\u001a\u00060BR\u00020\u00008\u0000X\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001e\u0010K\u001a\u00060GR\u00020\u00008\u0000X\u0004¢\u0006\f\n\u0004\b$\u0010H\u001a\u0004\bI\u0010JR\u001e\u0010P\u001a\u00060LR\u00020\u00008\u0000X\u0004¢\u0006\f\n\u0004\b3\u0010M\u001a\u0004\bN\u0010OR\u001e\u0010R\u001a\u00060LR\u00020\u00008\u0000X\u0004¢\u0006\f\n\u0004\b.\u0010M\u001a\u0004\bQ\u0010OR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028@@\u0000X\u000e¢\u0006\u0012\n\u0004\bN\u0010S\u001a\u0004\b?\u0010T\"\u0004\bU\u0010VR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010W\u001a\u0004\bC\u0010X\"\u0004\bY\u0010ZR\u0011\u0010]\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0011\u0010_\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b^\u0010\\¨\u0006c"}, d2 = {"Lhl/g;", "", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "Ljava/io/IOException;", "errorException", "", "e", "Lokhttp3/s;", "E", "Lokio/Timeout;", "v", "G", "Lokio/Sink;", "n", "rstStatusCode", "", "d", "f", "Lokio/BufferedSource;", "source", "", "length", "w", "headers", "inFinished", "x", "y", "b", "()V", "", "delta", "a", "c", "F", "I", "j", "()I", "id", "Lhl/d;", "Lhl/d;", "g", "()Lhl/d;", "connection", "<set-?>", "J", "l", "()J", "C", "(J)V", "readBytesTotal", "k", "B", "readBytesAcknowledged", "r", "D", "writeBytesTotal", "q", "setWriteBytesMaximum$okhttp", "writeBytesMaximum", "Ljava/util/ArrayDeque;", "Ljava/util/ArrayDeque;", "headersQueue", "h", "Z", "hasResponseHeaders", "Lhl/g$c;", "i", "Lhl/g$c;", "p", "()Lhl/g$c;", "Lhl/g$b;", "Lhl/g$b;", "o", "()Lhl/g$b;", "sink", "Lhl/g$d;", "Lhl/g$d;", "m", "()Lhl/g$d;", "readTimeout", "s", "writeTimeout", "Lokhttp3/internal/http2/ErrorCode;", "()Lokhttp3/internal/http2/ErrorCode;", "z", "(Lokhttp3/internal/http2/ErrorCode;)V", "Ljava/io/IOException;", "()Ljava/io/IOException;", "A", "(Ljava/io/IOException;)V", "u", "()Z", "isOpen", "t", "isLocallyInitiated", "outFinished", "<init>", "(ILhl/d;ZZLokhttp3/s;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class g {

    /* renamed from: o  reason: collision with root package name */
    public static final a f29897o = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f29898a;

    /* renamed from: b  reason: collision with root package name */
    private final d f29899b;

    /* renamed from: c  reason: collision with root package name */
    private long f29900c;

    /* renamed from: d  reason: collision with root package name */
    private long f29901d;

    /* renamed from: e  reason: collision with root package name */
    private long f29902e;

    /* renamed from: f  reason: collision with root package name */
    private long f29903f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayDeque<s> f29904g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f29905h;

    /* renamed from: i  reason: collision with root package name */
    private final c f29906i;

    /* renamed from: j  reason: collision with root package name */
    private final b f29907j;

    /* renamed from: k  reason: collision with root package name */
    private final d f29908k = new d(this);

    /* renamed from: l  reason: collision with root package name */
    private final d f29909l = new d(this);

    /* renamed from: m  reason: collision with root package name */
    private ErrorCode f29910m;

    /* renamed from: n  reason: collision with root package name */
    private IOException f29911n;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lhl/g$a;", "", "", "EMIT_BUFFER_SIZE", "J", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b \u0010\u0013¨\u0006$"}, d2 = {"Lhl/g$b;", "Lokio/Sink;", "", "outFinishedOnLastFrame", "", "a", "Lokio/Buffer;", "source", "", "byteCount", "k0", "flush", "Lokio/Timeout;", "p", "close", "Z", "c", "()Z", "setFinished", "(Z)V", "finished", "b", "Lokio/Buffer;", "sendBuffer", "Lokhttp3/s;", "Lokhttp3/s;", "getTrailers", "()Lokhttp3/s;", "setTrailers", "(Lokhttp3/s;)V", "trailers", "d", "e", "closed", "<init>", "(Lhl/g;Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class b implements Sink {

        /* renamed from: a  reason: collision with root package name */
        private boolean f29912a;

        /* renamed from: b  reason: collision with root package name */
        private final Buffer f29913b = new Buffer();

        /* renamed from: c  reason: collision with root package name */
        private s f29914c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f29915d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ g f29916e;

        public b(g gVar, boolean z10) {
            j.g(gVar, "this$0");
            this.f29916e = gVar;
            this.f29912a = z10;
        }

        /* JADX INFO: finally extract failed */
        private final void a(boolean z10) throws IOException {
            long min;
            boolean z11;
            boolean z12;
            g gVar = this.f29916e;
            synchronized (gVar) {
                gVar.s().u();
                while (gVar.r() >= gVar.q() && !c() && !b() && gVar.h() == null) {
                    try {
                        gVar.F();
                    } catch (Throwable th2) {
                        gVar.s().B();
                        throw th2;
                    }
                }
                gVar.s().B();
                gVar.c();
                min = Math.min(gVar.q() - gVar.r(), this.f29913b.size());
                gVar.D(gVar.r() + min);
                if (!z10 || min != this.f29913b.size()) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                z12 = z11;
                Unit unit = Unit.f32013a;
            }
            this.f29916e.s().u();
            try {
                this.f29916e.g().a1(this.f29916e.j(), z12, this.f29913b, min);
            } finally {
                this.f29916e.s().B();
            }
        }

        public final boolean b() {
            return this.f29915d;
        }

        public final boolean c() {
            return this.f29912a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
            if (r10.f29916e.o().f29912a != false) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
            if (r10.f29913b.size() <= 0) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0063, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0068, code lost:
            if (r10.f29914c == null) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006a, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x006d, code lost:
            if (r4 == false) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0077, code lost:
            if (r10.f29913b.size() <= 0) goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0079, code lost:
            a(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x007d, code lost:
            r0 = r10.f29916e.g();
            r2 = r10.f29916e.j();
            r4 = r10.f29914c;
            kotlin.jvm.internal.j.d(r4);
            r0.b1(r2, r1, bl.d.O(r4));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0096, code lost:
            if (r0 == false) goto L_0x00a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a0, code lost:
            if (r10.f29913b.size() <= 0) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a2, code lost:
            a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
            if (r1 == false) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
            r10.f29916e.g().a1(r10.f29916e.j(), true, (okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bb, code lost:
            r0 = r10.f29916e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bd, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            e(true);
            r1 = kotlin.Unit.f32013a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c3, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c4, code lost:
            r10.f29916e.g().flush();
            r10.f29916e.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d2, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r10 = this;
                hl.g r0 = r10.f29916e
                boolean r1 = bl.d.f24935h
                if (r1 == 0) goto L_0x0034
                boolean r1 = java.lang.Thread.holdsLock(r0)
                if (r1 != 0) goto L_0x000d
                goto L_0x0034
            L_0x000d:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Thread "
                r2.append(r3)
                java.lang.Thread r3 = java.lang.Thread.currentThread()
                java.lang.String r3 = r3.getName()
                r2.append(r3)
                java.lang.String r3 = " MUST NOT hold lock on "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r1.<init>(r0)
                throw r1
            L_0x0034:
                hl.g r0 = r10.f29916e
                monitor-enter(r0)
                boolean r1 = r10.b()     // Catch:{ all -> 0x00d6 }
                if (r1 == 0) goto L_0x003f
                monitor-exit(r0)
                return
            L_0x003f:
                okhttp3.internal.http2.ErrorCode r1 = r0.h()     // Catch:{ all -> 0x00d6 }
                r2 = 0
                r3 = 1
                if (r1 != 0) goto L_0x0049
                r1 = r3
                goto L_0x004a
            L_0x0049:
                r1 = r2
            L_0x004a:
                kotlin.Unit r4 = kotlin.Unit.f32013a     // Catch:{ all -> 0x00d6 }
                monitor-exit(r0)
                hl.g r0 = r10.f29916e
                hl.g$b r0 = r0.o()
                boolean r0 = r0.f29912a
                if (r0 != 0) goto L_0x00bb
                okio.Buffer r0 = r10.f29913b
                long r4 = r0.size()
                r6 = 0
                int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r0 <= 0) goto L_0x0065
                r0 = r3
                goto L_0x0066
            L_0x0065:
                r0 = r2
            L_0x0066:
                okhttp3.s r4 = r10.f29914c
                if (r4 == 0) goto L_0x006c
                r4 = r3
                goto L_0x006d
            L_0x006c:
                r4 = r2
            L_0x006d:
                if (r4 == 0) goto L_0x0096
            L_0x006f:
                okio.Buffer r0 = r10.f29913b
                long r4 = r0.size()
                int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r0 <= 0) goto L_0x007d
                r10.a(r2)
                goto L_0x006f
            L_0x007d:
                hl.g r0 = r10.f29916e
                hl.d r0 = r0.g()
                hl.g r2 = r10.f29916e
                int r2 = r2.j()
                okhttp3.s r4 = r10.f29914c
                kotlin.jvm.internal.j.d(r4)
                java.util.List r4 = bl.d.O(r4)
                r0.b1(r2, r1, r4)
                goto L_0x00bb
            L_0x0096:
                if (r0 == 0) goto L_0x00a6
            L_0x0098:
                okio.Buffer r0 = r10.f29913b
                long r0 = r0.size()
                int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r0 <= 0) goto L_0x00bb
                r10.a(r3)
                goto L_0x0098
            L_0x00a6:
                if (r1 == 0) goto L_0x00bb
                hl.g r0 = r10.f29916e
                hl.d r4 = r0.g()
                hl.g r0 = r10.f29916e
                int r5 = r0.j()
                r6 = 1
                r7 = 0
                r8 = 0
                r4.a1(r5, r6, r7, r8)
            L_0x00bb:
                hl.g r0 = r10.f29916e
                monitor-enter(r0)
                r10.e(r3)     // Catch:{ all -> 0x00d3 }
                kotlin.Unit r1 = kotlin.Unit.f32013a     // Catch:{ all -> 0x00d3 }
                monitor-exit(r0)
                hl.g r0 = r10.f29916e
                hl.d r0 = r0.g()
                r0.flush()
                hl.g r0 = r10.f29916e
                r0.b()
                return
            L_0x00d3:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            L_0x00d6:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: hl.g.b.close():void");
        }

        public final void e(boolean z10) {
            this.f29915d = z10;
        }

        public void flush() throws IOException {
            g gVar = this.f29916e;
            if (!bl.d.f24935h || !Thread.holdsLock(gVar)) {
                g gVar2 = this.f29916e;
                synchronized (gVar2) {
                    gVar2.c();
                    Unit unit = Unit.f32013a;
                }
                while (this.f29913b.size() > 0) {
                    a(false);
                    this.f29916e.g().flush();
                }
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + gVar);
        }

        public void k0(Buffer buffer, long j10) throws IOException {
            j.g(buffer, "source");
            g gVar = this.f29916e;
            if (!bl.d.f24935h || !Thread.holdsLock(gVar)) {
                this.f29913b.k0(buffer, j10);
                while (this.f29913b.size() >= 16384) {
                    a(false);
                }
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + gVar);
        }

        public Timeout p() {
            return this.f29916e.s();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010!\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b\u001b\u0010\u001eR$\u0010(\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010*\u001a\u00020\u00148\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017\"\u0004\b)\u0010\u0019¨\u0006-"}, d2 = {"Lhl/g$c;", "Lokio/Source;", "", "read", "", "l", "Lokio/Buffer;", "sink", "byteCount", "N1", "Lokio/BufferedSource;", "source", "f", "(Lokio/BufferedSource;J)V", "Lokio/Timeout;", "p", "close", "a", "J", "maxByteCount", "", "b", "Z", "()Z", "h", "(Z)V", "finished", "c", "Lokio/Buffer;", "e", "()Lokio/Buffer;", "receiveBuffer", "d", "readBuffer", "Lokhttp3/s;", "Lokhttp3/s;", "getTrailers", "()Lokhttp3/s;", "k", "(Lokhttp3/s;)V", "trailers", "g", "closed", "<init>", "(Lhl/g;JZ)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class c implements Source {

        /* renamed from: a  reason: collision with root package name */
        private final long f29917a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f29918b;

        /* renamed from: c  reason: collision with root package name */
        private final Buffer f29919c = new Buffer();

        /* renamed from: d  reason: collision with root package name */
        private final Buffer f29920d = new Buffer();

        /* renamed from: e  reason: collision with root package name */
        private s f29921e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f29922f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ g f29923g;

        public c(g gVar, long j10, boolean z10) {
            j.g(gVar, "this$0");
            this.f29923g = gVar;
            this.f29917a = j10;
            this.f29918b = z10;
        }

        private final void l(long j10) {
            g gVar = this.f29923g;
            if (!bl.d.f24935h || !Thread.holdsLock(gVar)) {
                this.f29923g.g().W0(j10);
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + gVar);
        }

        /* JADX INFO: finally extract failed */
        public long N1(Buffer buffer, long j10) throws IOException {
            boolean z10;
            long j11;
            boolean z11;
            Buffer buffer2 = buffer;
            long j12 = j10;
            j.g(buffer2, "sink");
            long j13 = 0;
            if (j12 >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                while (true) {
                    Throwable th2 = null;
                    g gVar = this.f29923g;
                    synchronized (gVar) {
                        gVar.m().u();
                        try {
                            if (gVar.h() != null && (th2 = gVar.i()) == null) {
                                ErrorCode h10 = gVar.h();
                                j.d(h10);
                                th2 = new StreamResetException(h10);
                            }
                            if (!a()) {
                                if (c().size() > j13) {
                                    j11 = c().N1(buffer2, Math.min(j12, c().size()));
                                    gVar.C(gVar.l() + j11);
                                    long l10 = gVar.l() - gVar.k();
                                    if (th2 == null && l10 >= ((long) (gVar.g().S().c() / 2))) {
                                        gVar.g().g1(gVar.j(), l10);
                                        gVar.B(gVar.l());
                                    }
                                } else if (b() || th2 != null) {
                                    j11 = -1;
                                } else {
                                    gVar.F();
                                    j11 = -1;
                                    z11 = true;
                                    gVar.m().B();
                                    Unit unit = Unit.f32013a;
                                }
                                z11 = false;
                                gVar.m().B();
                                Unit unit2 = Unit.f32013a;
                            } else {
                                throw new IOException("stream closed");
                            }
                        } catch (Throwable th3) {
                            gVar.m().B();
                            throw th3;
                        }
                    }
                    if (z11) {
                        j13 = 0;
                    } else if (j11 != -1) {
                        l(j11);
                        return j11;
                    } else if (th2 == null) {
                        return -1;
                    } else {
                        throw th2;
                    }
                }
            } else {
                throw new IllegalArgumentException(j.p("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
        }

        public final boolean a() {
            return this.f29922f;
        }

        public final boolean b() {
            return this.f29918b;
        }

        public final Buffer c() {
            return this.f29920d;
        }

        public void close() throws IOException {
            long size;
            g gVar = this.f29923g;
            synchronized (gVar) {
                g(true);
                size = c().size();
                c().a();
                gVar.notifyAll();
                Unit unit = Unit.f32013a;
            }
            if (size > 0) {
                l(size);
            }
            this.f29923g.b();
        }

        public final Buffer e() {
            return this.f29919c;
        }

        public final void f(BufferedSource bufferedSource, long j10) throws IOException {
            boolean b10;
            boolean z10;
            boolean z11;
            long j11;
            j.g(bufferedSource, "source");
            g gVar = this.f29923g;
            if (!bl.d.f24935h || !Thread.holdsLock(gVar)) {
                while (j10 > 0) {
                    synchronized (this.f29923g) {
                        b10 = b();
                        z10 = true;
                        if (c().size() + j10 > this.f29917a) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        Unit unit = Unit.f32013a;
                    }
                    if (z11) {
                        bufferedSource.skip(j10);
                        this.f29923g.f(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (b10) {
                        bufferedSource.skip(j10);
                        return;
                    } else {
                        long N1 = bufferedSource.N1(this.f29919c, j10);
                        if (N1 != -1) {
                            j10 -= N1;
                            g gVar2 = this.f29923g;
                            synchronized (gVar2) {
                                if (a()) {
                                    j11 = e().size();
                                    e().a();
                                } else {
                                    if (c().size() != 0) {
                                        z10 = false;
                                    }
                                    c().o0(e());
                                    if (z10) {
                                        gVar2.notifyAll();
                                    }
                                    j11 = 0;
                                }
                            }
                            if (j11 > 0) {
                                l(j11);
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + gVar);
        }

        public final void g(boolean z10) {
            this.f29922f = z10;
        }

        public final void h(boolean z10) {
            this.f29918b = z10;
        }

        public final void k(s sVar) {
            this.f29921e = sVar;
        }

        public Timeout p() {
            return this.f29923g.m();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lhl/g$d;", "Lokio/AsyncTimeout;", "", "A", "Ljava/io/IOException;", "cause", "w", "B", "<init>", "(Lhl/g;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class d extends AsyncTimeout {

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ g f29924m;

        public d(g gVar) {
            j.g(gVar, "this$0");
            this.f29924m = gVar;
        }

        /* access modifiers changed from: protected */
        public void A() {
            this.f29924m.f(ErrorCode.CANCEL);
            this.f29924m.g().H0();
        }

        public final void B() throws IOException {
            if (v()) {
                throw w((IOException) null);
            }
        }

        /* access modifiers changed from: protected */
        public IOException w(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }
    }

    public g(int i10, d dVar, boolean z10, boolean z11, s sVar) {
        j.g(dVar, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
        this.f29898a = i10;
        this.f29899b = dVar;
        this.f29903f = (long) dVar.Y().c();
        ArrayDeque<s> arrayDeque = new ArrayDeque<>();
        this.f29904g = arrayDeque;
        this.f29906i = new c(this, (long) dVar.S().c(), z11);
        this.f29907j = new b(this, z10);
        if (sVar != null) {
            if (!t()) {
                arrayDeque.add(sVar);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
        } else if (!t()) {
            throw new IllegalStateException("remotely-initiated streams should have headers".toString());
        }
    }

    private final boolean e(ErrorCode errorCode, IOException iOException) {
        if (!bl.d.f24935h || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (h() != null) {
                    return false;
                }
                if (p().b() && o().c()) {
                    return false;
                }
                z(errorCode);
                A(iOException);
                notifyAll();
                Unit unit = Unit.f32013a;
                this.f29899b.E0(this.f29898a);
                return true;
            }
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void A(IOException iOException) {
        this.f29911n = iOException;
    }

    public final void B(long j10) {
        this.f29901d = j10;
    }

    public final void C(long j10) {
        this.f29900c = j10;
    }

    public final void D(long j10) {
        this.f29902e = j10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        r2.f29908k.B();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized okhttp3.s E() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            hl.g$d r0 = r2.f29908k     // Catch:{ all -> 0x004a }
            r0.u()     // Catch:{ all -> 0x004a }
        L_0x0006:
            java.util.ArrayDeque<okhttp3.s> r0 = r2.f29904g     // Catch:{ all -> 0x0043 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0016
            okhttp3.internal.http2.ErrorCode r0 = r2.f29910m     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x0016
            r2.F()     // Catch:{ all -> 0x0043 }
            goto L_0x0006
        L_0x0016:
            hl.g$d r0 = r2.f29908k     // Catch:{ all -> 0x004a }
            r0.B()     // Catch:{ all -> 0x004a }
            java.util.ArrayDeque<okhttp3.s> r0 = r2.f29904g     // Catch:{ all -> 0x004a }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x004a }
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0034
            java.util.ArrayDeque<okhttp3.s> r0 = r2.f29904g     // Catch:{ all -> 0x004a }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x004a }
            java.lang.String r1 = "headersQueue.removeFirst()"
            kotlin.jvm.internal.j.f(r0, r1)     // Catch:{ all -> 0x004a }
            okhttp3.s r0 = (okhttp3.s) r0     // Catch:{ all -> 0x004a }
            monitor-exit(r2)
            return r0
        L_0x0034:
            java.io.IOException r0 = r2.f29911n     // Catch:{ all -> 0x004a }
            if (r0 != 0) goto L_0x0042
            okhttp3.internal.http2.StreamResetException r0 = new okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x004a }
            okhttp3.internal.http2.ErrorCode r1 = r2.f29910m     // Catch:{ all -> 0x004a }
            kotlin.jvm.internal.j.d(r1)     // Catch:{ all -> 0x004a }
            r0.<init>(r1)     // Catch:{ all -> 0x004a }
        L_0x0042:
            throw r0     // Catch:{ all -> 0x004a }
        L_0x0043:
            r0 = move-exception
            hl.g$d r1 = r2.f29908k     // Catch:{ all -> 0x004a }
            r1.B()     // Catch:{ all -> 0x004a }
            throw r0     // Catch:{ all -> 0x004a }
        L_0x004a:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hl.g.E():okhttp3.s");
    }

    public final void F() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final Timeout G() {
        return this.f29909l;
    }

    public final void a(long j10) {
        this.f29903f += j10;
        if (j10 > 0) {
            notifyAll();
        }
    }

    public final void b() throws IOException {
        boolean z10;
        boolean u10;
        if (!bl.d.f24935h || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (p().b() || !p().a() || (!o().c() && !o().b())) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                u10 = u();
                Unit unit = Unit.f32013a;
            }
            if (z10) {
                d(ErrorCode.CANCEL, (IOException) null);
            } else if (!u10) {
                this.f29899b.E0(this.f29898a);
            }
        } else {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
    }

    public final void c() throws IOException {
        if (this.f29907j.b()) {
            throw new IOException("stream closed");
        } else if (this.f29907j.c()) {
            throw new IOException("stream finished");
        } else if (this.f29910m != null) {
            Throwable th2 = this.f29911n;
            if (th2 == null) {
                ErrorCode errorCode = this.f29910m;
                j.d(errorCode);
                th2 = new StreamResetException(errorCode);
            }
            throw th2;
        }
    }

    public final void d(ErrorCode errorCode, IOException iOException) throws IOException {
        j.g(errorCode, "rstStatusCode");
        if (e(errorCode, iOException)) {
            this.f29899b.d1(this.f29898a, errorCode);
        }
    }

    public final void f(ErrorCode errorCode) {
        j.g(errorCode, "errorCode");
        if (e(errorCode, (IOException) null)) {
            this.f29899b.e1(this.f29898a, errorCode);
        }
    }

    public final d g() {
        return this.f29899b;
    }

    public final synchronized ErrorCode h() {
        return this.f29910m;
    }

    public final IOException i() {
        return this.f29911n;
    }

    public final int j() {
        return this.f29898a;
    }

    public final long k() {
        return this.f29901d;
    }

    public final long l() {
        return this.f29900c;
    }

    public final d m() {
        return this.f29908k;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okio.Sink n() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f29905h     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x000e
            boolean r0 = r2.t()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x000c
            goto L_0x000e
        L_0x000c:
            r0 = 0
            goto L_0x000f
        L_0x000e:
            r0 = 1
        L_0x000f:
            if (r0 == 0) goto L_0x0017
            kotlin.Unit r0 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            hl.g$b r0 = r2.f29907j
            return r0
        L_0x0017:
            java.lang.String r0 = "reply before requesting the sink"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0023 }
            r1.<init>(r0)     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hl.g.n():okio.Sink");
    }

    public final b o() {
        return this.f29907j;
    }

    public final c p() {
        return this.f29906i;
    }

    public final long q() {
        return this.f29903f;
    }

    public final long r() {
        return this.f29902e;
    }

    public final d s() {
        return this.f29909l;
    }

    public final boolean t() {
        boolean z10;
        if ((this.f29898a & 1) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f29899b.J() == z10) {
            return true;
        }
        return false;
    }

    public final synchronized boolean u() {
        if (this.f29910m != null) {
            return false;
        }
        if ((this.f29906i.b() || this.f29906i.a()) && ((this.f29907j.c() || this.f29907j.b()) && this.f29905h)) {
            return false;
        }
        return true;
    }

    public final Timeout v() {
        return this.f29908k;
    }

    public final void w(BufferedSource bufferedSource, int i10) throws IOException {
        j.g(bufferedSource, "source");
        if (!bl.d.f24935h || !Thread.holdsLock(this)) {
            this.f29906i.f(bufferedSource, (long) i10);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void x(okhttp3.s r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.j.g(r3, r0)
            boolean r0 = bl.d.f24935h
            if (r0 == 0) goto L_0x0037
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto L_0x0010
            goto L_0x0037
        L_0x0010:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Thread "
            r4.append(r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r0 = r0.getName()
            r4.append(r0)
            java.lang.String r0 = " MUST NOT hold lock on "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x0037:
            monitor-enter(r2)
            boolean r0 = r2.f29905h     // Catch:{ all -> 0x006c }
            r1 = 1
            if (r0 == 0) goto L_0x0048
            if (r4 != 0) goto L_0x0040
            goto L_0x0048
        L_0x0040:
            hl.g$c r0 = r2.p()     // Catch:{ all -> 0x006c }
            r0.k(r3)     // Catch:{ all -> 0x006c }
            goto L_0x004f
        L_0x0048:
            r2.f29905h = r1     // Catch:{ all -> 0x006c }
            java.util.ArrayDeque<okhttp3.s> r0 = r2.f29904g     // Catch:{ all -> 0x006c }
            r0.add(r3)     // Catch:{ all -> 0x006c }
        L_0x004f:
            if (r4 == 0) goto L_0x0058
            hl.g$c r3 = r2.p()     // Catch:{ all -> 0x006c }
            r3.h(r1)     // Catch:{ all -> 0x006c }
        L_0x0058:
            boolean r3 = r2.u()     // Catch:{ all -> 0x006c }
            r2.notifyAll()     // Catch:{ all -> 0x006c }
            kotlin.Unit r4 = kotlin.Unit.f32013a     // Catch:{ all -> 0x006c }
            monitor-exit(r2)
            if (r3 != 0) goto L_0x006b
            hl.d r3 = r2.f29899b
            int r4 = r2.f29898a
            r3.E0(r4)
        L_0x006b:
            return
        L_0x006c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: hl.g.x(okhttp3.s, boolean):void");
    }

    public final synchronized void y(ErrorCode errorCode) {
        j.g(errorCode, "errorCode");
        if (this.f29910m == null) {
            this.f29910m = errorCode;
            notifyAll();
        }
    }

    public final void z(ErrorCode errorCode) {
        this.f29910m = errorCode;
    }
}
