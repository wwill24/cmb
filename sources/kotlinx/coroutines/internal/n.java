package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.z0;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b(\u0010)J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\b\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003H\u0002J%\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0001J\u001f\u0010\u0012\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0001J\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013H\u0017J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u001c\u0010\u0017\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u001c\u0010\u0018\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003H\u0017R\u0014\u0010\u001b\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u001e\u0010\"\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010'\u001a\u00060#j\u0002`$8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lkotlinx/coroutines/internal/n;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/r0;", "", "c0", "block", "Y", "", "timeMillis", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/z0;", "u", "Lkotlinx/coroutines/n;", "", "continuation", "k", "", "parallelism", "S", "run", "E", "F", "c", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "d", "I", "runningWorkers", "Lkotlinx/coroutines/internal/s;", "f", "Lkotlinx/coroutines/internal/s;", "queue", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "g", "Ljava/lang/Object;", "workerAllocationLock", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class n extends CoroutineDispatcher implements Runnable, r0 {

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineDispatcher f32548c;

    /* renamed from: d  reason: collision with root package name */
    private final int f32549d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ r0 f32550e;

    /* renamed from: f  reason: collision with root package name */
    private final s<Runnable> f32551f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f32552g;
    private volatile int runningWorkers;

    public n(CoroutineDispatcher coroutineDispatcher, int i10) {
        r0 r0Var;
        this.f32548c = coroutineDispatcher;
        this.f32549d = i10;
        if (coroutineDispatcher instanceof r0) {
            r0Var = (r0) coroutineDispatcher;
        } else {
            r0Var = null;
        }
        this.f32550e = r0Var == null ? o0.a() : r0Var;
        this.f32551f = new s<>(false);
        this.f32552g = new Object();
    }

    private final boolean Y(Runnable runnable) {
        this.f32551f.a(runnable);
        if (this.runningWorkers >= this.f32549d) {
            return true;
        }
        return false;
    }

    private final boolean c0() {
        synchronized (this.f32552g) {
            if (this.runningWorkers >= this.f32549d) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    public void E(CoroutineContext coroutineContext, Runnable runnable) {
        if (!Y(runnable) && c0()) {
            this.f32548c.E(this, this);
        }
    }

    public void F(CoroutineContext coroutineContext, Runnable runnable) {
        if (!Y(runnable) && c0()) {
            this.f32548c.F(this, this);
        }
    }

    public CoroutineDispatcher S(int i10) {
        o.a(i10);
        if (i10 >= this.f32549d) {
            return this;
        }
        return super.S(i10);
    }

    public void k(long j10, kotlinx.coroutines.n<? super Unit> nVar) {
        this.f32550e.k(j10, nVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r1 = r4.f32552g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r4.runningWorkers--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r4.f32551f.c() != 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.runningWorkers++;
        r2 = kotlin.Unit.f32013a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            r0 = 0
        L_0x0001:
            r1 = r0
        L_0x0002:
            kotlinx.coroutines.internal.s<java.lang.Runnable> r2 = r4.f32551f
            java.lang.Object r2 = r2.d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L_0x002a
            r2.run()     // Catch:{ all -> 0x0010 }
            goto L_0x0016
        L_0x0010:
            r2 = move-exception
            kotlin.coroutines.EmptyCoroutineContext r3 = kotlin.coroutines.EmptyCoroutineContext.f32070a
            kotlinx.coroutines.i0.a(r3, r2)
        L_0x0016:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L_0x0002
            kotlinx.coroutines.CoroutineDispatcher r2 = r4.f32548c
            boolean r2 = r2.O(r4)
            if (r2 == 0) goto L_0x0002
            kotlinx.coroutines.CoroutineDispatcher r0 = r4.f32548c
            r0.E(r4, r4)
            return
        L_0x002a:
            java.lang.Object r1 = r4.f32552g
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch:{ all -> 0x0047 }
            int r2 = r2 + -1
            r4.runningWorkers = r2     // Catch:{ all -> 0x0047 }
            kotlinx.coroutines.internal.s<java.lang.Runnable> r2 = r4.f32551f     // Catch:{ all -> 0x0047 }
            int r2 = r2.c()     // Catch:{ all -> 0x0047 }
            if (r2 != 0) goto L_0x003d
            monitor-exit(r1)
            return
        L_0x003d:
            int r2 = r4.runningWorkers     // Catch:{ all -> 0x0047 }
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch:{ all -> 0x0047 }
            kotlin.Unit r2 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            goto L_0x0001
        L_0x0047:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.n.run():void");
    }

    public z0 u(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        return this.f32550e.u(j10, runnable, coroutineContext);
    }
}
