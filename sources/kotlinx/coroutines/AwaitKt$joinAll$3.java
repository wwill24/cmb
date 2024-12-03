package kotlinx.coroutines;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", l = {66}, m = "joinAll")
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
final class AwaitKt$joinAll$3 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    AwaitKt$joinAll$3(c<? super AwaitKt$joinAll$3> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.a((Collection<? extends s1>) null, this);
    }
}
