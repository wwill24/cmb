package el;

import com.google.android.gms.common.api.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0003\u0012\u0018\tB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\u0004R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001eR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0 8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0 8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010!R\u0014\u0010&\u001a\u00020$8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010%¨\u0006)"}, d2 = {"Lel/e;", "", "Lel/a;", "task", "", "e", "j", "", "delayNanos", "c", "Lel/d;", "taskQueue", "h", "(Lel/d;)V", "d", "i", "f", "Lel/e$a;", "a", "Lel/e$a;", "g", "()Lel/e$a;", "backend", "", "b", "I", "nextQueueName", "", "Z", "coordinatorWaiting", "J", "coordinatorWakeUpAt", "", "Ljava/util/List;", "busyQueues", "readyQueues", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "runnable", "<init>", "(Lel/e$a;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class e {

    /* renamed from: h  reason: collision with root package name */
    public static final b f29629h = new b((DefaultConstructorMarker) null);

    /* renamed from: i  reason: collision with root package name */
    public static final e f29630i = new e(new c(bl.d.M(j.p(bl.d.f24936i, " TaskRunner"), true)));
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final Logger f29631j;

    /* renamed from: a  reason: collision with root package name */
    private final a f29632a;

    /* renamed from: b  reason: collision with root package name */
    private int f29633b = 10000;

    /* renamed from: c  reason: collision with root package name */
    private boolean f29634c;

    /* renamed from: d  reason: collision with root package name */
    private long f29635d;

    /* renamed from: e  reason: collision with root package name */
    private final List<d> f29636e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<d> f29637f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f29638g = new d(this);

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\r"}, d2 = {"Lel/e$a;", "", "", "a", "Lel/e;", "taskRunner", "", "b", "nanos", "c", "Ljava/lang/Runnable;", "runnable", "execute", "okhttp"}, k = 1, mv = {1, 6, 0})
    public interface a {
        long a();

        void b(e eVar);

        void c(e eVar, long j10);

        void execute(Runnable runnable);
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lel/e$b;", "", "Ljava/util/logging/Logger;", "logger", "Ljava/util/logging/Logger;", "a", "()Ljava/util/logging/Logger;", "Lel/e;", "INSTANCE", "Lel/e;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Logger a() {
            return e.f29631j;
        }
    }

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000e¨\u0006\u0014"}, d2 = {"Lel/e$c;", "Lel/e$a;", "", "a", "Lel/e;", "taskRunner", "", "b", "nanos", "c", "Ljava/lang/Runnable;", "runnable", "execute", "Ljava/util/concurrent/ThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "<init>", "(Ljava/util/concurrent/ThreadFactory;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class c implements a {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadPoolExecutor f29639a;

        public c(ThreadFactory threadFactory) {
            j.g(threadFactory, "threadFactory");
            this.f29639a = new ThreadPoolExecutor(0, a.e.API_PRIORITY_OTHER, 60, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        public long a() {
            return System.nanoTime();
        }

        public void b(e eVar) {
            j.g(eVar, "taskRunner");
            eVar.notify();
        }

        public void c(e eVar, long j10) throws InterruptedException {
            j.g(eVar, "taskRunner");
            long j11 = j10 / 1000000;
            long j12 = j10 - (1000000 * j11);
            if (j11 > 0 || j10 > 0) {
                eVar.wait(j11, (int) j12);
            }
        }

        public void execute(Runnable runnable) {
            j.g(runnable, "runnable");
            this.f29639a.execute(runnable);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"el/e$d", "Ljava/lang/Runnable;", "", "run", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f29640a;

        d(e eVar) {
            this.f29640a = eVar;
        }

        public void run() {
            a d10;
            while (true) {
                e eVar = this.f29640a;
                synchronized (eVar) {
                    d10 = eVar.d();
                }
                if (d10 != null) {
                    d d11 = d10.d();
                    j.d(d11);
                    e eVar2 = this.f29640a;
                    long j10 = -1;
                    boolean isLoggable = e.f29629h.a().isLoggable(Level.FINE);
                    if (isLoggable) {
                        j10 = d11.h().g().a();
                        b.c(d10, d11, "starting");
                    }
                    try {
                        eVar2.j(d10);
                        Unit unit = Unit.f32013a;
                        if (isLoggable) {
                            b.c(d10, d11, j.p("finished run in ", b.b(d11.h().g().a() - j10)));
                        }
                    } catch (Throwable th2) {
                        if (isLoggable) {
                            b.c(d10, d11, j.p("failed a run in ", b.b(d11.h().g().a() - j10)));
                        }
                        throw th2;
                    }
                } else {
                    return;
                }
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        j.f(logger, "getLogger(TaskRunner::class.java.name)");
        f29631j = logger;
    }

    public e(a aVar) {
        j.g(aVar, "backend");
        this.f29632a = aVar;
    }

    private final void c(a aVar, long j10) {
        boolean z10;
        if (!bl.d.f24935h || Thread.holdsLock(this)) {
            d d10 = aVar.d();
            j.d(d10);
            if (d10.c() == aVar) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                boolean d11 = d10.d();
                d10.m(false);
                d10.l((a) null);
                this.f29636e.remove(d10);
                if (j10 != -1 && !d11 && !d10.g()) {
                    d10.k(aVar, j10, true);
                }
                if (!d10.e().isEmpty()) {
                    this.f29637f.add(d10);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    private final void e(a aVar) {
        if (!bl.d.f24935h || Thread.holdsLock(this)) {
            aVar.g(-1);
            d d10 = aVar.d();
            j.d(d10);
            d10.e().remove(aVar);
            this.f29637f.remove(d10);
            d10.l(aVar);
            this.f29636e.add(d10);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    /* access modifiers changed from: private */
    public final void j(a aVar) {
        if (!bl.d.f24935h || !Thread.holdsLock(this)) {
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            currentThread.setName(aVar.b());
            try {
                long f10 = aVar.f();
                synchronized (this) {
                    c(aVar, f10);
                    Unit unit = Unit.f32013a;
                }
                currentThread.setName(name);
            } catch (Throwable th2) {
                synchronized (this) {
                    c(aVar, -1);
                    Unit unit2 = Unit.f32013a;
                    currentThread.setName(name);
                    throw th2;
                }
            }
        } else {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final el.a d() {
        /*
            r14 = this;
            boolean r0 = bl.d.f24935h
            if (r0 == 0) goto L_0x0032
            boolean r0 = java.lang.Thread.holdsLock(r14)
            if (r0 == 0) goto L_0x000b
            goto L_0x0032
        L_0x000b:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Thread "
            r1.append(r2)
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            java.lang.String r2 = " MUST hold lock on "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0032:
            java.util.List<el.d> r0 = r14.f29637f
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x003c
            return r1
        L_0x003c:
            el.e$a r0 = r14.f29632a
            long r2 = r0.a()
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.util.List<el.d> r0 = r14.f29637f
            java.util.Iterator r0 = r0.iterator()
            r6 = r1
        L_0x004e:
            boolean r7 = r0.hasNext()
            r8 = 1
            r9 = 0
            if (r7 == 0) goto L_0x0080
            java.lang.Object r7 = r0.next()
            el.d r7 = (el.d) r7
            java.util.List r7 = r7.e()
            java.lang.Object r7 = r7.get(r9)
            el.a r7 = (el.a) r7
            long r10 = r7.c()
            long r10 = r10 - r2
            r12 = 0
            long r10 = java.lang.Math.max(r12, r10)
            int r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x007a
            long r4 = java.lang.Math.min(r10, r4)
            goto L_0x004e
        L_0x007a:
            if (r6 == 0) goto L_0x007e
            r0 = r8
            goto L_0x0081
        L_0x007e:
            r6 = r7
            goto L_0x004e
        L_0x0080:
            r0 = r9
        L_0x0081:
            if (r6 == 0) goto L_0x009d
            r14.e(r6)
            if (r0 != 0) goto L_0x0095
            boolean r0 = r14.f29634c
            if (r0 != 0) goto L_0x009c
            java.util.List<el.d> r0 = r14.f29637f
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r8
            if (r0 == 0) goto L_0x009c
        L_0x0095:
            el.e$a r0 = r14.f29632a
            java.lang.Runnable r1 = r14.f29638g
            r0.execute(r1)
        L_0x009c:
            return r6
        L_0x009d:
            boolean r0 = r14.f29634c
            if (r0 == 0) goto L_0x00ae
            long r6 = r14.f29635d
            long r6 = r6 - r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ad
            el.e$a r0 = r14.f29632a
            r0.b(r14)
        L_0x00ad:
            return r1
        L_0x00ae:
            r14.f29634c = r8
            long r2 = r2 + r4
            r14.f29635d = r2
            el.e$a r0 = r14.f29632a     // Catch:{ InterruptedException -> 0x00be }
            r0.c(r14, r4)     // Catch:{ InterruptedException -> 0x00be }
        L_0x00b8:
            r14.f29634c = r9
            goto L_0x0032
        L_0x00bc:
            r0 = move-exception
            goto L_0x00c2
        L_0x00be:
            r14.f()     // Catch:{ all -> 0x00bc }
            goto L_0x00b8
        L_0x00c2:
            r14.f29634c = r9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: el.e.d():el.a");
    }

    public final void f() {
        int size = this.f29636e.size() - 1;
        if (size >= 0) {
            while (true) {
                int i10 = size - 1;
                this.f29636e.get(size).b();
                if (i10 < 0) {
                    break;
                }
                size = i10;
            }
        }
        int size2 = this.f29637f.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i11 = size2 - 1;
                d dVar = this.f29637f.get(size2);
                dVar.b();
                if (dVar.e().isEmpty()) {
                    this.f29637f.remove(size2);
                }
                if (i11 >= 0) {
                    size2 = i11;
                } else {
                    return;
                }
            }
        }
    }

    public final a g() {
        return this.f29632a;
    }

    public final void h(d dVar) {
        j.g(dVar, "taskQueue");
        if (!bl.d.f24935h || Thread.holdsLock(this)) {
            if (dVar.c() == null) {
                if (!dVar.e().isEmpty()) {
                    bl.d.c(this.f29637f, dVar);
                } else {
                    this.f29637f.remove(dVar);
                }
            }
            if (this.f29634c) {
                this.f29632a.b(this);
            } else {
                this.f29632a.execute(this.f29638g);
            }
        } else {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
    }

    public final d i() {
        int i10;
        synchronized (this) {
            i10 = this.f29633b;
            this.f29633b = i10 + 1;
        }
        return new d(this, j.p("Q", Integer.valueOf(i10)));
    }
}
