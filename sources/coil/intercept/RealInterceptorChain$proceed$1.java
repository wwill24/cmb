package coil.intercept;

import coil.request.g;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "coil.intercept.RealInterceptorChain", f = "RealInterceptorChain.kt", l = {25}, m = "proceed")
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final class RealInterceptorChain$proceed$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealInterceptorChain this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealInterceptorChain$proceed$1(RealInterceptorChain realInterceptorChain, c<? super RealInterceptorChain$proceed$1> cVar) {
        super(cVar);
        this.this$0 = realInterceptorChain;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g((g) null, this);
    }
}
