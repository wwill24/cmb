package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.l;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BI\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\u001c\u0010\u0013\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\"\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR*\u0010\u0013\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/flow/DistinctFlowImpl;", "T", "Lkotlinx/coroutines/flow/b;", "Lkotlinx/coroutines/flow/c;", "collector", "", "a", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/b;", "upstream", "Lkotlin/Function1;", "", "b", "Lkotlin/jvm/functions/Function1;", "keySelector", "Lkotlin/Function2;", "", "c", "Lkotlin/jvm/functions/Function2;", "areEquivalent", "<init>", "(Lkotlinx/coroutines/flow/b;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class DistinctFlowImpl<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final b<T> f32357a;

    /* renamed from: b  reason: collision with root package name */
    public final Function1<T, Object> f32358b;

    /* renamed from: c  reason: collision with root package name */
    public final Function2<Object, Object, Boolean> f32359c;

    public DistinctFlowImpl(b<? extends T> bVar, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        this.f32357a = bVar;
        this.f32358b = function1;
        this.f32359c = function2;
    }

    public Object a(c<? super T> cVar, c<? super Unit> cVar2) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = l.f32464a;
        Object a10 = this.f32357a.a(new DistinctFlowImpl$collect$2(this, ref$ObjectRef, cVar), cVar2);
        if (a10 == b.d()) {
            return a10;
        }
        return Unit.f32013a;
    }
}
