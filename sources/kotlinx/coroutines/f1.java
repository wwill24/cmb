package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlinx.coroutines.e1;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0004J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014R\u0014\u0010\f\u001a\u00020\t8$X¤\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/f1;", "Lkotlinx/coroutines/d1;", "", "S0", "", "now", "Lkotlinx/coroutines/e1$c;", "delayedTask", "R0", "Ljava/lang/Thread;", "Q0", "()Ljava/lang/Thread;", "thread", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class f1 extends d1 {
    /* access modifiers changed from: protected */
    public abstract Thread Q0();

    /* access modifiers changed from: protected */
    public void R0(long j10, e1.c cVar) {
        n0.f32584h.i1(j10, cVar);
    }

    /* access modifiers changed from: protected */
    public final void S0() {
        Thread Q0 = Q0();
        if (Thread.currentThread() != Q0) {
            c.a();
            LockSupport.unpark(Q0);
        }
    }
}
