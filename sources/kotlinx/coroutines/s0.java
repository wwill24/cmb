package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.f;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0018\u0010\t\u001a\u00020\u0006*\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"", "timeMillis", "", "a", "(JLkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/r0;", "b", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/r0;", "delay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class s0 {
    public static final Object a(long j10, c<? super Unit> cVar) {
        if (j10 <= 0) {
            return Unit.f32013a;
        }
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        oVar.y();
        if (j10 < Long.MAX_VALUE) {
            b(oVar.getContext()).k(j10, oVar);
        }
        Object v10 = oVar.v();
        if (v10 == b.d()) {
            f.c(cVar);
        }
        if (v10 == b.d()) {
            return v10;
        }
        return Unit.f32013a;
    }

    public static final r0 b(CoroutineContext coroutineContext) {
        CoroutineContext.Element c10 = coroutineContext.c(d.f32074s);
        r0 r0Var = c10 instanceof r0 ? (r0) c10 : null;
        return r0Var == null ? o0.a() : r0Var;
    }
}
