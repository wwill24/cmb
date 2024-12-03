package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0001\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\r\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108TX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/f;", "T", "Lkotlinx/coroutines/a;", "", "state", "", "i1", "()Ljava/lang/Object;", "Ljava/lang/Thread;", "c", "Ljava/lang/Thread;", "blockedThread", "Lkotlinx/coroutines/d1;", "d", "Lkotlinx/coroutines/d1;", "eventLoop", "", "z0", "()Z", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/d1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class f<T> extends a<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Thread f32354c;

    /* renamed from: d  reason: collision with root package name */
    private final d1 f32355d;

    public f(CoroutineContext coroutineContext, Thread thread, d1 d1Var) {
        super(coroutineContext, true, true);
        this.f32354c = thread;
        this.f32355d = d1Var;
    }

    /* access modifiers changed from: protected */
    public void T(Object obj) {
        if (!j.b(Thread.currentThread(), this.f32354c)) {
            Thread thread = this.f32354c;
            c.a();
            LockSupport.unpark(thread);
        }
    }

    public final T i1() {
        long j10;
        c.a();
        try {
            d1 d1Var = this.f32355d;
            b0 b0Var = null;
            if (d1Var != null) {
                d1.t0(d1Var, false, 1, (Object) null);
            }
            while (!Thread.interrupted()) {
                d1 d1Var2 = this.f32355d;
                if (d1Var2 != null) {
                    j10 = d1Var2.H0();
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (!y0()) {
                    c.a();
                    LockSupport.parkNanos(this, j10);
                } else {
                    d1 d1Var3 = this.f32355d;
                    if (d1Var3 != null) {
                        d1.c0(d1Var3, false, 1, (Object) null);
                    }
                    c.a();
                    T h10 = z1.h(q0());
                    if (h10 instanceof b0) {
                        b0Var = (b0) h10;
                    }
                    if (b0Var == null) {
                        return h10;
                    }
                    throw b0Var.f32285a;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            W(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            c.a();
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public boolean z0() {
        return true;
    }
}
