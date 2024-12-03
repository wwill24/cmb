package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.l0;
import pk.n;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003Bf\u0012.\u0010\u0016\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J!\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\fH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R?\u0010\u0016\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00118\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest;", "T", "R", "Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "j", "Lkotlinx/coroutines/flow/c;", "collector", "", "r", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function3;", "Lkotlin/coroutines/c;", "", "e", "Lpk/n;", "transform", "Lkotlinx/coroutines/flow/b;", "flow", "<init>", "(Lpk/n;Lkotlinx/coroutines/flow/b;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final n<c<? super R>, T, kotlin.coroutines.c<? super Unit>, Object> f32439e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelFlowTransformLatest(n nVar, b bVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(nVar, bVar, (i11 & 4) != 0 ? EmptyCoroutineContext.f32070a : coroutineContext, (i11 & 8) != 0 ? -2 : i10, (i11 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* access modifiers changed from: protected */
    public ChannelFlow<R> j(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.f32439e, this.f32438d, coroutineContext, i10, bufferOverflow);
    }

    /* access modifiers changed from: protected */
    public Object r(c<? super R> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        Object g10 = l0.g(new ChannelFlowTransformLatest$flowCollect$3(this, cVar, (kotlin.coroutines.c<? super ChannelFlowTransformLatest$flowCollect$3>) null), cVar2);
        return g10 == b.d() ? g10 : Unit.f32013a;
    }

    public ChannelFlowTransformLatest(n<? super c<? super R>, ? super T, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> nVar, b<? extends T> bVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        super(bVar, coroutineContext, i10, bufferOverflow);
        this.f32439e = nVar;
    }
}
