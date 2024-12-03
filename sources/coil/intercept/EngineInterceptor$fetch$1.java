package coil.intercept;

import coil.a;
import coil.b;
import coil.request.g;
import coil.request.k;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {165}, m = "fetch")
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final class EngineInterceptor$fetch$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EngineInterceptor$fetch$1(EngineInterceptor engineInterceptor, c<? super EngineInterceptor$fetch$1> cVar) {
        super(cVar);
        this.this$0 = engineInterceptor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j((a) null, (g) null, (Object) null, (k) null, (b) null, this);
    }
}
