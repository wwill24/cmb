package kotlinx.coroutines.flow.internal;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.o;

@d(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {60}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/channels/o;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class ChannelFlow$collectToFun$1 extends SuspendLambda implements Function2<o<? super T>, c<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlow<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlow$collectToFun$1(ChannelFlow<T> channelFlow, c<? super ChannelFlow$collectToFun$1> cVar) {
        super(2, cVar);
        this.this$0 = channelFlow;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this.this$0, cVar);
        channelFlow$collectToFun$1.L$0 = obj;
        return channelFlow$collectToFun$1;
    }

    /* renamed from: i */
    public final Object invoke(o<? super T> oVar, c<? super Unit> cVar) {
        return ((ChannelFlow$collectToFun$1) create(oVar, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            ChannelFlow<T> channelFlow = this.this$0;
            this.label = 1;
            if (channelFlow.i((o) this.L$0, this) == d10) {
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
