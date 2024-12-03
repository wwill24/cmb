package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"kotlinx/coroutines/i", "kotlinx/coroutines/j"}, d2 = {}, k = 4, mv = {1, 6, 0})
public final class h {
    public static final <T> p0<T> a(k0 k0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super k0, ? super c<? super T>, ? extends Object> function2) {
        return j.a(k0Var, coroutineContext, coroutineStart, function2);
    }

    public static final s1 c(k0 k0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2) {
        return j.c(k0Var, coroutineContext, coroutineStart, function2);
    }

    public static final <T> T e(CoroutineContext coroutineContext, Function2<? super k0, ? super c<? super T>, ? extends Object> function2) throws InterruptedException {
        return i.a(coroutineContext, function2);
    }

    public static final <T> Object g(CoroutineContext coroutineContext, Function2<? super k0, ? super c<? super T>, ? extends Object> function2, c<? super T> cVar) {
        return j.e(coroutineContext, function2, cVar);
    }
}
