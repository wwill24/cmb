package kotlinx.coroutines.flow.internal;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.q;
import kotlinx.coroutines.k0;

@d(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {123}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class ChannelFlow$collect$2 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.c<T> $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlow<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlow$collect$2(kotlinx.coroutines.flow.c<? super T> cVar, ChannelFlow<T> channelFlow, c<? super ChannelFlow$collect$2> cVar2) {
        super(2, cVar2);
        this.$collector = cVar;
        this.this$0 = channelFlow;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelFlow$collect$2 channelFlow$collect$2 = new ChannelFlow$collect$2(this.$collector, this.this$0, cVar);
        channelFlow$collect$2.L$0 = obj;
        return channelFlow$collect$2;
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((ChannelFlow$collect$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            kotlinx.coroutines.flow.c<T> cVar = this.$collector;
            q<T> n10 = this.this$0.n((k0) this.L$0);
            this.label = 1;
            if (kotlinx.coroutines.flow.d.p(cVar, n10, this) == d10) {
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
