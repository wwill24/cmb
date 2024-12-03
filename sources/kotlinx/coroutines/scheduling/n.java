package kotlinx.coroutines.scheduling;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import net.bytebuddy.jar.asm.Opcodes;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u0012*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0011J!\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010 R\u0014\u0010%\u001a\u00020\"8@X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\"8@X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$¨\u0006*"}, d2 = {"Lkotlinx/coroutines/scheduling/n;", "", "Lkotlinx/coroutines/scheduling/g;", "task", "c", "(Lkotlinx/coroutines/scheduling/g;)Lkotlinx/coroutines/scheduling/g;", "victim", "", "blockingOnly", "", "m", "(Lkotlinx/coroutines/scheduling/n;Z)J", "Lkotlinx/coroutines/scheduling/c;", "queue", "j", "(Lkotlinx/coroutines/scheduling/c;)Z", "i", "()Lkotlinx/coroutines/scheduling/g;", "", "d", "(Lkotlinx/coroutines/scheduling/g;)V", "h", "fair", "a", "(Lkotlinx/coroutines/scheduling/g;Z)Lkotlinx/coroutines/scheduling/g;", "l", "(Lkotlinx/coroutines/scheduling/n;)J", "k", "globalQueue", "g", "(Lkotlinx/coroutines/scheduling/c;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "", "e", "()I", "bufferSize", "f", "size", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class n {

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32668b;

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f32669c;

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f32670d;

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f32671e;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReferenceArray<g> f32672a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;

    static {
        Class<n> cls = n.class;
        f32668b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        f32669c = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        f32670d = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        f32671e = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    public static /* synthetic */ g b(n nVar, g gVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return nVar.a(gVar, z10);
    }

    private final g c(g gVar) {
        boolean z10 = true;
        if (gVar.f32657b.b() != 1) {
            z10 = false;
        }
        if (z10) {
            f32671e.incrementAndGet(this);
        }
        if (e() == 127) {
            return gVar;
        }
        int i10 = this.producerIndex & Opcodes.LAND;
        while (this.f32672a.get(i10) != null) {
            Thread.yield();
        }
        this.f32672a.lazySet(i10, gVar);
        f32669c.incrementAndGet(this);
        return null;
    }

    private final void d(g gVar) {
        if (gVar != null) {
            boolean z10 = true;
            if (gVar.f32657b.b() != 1) {
                z10 = false;
            }
            if (z10) {
                f32671e.decrementAndGet(this);
            }
        }
    }

    private final g i() {
        g andSet;
        while (true) {
            int i10 = this.consumerIndex;
            if (i10 - this.producerIndex == 0) {
                return null;
            }
            int i11 = i10 & Opcodes.LAND;
            if (f32670d.compareAndSet(this, i10, i10 + 1) && (andSet = this.f32672a.getAndSet(i11, (Object) null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(c cVar) {
        g i10 = i();
        if (i10 == null) {
            return false;
        }
        cVar.a(i10);
        return true;
    }

    private final long m(n nVar, boolean z10) {
        g gVar;
        do {
            gVar = (g) nVar.lastScheduledTask;
            if (gVar == null) {
                return -2;
            }
            if (z10) {
                boolean z11 = true;
                if (gVar.f32657b.b() != 1) {
                    z11 = false;
                }
                if (!z11) {
                    return -2;
                }
            }
            long a10 = k.f32664e.a() - gVar.f32656a;
            long j10 = k.f32660a;
            if (a10 < j10) {
                return j10 - a10;
            }
        } while (!a.a(f32668b, nVar, gVar, (Object) null));
        b(this, gVar, false, 2, (Object) null);
        return -1;
    }

    public final g a(g gVar, boolean z10) {
        if (z10) {
            return c(gVar);
        }
        g gVar2 = (g) f32668b.getAndSet(this, gVar);
        if (gVar2 == null) {
            return null;
        }
        return c(gVar2);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(c cVar) {
        g gVar = (g) f32668b.getAndSet(this, (Object) null);
        if (gVar != null) {
            cVar.a(gVar);
        }
        do {
        } while (j(cVar));
    }

    public final g h() {
        g gVar = (g) f32668b.getAndSet(this, (Object) null);
        return gVar == null ? i() : gVar;
    }

    public final long k(n nVar) {
        int i10 = nVar.consumerIndex;
        int i11 = nVar.producerIndex;
        AtomicReferenceArray<g> atomicReferenceArray = nVar.f32672a;
        while (true) {
            boolean z10 = true;
            if (i10 == i11) {
                break;
            }
            int i12 = i10 & Opcodes.LAND;
            if (nVar.blockingTasksInBuffer == 0) {
                break;
            }
            g gVar = atomicReferenceArray.get(i12);
            if (gVar != null) {
                if (gVar.f32657b.b() != 1) {
                    z10 = false;
                }
                if (z10 && m.a(atomicReferenceArray, i12, gVar, (Object) null)) {
                    f32671e.decrementAndGet(nVar);
                    b(this, gVar, false, 2, (Object) null);
                    return -1;
                }
            }
            i10++;
        }
        return m(nVar, true);
    }

    public final long l(n nVar) {
        g i10 = nVar.i();
        if (i10 == null) {
            return m(nVar, false);
        }
        b(this, i10, false, 2, (Object) null);
        return -1;
    }
}
