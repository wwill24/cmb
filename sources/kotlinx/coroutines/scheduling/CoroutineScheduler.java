package kotlinx.coroutines.scheduling;

import com.google.android.gms.common.api.a;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.random.Random;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.m0;
import net.bytebuddy.asm.Advice;

@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0003\u00064OB+\u0012\u0006\u0010=\u001a\u00020\f\u0012\u0006\u0010>\u001a\u00020\f\u0012\b\b\u0002\u0010@\u001a\u00020\u0013\u0012\b\b\u0002\u0010C\u001a\u000207¢\u0006\u0004\bM\u0010NJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\bR\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001c\u001a\u0004\u0018\u00010\u0003*\b\u0018\u00010\bR\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002¢\u0006\u0004\b\u001e\u0010\nJ)\u0010!\u001a\u00020\u00102\n\u0010\u000b\u001a\u00060\bR\u00020\u00002\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\u00052\n\u0010\u000b\u001a\u00060\bR\u00020\u0000¢\u0006\u0004\b#\u0010$J\u001b\u0010(\u001a\u00020\u00102\n\u0010'\u001a\u00060%j\u0002`&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0010H\u0016¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0013¢\u0006\u0004\b-\u0010.J-\u00102\u001a\u00020\u00102\n\u0010/\u001a\u00060%j\u0002`&2\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b2\u00103J!\u00104\u001a\u00020\u00032\n\u0010/\u001a\u00060%j\u0002`&2\u0006\u00101\u001a\u000200¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u0010¢\u0006\u0004\b6\u0010+J\u000f\u00108\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020\f8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010<R\u0014\u0010>\u001a\u00020\f8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010<R\u0014\u0010@\u001a\u00020\u00138\u0006X\u0004¢\u0006\u0006\n\u0004\b4\u0010?R\u0014\u0010C\u001a\u0002078\u0006X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020D8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010ER\u0014\u0010G\u001a\u00020D8\u0006X\u0004¢\u0006\u0006\n\u0004\b2\u0010ER\u001e\u0010K\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000H8\u0006X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0011\u0010L\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bL\u0010\u0018¨\u0006P"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/scheduling/g;", "task", "", "a", "(Lkotlinx/coroutines/scheduling/g;)Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;", "k", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;", "worker", "", "h", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;)I", "skipUnpark", "", "v", "(Z)V", "", "state", "C", "(J)Z", "F", "()Z", "b", "()I", "tailDispatch", "y", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;Lkotlinx/coroutines/scheduling/g;Z)Lkotlinx/coroutines/scheduling/g;", "e", "oldIndex", "newIndex", "m", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;II)V", "l", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "command", "execute", "(Ljava/lang/Runnable;)V", "close", "()V", "timeout", "u", "(J)V", "block", "Lkotlinx/coroutines/scheduling/h;", "taskContext", "f", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/h;Z)V", "c", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/h;)Lkotlinx/coroutines/scheduling/g;", "x", "", "toString", "()Ljava/lang/String;", "n", "(Lkotlinx/coroutines/scheduling/g;)V", "I", "corePoolSize", "maxPoolSize", "J", "idleWorkerKeepAliveNs", "d", "Ljava/lang/String;", "schedulerName", "Lkotlinx/coroutines/scheduling/c;", "Lkotlinx/coroutines/scheduling/c;", "globalCpuQueue", "globalBlockingQueue", "Lkotlinx/coroutines/internal/a0;", "g", "Lkotlinx/coroutines/internal/a0;", "workers", "isTerminated", "<init>", "(IIJLjava/lang/String;)V", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class CoroutineScheduler implements Executor, Closeable {

    /* renamed from: h  reason: collision with root package name */
    public static final a f32620h = new a((DefaultConstructorMarker) null);

    /* renamed from: j  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f32621j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: k  reason: collision with root package name */
    static final /* synthetic */ AtomicLongFieldUpdater f32622k = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: l  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f32623l = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* renamed from: m  reason: collision with root package name */
    public static final f0 f32624m = new f0("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated;

    /* renamed from: a  reason: collision with root package name */
    public final int f32625a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32626b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32627c;
    volatile /* synthetic */ long controlState;

    /* renamed from: d  reason: collision with root package name */
    public final String f32628d;

    /* renamed from: e  reason: collision with root package name */
    public final c f32629e;

    /* renamed from: f  reason: collision with root package name */
    public final c f32630f;

    /* renamed from: g  reason: collision with root package name */
    public final a0<c> f32631g;
    private volatile /* synthetic */ long parkedWorkersStack;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00058\u0000XT¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0000XT¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$a;", "", "", "BLOCKING_MASK", "J", "", "BLOCKING_SHIFT", "I", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "Lkotlinx/coroutines/internal/f0;", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/f0;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
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
        public static final /* synthetic */ int[] f32638a;

        static {
            int[] iArr = new int[WorkerState.values().length];
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.DORMANT.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
            f32638a = iArr;
        }
    }

    public CoroutineScheduler(int i10, int i11, long j10, String str) {
        boolean z10;
        boolean z11;
        boolean z12;
        this.f32625a = i10;
        this.f32626b = i11;
        this.f32627c = j10;
        this.f32628d = str;
        boolean z13 = true;
        if (i10 >= 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i11 >= i10) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i11 <= 2097150) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    if (j10 <= 0 ? false : z13) {
                        this.f32629e = new c();
                        this.f32630f = new c();
                        this.parkedWorkersStack = 0;
                        this.f32631g = new a0<>(i10 + 1);
                        this.controlState = ((long) i10) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
    }

    private final boolean C(long j10) {
        if (j.c(((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21)), 0) < this.f32625a) {
            int b10 = b();
            if (b10 == 1 && this.f32625a > 1) {
                b();
            }
            if (b10 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean E(CoroutineScheduler coroutineScheduler, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.C(j10);
    }

    private final boolean F() {
        c k10;
        do {
            k10 = k();
            if (k10 == null) {
                return false;
            }
        } while (!c.f32639h.compareAndSet(k10, -1, 0));
        LockSupport.unpark(k10);
        return true;
    }

    private final boolean a(g gVar) {
        boolean z10 = true;
        if (gVar.f32657b.b() != 1) {
            z10 = false;
        }
        if (z10) {
            return this.f32630f.a(gVar);
        }
        return this.f32629e.a(gVar);
    }

    private final int b() {
        boolean z10;
        synchronized (this.f32631g) {
            if (isTerminated()) {
                return -1;
            }
            long j10 = this.controlState;
            int i10 = (int) (j10 & 2097151);
            boolean z11 = false;
            int c10 = j.c(i10 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
            if (c10 >= this.f32625a) {
                return 0;
            }
            if (i10 >= this.f32626b) {
                return 0;
            }
            int i11 = ((int) (this.controlState & 2097151)) + 1;
            if (i11 <= 0 || this.f32631g.b(i11) != null) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                c cVar = new c(this, i11);
                this.f32631g.c(i11, cVar);
                if (i11 == ((int) (2097151 & f32622k.incrementAndGet(this)))) {
                    z11 = true;
                }
                if (z11) {
                    cVar.start();
                    int i12 = c10 + 1;
                    return i12;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final c e() {
        c cVar;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof c) {
            cVar = (c) currentThread;
        } else {
            cVar = null;
        }
        if (cVar == null || !j.b(CoroutineScheduler.this, this)) {
            return null;
        }
        return cVar;
    }

    public static /* synthetic */ void g(CoroutineScheduler coroutineScheduler, Runnable runnable, h hVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            hVar = k.f32665f;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        coroutineScheduler.f(runnable, hVar, z10);
    }

    private final int h(c cVar) {
        Object h10 = cVar.h();
        while (h10 != f32624m) {
            if (h10 == null) {
                return 0;
            }
            c cVar2 = (c) h10;
            int g10 = cVar2.g();
            if (g10 != 0) {
                return g10;
            }
            h10 = cVar2.h();
        }
        return -1;
    }

    private final c k() {
        while (true) {
            long j10 = this.parkedWorkersStack;
            c b10 = this.f32631g.b((int) (2097151 & j10));
            if (b10 == null) {
                return null;
            }
            long j11 = (2097152 + j10) & -2097152;
            int h10 = h(b10);
            if (h10 >= 0) {
                if (f32621j.compareAndSet(this, j10, ((long) h10) | j11)) {
                    b10.p(f32624m);
                    return b10;
                }
            }
        }
    }

    private final void v(boolean z10) {
        long addAndGet = f32622k.addAndGet(this, 2097152);
        if (!z10 && !F() && !C(addAndGet)) {
            F();
        }
    }

    private final g y(c cVar, g gVar, boolean z10) {
        if (cVar == null || cVar.f32641b == WorkerState.TERMINATED) {
            return gVar;
        }
        if (gVar.f32657b.b() == 0 && cVar.f32641b == WorkerState.BLOCKING) {
            return gVar;
        }
        cVar.f32645f = true;
        return cVar.f32640a.a(gVar, z10);
    }

    public final g c(Runnable runnable, h hVar) {
        long a10 = k.f32664e.a();
        if (!(runnable instanceof g)) {
            return new j(runnable, a10, hVar);
        }
        g gVar = (g) runnable;
        gVar.f32656a = a10;
        gVar.f32657b = hVar;
        return gVar;
    }

    public void close() {
        u(10000);
    }

    public void execute(Runnable runnable) {
        g(this, runnable, (h) null, false, 6, (Object) null);
    }

    public final void f(Runnable runnable, h hVar, boolean z10) {
        boolean z11;
        kotlinx.coroutines.c.a();
        g c10 = c(runnable, hVar);
        c e10 = e();
        g y10 = y(e10, c10, z10);
        if (y10 == null || a(y10)) {
            if (!z10 || e10 == null) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (c10.f32657b.b() != 0) {
                v(z11);
            } else if (!z11) {
                x();
            }
        } else {
            throw new RejectedExecutionException(this.f32628d + " was terminated");
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final boolean l(c cVar) {
        long j10;
        int g10;
        if (cVar.h() != f32624m) {
            return false;
        }
        do {
            j10 = this.parkedWorkersStack;
            g10 = cVar.g();
            cVar.p(this.f32631g.b((int) (2097151 & j10)));
        } while (!f32621j.compareAndSet(this, j10, ((2097152 + j10) & -2097152) | ((long) g10)));
        return true;
    }

    public final void m(c cVar, int i10, int i11) {
        while (true) {
            long j10 = this.parkedWorkersStack;
            int i12 = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & -2097152;
            if (i12 == i10) {
                if (i11 == 0) {
                    i12 = h(cVar);
                } else {
                    i12 = i11;
                }
            }
            if (i12 >= 0) {
                if (f32621j.compareAndSet(this, j10, j11 | ((long) i12))) {
                    return;
                }
            }
        }
    }

    public final void n(g gVar) {
        try {
            gVar.run();
        } catch (Throwable th2) {
            kotlinx.coroutines.c.a();
            throw th2;
        }
        kotlinx.coroutines.c.a();
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a10 = this.f32631g.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < a10; i15++) {
            c b10 = this.f32631g.b(i15);
            if (b10 != null) {
                int f10 = b10.f32640a.f();
                int i16 = b.f32638a[b10.f32641b.ordinal()];
                if (i16 == 1) {
                    i12++;
                } else if (i16 == 2) {
                    i11++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(f10);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (i16 == 3) {
                    i10++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(f10);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                } else if (i16 == 4) {
                    i13++;
                    if (f10 > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(f10);
                        sb4.append(Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL);
                        arrayList.add(sb4.toString());
                    }
                } else if (i16 == 5) {
                    i14++;
                }
            }
        }
        long j10 = this.controlState;
        return this.f32628d + '@' + m0.b(this) + "[Pool Size {core = " + this.f32625a + ", max = " + this.f32626b + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f32629e.c() + ", global blocking queue size = " + this.f32630f.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((4398044413952L & j10) >> 21)) + ", CPUs acquired = " + (this.f32625a - ((int) ((9223367638808264704L & j10) >> 42))) + "}]";
    }

    public final void u(long j10) {
        int i10;
        g gVar;
        if (f32623l.compareAndSet(this, 0, 1)) {
            c e10 = e();
            synchronized (this.f32631g) {
                i10 = (int) (this.controlState & 2097151);
            }
            if (1 <= i10) {
                int i11 = 1;
                while (true) {
                    c b10 = this.f32631g.b(i11);
                    j.d(b10);
                    c cVar = b10;
                    if (cVar != e10) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j10);
                        }
                        cVar.f32640a.g(this.f32630f);
                    }
                    if (i11 == i10) {
                        break;
                    }
                    i11++;
                }
            }
            this.f32630f.b();
            this.f32629e.b();
            while (true) {
                if (e10 != null) {
                    gVar = e10.f(true);
                    if (gVar != null) {
                        continue;
                        n(gVar);
                    }
                }
                gVar = (g) this.f32629e.d();
                if (gVar == null && (gVar = (g) this.f32630f.d()) == null) {
                    break;
                }
                n(gVar);
            }
            if (e10 != null) {
                e10.s(WorkerState.TERMINATED);
            }
            this.parkedWorkersStack = 0;
            this.controlState = 0;
        }
    }

    public final void x() {
        if (!F() && !E(this, 0, 1, (Object) null)) {
            F();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bA\u0010BB\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020\u000e¢\u0006\u0004\bA\u0010CJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0007J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0011J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u0019J\u0015\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\u0007J\u0015\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0019R*\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u0011R\u0014\u00100\u001a\u00020-8\u0006X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u001e8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0012\u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u00104R$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010=\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u00104R\u0016\u0010>\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010)R\u0016\u0010@\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b&\u0010?¨\u0006D"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;", "Ljava/lang/Thread;", "", "q", "()Z", "", "n", "()V", "r", "j", "Lkotlinx/coroutines/scheduling/g;", "task", "d", "(Lkotlinx/coroutines/scheduling/g;)V", "", "taskMode", "c", "(I)V", "b", "l", "u", "mode", "i", "scanLocalQueue", "e", "(Z)Lkotlinx/coroutines/scheduling/g;", "m", "()Lkotlinx/coroutines/scheduling/g;", "blockingOnly", "t", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "s", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "run", "upperBound", "k", "(I)I", "f", "index", "indexInArray", "I", "g", "()I", "o", "Lkotlinx/coroutines/scheduling/n;", "a", "Lkotlinx/coroutines/scheduling/n;", "localQueue", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "state", "", "J", "terminationDeadline", "", "nextParkedWorker", "Ljava/lang/Object;", "h", "()Ljava/lang/Object;", "p", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "Z", "mayHaveLocalTasks", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public final class c extends Thread {

        /* renamed from: h  reason: collision with root package name */
        static final /* synthetic */ AtomicIntegerFieldUpdater f32639h = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: a  reason: collision with root package name */
        public final n f32640a;

        /* renamed from: b  reason: collision with root package name */
        public WorkerState f32641b;

        /* renamed from: c  reason: collision with root package name */
        private long f32642c;

        /* renamed from: d  reason: collision with root package name */
        private long f32643d;

        /* renamed from: e  reason: collision with root package name */
        private int f32644e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f32645f;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        private c() {
            setDaemon(true);
            this.f32640a = new n();
            this.f32641b = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.f32624m;
            this.f32644e = Random.f32142a.c();
        }

        private final void b(int i10) {
            if (i10 != 0) {
                CoroutineScheduler.f32622k.addAndGet(CoroutineScheduler.this, -2097152);
                if (this.f32641b != WorkerState.TERMINATED) {
                    this.f32641b = WorkerState.DORMANT;
                }
            }
        }

        private final void c(int i10) {
            if (i10 != 0 && s(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.x();
            }
        }

        private final void d(g gVar) {
            int b10 = gVar.f32657b.b();
            i(b10);
            c(b10);
            CoroutineScheduler.this.n(gVar);
            b(b10);
        }

        private final g e(boolean z10) {
            boolean z11;
            g m10;
            g m11;
            if (z10) {
                if (k(CoroutineScheduler.this.f32625a * 2) == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (m11 = m()) != null) {
                    return m11;
                }
                g h10 = this.f32640a.h();
                if (h10 != null) {
                    return h10;
                }
                if (!z11 && (m10 = m()) != null) {
                    return m10;
                }
            } else {
                g m12 = m();
                if (m12 != null) {
                    return m12;
                }
            }
            return t(false);
        }

        private final void i(int i10) {
            this.f32642c = 0;
            if (this.f32641b == WorkerState.PARKING) {
                this.f32641b = WorkerState.BLOCKING;
            }
        }

        private final boolean j() {
            return this.nextParkedWorker != CoroutineScheduler.f32624m;
        }

        private final void l() {
            if (this.f32642c == 0) {
                this.f32642c = System.nanoTime() + CoroutineScheduler.this.f32627c;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f32627c);
            if (System.nanoTime() - this.f32642c >= 0) {
                this.f32642c = 0;
                u();
            }
        }

        private final g m() {
            if (k(2) == 0) {
                g gVar = (g) CoroutineScheduler.this.f32629e.d();
                if (gVar != null) {
                    return gVar;
                }
                return (g) CoroutineScheduler.this.f32630f.d();
            }
            g gVar2 = (g) CoroutineScheduler.this.f32630f.d();
            if (gVar2 != null) {
                return gVar2;
            }
            return (g) CoroutineScheduler.this.f32629e.d();
        }

        private final void n() {
            loop0:
            while (true) {
                boolean z10 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f32641b != WorkerState.TERMINATED) {
                    g f10 = f(this.f32645f);
                    if (f10 != null) {
                        this.f32643d = 0;
                        d(f10);
                    } else {
                        this.f32645f = false;
                        if (this.f32643d == 0) {
                            r();
                        } else if (!z10) {
                            z10 = true;
                        } else {
                            s(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f32643d);
                            this.f32643d = 0;
                        }
                    }
                }
            }
            s(WorkerState.TERMINATED);
        }

        private final boolean q() {
            boolean z10;
            if (this.f32641b != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j10 = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j10) >> 42)) != 0) {
                        if (CoroutineScheduler.f32622k.compareAndSet(coroutineScheduler, j10, j10 - 4398046511104L)) {
                            z10 = true;
                            break;
                        }
                    } else {
                        z10 = false;
                        break;
                    }
                }
                if (!z10) {
                    return false;
                }
                this.f32641b = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        private final void r() {
            if (!j()) {
                CoroutineScheduler.this.l(this);
                return;
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !CoroutineScheduler.this.isTerminated() && this.f32641b != WorkerState.TERMINATED) {
                s(WorkerState.PARKING);
                Thread.interrupted();
                l();
            }
        }

        private final g t(boolean z10) {
            long j10;
            int i10 = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i10 < 2) {
                return null;
            }
            int k10 = k(i10);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j11 = Long.MAX_VALUE;
            for (int i11 = 0; i11 < i10; i11++) {
                k10++;
                if (k10 > i10) {
                    k10 = 1;
                }
                c b10 = coroutineScheduler.f32631g.b(k10);
                if (!(b10 == null || b10 == this)) {
                    if (z10) {
                        j10 = this.f32640a.k(b10.f32640a);
                    } else {
                        j10 = this.f32640a.l(b10.f32640a);
                    }
                    if (j10 == -1) {
                        return this.f32640a.h();
                    }
                    if (j10 > 0) {
                        j11 = Math.min(j11, j10);
                    }
                }
            }
            if (j11 == Long.MAX_VALUE) {
                j11 = 0;
            }
            this.f32643d = j11;
            return null;
        }

        private final void u() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f32631g) {
                if (!coroutineScheduler.isTerminated()) {
                    if (((int) (coroutineScheduler.controlState & 2097151)) > coroutineScheduler.f32625a) {
                        if (f32639h.compareAndSet(this, -1, 1)) {
                            int i10 = this.indexInArray;
                            o(0);
                            coroutineScheduler.m(this, i10, 0);
                            int andDecrement = (int) (CoroutineScheduler.f32622k.getAndDecrement(coroutineScheduler) & 2097151);
                            if (andDecrement != i10) {
                                c b10 = coroutineScheduler.f32631g.b(andDecrement);
                                j.d(b10);
                                c cVar = b10;
                                coroutineScheduler.f32631g.c(i10, cVar);
                                cVar.o(i10);
                                coroutineScheduler.m(cVar, andDecrement, i10);
                            }
                            coroutineScheduler.f32631g.c(andDecrement, null);
                            Unit unit = Unit.f32013a;
                            this.f32641b = WorkerState.TERMINATED;
                        }
                    }
                }
            }
        }

        public final g f(boolean z10) {
            g gVar;
            if (q()) {
                return e(z10);
            }
            if (z10) {
                gVar = this.f32640a.h();
                if (gVar == null) {
                    gVar = (g) CoroutineScheduler.this.f32630f.d();
                }
            } else {
                gVar = (g) CoroutineScheduler.this.f32630f.d();
            }
            if (gVar == null) {
                return t(true);
            }
            return gVar;
        }

        public final int g() {
            return this.indexInArray;
        }

        public final Object h() {
            return this.nextParkedWorker;
        }

        public final int k(int i10) {
            int i11 = this.f32644e;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f32644e = i14;
            int i15 = i10 - 1;
            if ((i15 & i10) == 0) {
                return i14 & i15;
            }
            return (i14 & a.e.API_PRIORITY_OTHER) % i10;
        }

        public final void o(int i10) {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CoroutineScheduler.this.f32628d);
            sb2.append("-worker-");
            if (i10 == 0) {
                str = "TERMINATED";
            } else {
                str = String.valueOf(i10);
            }
            sb2.append(str);
            setName(sb2.toString());
            this.indexInArray = i10;
        }

        public final void p(Object obj) {
            this.nextParkedWorker = obj;
        }

        public void run() {
            n();
        }

        public final boolean s(WorkerState workerState) {
            boolean z10;
            WorkerState workerState2 = this.f32641b;
            if (workerState2 == WorkerState.CPU_ACQUIRED) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                CoroutineScheduler.f32622k.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f32641b = workerState;
            }
            return z10;
        }

        public c(CoroutineScheduler coroutineScheduler, int i10) {
            this();
            o(i10);
        }
    }
}
