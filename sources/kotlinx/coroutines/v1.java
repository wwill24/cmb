package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {}, d1 = {"kotlinx/coroutines/w1", "kotlinx/coroutines/x1"}, d2 = {}, k = 4, mv = {1, 6, 0})
public final class v1 {
    public static final z a(s1 s1Var) {
        return x1.a(s1Var);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        x1.c(coroutineContext, cancellationException);
    }

    public static final void e(CoroutineContext coroutineContext, CancellationException cancellationException) {
        x1.e(coroutineContext, cancellationException);
    }

    public static final void g(n<?> nVar, Future<?> future) {
        w1.a(nVar, future);
    }

    public static final z0 h(s1 s1Var, z0 z0Var) {
        return x1.g(s1Var, z0Var);
    }

    public static final void i(CoroutineContext coroutineContext) {
        x1.h(coroutineContext);
    }

    public static final void j(s1 s1Var) {
        x1.i(s1Var);
    }

    public static final s1 k(CoroutineContext coroutineContext) {
        return x1.j(coroutineContext);
    }
}
