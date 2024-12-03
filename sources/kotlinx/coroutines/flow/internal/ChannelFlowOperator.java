package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.o;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;

@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B-\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H¤@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\fJ\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0004X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "S", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/c;", "collector", "Lkotlin/coroutines/CoroutineContext;", "newContext", "", "q", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/c;)Ljava/lang/Object;", "r", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/o;", "scope", "i", "(Lkotlinx/coroutines/channels/o;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "", "toString", "Lkotlinx/coroutines/flow/b;", "d", "Lkotlinx/coroutines/flow/b;", "flow", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/flow/b;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    /* renamed from: d  reason: collision with root package name */
    protected final b<S> f32438d;

    public ChannelFlowOperator(b<? extends S> bVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        super(coroutineContext, i10, bufferOverflow);
        this.f32438d = bVar;
    }

    static /* synthetic */ Object o(ChannelFlowOperator channelFlowOperator, c cVar, kotlin.coroutines.c cVar2) {
        if (channelFlowOperator.f32436b == -3) {
            CoroutineContext context = cVar2.getContext();
            CoroutineContext e02 = context.e0(channelFlowOperator.f32435a);
            if (j.b(e02, context)) {
                Object r10 = channelFlowOperator.r(cVar, cVar2);
                if (r10 == b.d()) {
                    return r10;
                }
                return Unit.f32013a;
            }
            d.b bVar = d.f32074s;
            if (j.b(e02.c(bVar), context.c(bVar))) {
                Object q10 = channelFlowOperator.q(cVar, e02, cVar2);
                if (q10 == b.d()) {
                    return q10;
                }
                return Unit.f32013a;
            }
        }
        Object a10 = super.a(cVar, cVar2);
        if (a10 == b.d()) {
            return a10;
        }
        return Unit.f32013a;
    }

    static /* synthetic */ Object p(ChannelFlowOperator channelFlowOperator, o oVar, kotlin.coroutines.c cVar) {
        Object r10 = channelFlowOperator.r(new m(oVar), cVar);
        return r10 == b.d() ? r10 : Unit.f32013a;
    }

    private final Object q(c<? super T> cVar, CoroutineContext coroutineContext, kotlin.coroutines.c<? super Unit> cVar2) {
        Object d10 = d.d(coroutineContext, d.e(cVar, cVar2.getContext()), (Object) null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, (kotlin.coroutines.c<? super ChannelFlowOperator$collectWithContextUndispatched$2>) null), cVar2, 4, (Object) null);
        if (d10 == b.d()) {
            return d10;
        }
        return Unit.f32013a;
    }

    public Object a(c<? super T> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return o(this, cVar, cVar2);
    }

    /* access modifiers changed from: protected */
    public Object i(o<? super T> oVar, kotlin.coroutines.c<? super Unit> cVar) {
        return p(this, oVar, cVar);
    }

    /* access modifiers changed from: protected */
    public abstract Object r(c<? super T> cVar, kotlin.coroutines.c<? super Unit> cVar2);

    public String toString() {
        return this.f32438d + " -> " + super.toString();
    }
}
