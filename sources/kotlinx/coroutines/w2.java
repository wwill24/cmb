package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/w2;", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "parallelism", "S", "Lkotlin/coroutines/CoroutineContext;", "context", "", "O", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "E", "", "toString", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class w2 extends CoroutineDispatcher {

    /* renamed from: c  reason: collision with root package name */
    public static final w2 f32732c = new w2();

    private w2() {
    }

    public void E(CoroutineContext coroutineContext, Runnable runnable) {
        z2 z2Var = (z2) coroutineContext.c(z2.f32748c);
        if (z2Var != null) {
            z2Var.f32749b = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    public boolean O(CoroutineContext coroutineContext) {
        return false;
    }

    public CoroutineDispatcher S(int i10) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
