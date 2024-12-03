package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.j0;
import kotlinx.coroutines.internal.k0;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.r0;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\b \u0018\u00002\u00020\u00012\u00020\u0002:\u000489:;B\u0007¢\u0006\u0004\b7\u0010\rJ\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\rJ%\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00112\n\u0010\u001e\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$2\n\u0010\u001e\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u000b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0016¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u000bH\u0004¢\u0006\u0004\b,\u0010\rR$\u00102\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00068B@BX\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00104\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b3\u0010/R\u0014\u00106\u001a\u00020\u00118TX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010#¨\u0006<"}, d2 = {"Lkotlinx/coroutines/e1;", "Lkotlinx/coroutines/f1;", "Lkotlinx/coroutines/r0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "task", "", "c1", "(Ljava/lang/Runnable;)Z", "a1", "()Ljava/lang/Runnable;", "", "W0", "()V", "Lkotlinx/coroutines/e1$c;", "p1", "(Lkotlinx/coroutines/e1$c;)Z", "", "now", "delayedTask", "", "j1", "(JLkotlinx/coroutines/e1$c;)I", "g1", "shutdown", "timeMillis", "Lkotlinx/coroutines/n;", "continuation", "k", "(JLkotlinx/coroutines/n;)V", "block", "Lkotlinx/coroutines/z0;", "m1", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/z0;", "H0", "()J", "Lkotlin/coroutines/CoroutineContext;", "context", "E", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "b1", "(Ljava/lang/Runnable;)V", "i1", "(JLkotlinx/coroutines/e1$c;)V", "h1", "value", "d1", "()Z", "o1", "(Z)V", "isCompleted", "e1", "isEmpty", "m0", "nextTime", "<init>", "a", "b", "c", "d", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class e1 extends f1 implements r0 {

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32345f;

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32346g;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;
    private volatile /* synthetic */ Object _queue = null;

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/e1$a;", "Lkotlinx/coroutines/e1$c;", "", "run", "", "toString", "Lkotlinx/coroutines/n;", "c", "Lkotlinx/coroutines/n;", "cont", "", "nanoTime", "<init>", "(Lkotlinx/coroutines/e1;JLkotlinx/coroutines/n;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class a extends c {

        /* renamed from: c  reason: collision with root package name */
        private final n<Unit> f32347c;

        public a(long j10, n<? super Unit> nVar) {
            super(j10);
            this.f32347c = nVar;
        }

        public void run() {
            this.f32347c.D(e1.this, Unit.f32013a);
        }

        public String toString() {
            return super.toString() + this.f32347c;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\n\u001a\u00060\u0006j\u0002`\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/e1$b;", "Lkotlinx/coroutines/e1$c;", "", "run", "", "toString", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "c", "Ljava/lang/Runnable;", "block", "", "nanoTime", "<init>", "(JLjava/lang/Runnable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class b extends c {

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f32349c;

        public b(long j10, Runnable runnable) {
            super(j10);
            this.f32349c = runnable;
        }

        public void run() {
            this.f32349c.run();
        }

        public String toString() {
            return super.toString() + this.f32349c;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b(\u0010)J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u00020\u00078\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010#2\f\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010#8V@VX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010%\"\u0004\b\u0016\u0010&¨\u0006*"}, d2 = {"Lkotlinx/coroutines/e1$c;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/z0;", "Lkotlinx/coroutines/internal/k0;", "other", "", "c", "", "now", "", "h", "Lkotlinx/coroutines/e1$d;", "delayed", "Lkotlinx/coroutines/e1;", "eventLoop", "d", "", "dispose", "", "toString", "a", "J", "nanoTime", "", "_heap", "Ljava/lang/Object;", "b", "I", "getIndex", "()I", "setIndex", "(I)V", "index", "Lkotlinx/coroutines/internal/j0;", "value", "()Lkotlinx/coroutines/internal/j0;", "(Lkotlinx/coroutines/internal/j0;)V", "heap", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static abstract class c implements Runnable, Comparable<c>, z0, k0 {
        private volatile Object _heap;

        /* renamed from: a  reason: collision with root package name */
        public long f32350a;

        /* renamed from: b  reason: collision with root package name */
        private int f32351b = -1;

        public c(long j10) {
            this.f32350a = j10;
        }

        public void a(j0<?> j0Var) {
            boolean z10;
            if (this._heap != h1.f32492a) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this._heap = j0Var;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public j0<?> b() {
            Object obj = this._heap;
            if (obj instanceof j0) {
                return (j0) obj;
            }
            return null;
        }

        /* renamed from: c */
        public int compareTo(c cVar) {
            int i10 = ((this.f32350a - cVar.f32350a) > 0 ? 1 : ((this.f32350a - cVar.f32350a) == 0 ? 0 : -1));
            if (i10 > 0) {
                return 1;
            }
            return i10 < 0 ? -1 : 0;
        }

        public final synchronized int d(long j10, d dVar, e1 e1Var) {
            if (this._heap == h1.f32492a) {
                return 2;
            }
            synchronized (dVar) {
                c cVar = (c) dVar.b();
                if (e1Var.d1()) {
                    return 1;
                }
                if (cVar == null) {
                    dVar.f32352b = j10;
                } else {
                    long j11 = cVar.f32350a;
                    if (j11 - j10 < 0) {
                        j10 = j11;
                    }
                    if (j10 - dVar.f32352b > 0) {
                        dVar.f32352b = j10;
                    }
                }
                long j12 = this.f32350a;
                long j13 = dVar.f32352b;
                if (j12 - j13 < 0) {
                    this.f32350a = j13;
                }
                dVar.a(this);
                return 0;
            }
        }

        public final synchronized void dispose() {
            d dVar;
            Object obj = this._heap;
            if (obj != h1.f32492a) {
                if (obj instanceof d) {
                    dVar = (d) obj;
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    dVar.g(this);
                }
                this._heap = h1.f32492a;
            }
        }

        public int getIndex() {
            return this.f32351b;
        }

        public final boolean h(long j10) {
            return j10 - this.f32350a >= 0;
        }

        public void setIndex(int i10) {
            this.f32351b = i10;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f32350a + PropertyUtils.INDEXED_DELIM2;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/e1$d;", "Lkotlinx/coroutines/internal/j0;", "Lkotlinx/coroutines/e1$c;", "", "b", "J", "timeNow", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class d extends j0<c> {

        /* renamed from: b  reason: collision with root package name */
        public long f32352b;

        public d(long j10) {
            this.f32352b = j10;
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<e1> cls2 = e1.class;
        f32345f = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_queue");
        f32346g = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_delayed");
    }

    private final void W0() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f32345f, this, (Object) null, h1.f32493b)) {
                    return;
                }
            } else if (obj instanceof t) {
                ((t) obj).d();
                return;
            } else if (obj != h1.f32493b) {
                t tVar = new t(8, true);
                tVar.a((Runnable) obj);
                if (androidx.concurrent.futures.a.a(f32345f, this, obj, tVar)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final Runnable a1() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof t) {
                t tVar = (t) obj;
                Object j10 = tVar.j();
                if (j10 != t.f32560h) {
                    return (Runnable) j10;
                }
                androidx.concurrent.futures.a.a(f32345f, this, obj, tVar.i());
            } else if (obj == h1.f32493b) {
                return null;
            } else {
                if (androidx.concurrent.futures.a.a(f32345f, this, obj, (Object) null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean c1(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (d1()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f32345f, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof t) {
                t tVar = (t) obj;
                int a10 = tVar.a(runnable);
                if (a10 == 0) {
                    return true;
                }
                if (a10 == 1) {
                    androidx.concurrent.futures.a.a(f32345f, this, obj, tVar.i());
                } else if (a10 == 2) {
                    return false;
                }
            } else if (obj == h1.f32493b) {
                return false;
            } else {
                t tVar2 = new t(8, true);
                tVar2.a((Runnable) obj);
                tVar2.a(runnable);
                if (androidx.concurrent.futures.a.a(f32345f, this, obj, tVar2)) {
                    return true;
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    /* access modifiers changed from: private */
    public final boolean d1() {
        return this._isCompleted;
    }

    private final void g1() {
        c cVar;
        c.a();
        long nanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) this._delayed;
            if (dVar != null && (cVar = (c) dVar.i()) != null) {
                R0(nanoTime, cVar);
            } else {
                return;
            }
        }
    }

    private final int j1(long j10, c cVar) {
        if (d1()) {
            return 1;
        }
        d dVar = (d) this._delayed;
        if (dVar == null) {
            androidx.concurrent.futures.a.a(f32346g, this, (Object) null, new d(j10));
            Object obj = this._delayed;
            j.d(obj);
            dVar = (d) obj;
        }
        return cVar.d(j10, dVar, this);
    }

    private final void o1(boolean z10) {
        this._isCompleted = z10 ? 1 : 0;
    }

    private final boolean p1(c cVar) {
        d dVar = (d) this._delayed;
        return (dVar != null ? (c) dVar.e() : null) == cVar;
    }

    public final void E(CoroutineContext coroutineContext, Runnable runnable) {
        b1(runnable);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long H0() {
        /*
            r9 = this;
            boolean r0 = r9.I0()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.Object r0 = r9._delayed
            kotlinx.coroutines.e1$d r0 = (kotlinx.coroutines.e1.d) r0
            if (r0 == 0) goto L_0x0045
            boolean r3 = r0.d()
            if (r3 != 0) goto L_0x0045
            kotlinx.coroutines.c.a()
            long r3 = java.lang.System.nanoTime()
        L_0x001c:
            monitor-enter(r0)
            kotlinx.coroutines.internal.k0 r5 = r0.b()     // Catch:{ all -> 0x0042 }
            r6 = 0
            if (r5 != 0) goto L_0x0026
            monitor-exit(r0)
            goto L_0x003d
        L_0x0026:
            kotlinx.coroutines.e1$c r5 = (kotlinx.coroutines.e1.c) r5     // Catch:{ all -> 0x0042 }
            boolean r7 = r5.h(r3)     // Catch:{ all -> 0x0042 }
            r8 = 0
            if (r7 == 0) goto L_0x0034
            boolean r5 = r9.c1(r5)     // Catch:{ all -> 0x0042 }
            goto L_0x0035
        L_0x0034:
            r5 = r8
        L_0x0035:
            if (r5 == 0) goto L_0x003c
            kotlinx.coroutines.internal.k0 r5 = r0.h(r8)     // Catch:{ all -> 0x0042 }
            r6 = r5
        L_0x003c:
            monitor-exit(r0)
        L_0x003d:
            kotlinx.coroutines.e1$c r6 = (kotlinx.coroutines.e1.c) r6
            if (r6 != 0) goto L_0x001c
            goto L_0x0045
        L_0x0042:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0045:
            java.lang.Runnable r0 = r9.a1()
            if (r0 == 0) goto L_0x004f
            r0.run()
            return r1
        L_0x004f:
            long r0 = r9.m0()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.e1.H0():long");
    }

    public void b1(Runnable runnable) {
        if (c1(runnable)) {
            S0();
        } else {
            n0.f32584h.b1(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean e1() {
        if (!E0()) {
            return false;
        }
        d dVar = (d) this._delayed;
        if (dVar != null && !dVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof t) {
                return ((t) obj).g();
            }
            if (obj != h1.f32493b) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void h1() {
        this._queue = null;
        this._delayed = null;
    }

    public final void i1(long j10, c cVar) {
        int j12 = j1(j10, cVar);
        if (j12 != 0) {
            if (j12 == 1) {
                R0(j10, cVar);
            } else if (j12 != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (p1(cVar)) {
            S0();
        }
    }

    public void k(long j10, n<? super Unit> nVar) {
        long c10 = h1.c(j10);
        if (c10 < 4611686018427387903L) {
            c.a();
            long nanoTime = System.nanoTime();
            a aVar = new a(c10 + nanoTime, nVar);
            i1(nanoTime, aVar);
            q.a(nVar, aVar);
        }
    }

    /* access modifiers changed from: protected */
    public long m0() {
        c cVar;
        if (super.m0() == 0) {
            return 0;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof t) {
                if (!((t) obj).g()) {
                    return 0;
                }
            } else if (obj == h1.f32493b) {
                return Long.MAX_VALUE;
            } else {
                return 0;
            }
        }
        d dVar = (d) this._delayed;
        if (dVar == null || (cVar = (c) dVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j10 = cVar.f32350a;
        c.a();
        return j.d(j10 - System.nanoTime(), 0);
    }

    /* access modifiers changed from: protected */
    public final z0 m1(long j10, Runnable runnable) {
        long c10 = h1.c(j10);
        if (c10 >= 4611686018427387903L) {
            return e2.f32353a;
        }
        c.a();
        long nanoTime = System.nanoTime();
        b bVar = new b(c10 + nanoTime, runnable);
        i1(nanoTime, bVar);
        return bVar;
    }

    public void shutdown() {
        q2.f32598a.c();
        o1(true);
        W0();
        do {
        } while (H0() <= 0);
        g1();
    }

    public z0 u(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        return r0.a.a(this, j10, runnable, coroutineContext);
    }
}
