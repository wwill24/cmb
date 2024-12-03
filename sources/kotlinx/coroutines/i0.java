package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000¨\u0006\t"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "a", "originalException", "thrownException", "b", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class i0 {
    public static final void a(CoroutineContext coroutineContext, Throwable th2) {
        try {
            g0 g0Var = (g0) coroutineContext.c(g0.f32489u);
            if (g0Var != null) {
                g0Var.P(coroutineContext, th2);
            } else {
                h0.a(coroutineContext, th2);
            }
        } catch (Throwable th3) {
            h0.a(coroutineContext, b(th2, th3));
        }
    }

    public static final Throwable b(Throwable th2, Throwable th3) {
        if (th2 == th3) {
            return th2;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th3);
        b.a(runtimeException, th2);
        return runtimeException;
    }
}
