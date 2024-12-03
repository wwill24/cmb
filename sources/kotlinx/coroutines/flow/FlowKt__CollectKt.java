package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.k;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001e\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u001aG\u0010\r\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a1\u0010\u0011\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/flow/b;", "", "a", "(Lkotlinx/coroutines/flow/b;Lkotlin/coroutines/c;)Ljava/lang/Object;", "T", "Lkotlinx/coroutines/k0;", "scope", "Lkotlinx/coroutines/s1;", "d", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "action", "b", "(Lkotlinx/coroutines/flow/b;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/c;", "flow", "c", "(Lkotlinx/coroutines/flow/c;Lkotlinx/coroutines/flow/b;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__CollectKt {
    public static final Object a(b<?> bVar, c<? super Unit> cVar) {
        Object a10 = bVar.a(k.f32463a, cVar);
        return a10 == b.d() ? a10 : Unit.f32013a;
    }

    public static final <T> Object b(b<? extends T> bVar, Function2<? super T, ? super c<? super Unit>, ? extends Object> function2, c<? super Unit> cVar) {
        Object g10 = d.g(f.b(d.A(bVar, function2), 0, (BufferOverflow) null, 2, (Object) null), cVar);
        return g10 == b.d() ? g10 : Unit.f32013a;
    }

    public static final <T> Object c(c<? super T> cVar, b<? extends T> bVar, c<? super Unit> cVar2) {
        d.r(cVar);
        Object a10 = bVar.a(cVar, cVar2);
        if (a10 == b.d()) {
            return a10;
        }
        return Unit.f32013a;
    }

    public static final <T> s1 d(b<? extends T> bVar, k0 k0Var) {
        return j.d(k0Var, (CoroutineContext) null, (CoroutineStart) null, new FlowKt__CollectKt$launchIn$1(bVar, (c<? super FlowKt__CollectKt$launchIn$1>) null), 3, (Object) null);
    }
}
