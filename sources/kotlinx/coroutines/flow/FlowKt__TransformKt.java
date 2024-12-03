package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002\u001aJ\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"", "T", "Lkotlinx/coroutines/flow/b;", "a", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "action", "b", "(Lkotlinx/coroutines/flow/b;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/b;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__TransformKt {
    public static final <T> b<T> a(b<? extends T> bVar) {
        return new FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1(bVar);
    }

    public static final <T> b<T> b(b<? extends T> bVar, Function2<? super T, ? super c<? super Unit>, ? extends Object> function2) {
        return new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(bVar, function2);
    }
}
