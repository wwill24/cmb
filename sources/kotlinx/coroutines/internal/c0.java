package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.internal.c0;
import net.bytebuddy.jar.asm.Opcodes;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0005J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/internal/c0;", "S", "Lkotlinx/coroutines/internal/g;", "", "p", "()Z", "l", "", "o", "()V", "", "c", "J", "m", "()J", "id", "", "n", "()I", "maxSlots", "g", "removed", "prev", "pointers", "<init>", "(JLkotlinx/coroutines/internal/c0;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class c0<S extends c0<S>> extends g<S> {

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f32522d = AtomicIntegerFieldUpdater.newUpdater(c0.class, "cleanedAndPointers");

    /* renamed from: c  reason: collision with root package name */
    private final long f32523c;
    private volatile /* synthetic */ int cleanedAndPointers;

    public c0(long j10, S s10, int i10) {
        super(s10);
        this.f32523c = j10;
        this.cleanedAndPointers = i10 << 16;
    }

    public boolean g() {
        return this.cleanedAndPointers == n() && !i();
    }

    public final boolean l() {
        return f32522d.addAndGet(this, Opcodes.V_PREVIEW) == n() && !i();
    }

    public final long m() {
        return this.f32523c;
    }

    public abstract int n();

    public final void o() {
        if (f32522d.incrementAndGet(this) == n() && !i()) {
            j();
        }
    }

    public final boolean p() {
        int i10;
        boolean z10;
        do {
            i10 = this.cleanedAndPointers;
            if (i10 != n() || i()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                return false;
            }
        } while (!f32522d.compareAndSet(this, i10, 65536 + i10));
        return true;
    }
}
