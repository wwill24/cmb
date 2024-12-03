package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/r0;", "", "", "timeMillis", "Lkotlinx/coroutines/n;", "", "continuation", "k", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/z0;", "u", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface r0 {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static z0 a(r0 r0Var, long j10, Runnable runnable, CoroutineContext coroutineContext) {
            return o0.a().u(j10, runnable, coroutineContext);
        }
    }

    void k(long j10, n<? super Unit> nVar);

    z0 u(long j10, Runnable runnable, CoroutineContext coroutineContext);
}
