package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.channels.o;

@d(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", l = {336}, m = "collectTo")
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
final class CallbackFlowBuilder$collectTo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CallbackFlowBuilder<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CallbackFlowBuilder$collectTo$1(CallbackFlowBuilder<T> callbackFlowBuilder, c<? super CallbackFlowBuilder$collectTo$1> cVar) {
        super(cVar);
        this.this$0 = callbackFlowBuilder;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i((o) null, this);
    }
}
