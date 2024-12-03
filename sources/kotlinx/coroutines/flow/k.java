package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B4\u0012(\u0010\r\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R9\u0010\r\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b8\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/flow/k;", "T", "Lkotlinx/coroutines/flow/AbstractFlow;", "Lkotlinx/coroutines/flow/c;", "collector", "", "b", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "a", "Lkotlin/jvm/functions/Function2;", "block", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class k<T> extends AbstractFlow<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function2<c<? super T>, c<? super Unit>, Object> f32472a;

    public k(Function2<? super c<? super T>, ? super c<? super Unit>, ? extends Object> function2) {
        this.f32472a = function2;
    }

    public Object b(c<? super T> cVar, c<? super Unit> cVar2) {
        Object invoke = this.f32472a.invoke(cVar, cVar2);
        return invoke == b.d() ? invoke : Unit.f32013a;
    }
}
