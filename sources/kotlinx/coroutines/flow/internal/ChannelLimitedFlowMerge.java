package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.o;
import kotlinx.coroutines.channels.q;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0012\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J&\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "j", "Lkotlinx/coroutines/k0;", "scope", "Lkotlinx/coroutines/channels/q;", "n", "Lkotlinx/coroutines/channels/o;", "", "i", "(Lkotlinx/coroutines/channels/o;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "Lkotlinx/coroutines/flow/b;", "d", "Ljava/lang/Iterable;", "flows", "<init>", "(Ljava/lang/Iterable;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ChannelLimitedFlowMerge<T> extends ChannelFlow<T> {

    /* renamed from: d  reason: collision with root package name */
    private final Iterable<b<T>> f32444d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelLimitedFlowMerge(Iterable iterable, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(iterable, (i11 & 2) != 0 ? EmptyCoroutineContext.f32070a : coroutineContext, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* access modifiers changed from: protected */
    public Object i(o<? super T> oVar, c<? super Unit> cVar) {
        m mVar = new m(oVar);
        for (b<T> channelLimitedFlowMerge$collectTo$2$1 : this.f32444d) {
            s1 unused = j.d(oVar, (CoroutineContext) null, (CoroutineStart) null, new ChannelLimitedFlowMerge$collectTo$2$1(channelLimitedFlowMerge$collectTo$2$1, mVar, (c<? super ChannelLimitedFlowMerge$collectTo$2$1>) null), 3, (Object) null);
        }
        return Unit.f32013a;
    }

    /* access modifiers changed from: protected */
    public ChannelFlow<T> j(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        return new ChannelLimitedFlowMerge(this.f32444d, coroutineContext, i10, bufferOverflow);
    }

    public q<T> n(k0 k0Var) {
        return ProduceKt.b(k0Var, this.f32435a, this.f32436b, l());
    }

    public ChannelLimitedFlowMerge(Iterable<? extends b<? extends T>> iterable, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        super(coroutineContext, i10, bufferOverflow);
        this.f32444d = iterable;
    }
}
