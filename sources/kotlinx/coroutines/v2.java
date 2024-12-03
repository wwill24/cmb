package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.functions.Function2;
import zk.b;

@Metadata(bv = {}, d1 = {"\u00000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aR\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H@ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\b\u0010\t\u001a\\\u0010\r\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\n\"\b\b\u0001\u0010\u0000*\u00028\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b2\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0010H\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"T", "", "timeMillis", "Lkotlin/Function2;", "Lkotlinx/coroutines/k0;", "Lkotlin/coroutines/c;", "", "block", "c", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/c;)Ljava/lang/Object;", "U", "Lkotlinx/coroutines/u2;", "coroutine", "b", "(Lkotlinx/coroutines/u2;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "time", "Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/TimeoutCancellationException;", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class v2 {
    public static final TimeoutCancellationException a(long j10, s1 s1Var) {
        return new TimeoutCancellationException("Timed out waiting for " + j10 + " ms", s1Var);
    }

    private static final <U, T extends U> Object b(u2<U, ? super T> u2Var, Function2<? super k0, ? super c<? super T>, ? extends Object> function2) {
        v1.h(u2Var, s0.b(u2Var.f32519c.getContext()).u(u2Var.f32730d, u2Var, u2Var.getContext()));
        return b.e(u2Var, u2Var, function2);
    }

    public static final <T> Object c(long j10, Function2<? super k0, ? super c<? super T>, ? extends Object> function2, c<? super T> cVar) {
        if (j10 > 0) {
            Object b10 = b(new u2(j10, cVar), function2);
            if (b10 == b.d()) {
                f.c(cVar);
            }
            return b10;
        }
        throw new TimeoutCancellationException("Timed out immediately");
    }
}
