package okhttp3.internal.connection;

import bl.d;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.leanplum.internal.Constants;
import fl.g;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;
import okhttp3.CertificatePinner;
import okhttp3.a0;
import okhttp3.f;
import okhttp3.o;
import okhttp3.q;
import okhttp3.t;
import okhttp3.x;
import okhttp3.y;
import okio.AsyncTimeout;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017*\u0001O\u0018\u00002\u00020\u0001:\u00029>B\u001f\u0012\u0006\u0010=\u001a\u000208\u0012\u0006\u0010B\u001a\u00020\u0011\u0012\u0006\u0010F\u001a\u00020\u0014¢\u0006\u0004\bm\u0010nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J#\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\u00028\u0000\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u000f\u0010\u001b\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0014J\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0004\b#\u0010$J\u000e\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%J;\u0010+\u001a\u00028\u0000\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00028\u0000H\u0000¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b-\u0010\u0007J\u0011\u0010/\u001a\u0004\u0018\u00010.H\u0000¢\u0006\u0004\b/\u00100J\u0006\u00101\u001a\u00020\u0002J\u0017\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0014H\u0000¢\u0006\u0004\b3\u00104J\u0006\u00105\u001a\u00020\u0014J\u000f\u00106\u001a\u00020\u000eH\u0000¢\u0006\u0004\b6\u00107R\u0017\u0010=\u001a\u0002088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0017\u0010B\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010F\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b'\u0010C\u001a\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020G8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010HR\u001a\u0010N\u001a\u00020J8\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010K\u001a\u0004\bL\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010PR\u0014\u0010T\u001a\u00020R8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010YR(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010[\u001a\u0004\u0018\u00010%8\u0006@BX\u000e¢\u0006\f\n\u0004\b3\u0010\\\u001a\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010CR(\u0010c\u001a\u0004\u0018\u00010\"2\b\u0010[\u001a\u0004\u0018\u00010\"8\u0000@BX\u000e¢\u0006\f\n\u0004\b\u0015\u0010`\u001a\u0004\ba\u0010bR\u0016\u0010e\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010CR\u0016\u0010f\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010CR\u0016\u0010g\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010CR\u0016\u0010h\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010CR\u0018\u0010(\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010`R$\u0010l\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b6\u0010\\\u001a\u0004\bi\u0010^\"\u0004\bj\u0010k¨\u0006o"}, d2 = {"Lokhttp3/internal/connection/e;", "Lokhttp3/e;", "", "e", "Ljava/io/IOException;", "E", "d", "(Ljava/io/IOException;)Ljava/io/IOException;", "cause", "C", "Lokhttp3/t;", "url", "Lokhttp3/a;", "i", "", "D", "h", "Lokhttp3/y;", "g", "cancel", "", "m", "Lokhttp3/a0;", "f", "Lokhttp3/f;", "responseCallback", "P", "t", "()Lokhttp3/a0;", "request", "newExchangeFinder", "j", "Lfl/g;", "chain", "Lokhttp3/internal/connection/c;", "u", "(Lfl/g;)Lokhttp3/internal/connection/c;", "Lokhttp3/internal/connection/RealConnection;", "connection", "c", "exchange", "requestDone", "responseDone", "v", "(Lokhttp3/internal/connection/c;ZZLjava/io/IOException;)Ljava/io/IOException;", "w", "Ljava/net/Socket;", "y", "()Ljava/net/Socket;", "B", "closeExchange", "k", "(Z)V", "z", "x", "()Ljava/lang/String;", "Lokhttp3/x;", "a", "Lokhttp3/x;", "l", "()Lokhttp3/x;", "client", "b", "Lokhttp3/y;", "s", "()Lokhttp3/y;", "originalRequest", "Z", "q", "()Z", "forWebSocket", "Lokhttp3/internal/connection/f;", "Lokhttp3/internal/connection/f;", "connectionPool", "Lokhttp3/q;", "Lokhttp3/q;", "p", "()Lokhttp3/q;", "eventListener", "okhttp3/internal/connection/e$c", "Lokhttp3/internal/connection/e$c;", "timeout", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "executed", "", "Ljava/lang/Object;", "callStackTrace", "Lokhttp3/internal/connection/d;", "Lokhttp3/internal/connection/d;", "exchangeFinder", "<set-?>", "Lokhttp3/internal/connection/RealConnection;", "o", "()Lokhttp3/internal/connection/RealConnection;", "timeoutEarlyExit", "Lokhttp3/internal/connection/c;", "r", "()Lokhttp3/internal/connection/c;", "interceptorScopedExchange", "n", "requestBodyOpen", "responseBodyOpen", "expectMoreExchanges", "canceled", "getConnectionToCancel", "A", "(Lokhttp3/internal/connection/RealConnection;)V", "connectionToCancel", "<init>", "(Lokhttp3/x;Lokhttp3/y;Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class e implements okhttp3.e {

    /* renamed from: a  reason: collision with root package name */
    private final x f33047a;

    /* renamed from: b  reason: collision with root package name */
    private final y f33048b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f33049c;

    /* renamed from: d  reason: collision with root package name */
    private final f f33050d;

    /* renamed from: e  reason: collision with root package name */
    private final q f33051e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final c f33052f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicBoolean f33053g = new AtomicBoolean();

    /* renamed from: h  reason: collision with root package name */
    private Object f33054h;

    /* renamed from: j  reason: collision with root package name */
    private d f33055j;

    /* renamed from: k  reason: collision with root package name */
    private RealConnection f33056k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f33057l;

    /* renamed from: m  reason: collision with root package name */
    private c f33058m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f33059n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f33060p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f33061q = true;

    /* renamed from: t  reason: collision with root package name */
    private volatile boolean f33062t;

    /* renamed from: w  reason: collision with root package name */
    private volatile c f33063w;

    /* renamed from: x  reason: collision with root package name */
    private volatile RealConnection f33064x;

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u00060\u0000R\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\u0004H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000bR$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0018¨\u0006\u001c"}, d2 = {"Lokhttp3/internal/connection/e$a;", "Ljava/lang/Runnable;", "Lokhttp3/internal/connection/e;", "other", "", "e", "Ljava/util/concurrent/ExecutorService;", "executorService", "a", "run", "Lokhttp3/f;", "Lokhttp3/f;", "responseCallback", "Ljava/util/concurrent/atomic/AtomicInteger;", "<set-?>", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "c", "()Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "", "d", "()Ljava/lang/String;", "host", "()Lokhttp3/internal/connection/e;", "call", "<init>", "(Lokhttp3/internal/connection/e;Lokhttp3/f;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final f f33065a;

        /* renamed from: b  reason: collision with root package name */
        private volatile AtomicInteger f33066b = new AtomicInteger(0);

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f33067c;

        public a(e eVar, f fVar) {
            j.g(eVar, "this$0");
            j.g(fVar, "responseCallback");
            this.f33067c = eVar;
            this.f33065a = fVar;
        }

        public final void a(ExecutorService executorService) {
            j.g(executorService, "executorService");
            o p10 = this.f33067c.l().p();
            if (!d.f24935h || !Thread.holdsLock(p10)) {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e10) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e10);
                    this.f33067c.w(interruptedIOException);
                    this.f33065a.onFailure(this.f33067c, interruptedIOException);
                    this.f33067c.l().p().f(this);
                } catch (Throwable th2) {
                    this.f33067c.l().p().f(this);
                    throw th2;
                }
            } else {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + p10);
            }
        }

        public final e b() {
            return this.f33067c;
        }

        public final AtomicInteger c() {
            return this.f33066b;
        }

        public final String d() {
            return this.f33067c.s().j().i();
        }

        public final void e(a aVar) {
            j.g(aVar, "other");
            this.f33066b = aVar.f33066b;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[Catch:{ all -> 0x0058, all -> 0x0093 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0060 A[Catch:{ all -> 0x0058, all -> 0x0093 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0075 A[Catch:{ all -> 0x0058, all -> 0x0093 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                okhttp3.internal.connection.e r0 = r8.f33067c
                java.lang.String r0 = r0.x()
                java.lang.String r1 = "OkHttp "
                java.lang.String r0 = kotlin.jvm.internal.j.p(r1, r0)
                okhttp3.internal.connection.e r1 = r8.f33067c
                java.lang.Thread r2 = java.lang.Thread.currentThread()
                java.lang.String r3 = r2.getName()
                r2.setName(r0)
                r0 = 0
                okhttp3.internal.connection.e$c r4 = r1.f33052f     // Catch:{ all -> 0x0093 }
                r4.u()     // Catch:{ all -> 0x0093 }
                okhttp3.a0 r0 = r1.t()     // Catch:{ IOException -> 0x005a, all -> 0x003b }
                r4 = 1
                okhttp3.f r5 = r8.f33065a     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
                r5.onResponse(r1, r0)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
                okhttp3.x r0 = r1.l()     // Catch:{ all -> 0x0093 }
                okhttp3.o r0 = r0.p()     // Catch:{ all -> 0x0093 }
            L_0x0033:
                r0.f(r8)     // Catch:{ all -> 0x0093 }
                goto L_0x0083
            L_0x0037:
                r0 = move-exception
                goto L_0x003f
            L_0x0039:
                r0 = move-exception
                goto L_0x005e
            L_0x003b:
                r4 = move-exception
                r7 = r4
                r4 = r0
                r0 = r7
            L_0x003f:
                r1.cancel()     // Catch:{ all -> 0x0058 }
                if (r4 != 0) goto L_0x0057
                java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0058 }
                java.lang.String r5 = "canceled due to "
                java.lang.String r5 = kotlin.jvm.internal.j.p(r5, r0)     // Catch:{ all -> 0x0058 }
                r4.<init>(r5)     // Catch:{ all -> 0x0058 }
                gk.b.a(r4, r0)     // Catch:{ all -> 0x0058 }
                okhttp3.f r5 = r8.f33065a     // Catch:{ all -> 0x0058 }
                r5.onFailure(r1, r4)     // Catch:{ all -> 0x0058 }
            L_0x0057:
                throw r0     // Catch:{ all -> 0x0058 }
            L_0x0058:
                r0 = move-exception
                goto L_0x0087
            L_0x005a:
                r4 = move-exception
                r7 = r4
                r4 = r0
                r0 = r7
            L_0x005e:
                if (r4 == 0) goto L_0x0075
                il.j$a r4 = il.j.f30050a     // Catch:{ all -> 0x0058 }
                il.j r4 = r4.g()     // Catch:{ all -> 0x0058 }
                java.lang.String r5 = "Callback failure for "
                java.lang.String r6 = r1.D()     // Catch:{ all -> 0x0058 }
                java.lang.String r5 = kotlin.jvm.internal.j.p(r5, r6)     // Catch:{ all -> 0x0058 }
                r6 = 4
                r4.j(r5, r6, r0)     // Catch:{ all -> 0x0058 }
                goto L_0x007a
            L_0x0075:
                okhttp3.f r4 = r8.f33065a     // Catch:{ all -> 0x0058 }
                r4.onFailure(r1, r0)     // Catch:{ all -> 0x0058 }
            L_0x007a:
                okhttp3.x r0 = r1.l()     // Catch:{ all -> 0x0093 }
                okhttp3.o r0 = r0.p()     // Catch:{ all -> 0x0093 }
                goto L_0x0033
            L_0x0083:
                r2.setName(r3)
                return
            L_0x0087:
                okhttp3.x r1 = r1.l()     // Catch:{ all -> 0x0093 }
                okhttp3.o r1 = r1.p()     // Catch:{ all -> 0x0093 }
                r1.f(r8)     // Catch:{ all -> 0x0093 }
                throw r0     // Catch:{ all -> 0x0093 }
            L_0x0093:
                r0 = move-exception
                r2.setName(r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.e.a.run():void");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/connection/e$b;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/e;", "", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "callStackTrace", "referent", "<init>", "(Lokhttp3/internal/connection/e;Ljava/lang/Object;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b extends WeakReference<e> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f33068a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(e eVar, Object obj) {
            super(eVar);
            j.g(eVar, "referent");
            this.f33068a = obj;
        }

        public final Object a() {
            return this.f33068a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004"}, d2 = {"okhttp3/internal/connection/e$c", "Lokio/AsyncTimeout;", "", "A", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class c extends AsyncTimeout {

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ e f33069m;

        c(e eVar) {
            this.f33069m = eVar;
        }

        /* access modifiers changed from: protected */
        public void A() {
            this.f33069m.cancel();
        }
    }

    public e(x xVar, y yVar, boolean z10) {
        j.g(xVar, Constants.Params.CLIENT);
        j.g(yVar, "originalRequest");
        this.f33047a = xVar;
        this.f33048b = yVar;
        this.f33049c = z10;
        this.f33050d = xVar.k().a();
        this.f33051e = xVar.r().a(this);
        c cVar = new c(this);
        cVar.g((long) l().h(), TimeUnit.MILLISECONDS);
        this.f33052f = cVar;
    }

    private final <E extends IOException> E C(E e10) {
        if (this.f33057l || !this.f33052f.v()) {
            return e10;
        }
        E interruptedIOException = new InterruptedIOException("timeout");
        if (e10 != null) {
            interruptedIOException.initCause(e10);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: private */
    public final String D() {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        if (m()) {
            str = "canceled ";
        } else {
            str = "";
        }
        sb2.append(str);
        if (this.f33049c) {
            str2 = "web socket";
        } else {
            str2 = "call";
        }
        sb2.append(str2);
        sb2.append(" to ");
        sb2.append(x());
        return sb2.toString();
    }

    private final <E extends IOException> E d(E e10) {
        Socket y10;
        boolean z10;
        boolean z11 = d.f24935h;
        if (!z11 || !Thread.holdsLock(this)) {
            RealConnection realConnection = this.f33056k;
            if (realConnection != null) {
                if (!z11 || !Thread.holdsLock(realConnection)) {
                    synchronized (realConnection) {
                        y10 = y();
                    }
                    if (this.f33056k == null) {
                        if (y10 != null) {
                            d.n(y10);
                        }
                        this.f33051e.k(this, realConnection);
                    } else {
                        if (y10 == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (!z10) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    }
                } else {
                    throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + realConnection);
                }
            }
            E C = C(e10);
            if (e10 != null) {
                q qVar = this.f33051e;
                j.d(C);
                qVar.d(this, C);
            } else {
                this.f33051e.c(this);
            }
            return C;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    private final void e() {
        this.f33054h = il.j.f30050a.g().h("response.body().close()");
        this.f33051e.e(this);
    }

    private final okhttp3.a i(t tVar) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (tVar.j()) {
            SSLSocketFactory G = this.f33047a.G();
            hostnameVerifier = this.f33047a.v();
            sSLSocketFactory = G;
            certificatePinner = this.f33047a.i();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new okhttp3.a(tVar.i(), tVar.o(), this.f33047a.q(), this.f33047a.F(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.f33047a.B(), this.f33047a.A(), this.f33047a.z(), this.f33047a.l(), this.f33047a.C());
    }

    public final void A(RealConnection realConnection) {
        this.f33064x = realConnection;
    }

    public final void B() {
        if (!this.f33057l) {
            this.f33057l = true;
            this.f33052f.v();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public void P(f fVar) {
        j.g(fVar, "responseCallback");
        if (this.f33053g.compareAndSet(false, true)) {
            e();
            this.f33047a.p().a(new a(this, fVar));
            return;
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public final void c(RealConnection realConnection) {
        boolean z10;
        j.g(realConnection, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
        if (!d.f24935h || Thread.holdsLock(realConnection)) {
            if (this.f33056k == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f33056k = realConnection;
                realConnection.n().add(new b(this, this.f33054h));
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    public void cancel() {
        if (!this.f33062t) {
            this.f33062t = true;
            c cVar = this.f33063w;
            if (cVar != null) {
                cVar.b();
            }
            RealConnection realConnection = this.f33064x;
            if (realConnection != null) {
                realConnection.d();
            }
            this.f33051e.f(this);
        }
    }

    public a0 f() {
        if (this.f33053g.compareAndSet(false, true)) {
            this.f33052f.u();
            e();
            try {
                this.f33047a.p().b(this);
                return t();
            } finally {
                this.f33047a.p().g(this);
            }
        } else {
            throw new IllegalStateException("Already Executed".toString());
        }
    }

    public y g() {
        return this.f33048b;
    }

    /* renamed from: h */
    public e clone() {
        return new e(this.f33047a, this.f33048b, this.f33049c);
    }

    public final void j(y yVar, boolean z10) {
        boolean z11;
        j.g(yVar, "request");
        if (this.f33058m == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            synchronized (this) {
                if (!(!this.f33060p)) {
                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                } else if (!this.f33059n) {
                    Unit unit = Unit.f32013a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            if (z10) {
                this.f33055j = new d(this.f33050d, i(yVar.j()), this, this.f33051e);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void k(boolean z10) {
        c cVar;
        synchronized (this) {
            if (this.f33061q) {
                Unit unit = Unit.f32013a;
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z10 && (cVar = this.f33063w) != null) {
            cVar.d();
        }
        this.f33058m = null;
    }

    public final x l() {
        return this.f33047a;
    }

    public boolean m() {
        return this.f33062t;
    }

    public final RealConnection o() {
        return this.f33056k;
    }

    public final q p() {
        return this.f33051e;
    }

    public final boolean q() {
        return this.f33049c;
    }

    public final c r() {
        return this.f33058m;
    }

    public final y s() {
        return this.f33048b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okhttp3.a0 t() throws java.io.IOException {
        /*
            r12 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            okhttp3.x r0 = r12.f33047a
            java.util.List r0 = r0.w()
            boolean unused = kotlin.collections.v.x(r2, r0)
            fl.j r0 = new fl.j
            okhttp3.x r1 = r12.f33047a
            r0.<init>(r1)
            r2.add(r0)
            fl.a r0 = new fl.a
            okhttp3.x r1 = r12.f33047a
            okhttp3.m r1 = r1.o()
            r0.<init>(r1)
            r2.add(r0)
            dl.a r0 = new dl.a
            okhttp3.x r1 = r12.f33047a
            r1.e()
            r9 = 0
            r0.<init>(r9)
            r2.add(r0)
            okhttp3.internal.connection.a r0 = okhttp3.internal.connection.a.f33015a
            r2.add(r0)
            boolean r0 = r12.f33049c
            if (r0 != 0) goto L_0x0046
            okhttp3.x r0 = r12.f33047a
            java.util.List r0 = r0.x()
            boolean unused = kotlin.collections.v.x(r2, r0)
        L_0x0046:
            fl.b r0 = new fl.b
            boolean r1 = r12.f33049c
            r0.<init>(r1)
            r2.add(r0)
            fl.g r10 = new fl.g
            r3 = 0
            r4 = 0
            okhttp3.y r5 = r12.f33048b
            okhttp3.x r0 = r12.f33047a
            int r6 = r0.j()
            okhttp3.x r0 = r12.f33047a
            int r7 = r0.D()
            okhttp3.x r0 = r12.f33047a
            int r8 = r0.I()
            r0 = r10
            r1 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            okhttp3.y r1 = r12.f33048b     // Catch:{ IOException -> 0x008b, all -> 0x0089 }
            okhttp3.a0 r1 = r10.a(r1)     // Catch:{ IOException -> 0x008b, all -> 0x0089 }
            boolean r2 = r12.m()     // Catch:{ IOException -> 0x008b, all -> 0x0089 }
            if (r2 != 0) goto L_0x007e
            r12.w(r9)
            return r1
        L_0x007e:
            bl.d.m(r1)     // Catch:{ IOException -> 0x008b, all -> 0x0089 }
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException -> 0x008b, all -> 0x0089 }
            java.lang.String r2 = "Canceled"
            r1.<init>(r2)     // Catch:{ IOException -> 0x008b, all -> 0x0089 }
            throw r1     // Catch:{ IOException -> 0x008b, all -> 0x0089 }
        L_0x0089:
            r1 = move-exception
            goto L_0x00a0
        L_0x008b:
            r0 = move-exception
            r1 = 1
            java.io.IOException r0 = r12.w(r0)     // Catch:{ all -> 0x009c }
            if (r0 != 0) goto L_0x009b
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x009c }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Throwable"
            r0.<init>(r2)     // Catch:{ all -> 0x009c }
            throw r0     // Catch:{ all -> 0x009c }
        L_0x009b:
            throw r0     // Catch:{ all -> 0x009c }
        L_0x009c:
            r0 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
        L_0x00a0:
            if (r0 != 0) goto L_0x00a5
            r12.w(r9)
        L_0x00a5:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.e.t():okhttp3.a0");
    }

    public final c u(g gVar) {
        j.g(gVar, "chain");
        synchronized (this) {
            if (!this.f33061q) {
                throw new IllegalStateException("released".toString());
            } else if (!(!this.f33060p)) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!this.f33059n) {
                Unit unit = Unit.f32013a;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        d dVar = this.f33055j;
        j.d(dVar);
        c cVar = new c(this, this.f33051e, dVar, dVar.a(this.f33047a, gVar));
        this.f33058m = cVar;
        this.f33063w = cVar;
        synchronized (this) {
            this.f33059n = true;
            this.f33060p = true;
        }
        if (!this.f33062t) {
            return cVar;
        }
        throw new IOException("Canceled");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0021 A[Catch:{ all -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0025 A[Catch:{ all -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0030 A[Catch:{ all -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0032 A[Catch:{ all -> 0x0017 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E extends java.io.IOException> E v(okhttp3.internal.connection.c r2, boolean r3, boolean r4, E r5) {
        /*
            r1 = this;
            java.lang.String r0 = "exchange"
            kotlin.jvm.internal.j.g(r2, r0)
            okhttp3.internal.connection.c r0 = r1.f33063w
            boolean r2 = kotlin.jvm.internal.j.b(r2, r0)
            if (r2 != 0) goto L_0x000e
            return r5
        L_0x000e:
            monitor-enter(r1)
            r2 = 0
            if (r3 == 0) goto L_0x0019
            boolean r0 = r1.f33059n     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x001f
            goto L_0x0019
        L_0x0017:
            r2 = move-exception
            goto L_0x005a
        L_0x0019:
            if (r4 == 0) goto L_0x0041
            boolean r0 = r1.f33060p     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0041
        L_0x001f:
            if (r3 == 0) goto L_0x0023
            r1.f33059n = r2     // Catch:{ all -> 0x0017 }
        L_0x0023:
            if (r4 == 0) goto L_0x0027
            r1.f33060p = r2     // Catch:{ all -> 0x0017 }
        L_0x0027:
            boolean r3 = r1.f33059n     // Catch:{ all -> 0x0017 }
            r4 = 1
            if (r3 != 0) goto L_0x0032
            boolean r0 = r1.f33060p     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x0032
            r0 = r4
            goto L_0x0033
        L_0x0032:
            r0 = r2
        L_0x0033:
            if (r3 != 0) goto L_0x003e
            boolean r3 = r1.f33060p     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x003e
            boolean r3 = r1.f33061q     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x003e
            r2 = r4
        L_0x003e:
            r3 = r2
            r2 = r0
            goto L_0x0042
        L_0x0041:
            r3 = r2
        L_0x0042:
            kotlin.Unit r4 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0017 }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x0052
            r2 = 0
            r1.f33063w = r2
            okhttp3.internal.connection.RealConnection r2 = r1.f33056k
            if (r2 != 0) goto L_0x004f
            goto L_0x0052
        L_0x004f:
            r2.s()
        L_0x0052:
            if (r3 == 0) goto L_0x0059
            java.io.IOException r2 = r1.d(r5)
            return r2
        L_0x0059:
            return r5
        L_0x005a:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.e.v(okhttp3.internal.connection.c, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public final IOException w(IOException iOException) {
        boolean z10;
        synchronized (this) {
            z10 = false;
            if (this.f33061q) {
                this.f33061q = false;
                if (!this.f33059n && !this.f33060p) {
                    z10 = true;
                }
            }
            Unit unit = Unit.f32013a;
        }
        if (z10) {
            return d(iOException);
        }
        return iOException;
    }

    public final String x() {
        return this.f33048b.j().q();
    }

    public final Socket y() {
        RealConnection realConnection = this.f33056k;
        j.d(realConnection);
        if (!d.f24935h || Thread.holdsLock(realConnection)) {
            List<Reference<e>> n10 = realConnection.n();
            Iterator<Reference<e>> it = n10.iterator();
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i10 = -1;
                    break;
                } else if (j.b(it.next().get(), this)) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 != -1) {
                z10 = true;
            }
            if (z10) {
                n10.remove(i10);
                this.f33056k = null;
                if (n10.isEmpty()) {
                    realConnection.B(System.nanoTime());
                    if (this.f33050d.c(realConnection)) {
                        return realConnection.D();
                    }
                }
                return null;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    public final boolean z() {
        d dVar = this.f33055j;
        j.d(dVar);
        return dVar.e();
    }
}
