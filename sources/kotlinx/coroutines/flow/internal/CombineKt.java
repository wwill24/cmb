package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;
import pk.n;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\r\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0018\u00010\u00030\u000624\u0010\f\u001a0\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bH@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e*\u001c\b\u0002\u0010\u0010\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f2\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"R", "T", "Lkotlinx/coroutines/flow/c;", "", "Lkotlinx/coroutines/flow/b;", "flows", "Lkotlin/Function0;", "arrayFactory", "Lkotlin/Function3;", "Lkotlin/coroutines/c;", "", "", "transform", "a", "(Lkotlinx/coroutines/flow/c;[Lkotlinx/coroutines/flow/b;Lkotlin/jvm/functions/Function0;Lpk/n;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/collections/IndexedValue;", "Update", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class CombineKt {
    public static final <R, T> Object a(c<? super R> cVar, b<? extends T>[] bVarArr, Function0<T[]> function0, n<? super c<? super R>, ? super T[], ? super kotlin.coroutines.c<? super Unit>, ? extends Object> nVar, kotlin.coroutines.c<? super Unit> cVar2) {
        Object a10 = FlowCoroutineKt.a(new CombineKt$combineInternal$2(bVarArr, function0, nVar, cVar, (kotlin.coroutines.c<? super CombineKt$combineInternal$2>) null), cVar2);
        return a10 == b.d() ? a10 : Unit.f32013a;
    }
}
