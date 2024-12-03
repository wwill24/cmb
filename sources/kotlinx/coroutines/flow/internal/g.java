package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.internal.b0;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/internal/g;", "T", "Lkotlinx/coroutines/internal/b0;", "", "cause", "", "c0", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/c;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class g<T> extends b0<T> {
    public g(CoroutineContext coroutineContext, c<? super T> cVar) {
        super(coroutineContext, cVar);
    }

    public boolean c0(Throwable th2) {
        if (th2 instanceof ChildCancelledException) {
            return true;
        }
        return X(th2);
    }
}
