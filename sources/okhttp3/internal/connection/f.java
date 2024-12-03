package okhttp3.internal.connection;

import com.coffeemeetsbagel.models.ModelDeeplinkData;
import el.d;
import el.e;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.c0;
import okhttp3.internal.connection.e;

@Metadata(bv = {}, d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001d\u0018\u0000 *2\u00020\u0001:\u0001\u0011B'\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010!¨\u0006+"}, d2 = {"Lokhttp3/internal/connection/f;", "", "Lokhttp3/internal/connection/RealConnection;", "connection", "", "now", "", "d", "Lokhttp3/a;", "address", "Lokhttp3/internal/connection/e;", "call", "", "Lokhttp3/c0;", "routes", "", "requireMultiplexed", "a", "", "e", "c", "b", "I", "maxIdleConnections", "J", "keepAliveDurationNs", "Lel/d;", "Lel/d;", "cleanupQueue", "okhttp3/internal/connection/f$b", "Lokhttp3/internal/connection/f$b;", "cleanupTask", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "connections", "Lel/e;", "taskRunner", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "<init>", "(Lel/e;IJLjava/util/concurrent/TimeUnit;)V", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class f {

    /* renamed from: f  reason: collision with root package name */
    public static final a f33070f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f33071a;

    /* renamed from: b  reason: collision with root package name */
    private final long f33072b;

    /* renamed from: c  reason: collision with root package name */
    private final d f33073c;

    /* renamed from: d  reason: collision with root package name */
    private final b f33074d = new b(this, j.p(bl.d.f24936i, " ConnectionPool"));

    /* renamed from: e  reason: collision with root package name */
    private final ConcurrentLinkedQueue<RealConnection> f33075e = new ConcurrentLinkedQueue<>();

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lokhttp3/internal/connection/f$a;", "", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/connection/f$b", "Lel/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b extends el.a {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ f f33076e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(f fVar, String str) {
            super(str, false, 2, (DefaultConstructorMarker) null);
            this.f33076e = fVar;
        }

        public long f() {
            return this.f33076e.b(System.nanoTime());
        }
    }

    public f(e eVar, int i10, long j10, TimeUnit timeUnit) {
        boolean z10;
        j.g(eVar, "taskRunner");
        j.g(timeUnit, "timeUnit");
        this.f33071a = i10;
        this.f33072b = timeUnit.toNanos(j10);
        this.f33073c = eVar.i();
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(j.p("keepAliveDuration <= 0: ", Long.valueOf(j10)).toString());
        }
    }

    private final int d(RealConnection realConnection, long j10) {
        if (!bl.d.f24935h || Thread.holdsLock(realConnection)) {
            List<Reference<e>> n10 = realConnection.n();
            int i10 = 0;
            while (i10 < n10.size()) {
                Reference reference = n10.get(i10);
                if (reference.get() != null) {
                    i10++;
                } else {
                    il.j.f30050a.g().l("A connection to " + realConnection.z().a().l() + " was leaked. Did you forget to close a response body?", ((e.b) reference).a());
                    n10.remove(i10);
                    realConnection.C(true);
                    if (n10.isEmpty()) {
                        realConnection.B(j10 - this.f33072b);
                        return 0;
                    }
                }
            }
            return n10.size();
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    public final boolean a(okhttp3.a aVar, e eVar, List<c0> list, boolean z10) {
        j.g(aVar, "address");
        j.g(eVar, "call");
        Iterator<RealConnection> it = this.f33075e.iterator();
        while (it.hasNext()) {
            RealConnection next = it.next();
            j.f(next, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
            synchronized (next) {
                if (z10) {
                    if (!next.v()) {
                        Unit unit = Unit.f32013a;
                    }
                }
                if (next.t(aVar, list)) {
                    eVar.c(next);
                    return true;
                }
                Unit unit2 = Unit.f32013a;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x007a, code lost:
        bl.d.n(r3.D());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0087, code lost:
        if (r10.f33075e.isEmpty() == false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0089, code lost:
        r10.f33073c.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008e, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long b(long r11) {
        /*
            r10 = this;
            java.util.concurrent.ConcurrentLinkedQueue<okhttp3.internal.connection.RealConnection> r0 = r10.f33075e
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
            r2 = 0
            r3 = -9223372036854775808
            r4 = r3
            r3 = r2
            r2 = r1
        L_0x000d:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x003d
            java.lang.Object r6 = r0.next()
            okhttp3.internal.connection.RealConnection r6 = (okhttp3.internal.connection.RealConnection) r6
            java.lang.String r7 = "connection"
            kotlin.jvm.internal.j.f(r6, r7)
            monitor-enter(r6)
            int r7 = r10.d(r6, r11)     // Catch:{ all -> 0x003a }
            if (r7 <= 0) goto L_0x0028
            int r2 = r2 + 1
            goto L_0x0038
        L_0x0028:
            int r1 = r1 + 1
            long r7 = r6.o()     // Catch:{ all -> 0x003a }
            long r7 = r11 - r7
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x0036
            r3 = r6
            r4 = r7
        L_0x0036:
            kotlin.Unit r7 = kotlin.Unit.f32013a     // Catch:{ all -> 0x003a }
        L_0x0038:
            monitor-exit(r6)
            goto L_0x000d
        L_0x003a:
            r11 = move-exception
            monitor-exit(r6)
            throw r11
        L_0x003d:
            long r6 = r10.f33072b
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0052
            int r0 = r10.f33071a
            if (r1 <= r0) goto L_0x0048
            goto L_0x0052
        L_0x0048:
            if (r1 <= 0) goto L_0x004c
            long r6 = r6 - r4
            return r6
        L_0x004c:
            if (r2 <= 0) goto L_0x004f
            return r6
        L_0x004f:
            r11 = -1
            return r11
        L_0x0052:
            kotlin.jvm.internal.j.d(r3)
            monitor-enter(r3)
            java.util.List r0 = r3.n()     // Catch:{ all -> 0x008f }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x008f }
            r1 = 1
            r0 = r0 ^ r1
            r6 = 0
            if (r0 == 0) goto L_0x0066
            monitor-exit(r3)
            return r6
        L_0x0066:
            long r8 = r3.o()     // Catch:{ all -> 0x008f }
            long r8 = r8 + r4
            int r11 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r11 == 0) goto L_0x0071
            monitor-exit(r3)
            return r6
        L_0x0071:
            r3.C(r1)     // Catch:{ all -> 0x008f }
            java.util.concurrent.ConcurrentLinkedQueue<okhttp3.internal.connection.RealConnection> r11 = r10.f33075e     // Catch:{ all -> 0x008f }
            r11.remove(r3)     // Catch:{ all -> 0x008f }
            monitor-exit(r3)
            java.net.Socket r11 = r3.D()
            bl.d.n(r11)
            java.util.concurrent.ConcurrentLinkedQueue<okhttp3.internal.connection.RealConnection> r11 = r10.f33075e
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L_0x008e
            el.d r11 = r10.f33073c
            r11.a()
        L_0x008e:
            return r6
        L_0x008f:
            r11 = move-exception
            monitor-exit(r3)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.f.b(long):long");
    }

    public final boolean c(RealConnection realConnection) {
        j.g(realConnection, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
        if (bl.d.f24935h && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        } else if (realConnection.p() || this.f33071a == 0) {
            realConnection.C(true);
            this.f33075e.remove(realConnection);
            if (!this.f33075e.isEmpty()) {
                return true;
            }
            this.f33073c.a();
            return true;
        } else {
            d.j(this.f33073c, this.f33074d, 0, 2, (Object) null);
            return false;
        }
    }

    public final void e(RealConnection realConnection) {
        j.g(realConnection, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
        if (!bl.d.f24935h || Thread.holdsLock(realConnection)) {
            this.f33075e.add(realConnection);
            d.j(this.f33073c, this.f33074d, 0, 2, (Object) null);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }
}
