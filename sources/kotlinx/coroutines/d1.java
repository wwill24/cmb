package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.a;
import kotlinx.coroutines.internal.o;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tJ\u0010\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u00020\u000bH\u0016R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\"\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010$\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b#\u0010!¨\u0006'"}, d2 = {"Lkotlinx/coroutines/d1;", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "unconfined", "", "f0", "H0", "I0", "N0", "Lkotlinx/coroutines/u0;", "task", "", "i0", "q0", "Y", "", "parallelism", "S", "shutdown", "c", "J", "useCount", "d", "Z", "shared", "Lkotlinx/coroutines/internal/a;", "e", "Lkotlinx/coroutines/internal/a;", "unconfinedQueue", "m0", "()J", "nextTime", "B0", "()Z", "isUnconfinedLoopActive", "E0", "isUnconfinedQueueEmpty", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class d1 extends CoroutineDispatcher {

    /* renamed from: c  reason: collision with root package name */
    private long f32342c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f32343d;

    /* renamed from: e  reason: collision with root package name */
    private a<u0<?>> f32344e;

    public static /* synthetic */ void c0(d1 d1Var, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            d1Var.Y(z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long f0(boolean z10) {
        return z10 ? 4294967296L : 1;
    }

    public static /* synthetic */ void t0(d1 d1Var, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            d1Var.q0(z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final boolean B0() {
        return this.f32342c >= f0(true);
    }

    public final boolean E0() {
        a<u0<?>> aVar = this.f32344e;
        if (aVar != null) {
            return aVar.c();
        }
        return true;
    }

    public long H0() {
        return !I0() ? Long.MAX_VALUE : 0;
    }

    public final boolean I0() {
        u0 d10;
        a<u0<?>> aVar = this.f32344e;
        if (aVar == null || (d10 = aVar.d()) == null) {
            return false;
        }
        d10.run();
        return true;
    }

    public boolean N0() {
        return false;
    }

    public final CoroutineDispatcher S(int i10) {
        o.a(i10);
        return this;
    }

    public final void Y(boolean z10) {
        long f02 = this.f32342c - f0(z10);
        this.f32342c = f02;
        if (f02 <= 0 && this.f32343d) {
            shutdown();
        }
    }

    public final void i0(u0<?> u0Var) {
        a<u0<?>> aVar = this.f32344e;
        if (aVar == null) {
            aVar = new a<>();
            this.f32344e = aVar;
        }
        aVar.a(u0Var);
    }

    /* access modifiers changed from: protected */
    public long m0() {
        a<u0<?>> aVar = this.f32344e;
        if (aVar != null && !aVar.c()) {
            return 0;
        }
        return Long.MAX_VALUE;
    }

    public final void q0(boolean z10) {
        this.f32342c += f0(z10);
        if (!z10) {
            this.f32343d = true;
        }
    }

    public void shutdown() {
    }
}
