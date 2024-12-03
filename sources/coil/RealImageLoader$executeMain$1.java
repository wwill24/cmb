package coil;

import coil.request.g;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "coil.RealImageLoader", f = "RealImageLoader.kt", l = {169, 180, 184}, m = "executeMain")
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final class RealImageLoader$executeMain$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealImageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealImageLoader$executeMain$1(RealImageLoader realImageLoader, c<? super RealImageLoader$executeMain$1> cVar) {
        super(cVar);
        this.this$0 = realImageLoader;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e((g) null, 0, this);
    }
}
