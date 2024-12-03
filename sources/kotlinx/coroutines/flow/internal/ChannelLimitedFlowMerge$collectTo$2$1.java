package kotlinx.coroutines.flow.internal;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;

@d(c = "kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge$collectTo$2$1", f = "Merge.kt", l = {96}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class ChannelLimitedFlowMerge$collectTo$2$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ m<T> $collector;
    final /* synthetic */ b<T> $flow;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelLimitedFlowMerge$collectTo$2$1(b<? extends T> bVar, m<T> mVar, c<? super ChannelLimitedFlowMerge$collectTo$2$1> cVar) {
        super(2, cVar);
        this.$flow = bVar;
        this.$collector = mVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ChannelLimitedFlowMerge$collectTo$2$1(this.$flow, this.$collector, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((ChannelLimitedFlowMerge$collectTo$2$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            b<T> bVar = this.$flow;
            m<T> mVar = this.$collector;
            this.label = 1;
            if (bVar.a(mVar, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
