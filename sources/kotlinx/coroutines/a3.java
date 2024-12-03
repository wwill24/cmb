package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0003"}, d2 = {"", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class a3 {
    public static final Object a(c<? super Unit> cVar) {
        i iVar;
        Object obj;
        CoroutineContext context = cVar.getContext();
        v1.i(context);
        c c10 = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
        if (c10 instanceof i) {
            iVar = (i) c10;
        } else {
            iVar = null;
        }
        if (iVar == null) {
            obj = Unit.f32013a;
        } else {
            if (iVar.f32535d.O(context)) {
                iVar.k(context, Unit.f32013a);
            } else {
                z2 z2Var = new z2();
                CoroutineContext e02 = context.e0(z2Var);
                Unit unit = Unit.f32013a;
                iVar.k(e02, unit);
                if (z2Var.f32749b) {
                    if (j.d(iVar)) {
                        obj = b.d();
                    } else {
                        obj = unit;
                    }
                }
            }
            obj = b.d();
        }
        if (obj == b.d()) {
            f.c(cVar);
        }
        if (obj == b.d()) {
            return obj;
        }
        return Unit.f32013a;
    }
}
