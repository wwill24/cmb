package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.k0;
import pk.n;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002$\b\u0001\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aP\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u000020\b\u0001\u0010\u0005\u001a*\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"R", "Lkotlin/Function2;", "Lkotlinx/coroutines/k0;", "Lkotlin/coroutines/c;", "", "block", "a", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/c;", "", "Lkotlinx/coroutines/flow/b;", "b", "(Lpk/n;)Lkotlinx/coroutines/flow/b;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class FlowCoroutineKt {

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/FlowCoroutineKt$a", "Lkotlinx/coroutines/flow/b;", "Lkotlinx/coroutines/flow/c;", "collector", "", "a", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class a implements b<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f32447a;

        public a(n nVar) {
            this.f32447a = nVar;
        }

        public Object a(c<? super R> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
            Object a10 = FlowCoroutineKt.a(new FlowCoroutineKt$scopedFlow$1$1(this.f32447a, cVar, (kotlin.coroutines.c<? super FlowCoroutineKt$scopedFlow$1$1>) null), cVar2);
            if (a10 == b.d()) {
                return a10;
            }
            return Unit.f32013a;
        }
    }

    public static final <R> Object a(Function2<? super k0, ? super kotlin.coroutines.c<? super R>, ? extends Object> function2, kotlin.coroutines.c<? super R> cVar) {
        g gVar = new g(cVar.getContext(), cVar);
        Object d10 = zk.b.d(gVar, gVar, function2);
        if (d10 == b.d()) {
            f.c(cVar);
        }
        return d10;
    }

    public static final <R> b<R> b(n<? super k0, ? super c<? super R>, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> nVar) {
        return new a(nVar);
    }
}
