package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR3\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f8\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/flow/internal/UndispatchedContextCollector;", "T", "Lkotlinx/coroutines/flow/c;", "value", "", "c", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "a", "Lkotlin/coroutines/CoroutineContext;", "emitContext", "", "b", "Ljava/lang/Object;", "countOrElement", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "Lkotlin/jvm/functions/Function2;", "emitRef", "downstream", "<init>", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class UndispatchedContextCollector<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineContext f32451a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f32452b;

    /* renamed from: c  reason: collision with root package name */
    private final Function2<T, kotlin.coroutines.c<? super Unit>, Object> f32453c;

    public UndispatchedContextCollector(c<? super T> cVar, CoroutineContext coroutineContext) {
        this.f32451a = coroutineContext;
        this.f32452b = ThreadContextKt.b(coroutineContext);
        this.f32453c = new UndispatchedContextCollector$emitRef$1(cVar, (kotlin.coroutines.c<? super UndispatchedContextCollector$emitRef$1>) null);
    }

    public Object c(T t10, kotlin.coroutines.c<? super Unit> cVar) {
        Object c10 = d.c(this.f32451a, t10, this.f32452b, this.f32453c, cVar);
        return c10 == b.d() ? c10 : Unit.f32013a;
    }
}
