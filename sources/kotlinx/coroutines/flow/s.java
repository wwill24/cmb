package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.l;
import kotlinx.coroutines.internal.f0;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a6\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0000\"\u001a\u0010\u0012\u001a\u00020\u000e8\u0002X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u0012\u0004\b\u0010\u0010\u0011\"\u001a\u0010\u0015\u001a\u00020\u000e8\u0002X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u0012\u0004\b\u0014\u0010\u0011¨\u0006\u0016"}, d2 = {"T", "value", "Lkotlinx/coroutines/flow/i;", "a", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/i;", "Lkotlinx/coroutines/flow/r;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/b;", "d", "Lkotlinx/coroutines/internal/f0;", "Lkotlinx/coroutines/internal/f0;", "getNONE$annotations", "()V", "NONE", "b", "getPENDING$annotations", "PENDING", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final f0 f32484a = new f0("NONE");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final f0 f32485b = new f0("PENDING");

    public static final <T> i<T> a(T t10) {
        if (t10 == null) {
            t10 = l.f32464a;
        }
        return new StateFlowImpl(t10);
    }

    public static final <T> b<T> d(r<? extends T> rVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        boolean z10 = false;
        if (i10 >= 0 && i10 < 2) {
            z10 = true;
        }
        if ((z10 || i10 == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) {
            return rVar;
        }
        return m.e(rVar, coroutineContext, i10, bufferOverflow);
    }
}
