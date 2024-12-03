package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.i;
import kotlinx.coroutines.s1;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001f\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005HAø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0014\u0010\u0017\u001a\u00028\u00008\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/flow/j;", "T", "Lkotlinx/coroutines/flow/r;", "", "Lkotlinx/coroutines/flow/internal/i;", "Lkotlinx/coroutines/flow/c;", "collector", "", "a", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/b;", "d", "Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/s1;", "job", "getValue", "()Ljava/lang/Object;", "value", "flow", "<init>", "(Lkotlinx/coroutines/flow/r;Lkotlinx/coroutines/s1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class j<T> implements r<T>, b, i<T> {

    /* renamed from: a  reason: collision with root package name */
    private final s1 f32470a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ r<T> f32471b;

    public j(r<? extends T> rVar, s1 s1Var) {
        this.f32470a = s1Var;
        this.f32471b = rVar;
    }

    public Object a(c<? super T> cVar, c<?> cVar2) {
        return this.f32471b.a(cVar, cVar2);
    }

    public b<T> d(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        return s.d(this, coroutineContext, i10, bufferOverflow);
    }

    public T getValue() {
        return this.f32471b.getValue();
    }
}
