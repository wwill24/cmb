package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\t\u001a\u00020\u0005H\u0014J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0001J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lokio/AsyncTimeout;", "Lokio/Timeout;", "", "now", "x", "", "u", "", "v", "A", "Lokio/Sink;", "sink", "y", "Lokio/Source;", "source", "z", "Ljava/io/IOException;", "cause", "o", "w", "f", "Z", "inQueue", "g", "Lokio/AsyncTimeout;", "next", "h", "J", "timeoutAt", "<init>", "()V", "i", "Companion", "Watchdog", "okio"}, k = 1, mv = {1, 6, 0})
public class AsyncTimeout extends Timeout {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f33287i = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final long f33288j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final long f33289k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static AsyncTimeout f33290l;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f33291f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public AsyncTimeout f33292g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public long f33293h;

    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lokio/AsyncTimeout$Companion;", "", "Lokio/AsyncTimeout;", "node", "", "timeoutNanos", "", "hasDeadline", "", "e", "d", "c", "()Lokio/AsyncTimeout;", "IDLE_TIMEOUT_MILLIS", "J", "IDLE_TIMEOUT_NANOS", "", "TIMEOUT_WRITE_SIZE", "I", "head", "Lokio/AsyncTimeout;", "<init>", "()V", "okio"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean d(AsyncTimeout asyncTimeout) {
            synchronized (AsyncTimeout.class) {
                if (!asyncTimeout.f33291f) {
                    return false;
                }
                asyncTimeout.f33291f = false;
                for (AsyncTimeout j10 = AsyncTimeout.f33290l; j10 != null; j10 = j10.f33292g) {
                    if (j10.f33292g == asyncTimeout) {
                        j10.f33292g = asyncTimeout.f33292g;
                        asyncTimeout.f33292g = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* access modifiers changed from: private */
        public final void e(AsyncTimeout asyncTimeout, long j10, boolean z10) {
            Class<AsyncTimeout> cls = AsyncTimeout.class;
            synchronized (cls) {
                if (!asyncTimeout.f33291f) {
                    asyncTimeout.f33291f = true;
                    if (AsyncTimeout.f33290l == null) {
                        AsyncTimeout.f33290l = new AsyncTimeout();
                        new Watchdog().start();
                    }
                    long nanoTime = System.nanoTime();
                    int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
                    if (i10 != 0 && z10) {
                        asyncTimeout.f33293h = Math.min(j10, asyncTimeout.c() - nanoTime) + nanoTime;
                    } else if (i10 != 0) {
                        asyncTimeout.f33293h = j10 + nanoTime;
                    } else if (z10) {
                        asyncTimeout.f33293h = asyncTimeout.c();
                    } else {
                        throw new AssertionError();
                    }
                    long p10 = asyncTimeout.x(nanoTime);
                    AsyncTimeout j11 = AsyncTimeout.f33290l;
                    j.d(j11);
                    while (true) {
                        if (j11.f33292g == null) {
                            break;
                        }
                        AsyncTimeout n10 = j11.f33292g;
                        j.d(n10);
                        if (p10 < n10.x(nanoTime)) {
                            break;
                        }
                        j11 = j11.f33292g;
                        j.d(j11);
                    }
                    asyncTimeout.f33292g = j11.f33292g;
                    j11.f33292g = asyncTimeout;
                    if (j11 == AsyncTimeout.f33290l) {
                        cls.notify();
                    }
                    Unit unit = Unit.f32013a;
                } else {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
            }
        }

        public final AsyncTimeout c() throws InterruptedException {
            Class<AsyncTimeout> cls = AsyncTimeout.class;
            AsyncTimeout j10 = AsyncTimeout.f33290l;
            j.d(j10);
            AsyncTimeout n10 = j10.f33292g;
            if (n10 == null) {
                long nanoTime = System.nanoTime();
                cls.wait(AsyncTimeout.f33288j);
                AsyncTimeout j11 = AsyncTimeout.f33290l;
                j.d(j11);
                if (j11.f33292g != null || System.nanoTime() - nanoTime < AsyncTimeout.f33289k) {
                    return null;
                }
                return AsyncTimeout.f33290l;
            }
            long p10 = n10.x(System.nanoTime());
            if (p10 > 0) {
                long j12 = p10 / 1000000;
                cls.wait(j12, (int) (p10 - (1000000 * j12)));
                return null;
            }
            AsyncTimeout j13 = AsyncTimeout.f33290l;
            j.d(j13);
            j13.f33292g = n10.f33292g;
            n10.f33292g = null;
            return n10;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", "run", "", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0018, code lost:
            if (r1 == null) goto L_0x0000;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
            r1.A();
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<okio.AsyncTimeout> r0 = okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                okio.AsyncTimeout$Companion r1 = okio.AsyncTimeout.f33287i     // Catch:{ all -> 0x001e }
                okio.AsyncTimeout r1 = r1.c()     // Catch:{ all -> 0x001e }
                okio.AsyncTimeout r2 = okio.AsyncTimeout.f33290l     // Catch:{ all -> 0x001e }
                if (r1 != r2) goto L_0x0015
                r1 = 0
                okio.AsyncTimeout.f33290l = r1     // Catch:{ all -> 0x001e }
                monitor-exit(r0)     // Catch:{ InterruptedException -> 0x0000 }
                return
            L_0x0015:
                kotlin.Unit r2 = kotlin.Unit.f32013a     // Catch:{ all -> 0x001e }
                monitor-exit(r0)     // Catch:{ InterruptedException -> 0x0000 }
                if (r1 == 0) goto L_0x0000
                r1.A()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x001e:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ InterruptedException -> 0x0000 }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        f33288j = millis;
        f33289k = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* access modifiers changed from: private */
    public final long x(long j10) {
        return this.f33293h - j10;
    }

    /* access modifiers changed from: protected */
    public void A() {
    }

    public final IOException o(IOException iOException) {
        return w(iOException);
    }

    public final void u() {
        long h10 = h();
        boolean e10 = e();
        if (h10 != 0 || e10) {
            f33287i.e(this, h10, e10);
        }
    }

    public final boolean v() {
        return f33287i.d(this);
    }

    /* access modifiers changed from: protected */
    public IOException w(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink y(Sink sink) {
        j.g(sink, "sink");
        return new AsyncTimeout$sink$1(this, sink);
    }

    public final Source z(Source source) {
        j.g(source, "source");
        return new AsyncTimeout$source$1(this, source);
    }
}
